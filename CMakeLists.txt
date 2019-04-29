set(CMAKE_CXX_STANDARD 11)

project(DLDOProject)

find_package(Torch REQUIRED)

add_subdirectory(toulbar2-cpd)

#target_link_libraries(DLDOProject "${TORCH_LIBRARIES}")