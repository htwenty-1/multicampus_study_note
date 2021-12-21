/*
    CRUD(insert, delete, select, update) 중에서 가장 중요한거는 SELECT
    형식:
        SELECT 절(값 or 컬럼명 or 함수, sub query)
        FROM 절(테이블명, sub query)
*/

SELECT * FROM employees;   -- 모든 컬럼에 있는 데이터를 보여줘

SELECT * FROM TAB;  -- table에 대한 정보

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY FROM EMPLOYEES;

-- 연산처리
SELECT LAST_NAME, SALARY, SALARY + 300 FROM EMPLOYEES;  -- 300씩 더 받은 급여
SELECT LAST_NAME, SALARY, SALARY * 12 FROM EMPLOYEES;   -- 연봉

-- 문자열 연산
SELECT FIRST_NAME || ' ' || SALARY FROM EMPLOYEES;

--ALIAS
SELECT EMPLOYEE_ID AS 사원번호 FROM EMPLOYEES;

SELECT EMPLOYEE_ID AS 사원번호, SALARY AS 월급 FROM EMPLOYEES;

SELECT EMPLOYEE_ID AS 사원번호, SALARY AS 월급, FIRST_NAME 이름 FROM EMPLOYEES; -- 생략해도 오케이

--- 주의사항 : ALIAS에 넣은 글자에 공백을 주려면 큰 따옴표로 감싸야한다.
SELECT EMPLOYEE_ID AS "사원 번호", SALARY AS 월급, FIRST_NAME 이름 FROM EMPLOYEES; -- 생략해도 오케이

-- distinct : 중복행 삭제 기능
SELECT DISTINCT JOB_ID FROM EMPLOYEES;