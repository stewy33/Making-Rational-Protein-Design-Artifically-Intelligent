# Making Rational Protein Design Artificially Intelligent

This is Jimmy Kim, [Jason Wong](https://github.com/codethejason), [Richard Chen](https://github.com/Richarizardd), and my final project for [Deep Learning in Discrete Optimization](http://www.ams.jhu.edu/~wcook12/dl/index.html) taught by Bill Cook.

We developed an ML-based branching rule for solving Weighted Constraint Satisfaction Problems (WCSPs) we call "small branching". We observe the outcome of different branching variable choices during branch-and-bound optimization and teach a three layer MLP to estimate the size of the expanded subtree for a given branching decision. Finally, this is used to heuristically choose the branching variables that will lead to the smallest tree (and therefore the most efficient search).

Restricting ourselves to a similar set of optimization problems, we trained our network over a small set of Computational Protein Design (CPD) Problems. We used the [Toulbar2](https://github.com/toulbar2/toulbar2) WCSP solver to explore the subtrees generated from the CPD problems.

Read more in our accompanying [report](https://github.com/stewy33/Making-Rational-Protein-Design-Artifically-Intelligent/blob/master/Report.pdf)!
