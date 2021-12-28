/*
    특수 쿼리
    CASE == SWITCH...CASE와 유사함

    SUBSTR
*/

SELECT EMPLOYEE_ID, FIRST_NAME, PHONE_NUMBER,
       CASE SUBSTR(PHONE_NUMBER, 1, 3)
           WHEN '515' THEN '서울'
           WHEN '590' THEN '부산'
           WHEN '650' THEN '대전'
           ELSE '기타'
       END
FROM EMPLOYEES

SELECT EMPLOYEE_ID, FIRST_NAME, PHONE_NUMBER,
       CASE
           WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '515' THEN '서울'
           WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '590' THEN '부산'
           WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '650' THEN '대전'
           ELSE '기타'
       END AS 지역
FROM EMPLOYEES

SELECT SUBSTR('HELLO', 1, 2)    -- 첫번째부터 시작해서 몇글자만 가져와라
FROM DUAL

----------------------------------------------------------------------

-- DECODE
SELECT EMPLOYEE_ID, FIRST_NAME, PHONE_NUMBER,
    DECODE(SUBSTR(PHONE_NUMBER, 1, 3),
        '515', 'SEOUL',
        '590', 'BUSAN',
        '650', 'DAEJEON'
    ) AS AREA
FROM EMPLOYEES

-- 분석함수
/*
    RANKING FUNCTION
        - RANK()
        - DENSE_RANK()
        - ROW_NUMBER()
        - ROWNUM ===> CREATE ROW NUMBER COLUMN
---- HOW TO CALCULATE EMPLOYEE_ID BETWEEN 100 AND 109
*/
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID >= 100 AND EMPLOYEE_ID <= 109

---- CALCULATE TOP 10'S RANKING OF SALARY
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
ORDER BY SALARY DESC;                   --- >>>> ????? yuk...


SELECT ROWNUM, EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE ROWNUM <= 10;                     --- be NOT able to use above two condition

SELECT ROWNUM, EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE ROWNUM >= 11 AND ROWNUM <= 20;
-- Because SELECT, FROM, and WHERE have different processing orders.

-- 1. 급여의 순위 ==> 정렬
-- 2. 번호 지정 ==> ROWNUM
-- 3. 범위 지정

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY  -- 1
FROM EMPLOYEES
ORDER BY SALARY DESC;

SELECT ROWNUM, EMPLOYEE_ID, FIRST_NAME, SALARY  -- 2
FROM
    (SELECT EMPLOYEE_ID, FIRST_NAME, SALARY  -- 1
    FROM EMPLOYEES
    ORDER BY SALARY DESC)

SELECT RNUM, EMPLOYEE_ID, FIRST_NAME, SALARY  -- 3
    FROM
    (SELECT ROWNUM AS RNUM, EMPLOYEE_ID, FIRST_NAME, SALARY  -- 2
     FROM
        (SELECT EMPLOYEE_ID, FIRST_NAME, SALARY  -- 1
        FROM EMPLOYEES
        ORDER BY SALARY DESC)
    )
WHERE RNUM >= 11 AND RNUM <= 20;