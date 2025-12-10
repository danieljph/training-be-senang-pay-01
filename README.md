# Training BE SenangPay - Java Fundamentals

# Install SDKMan
Follow instruction on https://sdkman.io/install/

# Java Print (javap)
- To print Java class bytecode: javap -c MyFirstClassWithoutPackage

# Enable Java Debugger
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=9009 MyFirstClassWithoutPackage

# GraalVM
- Enable JDK GraalVM: sdk use java 21.0.2-graalce
- Compile java class using: javac MyFirstClassWithoutPackage.java
- Create Native-Image using: native-image MyFirstClassWithoutPackage
- Run Native-Image: ./MyFirstClassWithoutPackage

# Maven
Here are some of the most important phases in the default build lifecycle:
- validate: check if all information necessary for the build is available
- compile: compile the source code
- test-compile: compile the test source code
- test: run unit tests
- package: package compiled source code into the distributable format (jar, war, …)
- integration-test: process and deploy the package if needed to run integration tests
- install: install the package to a local repository
- deploy: copy the package to the remote repository
