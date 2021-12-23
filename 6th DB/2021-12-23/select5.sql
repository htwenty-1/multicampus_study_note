/*
    SUB QUERY : 쿼리 안의 쿼리문

    특징
        - 기본 쿼리보다 우선 실행된다.
        - SELECT : 단일 ROW, 단일 COLUMN 사용 ==> 산출되는 데이터 1개! 컬럼도 한개!
        - FROM   : 다중 ROW, 다중 COLUMN 사용
        - WHERE  : 다중 ROW, 다중 COLUMN 사용
*/

-- SELECT
SELECT EMPLOYEE_ID, FIRST_NAME,
       (SELECT FIRST_NAME
       FROM EMPLOYEES
       WHERE EMPLOYEE_ID = 100)
FROM EMPLOYEES;

-- 다중 로우이므로 안됨
SELECT EMPLOYEE_ID, FIRST_NAME,
       (SELECT FIRST_NAME
       FROM EMPLOYEES
       WHERE EMPLOYEE_ID = 10000)
FROM EMPLOYEES;

-- 다중 컬럼이므로 안됨
SELECT EMPLOYEE_ID, FIRST_NAME,
       (SELECT FIRST_NAME, SALARY
       FROM EMPLOYEES
       WHERE EMPLOYEE_ID = 10000)
FROM EMPLOYEES;

-- 서브쿼리 안에 함수를 같이 사용할 수 있음.
SELECT EMPLOYEE_ID, FIRST_NAME,
       (SELECT COUNT(*)
       FROM EMPLOYEES)
FROM EMPLOYEES;

--------------------------------------------
-- FROM
SELECT EMPLOYEE_ID, SALARY                      --- 여기에 들어갈 내용은
FROM(SELECT EMPLOYEE_ID, FIRST_NAME, SALARY     --- 여기서 내보내 준 내용만 들어가야함
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID = 80)
WHERE SALARY > 10000

--- 부서번호 50번, 급여 6000 이상

SELECT *
FROM EMPLOYEES
WHERE SALARY >= 6000
  AND DEPARTMENT_ID = 50

SELECT EMPLOYEE_ID, SALARY, DEPARTMENT_ID
FROM(SELECT *
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID = 50
      AND SALARY >= 6000);

SELECT EMPLOYEE_ID, SALARY, DEPARTMENT_ID
FROM(SELECT *
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID = 50)
WHERE SALARY >= 6000;

--- 업무별 급여의 합계, 인원 수, 사원명, 급여
SELECT E.EMPLOYEE_ID,
       E.SALARY,
       E.JOB_ID,
       J.JOB_ID,
       J."급여의 합계",
       J.인원수
FROM EMPLOYEES E, (SELECT JOB_ID, SUM(SALARY) AS "급여의 합계", COUNT(*) 인원수
                   FROM EMPLOYEES
                   GROUP BY JOB_ID)
WHERE E.JOB_ID = J.JOB_ID;

----------------------------------------------------------
-- WHERE
-- 평균 급여보다 많이 받는 사원
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT ROUND(AVG(SALARY)) FROM EMPLOYEES);

-- 부서별로 가장 많은 급여를 받는 사원과 같은 급여를 받는 사원을 산출하라
SELECT  DEPARTMENT_ID, SALARY, FIRST_NAME
FROM EMPLOYEES
WHERE (DEPARTMENT_ID, SALARY) IN (SELECT DEPARTMENT_ID, MAX(SALARY)
                                  FROM EMPLOYEES
                                  GROUP BY  DEPARTMENT_ID)
ORDER BY DEPARTMENT_ID;