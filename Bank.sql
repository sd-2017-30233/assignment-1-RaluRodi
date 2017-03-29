drop database if exists Bank;
create database if not exists Bank;
use Bank;

create table ClientInfo(
id int unique auto_increment primary key,
nameC varchar(40),
identity_card_nr int,
cnp char(20),
adress varchar(40));

create table Employee(
id int auto_increment primary key,
nameE varchar(40),
age int,
empl_date date);

create table Account(
id int unique auto_increment primary key,
account_type varchar(20),
amount int,
creation_date date,
id_client int,
id_employee int,
foreign key (id_client) references ClientInfo(id),
foreign key (id_employee) references Employee(id));

create table Admin(
username varchar(20),
pass varchar(20));

create table BasicUser(
username varchar(20),
pass varchar(20));

create table Bill(
id int unique auto_increment primary key,
bill_type varchar(20),
amount int,
id_client int,
foreign key(id_client) references ClientInfo(id));

insert into ClientInfo values
(1,'Sechel Raluca',123456,'2951507981234','Cluj-Napoca'),
(2,'Dregan Anda',786432,'2881503654382','Jibou'),
(3,'Ilies Vlad',764902,'1871207654873',	'Zalau'),
(4,'Popa Cristina',765912,'2910324675123','Jibou'),
(5,'Pintea Rares',124563,'1881213981234','Cluj-Napoca');

insert into Employee values
(1,'Popescu Dan',33,'2015-04-12'),
(2,'Sechel Stefan',40,'2014-02-13');

insert into Account values
(1,'spending account',500,'2017-04-16',1,1),
(2,'saving account',1000,'2016-10-12',2,1),
(3,'spending account',1400,'2015-02-14',3,2),
(4,'saving account',2000,'2016-10-15',4,2),
(5,'saving account',3000,'2016-12-12',5,2);


insert into BasicUser values
('user1','user1'),
('user2','user2');

insert into Admin values
('admin1','admin1'),
('admin1','admin1');

insert into Bill values
(1,'gas',65,1),
(2,'telephone',50,2);

select c.nameC as Nume,a.amount SumaTotala,b.amount SumaPlata from ClientInfo c, Account a, Bill b
where c.nameC='Pintea Rares' and a.id_client=c.id and b.id_client=c.id;


select e.nameE as Nume,c.NameC as NumeClient, a.account_type as Tip,a.amount as Suma from Account a, clientInfo c, Employee e
where a.creation_date>'2015-01-16' and a.creation_date>'2017-07-16' and a.id_client=c.id and a.id_employee=e.id and e.nameE='Sechel Stefan';



#OPERATII CLIENT

DROP PROCEDURE IF EXISTS ADD_CLIENT;
DELIMITER //
CREATE PROCEDURE ADD_CLIENT(nume varchar(20), idc_nr int, cnp char(20), adress varchar(20))
	BEGIN
		SET @idClinet:=NULL;
        
        SELECT @idClinet:=MAX(id) from ClientInfo;
        SET @idClient:=@idClient+1;
        
        INSERT INTO ClientInfo VALUES
        (@idClient,nume,idc_nr,cnp,adress);
        
	END //
DELIMITER ;

call ADD_CLIENT('Sechel Stefan',376385,'1700129654289','Jibou');
select * from ClientInfo;




DROP PROCEDURE IF EXISTS UPDATE_CLIENT;
DELIMITER //
CREATE PROCEDURE UPDATE_CLIENT (nameN varchar(20),idc_nrN int, cnpN char(20), adressN varchar(20))
	BEGIN
		START TRANSACTION;

            UPDATE ClientInfo SET ClientInfo.nameC = nameN,ClientInfo.identity_card_nr = idc_nrN,ClientInfo.cnp = cnpN,ClientInfo.adress = adressN
            WHERE
            ClientInfo.nameC = nameN;
   			COMMIT;
  END //
DELIMITER ;

call UPDATE_CLIENT('Sechel Raluca',123456,'2951507981234','Jibou');



#OPERATII CONT

DROP PROCEDURE IF EXISTS CREATE_ACCOUNT;
DELIMITER //
CREATE PROCEDURE CREATE_ACCOUNT (typea varchar(20), amount int, datec date,idc int,ide int)
	BEGIN
		SET @idAccount:=NULL;
        SELECT @idAccount:=MAX(id) from Account;
        SET @idAccount:=@idAccount+1;
        
        INSERT INTO Account VALUES
        (@idAccount,typea,amount,datec,idc,ide);
	END //
DELIMITER ;

CALL CREATE_ACCOUNT('Spending Account',1000,'2017-03-21',1,1);
select * from Account;



DROP PROCEDURE IF EXISTS UPDATE_ACCOUNT;
DELIMITER //
CREATE PROCEDURE UPDATE_ACCOUNT(idN int,typeN varchar(20),amountN int)
	BEGIN
		START TRANSACTION;
        
        UPDATE Account SET Account.account_type=typeN, Account.amount=amountN
        WHERE Account.id=idN;
        COMMIT;
	END //
DELIMITER ;

call UPDATE_ACCOUNT(1,'Saving Account',1900);



DROP PROCEDURE IF EXISTS DELETE_ACCOUNT;
DELIMITER //
CREATE PROCEDURE DELETE_ACCOUNT(idN int)
	BEGIN 
    
    delete from Account where Account.id=idN;
    
    END //
    
DELIMITER ;
call DELETE_ACCOUNT(1);



DROP PROCEDURE IF EXISTS UPDATE_AMOUNT;
DELIMITER //
CREATE PROCEDURE UPDATE_AMOUNT(idN int,amountN int)
	BEGIN
		START TRANSACTION;
        
        UPDATE Account SET Account.amount=amountN
        WHERE Account.id=idN;
        COMMIT;
	END //
DELIMITER ;


call update_amount(1,1098);


#OPERATII EMPLOYEE

DROP PROCEDURE IF EXISTS ADD_EMPLOYEE;
DELIMITER //
CREATE PROCEDURE ADD_EMPLOYEE(nume varchar(20), age int, empl_date date)
	BEGIN
		SET @idEmployee:=NULL;
        
        SELECT @idEmployee:=MAX(id) from Employee;
        SET @idEmployee:=@idEmployee+1;
        
        INSERT INTO Employee VALUES
        (@idEmployee,nume,age,empl_date);
        
	END //
DELIMITER ;

CALL ADD_EMPLOYEE('Ionescu Eugen',40,'2014-02-17');
select * from Employee;



DROP PROCEDURE IF EXISTS UPDATE_EMPLOYEE;
DELIMITER //
CREATE PROCEDURE UPDATE_EMPLOYEE (nameN varchar(20),ageN int, empl_dateN date)
	BEGIN
		START TRANSACTION;

            UPDATE Employee SET Employee.nameE = nameN,Employee.age = ageN,Employee.empl_date = empl_dateN
            WHERE
            Employee.nameE = nameN;
   			COMMIT;
  END //
DELIMITER ;

CALL UPDATE_EMPLOYEE('Ionescu Eugen',45,'2015-02-12');


DROP PROCEDURE IF EXISTS DELETE_EMPLOYEE;
DELIMITER //
CREATE PROCEDURE DELETE_EMPLOYEE(nume varchar(20))
	BEGIN 
    
    delete Employee,Account From Employee INNER JOIN Account
    where Employee.nameE=nume and Employee.id=Account.id_employee;
    END //
DELIMITER ;

CALL DELETE_EMPLOYEE('Popescu Eugen');


select * from BasicUser;



