
mvn archetype:generate -DgroupId=com.example -DartifactId=voting-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

 cd voting-app     

we have to add Spring Boot Starter Web manually in pom.xml file   

mvn clean install // create a target folder with a jar file

java -jar target/voting-app-1.0-SNAPSHOT.jar. // run the jar file using this command 




http://localhost:8080/entercandidate?name=ajay
http://localhost:8080/castvote?name=ajay
http://localhost:8080/countvote?name=ajay
http://localhost:8080/listvote
http://localhost:8080/getwinner