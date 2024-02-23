# Inner Source Demo

This repo holds a sample of a first-party application that depends on a second-party library. This "Inner Source"
pattern is quite common.  I wanted a simple project to use in various demo and test scenarios

The project features a simple library that contains one method, `printSystemTime`.  It does just what it says: 
prints the local system time to the console.

This library is used a similarly-simple application that invokes this method when executed.  If run successfully, 
it will simply print the system time to STDOUT.

Both the library and application follow the "Snapshot" and "Release" patterns for Maven projects.  Snapshot and 
Release artifacts are deployed to different repos.  This behavior is configured by conventional `-SNAPHOT` suffix on 
the artifact name XML snippts like so:

Snapshot:
```xml
<groupId>com.tomfjrog</groupId>
<artifactId>system-time-printer</artifactId>
<version>1.0.1-SNAPSHOT</version>
```
Release:
```xml
<groupId>com.tomfjrog</groupId>
<artifactId>system-time-printer</artifactId>
<version>1.0.1</version>
```
# How to Build & Deploy
1. Configure separate repo structures for the library and the application.  The setup here follows the "Pre-Built" 
   setup for Maven repos in Artifactory.
2. Edit the `settings.xml.example` files in the `application` and `library` repos with an appropriate username and 
   password/access_token for Artifactory.  Copy or rename this file to remove the `.example` suffix.
3. Build & deploy the library first by running `mvn clean install -s settings.xml && mvn deploy -s settings.xml` in 
   the `library` directory.
4. Build and deploy the application next by running `mvn clean install -s settings.xml && mvn deploy -s settings.xml` in
   the `application` directory.