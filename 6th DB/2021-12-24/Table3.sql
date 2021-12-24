/*
    무결성: Constraint, Column을 지정하는 성질

    Primary Key: 기본키, NULL(빈칸)이나 중복을 허용하지 않는다.
    Unique Key : 고유한 값, NULL을 허용한다. 중복은 허용하지 않는다.
    Foreign Key : 외래키, 테이블과 테이블을 연결한다.
                  외래키로 설정된 컬럼은 Primary Key나 Unique Key로 설정되어 있어야 한다.
    CHECK : 범위를 지정할 수 있고, 지정된 값 이외에 NULL을 사용한다.
    NOT NULL: NULL, 빈칸을 허용하지 않음
*/

-- NOT NULL
create table TB_TEST1
(
    COL1 varchar2(10) NOT NULL,
    COL2 varchar2(20)
);

insert into TB_TEST1(col1, col2)
values ('AAA', '111');

insert into TB_TEST1(col1)
values ('bbb');

-- insert into TB_TEST1(col1, col2)
-- values ('', '222')       --- 빈칸도 NULL

---------------------------------------------

-- Primary Key = Unique Key _ NOT NULL
drop table TB_TEST1
cascade constraints;

create table TB_TEST1(
    PKCOL VARCHAR2(10), constraint PK_TEST_01 PRIMARY KEY,
    COL1 VARCHAR(20),
    COL2 VARCHAR(30)
);

insert into TB_TEST1(pkcol, col1, col2)
values ('aaa', 'AAA', 'BBB');

insert into TB_TEST1(PKCOL)
values ('bbb');

insert into TB_TEST1(pkcol, col1, col2)
values('ccc', 123, '456');

drop table TB_TEST1;

------------------------------------------------
-- unique key

create table tb_test(
    ukcol varchar2(10) constraint uk_test_0 unique,
    col1 varchar(20),
    col2 varchar(20)
);

insert into tb_test(ukcol, col1, col2)
values('AAA', '111', 123);

insert into tb_test(col1, col2)
values('111', 123);

-- primary키와 unique key 삭제하기
alter table tb_test
drop
constraint uk_test_0;


-- check : 지정된 반환값만 사용, NULL허용
create table TB_CHECK(
    col1 varchar2(2),
    col2 varchar2(40),
    constraint chk_01 check(col1 in '...'),
    constraint chk_01 check(col2 > 0 and col2 <=10 )
);
------------------------------------

/*
    Foreign Key 외래키
    목적 : 테이블간 연결
    Primary Key나 Unique Key로 설정되어 있어야 한다
    NULL을 허용한다.
*/

drop table TB_DEPT
cascade constraints;

-- 기본 테이블
create table TB_DEPT(
    DEPARTMENT_ID varchar2(10),
    DEPARTMENT_NAME varchar2(20),
    LOCATION_ID number,
    constraint PK_DEPT_TEST PRIMARY KEY(DEPARTMENT_ID)
);

drop table TB_EMP
cascade constraints;

-- 연결할 테이블
create table TB_EMP(
    ENPNO varchar2(10),
    ENAME varchar2(20),
    DEPARTMENT_ID VARCHAR2(10),
    constraint FK_EMP_TEST foreign key(DEPARTMENT_ID)
    references TB_DEPT(DEPARTMENT_ID)
);

insert into TB_DEPT(department_id, department_name, location_id)
values ('10', '기획부', 02);
insert into TB_DEPT(department_id, department_name, location_id)
values ('20', '영업부', 042);
insert into TB_DEPT(department_id, department_name, location_id)
values ('30', '개발부', 055);
insert into TB_DEPT(department_id, department_name, location_id)
values ('40', 'IT부', 065);


insert into TB_EMP(enpno, ename, department_id)
values(1,'홍길동', 10);

insert into TB_EMP(enpno, ename, department_id)
values(2,'성춘향', 20);

insert into TB_EMP(enpno, ename, department_id)
values(3,'홍두깨', 30);

insert into TB_EMP(enpno, ename, department_id)
values(4,'일지매', '');



