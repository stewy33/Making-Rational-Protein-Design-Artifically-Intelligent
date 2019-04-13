import edu.duke.cs.osprey.astar.conf.ConfAStarTree;
import edu.duke.cs.osprey.confspace.ConfSearch;
import edu.duke.cs.osprey.confspace.SimpleConfSpace;
import edu.duke.cs.osprey.confspace.Strand;
import edu.duke.cs.osprey.ematrix.EnergyMatrix;
import edu.duke.cs.osprey.ematrix.SimplerEnergyMatrixCalculator;
import edu.duke.cs.osprey.energy.ConfEnergyCalculator;
import edu.duke.cs.osprey.energy.EnergyCalculator;
import edu.duke.cs.osprey.energy.forcefield.ForcefieldParams;
import edu.duke.cs.osprey.gmec.SimpleGMECFinder;
import edu.duke.cs.osprey.structure.PDBIO;

import java.util.List;

public class SimpleTest {

    public static void main(String args[]) {
        // Define a strand
        System.out.println(PDBIO.read("./OSPREY3/examples/1CC8/1CC8.ss.pdb").residues);
        Strand strand = new Strand.Builder(PDBIO.read("OSPREY3/examples/1CC8/1CC8.ss.pdb")).build();
        strand.flexibility.get("A2").setLibraryRotamers("ALA", "GLY");
        strand.flexibility.get("A3").setLibraryRotamers(Strand.WildType, "VAL");
        strand.flexibility.get("A4").setLibraryRotamers(Strand.WildType);

        SimpleConfSpace confSpace = new SimpleConfSpace.Builder().addStrands(strand).build();
        ForcefieldParams ffParams = new ForcefieldParams();

        // Define how we compute energy of molecules
        EnergyCalculator eCalc = new EnergyCalculator.Builder(confSpace, ffParams).build();
        // Define how we compute energy of conformations
        ConfEnergyCalculator confECalc = new ConfEnergyCalculator.Builder(confSpace, eCalc).build();

        // Define how confs should be ordered and searched
        EnergyMatrix eMat = new SimplerEnergyMatrixCalculator.Builder(confECalc).build().calcEnergyMatrix();
        ConfAStarTree aStarTree = new ConfAStarTree.Builder(eMat, confSpace).setMPLP().build();

        // Find best sequence and rotamers
        ConfSearch.EnergiedConf gmec = new SimpleGMECFinder.Builder(aStarTree, confECalc).build().find();
        System.out.println(gmec);
    }
}
