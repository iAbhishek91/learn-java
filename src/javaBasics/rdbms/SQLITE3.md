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
select * from albums order by artist desc;
select * from songs order by album, track;
select count(*),album from songs group by album;
select * from songs join albums on songs.album = albums._id LIMIT  10;
select s.title song,a.name artist from songs s join albums a on s.album = a._id;
select s.title song,a.name artist from songs s inner join albums a on s.album = a._id;
select a.name,al.name,s.track,s.title from songs s 
inner join albums al on s.album=al._id 
inner join artists a on al.artist=a._id
where al.name like '%cycle%'
order by a.name,al.name,s.track;

# update a table
update contacts set email="c@a.com" where name="steve";

# create a view
create view  artist_album_song_vw as
select a.name,al.name,s.track,s.title from songs s 
inner join albums al on s.album=al._id 
inner join artists a on al.artist=a._id
where al.name like '%cycle%'
order by a.name,al.name,s.track;

# delete a view
drop view artist_album_song_vw;

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

# switch on headers
.headers on
```

## Limitation

- datatype are not enforced on te column.
- alter table commands.

## Transactions

- **BEGIN TRANSACTION** : to start a transaction
- **END TRANSACTION** : to end a transaction, automatically the commit is done after a transaction, not in between.
- **COMMIT** : this commits the transaction, if COMMIT is used no need to use END TRANSACTION. In a way they are aliases.
- **ROLLBACK**: rollback any uncommitted changes and end the transactions.