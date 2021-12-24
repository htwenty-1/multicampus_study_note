create table STUDENT(
    NO integer,
    NAME varchar2(30),
    HEIGHT number(5, 1)
);

drop table STUDENT;

insert into STUDENT(no, name, height)
values (TEST_SEQ.nextval, '홍길동', 171.1);

select * from STUDENT;

insert into STUDENT(no, name, height)
values (TEST_SEQ.nextval, '성춘향', 156.2);

insert into STUDENT(no, name, height)
values (TEST_SEQ.nextval, '홍두깨', 185.4);