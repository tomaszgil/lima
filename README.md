# lima
## Maven ##

### Configuration ###
1. Download Maven binaries from https://maven.apache.org/download.cgi
2. Unzip them to your computer.
3. Ensure `JAVA_HOME` environment variable is set and points to your JDK installation.
4. If not right click My Computer and select Properties.
On the Advanced tab, select Environment Variables, and then edit `JAVA_HOME` to point to where the JDK software is located.
5. Add the `bin` directory of the created directory `apache-maven` to the `PATH` environment variable.
6. Test Maven installation, run mvn from the command-line:
```
mvn -v
```
### Quick Guide ###
Building project with Maven
```
mvn compile
```
Package to a JAR file
```
mvn package
```
Install dependencies
```
mvn install
```
Run tests
```
mvn tests
```

