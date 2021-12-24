-- 문제1) EMPLOYEES 테이블에서 Kochhar의 급여보다 많은 사원 정보의 사원번호,이름,담당업무,급여를 출력하라.
select EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
from (select EMPLOYEE_ID,
             FIRST_NAME,
             JOB_ID,
             SALARY
      from EMPLOYEES
      where SALARY > 17000 )

-- 문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 정보를
-- 사원번호,이름,담당업무,급여,부서번호를 출력하여라.
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY < (SELECT ROUND(AVG(SALARY)) FROM EMPLOYEES);


-- 문제3) EMPLOYEES 테이블에서 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하라

-- 문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하여라.
-- 단 업무별로 정렬하여라.

-- 문제5) EMPLOYEES 과 DEPARTMENTS 테이블에서 업무가 SA_MAN 사원의 정보를 이름,업무,부서명,근무지를 출력하라.
-- FROM, WHERE절 둘 다 작성

-- 문제6) EMPLOYEES 테이블에서 가장 많은 사원을 갖는 MANAGER의 사원번호를 출력하라.

-- 문제7) EMPLOYEES 테이블에서 가장 많은 사원이 속해 있는 부서 번호와 사원수를  출력하라.

-- 문제8) EMPLOYEES 테이블에서 사원번호가 123인 사원의 직업과 같고
--                           사원번호가 192인 사원의 급여(SAL)보다 많은 사원의 사원번호,이름,직업,급여를 출력하라.

-- 문제9)직업(JOB)별로 최소급여를 받는 사원의 정보를 사원번호,이름,업무,부서명을 출력하라.
-- 조건1 :직업별로 내림차순정렬

-- 문제10) EMPLOYEES 테이블에서 (50번 부서의 최소 급여)를 받는 사원보다 많은 급여를 받는
-- 사원의 정보를 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라.
-- 단 50번은 제외

-- 문제11) EMPLOYEES 테이블에서 50번 부서의 최고 급여를 받는 사원 보다 많은 급여를 받는 사원의 정보를 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라.
-- 단50번은 제외