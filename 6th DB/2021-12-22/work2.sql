-- 정렬
-- 문제1) EMPLOYEES 테이블에서 입사일자 순으로 정렬하여 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라.
SELECT EMPLOYEE_ID,
       FIRST_NAME,
       JOB_ID,
       SALARY,
       HIRE_DATE,
       DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY HIRE_DATE ASC;

-- 문제2) EMPLOYEES 테이블에서 가장 최근에 입사한 순으로 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라.
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES
ORDER BY HIRE_DATE DESC;

-- 문제3) EMPLOYEES 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬하여
-- 사원번호, 성명, 업무, 부서번호, 급여를 출력하여라.
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID, SALARY FROM EMPLOYEES
ORDER BY DEPARTMENT_ID ASC, SALARY DESC;


-- 문제4) EMPLOYEES 테이블에서 첫번째 정렬은 부서번호로 두번째 정렬은 업무로 세번째 정렬은 급여가 많은 순으로 정렬하여
-- 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하여라.
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_ID, JOB_ID, SALARY FROM EMPLOYEES
ORDER BY DEPARTMENT_ID ASC, JOB_ID ASC, SALARY DESC;


-- 표준함수
-- 문제1) EMPLOYEES 테이블에서 King의 정보를 대문자로 검색하고 사원번호, 성명, 담당업무를 대문자로 그리고 부서번호를 출력하라.
SELECT EMPLOYEE_ID, LAST_NAME, UPPER(JOB_ID), DEPARTMENT_ID FROM EMPLOYEES
WHERE UPPER(LAST_NAME) = 'KING';

-- 문제2) DEPARTMENTS 테이블에서 부서번호와 부서이름, 부서이름과 위치번호를 합하여 출력하도록 하라.
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, DEPARTMENT_ID ||' '|| LOCATION_ID FROM DEPARTMENTS;
-- CONCAT
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, CONCAT(DEPARTMENT_ID, LOCATION_ID) FROM DEPARTMENTS;

-- 문제3) EMPLOYEES 테이블에서 이름 중 ‘e’자의 위치를 출력하라.
SELECT FIRST_NAME, INSTR(FIRST_NAME, 'e') FROM EMPLOYEES

-- 문제4) EMPLOYEES 테이블에서 부서번호가 80인 사람의 급여를 30으로 나눈 나머지를 구하여 출력하라.
SELECT DEPARTMENT_ID, FIRST_NAME, SALARY, MOD(SALARY, 30) FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80

-- 문제5) EMPLOYEES 테이블에서 현재까지 근무일 수가 몇주 몇일 인가를 출력하여라.
-- 단 근무 일수가 많은 사람 순으로 출력하여라.
SELECT FIRST_NAME, HIRE_DATE,
       ROUND(SYSDATE-HIRE_DATE) AS WORKINGDAY,
       ROUND(ROUND(SYSDATE-HIRE_DATE) / 7) AS WORKINGWEEKS
FROM EMPLOYEES
ORDER BY WORKINGDAY DESC;


-- 문제6) EMPLOYEES 테이블에서 부서 50에서 급여 앞에 $를 삽입하고 3자리마다 ,를 출력하라
SELECT FIRST_NAME, SALARY, TO_CHAR(SALARY, '$999,999,999') FROM EMPLOYEES
WHERE DEPARTMENT_ID = 50;

-- 그룹핑
-- 문제1) EMPLOYEES 테이블에서 모든 SALESMAN(SA_)에 대하여 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
SELECT AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY) FROM EMPLOYEES
WHERE JOB_ID LIKE 'SA_%';

-- 문제2) EMPLOYEES 테이블에 등록되어 있는 인원수,
-- 보너스가 NULL이 아닌 인원수, 보너스의 평균, 등록되어 있는 부서의 수를 구하여 출력하라.
SELECT COUNT(*),
       COUNT(COMMISSION_PCT),       -- null은 count하지 않음
       ROUND(AVG(COMMISSION_PCT*SALARY)),
       COUNT(DISTINCT DEPARTMENT_ID)
FROM EMPLOYEES;

-- 문제3) EMPLOYEES 테이블에서 부서별로 인원수, 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라.
SELECT COUNT(*),
       ROUND(AVG(SALARY)),
       MIN(SALARY),
       MAX(SALARY),
       SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;

-- 문제4) EMPLOYEES 테이블에서 각 부서별로 인원수,급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 급여의 합이 많은 순으로 출력하여라.
SELECT DEPARTMENT_ID,
       COUNT(*),
       ROUND(AVG(SALARY)),
       MIN(SALARY),
       MAX(SALARY),
       SUM(SALARY) AS TOTALOFSAL
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY TOTALOFSAL DESC;

-- 문제5) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 부서번호, 업무,
-- 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라.
SELECT DEPARTMENT_ID,
       JOB_ID,
       COUNT(*),
       ROUND(AVG(SALARY)),
       SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID;


-- 문제6) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 구하여 출력하여라
SELECT DEPARTMENT_ID,
       COUNT(*),
       SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING COUNT(*) > 4;

-- 문제7) EMPLOYEES 테이블에서 급여가 최대 10000이상인 부서에 대해서 부서번호, 평균 급여, 급여의 합을 구하여 출력하여라.
SELECT DEPARTMENT_ID,
       ROUND(AVG(SALARY)),
       SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING MAX(SALARY) >= 10000;

-- 문제8) EMPLOYEES 테이블에서 업무별 급여의 평균이 10000 이상인 업무에 대해서 업무명,평균 급여, 급여의 합을 구하여 출력하라.
SELECT JOB_ID,
       ROUND(AVG(SALARY)),
       SUM(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING ROUND(AVG(SALARY)) >= 10000;

-- 문제9) EMPLOYEES 테이블에서 전체 월급이 10000을 초과하는 각 업무에 대해서 업무와 월급여 합계를 출력하라.
-- 단 판매원(SA)은 제외하고 월 급여 합계로 정렬(내림차순)하라.
SELECT JOB_ID,
       SUM(SALARY) AS TS
FROM EMPLOYEES
WHERE JOB_ID NOT LIKE 'SA%'
group by JOB_ID
HAVING SUM(SALARY) > 10000
ORDER BY TS DESC;
