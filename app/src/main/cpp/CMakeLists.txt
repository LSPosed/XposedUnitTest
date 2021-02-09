cmake_minimum_required(VERSION 3.4.1)

add_library(lsposed_module SHARED main.cpp)
find_library(log-lib log)
target_link_libraries(lsposed_module ${log-lib})