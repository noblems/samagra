--person table for all
--create table person(personId Serial primary key,firstName varchar, middleName varchar,lastName varchar,DOB varchar, sex varchar(7), createdDate varchar, updatedDate varchar,activeInd int)
--Address table for all
--create table address(adrressId serial primary key, addressPersonId integer ,addr1 varchar,addr2 varchar,addr3 varchar, city varchar, state varchar,pin varchar,createdDate varchar, updatedDate varchar,activeInd int)

--Student table for first service
--create table student(studentId serial primary key, studentPersonId integer, registerNumber integer,admissionNumber integer,studentAddressID integer,createdDate varchar, updatedDate varchar,activeInd int)
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
