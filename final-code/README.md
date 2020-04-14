This document is very helpful if you want to connect to mariadb/mysql on localhost

# Database connectivity
create database pac;

CREATE TABLE test (
    idd INT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY(idd)
);

insert into test values(1, "test");

select * from test;
------------------------------------------------
### Install mariadb using homebrue for MAC
https://mariadb.com/resources/blog/installing-mariadb-10-1-16-on-mac-os-x-with-homebrew/


### Download connector jar file from offcial
https://downloads.mariadb.com/Connectors/java/connector-java-2.6.0/

### Add database connector to classpath
export CLASSPATH=mariadb-java-client-2.6.0.jar:.

### start database
mysql -p pac
enter password is any else press enter

### Incase you want to add a new user to a DB
MariaDB [pac]> GRANT ALL PRIVILEGES ON *.* TO 'test'@'localhost' IDENTIFIED BY 'test' WITH GRANT OPTION;

### to see existing users
mysql -p mysql
MariaDB [mysql]> select user, authentication_string, host from User;

### setting classpath on MAC
```export CLASSPATH=:mariadb-java-client-2.6.0.jar:.```

nano ~/.bash_profile


rm *.class
javac Wolfcity.java 
java Wolfcity