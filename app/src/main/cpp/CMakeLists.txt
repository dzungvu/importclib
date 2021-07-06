cmake_minimum_required(VERSION 3.4.1)

# configure import libs
set(distribution_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../distribution)

#Add gmath library, because this lib is .a lib, so we add it as STATIC library
add_library(lib_gmath STATIC IMPORTED)
set_target_properties(lib_gmath PROPERTIES
        IMPORTED_LOCATION ${distribution_DIR}/gmath/lib/${ANDROID_ABI}/libgmath.a
        )


#Add gmath-bridge, later then, we will use this file to communicate with .h file
add_library(gmath-bridge SHARED
        gmath-bridge.cpp)

#Specifies include directories to use when compiling a given target
#More detail, view this https://cmake.org/cmake/help/latest/command/target_include_directories.html
target_include_directories(gmath-bridge PRIVATE
        ${distribution_DIR}/gmath/include
        )

#Specify libraries or flags to use when linking a given target and/or its dependents
#https://cmake.org/cmake/help/latest/command/target_link_libraries.html
target_link_libraries(gmath-bridge
        lib_gmath
        log)
