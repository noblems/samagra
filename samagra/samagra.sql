--person table for all
--create table person(personId Serial primary key,firstName varchar, middleName varchar,lastName varchar,DOB varchar, sex varchar(7), createdDate varchar, updatedDate varchar,activeInd int)
--Address table for all
--create table address(adrressId serial primary key, addressPersonId integer ,Addr1 varchar,Addr2 varchar,Addr3 varchar, city varchar, state varchar,pin varchar,createdDate varchar, updatedDate varchar,activeInd int)

--Student table for first service
--create table student(studentId serial primary key, studentPersonId integer, registerNumber integer,admissionNumber integer,studentAddressID integer,createdDate varchar, updatedDate varchar,activeInd int)
create table Subjects(subjectsId serial primary key,
	subjectName varchar,
	staffId integer,
	createdDate date,
	updatedDate date,
	activeInd integer)
	
	select * from subjects
	
	drop table subjects
	
create table Staff (
	staffId serial primary key,
	staffType varchar,
	staffPersonId integer,
	addressId integer,
	 createdDate Date  default current_date,
	  updatedDate Date,
	activeInd integer default 1)
	drop table staff
	insert into staff(stafftype,staffpersonid,addressid) values('test',1,2)
	select * from staff.
	select * from staff
update staff set updateddate=null, activeind=1
truncate staff
SELECT * FROM Staff WHERE staffId = 7 AND activeInd!=0
insert into staff(stafftype,staffpersonid,addressid) values('test',1,2)
create table Staff (
	staffId serial primary key,
	staffType varchar,
	staffPersonId integer,
	addressId integer,
	 createdDate Date  default current_date,
	  updatedDate Date,
	activeInd integer)
create table Division (
	  divisionId serial primary key,
	divisionName varchar,
	 staffId integer,
	 divisionDescription varchar,
	 standard integer,
	 createdDate Date  default current_date,
	  updatedDate Date,
	activeInd integer)
select * from person;
SELECT * FROM Student;
--drop table student
--drop table person
SELECT * FROM PERSON WHERE activeInd !=0
INSERT INTO person(
             firstname, middlename, lastname, dob, sex, createddate, 
            updateddate, activeind)
    VALUES ( 'test', 'test', 'test', current_date, 'Male', current_date, 
            current_date, 1);
INSERT INTO student( studentpersonid, registernumber, admissionnumber, 
            studentaddressid, createddate, updateddate, activeind)
    VALUES ( 8, 23, 45, 
            1, current_date, current_date, 1);

 update person set firstname='boogeyman' where personid=1
 
 delete from Student where studentid=1
 
 select * from Person p inner join
Student s
on s.studentPersonId=p.personid

--create table person(personId Serial primary key,firstName varchar not null, middleName varchar,lastName varchar not null,dob varchar, sex varchar(7) not null, createdDate date, updatedDate date,activeInd int)
--create table student(studentId serial primary key, studentPersonId integer references person(personid), registerNumber integer,admissionNumber integer,studentAddressID integer not null references address(addressId),createdDate date, updatedDate date,activeInd int)
select * from Student s inner join
Person p 
on s.studentPersonId=p.personid
inner join address a
on a.addressid=s.studentaddressid
where p.activeind!=0 and s. activeind!=0 and p.personid=23

select * from address
select * from Person
select * from student
delete  from Student 
delete from person
delete from address
update person set activeINd=1 where personid in (18,19)
begin transaction
drop table address;

drop table person
drop table student

create table address(addressId serial primary key, addressPersonId integer not null references person(personid),addr1 varchar,addr2 varchar,addr3 varchar, city varchar, state varchar,pin varchar,createdDate date, updatedDate date,activeInd int)
commit
rollback()
insert into person(person
INSERT INTO address(
            addresspersonid, addr1, addr2, addr3, city, state, 
            pin, createddate, updateddate, activeind)
    VALUES ( 23, 'test', 'test', 'test', 'test', 'test', 
            'test', current_date, current_date, 1);
