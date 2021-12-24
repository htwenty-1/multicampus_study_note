/*
    table : 기본적인 저장단위
    구성 : row, column

    도구로 작성할 수도 있고 쿼리문으로 작성할 수도 있는데 쿼리문을 많이 씀..

    table은 객체로 취급함.

    구분 잘해라~
    (table) create => 생성, drop => 삭제, alter => 수정
    (data)  insert => 생성, delete => 삭제, select => 검색, update => 수정
*/


-- 테이블 생성
create table TB_TEST01(
    COL1 varchar2(10 byte),
    COL2 varchar2(10 byte),
    COL3 varchar2(10 byte)
);

create table TB_TEST02(
    COL1 varchar2(10 byte),
    COL2 varchar2(10 byte),
    COL3 varchar2(10 byte)
)tablespace /*테이블 스페이스 이름*/;

-- 복제 : 데이터를 포함한 테이블 전체 복사
create table TB_TEST03 as select * from EMPLOYEES;

drop table TB_TEST04;

-- 복제 : 데이터 미포함 복제
create table TB_TEST04
    as select EMPLOYEE_ID, FIRST_NAME, SALARY from EMPLOYEES where 1=2;    -- 성립되지 않는 조건을 입력하면 데이터 미포함

-- 데이터를 포함하지 않고 복제한 후 컬럼명 바꾸기
create table TB_TEST04(empno, name, money)
    as select EMPLOYEE_ID, FIRST_NAME, SALARY from EMPLOYEES where 1=2;    -- 성립되지 않는 조건을 입력하면 데이터 미포함

-- 테이블 수정: alter -- 테이블명
alter table TB_TEST04
rename to TB_TEST99

-- 컬럼추가
alter table  TB_TEST99
add DEPT_NAME number(3);

-- 컬럼 수정
alter table TB_TEST99
modify DEPT_NAME varchar2(20);

-- 컬럼 삭제
alter table TB_TEST99
drop column DEPT_NAME;

-- 테이블 삭제
drop table TB_TEST01;
drop table TB_TEST02;
drop table TB_TEST03;
drop table TB_TEST04;

purge recyclebin;   ---> 휴지통에 안남음...