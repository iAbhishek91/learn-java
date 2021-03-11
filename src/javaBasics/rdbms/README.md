# JDBC

Is a middleman b/w java application, and the data source. JDBC driver will change based on the data source.

For example, to connect SQLite we need JDBC driver for SQLite which is different from MySql.

JDBC driver implements the same interface, so we can use any database with our application. *It's very similar to selenium webDriver*.

In another word, JDBC is a java library containing classes that implements JDBC API.

JDBC driver are written by database provider, if required we can write our own databases.

JDBC driver can be executed from internet or using build tools like Maven or Gradle. wil come in `*.jar`.


## JDBC structure

It consists of two package `java.sql` and `javax.sql` .

## JDBC browser

Optionally one can install, SQLite client from https://sqlitebrowser.org/dl/.

 Else we can use the command line tool `sqlite3` which comes with the database.
 
 > NOTE: JDBC Browser will lock the db file, and will not be able to accessed from CLI or from java code. Release the lock before performing any actions from elsewhere. `File > close database`.

## Transactions

When we perform more that one query to complete a task we need to make sure that when MULTIPLE QUERY are executed
we either complete all the query or none.

ACID property should be maintained:

- **A** : Atomicity -  all the changes are committed or none
- **C** : Consistency - db state should be valid before and after the transaction
- **I** : Isolation - until changes are committed, it should not be visible to each other.
- **D** : Durability - Once changes are committed, they are permanent. If db goes down or something happens the transaction should be available once its back up.