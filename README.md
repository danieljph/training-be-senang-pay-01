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
