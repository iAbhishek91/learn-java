# SQLite

For practicing on a laptop. It saves the data on a file.

*Easily find the file using `ll`  command.*

## Installation

On Mac its already installed.

test using `sqlite3` on terminal. Exit using `.quit`.

`...>` mean you are in between a line, end using `;` character. 

## Command

```shell script
# create a database
sqlite3 doctord.db

# create a table
create table contacts (name text, phone integer, email text);

# insert row
insert into contacts (name, phone, email) values ('Abhishek', 123456, 'a@a.com');
insert into contacts values ('Abhishek', 123456, 'a@a.com');

# query db
select * from contacts;

# update a table
update contacts set email="c@a.com" where name="steve";

# backup the table
.backup testbackup

# restore
.restore testbackup

# list tables
.tables

# Structure of your tables
.schema

# Exit or quit
.quit
.exit
```

## Limitation

- datatype are not enforced on te column.
- alter table commands.