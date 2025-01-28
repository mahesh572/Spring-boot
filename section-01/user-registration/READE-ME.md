// put host.docker.internal instead of ${MYSQL_HOST:localhost}  host.docker.internal:3306 to access Local MYSQL installed in windows machine. and put bind_address=0.0.0.0 in my.ini file of mysql to allow every ipaddress.

http://localhost:8080/actuator

http://localhost:8080/actuator/refresh POST method

curl -X POST http://localhost:8080/actuator/refresh


Need to add "spring-cloud-starter-config" dependency in client module to pull the config changes from config server.

Dockerfile
----------------

FROM :  Which specifies that our application is java to run it requires JAVA env or JDK, so it tells to the docker using the FROM keyword.

MAINTAINER : is used for who is writing the image or updating the image- Author of the Image.

RUN : it used to specify Compile time dependencies to download to build image or any pre requisites are to run like cloning git repository, mvn clean 	     	     		install.while image creation.
		* we can write multiple instructions it is executed in order.

CMD : it is used in Runtime, like "java -jar example.jar"  -  container creation time.
        * we can write multiple instructions but it executes last instruction of the CMD.
        
       * while building docker image, only RUN instructions are executed but CMD.
       
COPY : it is used to copy files from Host machine to container machine.

       * COPY target/app.jar(host ,windows) /app/home(linux or container file system)
       * for COPY - it copies the files only if we specify the physical location 
       * COPY target/app.jar /usr/app/app.jar
       
ADD  : it is also used to copy from source to destination.

       * ADD target/app.jar(host ,windows) /app/home(linux or container file system)
       *  for ADD - it copies the files only and also downloads the files from Internet .
       * ADD target/app.jar /usr/app/app.jar
       
       * ADD <http://github.com/example> /usr/app/app.jar 
       
WORKDIR :  it is used to be working directory where we want to execute the instructions further.
         
         * Here the app.jar is copied to /usr/app directory in container file system
         WORKDIR /usr/app   -  the directory has been changed and here after the instructions are executed in /usr/app directory.
         
USER  :  it is used to set the USER who is authorized to execute the commands.

EXPOSE : 8080 -  container port

			* it is used to specify information only , it doesn't change the application port runs inside the container.
			
ENTRYPOINT : it is used to be executed at the time of Container creation and can not be modified like CMD.
            * it is used to run the application like ENTRYPOINT ["java","-jar","app.jar"]
            
            
docker :
 	 
 	 	* getting into Container - docker exec -it <container-id> /bin/bash
 	 	* to exit from the container - exit
			
Network  :

		* Bridge
		* Host
		* None
		
		Default network is Bridge.
		* Bridge - and it will assign IP address to the container
		* Host - it will not assign IP address.
		* None - no network is available.
		
	we can use other 2 networks.
	
	   * Overlay
	   * MacVlan
	   
	   Overlay : is used for orchastration purpose - Docker swarm.
	   MacVlan : it assigns the physical ip address to the container.
	   
	   
	   docker network ls
	   docker network create mahesh-net
	   docker network rm mahesh-net
	   docker network inspect mahesh-net
	   
	   docker run -d -p 8080:8080 --network mahesh-net 8357/config-server
	   
	   

  
       
        

