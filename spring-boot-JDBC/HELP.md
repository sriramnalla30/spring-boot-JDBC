# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/maven-plugin/reference/html/#build-image)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/html/features.html#features.testing.testcontainers)
* [Testcontainers DB2 Module Reference Guide](https://java.testcontainers.org/modules/databases/db2/)
* [Testcontainers MariaDB Module Reference Guide](https://java.testcontainers.org/modules/databases/mariadb/)
* [Testcontainers MySQL Module Reference Guide](https://java.testcontainers.org/modules/databases/mysql/)
* [Testcontainers Oracle-Free Module Reference Guide](https://java.testcontainers.org/modules/databases/oraclefree/)
* [Testcontainers Postgres Module Reference Guide](https://java.testcontainers.org/modules/databases/postgres/)
* [Testcontainers MS SQL Server Module Reference Guide](https://java.testcontainers.org/modules/databases/mssqlserver/)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#data.sql.jdbc)
* [Apache Freemarker](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [JDBC API](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#data.sql)
* [Jersey](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#web.servlet.jersey)
* [Mustache](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Testcontainers](https://java.testcontainers.org/)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Vaadin](https://vaadin.com/docs)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#web)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#io.webservices)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#web.reactive)
* [WebSocket](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/htmlsingle/index.html#messaging.websockets)

### Guides
The following guides illustrate how to use some features concretely:

* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Creating CRUD UI with Vaadin](https://spring.io/guides/gs/crud-with-vaadin/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)

### Testcontainers support

This project uses [Testcontainers at development time](https://docs.spring.io/spring-boot/docs/3.2.8-SNAPSHOT/reference/html/features.html#features.testing.testcontainers.at-development-time).

Testcontainers has been configured to use the following Docker images:

* [`mariadb:latest`](https://hub.docker.com/_/mariadb)
* [`mysql:latest`](https://hub.docker.com/_/mysql)
* [`gvenzl/oracle-free:latest`](https://hub.docker.com/r/gvenzl/oracle-free)
* [`postgres:latest`](https://hub.docker.com/_/postgres)
* [`mcr.microsoft.com/mssql/server:latest`](https://mcr.microsoft.com/en-us/product/mssql/server/about/)

Please review the tags of the used images and set them to the same as you're running in production.

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

