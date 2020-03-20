# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Install MySQL as Docker Container

 docker run -d -p 33060:3306 --name mysql-db  -e MYSQL_ROOT_PASSWORD=secret --mount src=mysql-db-data,dst=/var/lib/mysql mysql
 
 docker exec -it mysql-db mysql -p
 
 mysql> create database todo_db;       

#### SQL creation

insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table list_to_do (id bigint not null, name varchar(255), primary key (id)) engine=MyISAM
create table list_to_do_items (list_to_do_id bigint not null, items_id bigint not null) engine=MyISAM
create table to_do (id bigint not null, completed bit not null, name varchar(255), list_to_do_id bigint, primary key (id)) engine=MyISAM
alter table list_to_do_items drop index UK_7dnsfp3h1u3ux8kfgk7tm5emk
alter table list_to_do_items add constraint UK_7dnsfp3h1u3ux8kfgk7tm5emk unique (items_id)
alter table list_to_do_items add constraint FKnncddxn80jwkuatj16qgnlux7 foreign key (items_id) references to_do (id)
alter table list_to_do_items add constraint FKjxy48s3babv6q7uqupe7xnyw9 foreign key (list_to_do_id) references list_to_do (id)
alter table to_do add constraint FKfif503pkhvxcgl2rbxtu6gnm8 foreign key (list_to_do_id) references list_to_do (id)