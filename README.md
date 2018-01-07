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

## JSON Requests ##
### GET ###
Json response are on `/json` path, example: 
```
http://localhost:8080/json/makaron?transforms=inverse
```
### POST ###
Sending a json request by [cURL] (https://en.wikipedia.org/wiki/CURL) 
```
curl -H "Content-Type: application/json" -X POST -d '{"text":"MAKARON","transforms":["inverse"]}' http://localhost:8080/json
```
Or by [Advanced REST client - Chrome Extension](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=en-US)
```
{
  "text": "Makaron",
  "transforms": ["inverse"]
}
```
