create table DEFT(DEPTNO, DNAME, MGR, LOC)
as select DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID
from DEPARTMENTS
where 1 = 2;

drop table DEFT purge;

-- insert

insert into DEFT(deptno, dname, mgr, loc)
values (10, '기획부', 100, 042);

insert into DEFT(deptno, dname)
values (20, '관리부');

insert into DEFT
values(30, 'IT부', 333, 02);

insert into DEFT(dname, deptno, mgr, loc)
values('경리부', 40, 200, 031);

-- insert into DEFT            --- not enough values
-- values(30, 'IT부', 40)

insert into DEFT(deptno, dname, mgr, loc)
values('40', '경리부', 200, 031);

-- 삭제
delete
from DEFT
where DNAME = 100;

delete
from DEFT
where mgr is null;

-- 수정
update DEFT
set mgr = 300
where DEPTNO = 30;

update DEFT
set deptno = 50, mgr = 500
where DNAME = '영업부;'

