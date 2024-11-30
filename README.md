## This project was built with: 
- Android Studio 2024.2.1 Patch 2
- Android SDK 34 and build tools
- NDK 28.0.12674087
- CMake 3.31.0

## The following scripts are provided but are very bare bones: 

- BUILD.bat - Invokes gradle to build the project. 
- INSTALL.bat - Installs the apk on a connected android device. 
- RUN.bat - Runs the app on the connected android device. 

## The relevant source files are: 

### Application
#### app/src/main/java/com/example/testjavaapp/MainActivity.java
The java application with a very basic UI

### Native Lib
#### TestNativeLib/src/main/java/com/example/testnativelib/NativeLib.java
The java side of the library
#### TestNativeLib/src/main/cpp/testnativelib.h
#### TestNativeLib/src/main/cpp/testnativelib.cpp
The C++ side of the library
