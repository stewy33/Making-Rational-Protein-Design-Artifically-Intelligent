set(CMAKE_CXX_STANDARD 11)

project(DLDOProject)

add_subdirectory(toulbar2-cpd)


find_package(Torch REQUIRED)

target_link_libraries(DLDOProject "${TORCH_LIBRARIES}")