# virtual-residential-manager-project

  A project for software engineering class.
  

## How to run?

    ./mvnw clean package && java -jar target/vrm.0.0.1-SNAPSHOT.jar


(the file name may be wrong, please make sure to use the same thing that is in your target folder. 

Done! You have a service running on your 8888 port. Now you can make requests to the API's. 
Example: 

Use curl to send a put request to the following url: 

    http://localhost:8888/gate?c=1
