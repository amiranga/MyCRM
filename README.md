# MyCRM

Simple application to manage customer data in an organization


### Prerequisites

* Java 8+
* Maven
* Wildfly
* Mysql


### Installing

1. Clone the repo
    ```sh
    git clone https://github.com/amiranga/MyCRM.git
    ```
2. Run sql scripts included in `/src/main/resources/scripts.sql`

3. Update mysql user name and password inside `/src/main/resources/hibernate.cfg.xml` file.

4. Install dependancies and build the project `config.js`
    ```sh
    mvn clean install
    ```

5. Deploy generated `target/mycrm.war` in wildfly
    
    If you are using InteliJ Idea, Use following configurations to deploy the application
    
    ![deployment configs](https://user-images.githubusercontent.com/8085994/67230896-cffa4f00-f45b-11e9-8496-6b66755ac0cb.png?raw=true "Title")

6. Access the application `http://localhost:8080/mycrm/`


### Built With

* [Spring](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Hibernate](https://hibernate.org/orm/) - ORM tool
* [jtable](http://www.jtable.org) - jQuery Framework to create CRUD tables

### Directory Structure

```aidl

.
├── pom.xml
├── README.md
├── src
    ├── main
        ├── java
        │   └── com
        │       └── amila
        │           └── mycrm
        │               ├── common
        │               ├── controller
        │               ├── dao
        │               ├── dto
        │               ├── entities
        │               ├── service
        │               └── util
        ├── resources
        │   ├── application.properties
        │   ├── hibernate.cfg.xml
        │   └── scripts.sql
        └── webapp
            ├── css
            ├── js
            └── WEB-INF
                ├── dispatcher-servlet.xml
                ├── views
                └── web.xml

```
### Application User Interface

*  List users

![List](https://user-images.githubusercontent.com/8085994/67230889-cec92200-f45b-11e9-9ee6-685b5a026944.png?raw=true "Title")

*  Add users

![add](https://user-images.githubusercontent.com/8085994/67230892-cec92200-f45b-11e9-9a81-d57f83332a7e.png?raw=true "Title")

*  Edit users

![edit](https://user-images.githubusercontent.com/8085994/67230894-cf61b880-f45b-11e9-9dde-59fb13135414.png?raw=true "Title")

*  Delete users

![delete](https://user-images.githubusercontent.com/8085994/67230893-cf61b880-f45b-11e9-83d9-b293f972f46a.png?raw=true "Title")


### License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
