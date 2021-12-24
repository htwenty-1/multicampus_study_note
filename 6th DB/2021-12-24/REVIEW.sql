-- 문제1) EMPLOYEES 테이블에서 Kochhar의 급여보다 많은 사원 정보의 사원번호,이름,담당업무,급여를 출력하라.
select EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
from EMPLOYEES
where SALARY > (select SALARY
                from EMPLOYEES
                where LAST_NAME = 'Kochar');

-- 문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 정보를
-- 사원번호,이름,담당업무,급여,부서번호를 출력하여라.
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY < (SELECT ROUND(AVG(SALARY)) FROM EMPLOYEES);

-- 문제3) EMPLOYEES 테이블에서 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하라
select DEPARTMENT_ID, min(SALARY)
from EMPLOYEES
group by DEPARTMENT_ID
having min(SALARY) > (select min(SALARY)
                      from EMPLOYEES
                      where DEPARTMENT_ID = 100)

-- 문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하여라.
-- 단 업무별로 정렬하여라.
select EMPLOYEE_ID,
       FIRST_NAME,
       JOB_ID,
       DEPARTMENT_ID
from EMPLOYEES
where (JOB_ID, salary ) in (select JOB_ID, min(SALARY)
                            from EMPLOYEES
                            group by JOB_ID)

-- 문제5) EMPLOYEES 과 DEPARTMENTS 테이블에서 업무가 SA_MAN 사원의 정보를 이름,업무,부서명,근무지를 출력하라.
-- FROM, WHERE절 둘 다 작성

-- FROM
select FIRST_NAME,
       JOB_ID,
       d.DEPARTMENT_NAME,
       CITY
from (select *
      from EMPLOYEES
      where JOB_ID = 'SA_MAN') e,
      DEPARTMENTS d,
      LOCATIONS l
where e.DEPARTMENT_ID = d.DEPARTMENT_ID
    and d.LOCATION_ID = l.LOCATION_ID;

-- where
select FIRST_NAME, JOB_ID, DEPARTMENT_NAME, CITY
from EMPLOYEES e, DEPARTMENTS d, LOCATIONS l
where e.DEPARTMENT_ID = d.DEPARTMENT_ID
    and d.LOCATION_ID = l.LOCATION_ID
    and e.JOB_ID = 'SA_MAN';

-- 문제6) EMPLOYEES 테이블에서 가장 많은 사원을 갖는 MANAGER의 사원번호를 출력하라.
select MANAGER_ID
from EMPLOYEES
group by MANAGER_ID
having count(MANAGER_ID) = (select max(count(*))
                            from EMPLOYEES
                            group by MANAGER_ID)

-- 문제7) EMPLOYEES 테이블에서 가장 많은 사원이 속해 있는 부서 번호와 사원수를  출력하라.
select DEPARTMENT_ID, count(*)
from EMPLOYEES
group by DEPARTMENT_ID
having count(DEPARTMENT_ID) = (select max(count(*))
                               from EMPLOYEES
                               group by DEPARTMENT_ID)

-- 문제8) EMPLOYEES 테이블에서 사원번호가 123인 사원의 직업과 같고
--                         사원번호가 192인 사원의 급여(SAL)보다 많은 사원의 사원번호,이름,직업,급여를 출력하라.
select EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
from EMPLOYEES
where
    JOB_ID = (select JOB_ID from EMPLOYEES where EMPLOYEE_ID = 123)
    and SALARY > (select SALARY from EMPLOYEES where EMPLOYEE_ID = 192)

-- 문제9)직업(JOB)별로 최소급여를 받는 사원의 정보를 사원번호,이름,업무,부서명을 출력하라.
-- 조건1 :직업별로 내림차순정렬
select EMPLOYEE_ID,
       FIRST_NAME,
       JOB_ID,
       DEPARTMENT_NAME
from EMPLOYEES e, DEPARTMENTS d
where e.DEPARTMENT_ID = d.DEPARTMENT_ID
    and (JOB_ID, SALARY)
        in (select JOB_ID, min(SALARY)
            from EMPLOYEES group by JOB_ID)

-- 문제10) EMPLOYEES 테이블에서 (50번 부서의 최소 급여)를 받는 사원보다 많은 급여를 받는
-- 사원의 정보를 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라.
-- 단 50번은 제외

select EMPLOYEE_ID, FIRST_NAME, JOB_ID, HIRE_DATE, SALARY, DEPARTMENT_ID
from EMPLOYEES
where SALARY > (select min(SALARY)
                from EMPLOYEES
                where DEPARTMENT_ID = 50)
      and DEPARTMENT_ID != 50;  -- and DEPARTMENT_ID <> 50

-- 문제11) EMPLOYEES 테이블에서 50번 부서의 최고 급여를 받는 사원 보다 많은 급여를 받는 사원의 정보를 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라.
-- 단50번은 제외
select EMPLOYEE_ID, FIRST_NAME, JOB_ID, HIRE_DATE, SALARY, DEPARTMENT_ID
from EMPLOYEES
where SALARY > (select max(SALARY)
                from EMPLOYEES
                where DEPARTMENT_ID = 50)
      and DEPARTMENT_ID != 50;  -- and DEPARTMENT_ID <> 50