 Projects are Located in Windows Machine :
 
 * Open Jenkins → Click New Item → Select Freestyle Project → Click OK.
 * Scroll down to Source Code Management.
 * Select None (since the project is local).
 * In Build Steps, click Add build step → Execute Windows batch command.
 * Enter the following command to navigate to your local project directory 	and build it

	 ### cd /d C:\path\to\your\project
 	 ###  mvn clean package