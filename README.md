# web-food-mvc

[License | MIT](https://github.com/bozhyk2/web-food-mvc/blob/master/LICENSE)
 
 ## About the project
 This project is a part of the Cooking Food website. This part represents a project with the CRUD operations. It uses the MVC pattern.

### Used
* Language: `Java 8`, `HQL`, `SQL`, `HTML`, `JS`.
* Frameworks: `Spring Framework 5`, `Spring MVC`, `Hibernate`.
* Technology: `JSP`.
* Database: `MySQL`.
* Tool and Utility: `Maven`.

### What the project does
The main goal of this project is to communicate with a database. 
You can use the project to add, read, update or delete data from the database.

## How to start the project locally
### Required to install
* Java 8
* MySQL 8.0
* Tomcat 9.0
* Git Bash
* Maven

### How to run
#### a. Clone the project. 
Start your Git Bash and put the command:

```shell
git clone https://github.com/bozhyk2/web-food-mvc.git
```
#### b. Create the same database
* Start MySQL Workbench installed on your computer.
* Run `src/main/webapp/resources/db/01-create-user.sql` to create a new user/password and database schema.
* Run `src/main/webapp/resources/db/02-food-create-db.sql` to insert some data into the database.
 
 As a result, you have created the database with: 
 * url:`jdbc:mysql://localhost:3306/web_calorie_tracker_ui?useSSL=false&serverTimezone=UTC`; 
 * user: `healthybody` ;
 * password: `beauty`.
 `
#### c. Run the project
* Run the command line. Go into the project directory. Use maven commands to clean and package your project into the `war` file:
```shell
mvn clean package
```
As a result, you can see the name of the generated `war` file and its localization.
* Deploy this `war` file with [Tomcat](#How-to-deploy-the-project-with-Tomcat)

## How to deploy the project with Tomcat
* Open the webapp directory located inside the folder where Tomcat has been installed.
* Put your war file into this directory.
* If Tomcat is running on your machine you can see a new folder with the name of your project created by Tomcat.
* Open `http:/localhost:8080/web-calculator-mvc` with a browser. `web-calculator-mvc` is the name of the folder created before.

