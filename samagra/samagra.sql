--person table for all
--create table person(personId Serial primary key,firstName varchar, middleName varchar,lastName varchar,DOB varchar, sex varchar(7), createdDate varchar, updatedDate varchar,activeInd int)
--Address table for all
--create table address(addressId serial primary key, addressPersonId integer ,Addr1 varchar,Addr2 varchar,Addr3 varchar, city varchar, state varchar,pin varchar,createdDate varchar, updatedDate varchar,activeInd int)

--Student table for first service
	create table person(personId Serial primary key,firstName varchar, middleName varchar,lastName varchar,DOB varchar, sex varchar(7),emailid varchar,contactno varchar(15),createdDate Date  default current_date,
	  updatedDate Date,
	activeInd integer default 1)
--create table Staff (
	staffId serial primary key,
	staffType varchar,
	staffPersonId integer,
	addressId integer,
	divisionId integer default NULL,
	 createdDate Date  default current_date,
	  updatedDate Date,
	activeInd integer default 1)
	drop table student
create table student(studentId serial primary key,
 studentPersonId integer,
  registerNumber integer,
  admissionNumber integer,
  studentAddressID integer,
  divisionId integer ,
  markId integer,
  createdDate varchar default current_date, 
  updatedDate varchar,
  activeInd int default 1)
create table emailtemplates(templateid serial primary key,
templatename varchar,
mailcontent varchar,
keyparam varchar(10),
templatedescription varchar,
 createdDate Date  default current_date,
	  updatedDate Date,
	activeInd integer default 1)
 create table Marks(
	markId serial primary key,
	subjectId integer,
	studentId integer,
	 mark float,
	grade varchar,
	staffId integer,
	createdDate date,
	updatedDate date,
	activeInd integer)
create table Subjects(subjectsId serial primary key,
	subjectName varchar,
	staffId integer,
	createdDate date,
	updatedDate date,
	activeInd integer)
	
	select * from subjects
	
	drop table subjects
	

	insert into staff(stafftype,staffpersonid,addressid) values('test',1,2)
	select * from staff.
	select * from staff
update staff set updateddate=null, activeind=1
truncate staff
SELECT * FROM Staff WHERE staffId = 7 AND activeInd!=0
insert into staff(stafftype,staffpersonid,addressid) values('test',1,2)
drop table staff
create table Staff (
	staffId serial primary key,
	staffType varchar,
	staffPersonId integer,
	addressId integer,
	divisionId int,
	 createdDate Date  default current_date,
	  updatedDate Date,
	activeInd integer default 1)
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
select * from division
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
    VALUES ( 2, 23, 45, 
            1, current_date, current_date, 1);

 update person set firstname='boogeyman' where personid=1
 
 delete from Student where studentid=1
 
 select * from Person p inner join
Student s
on s.studentPersonId=p.personid

--create table person(personId Serial primary key,firstName varchar not null, middleName varchar,lastName varchar not null,dob varchar, sex varchar(7) not null, createdDate date, updatedDate date,activeInd int)
--create table student(studentId serial primary key, studentPersonId integer references person(personid), registerNumber integer,admissionNumber integer,studentAddressID integer not null references address(addressId),createdDate date, updatedDate date,activeInd int)
select * from division d inner join Student s 
on d.divisionid=s.divisionid 
inner join
Person p 
on s.studentPersonId=p.personid
inner join address a
on a.addressid=s.studentaddressid
where s.registerrnumber =456
where s.studentid=4
where p.activeind!=0 and s. activeind!=0 and p.personid=23
delete from student where studentId=5
select * from division
select * from staff
update student set divisionid=1
select * from Staff s inner join
Person p 
on p.personid=s.staffpersonid
insert into staff(stafftype,staffpersonId,divisionid) values('faculty',25,1)
update student set divisionid=1 where studentid=4
select * from address
select * from Person
select * from student
--delete  from Student 
rollback()
--delete from person
--delete from address
update person set activeINd=1 where personid in (18,19)
begin transaction
drop table address;
delete from staff where staffpersonid=1524
drop table person
drop table student

create table address(addressId serial primary key, addressPersonId integer not null references person(personid),addr1 varchar,addr2 varchar,addr3 varchar, city varchar, state varchar,pin varchar,createdDate date, updatedDate date,activeInd int)
commit
rollback()
insert into person(person
INSERT INTO address(
            addresspersonid, addr1, addr2, addr3, city, state, 
            pin, createddate, updateddate, activeind)
    VALUES ( 1, 'test', 'test', 'test', 'test', 'test', 
            'test', current_date, current_date, 1);
