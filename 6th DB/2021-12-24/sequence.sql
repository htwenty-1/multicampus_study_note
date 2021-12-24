-- 문제1) EMPLOYEES 테이블에서 부서별로 인원수,평균 급여,급여의 합,최소 급여,최대 급여를 포함하는
-- EMP_DEPTNO 테이블을 생성하라.

drop table EMP_DEPTNO;

create table EMP_DEPTNO(STAFF, SALAVG, SUMAVG, MINSAL, MAXSAK)
as select count(*), round(avg(SALARY)), sum(SALARY), min(SALARY), max(SALARY)
from EMPLOYEES
group by DEPARTMENT_ID;


-- 문제2) EMP_DEPTNO 테이블에 ETC COLUMN을 추가하라. 단 자료형은 VARCHAR2(50) 사용하라.
alter table EMP_DEPTNO add ETC varchar2(50);

-- 문제3) EMP_DEPTNO 테이블에 ETC COLUMN을 수정하라. 자료 형은 VARCHAR2(15)로 하라.


-- 문제4) EMP_DEPTNO 테이블에 있는 ETC 을 삭제하고 확인하라.
delete
from EMP_DEPTNO
where ETC is null;

-- 문제5) 이전에 생성한 EMP_DEPTNO 테이블의 이름을 EMP_DEPT로 변경하라.


-- 문제6) EMP_DEPT 테이블을 삭제하라.
