/*
    JOIN : 두개 이상의 테이블을 연결하여 데이터를 검색하는 방법
           보통 두 개 이상의 "ROW"의 공통된 기본키, 외래키를 사용해서 "JOIN"한다.
    기본키(Primary Key) : 테이블에서 중복되지 않는 키
    외래키(Foreign Key) : 다른 테이블에서 primary key, unique "key"인 키

    "JOIN"의 종류
    - INNER JOIN(!)
    - FULL OUTER JOIN
    - CROSS JOIN
    - OUTER JOIN(!)
        * LEFT OUTER JOIN
        * RIGHT OUTER JOIN
    - SELF JOIN(!)
*/

select * from employees;

-- INNER JOIN
-- ANSI SQL
SELECT EMPLOYEE_ID,
       E.FIRST_NAME,        -- 한 테이블에만 있으므로 E를 빼도 동작함
       E.DEPARTMENT_ID,     -- 다른 테이블에도 존재하는 경우 "ALIAS"를 생략하면 안됨.
       D.DEPARTMENT_NAME
FROM EMPLOYEES E
INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

-- ORACLE
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
      AND E.EMPLOYEE_ID = 200;

SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.JOB_ID,
       J.JOB_ID,
       J.JOB_TITLE
FROM EMPLOYEES E, JOBS J
WHERE E.JOB_ID = J.JOB_ID;

----------------------------------------------------------------

-- CROSS JOIN: あまり使わないから、スキップしていいか
-- ANSI SQL
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E
CROSS JOIN DEPARTMENTS D;

-- ORACLE
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D;

----------------------------------------------------------------

-- FULL OUTER JOIN
-- ANSI SQL
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E
    FULL OUTER JOIN DEPARTMENTS D
    on E.DEPARTMENT_ID = D.DEPARTMENT_ID;

-- ORACLE : LEFT OUTER JOIN + RIGHT OUTER JOIN
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
UNION
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID(+) = D.DEPARTMENT_ID;

----------------------------------------------------------------

-- OUTER JOIN
--- LEFT OUTER JOIN
---- ANSI SQL
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E
    LEFT OUTER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

---- ORACLE
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+);

----------------------------------------------------------------

--- RIGHT OUTER JOIN(REVERSE LEFT)
---- ANSI SQL
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E
    RIGHT OUTER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

---- ORACLE
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID(+) = D.DEPARTMENT_ID;

----------------------------------------------------------------
-- LEFT OUTER JOIN + 차집합

SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
      AND E.DEPARTMENT_ID IS NULL;

SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_ID,
       D.DEPARTMENT_NAME
FROM EMPLOYEES E
     FULL OUTER JOIN DEPARTMENTS D
     ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE E.DEPARTMENT_ID IS NULL
      OR D.DEPARTMENT_ID IS NULL;

----------------------------------------------------------------
-- SELF JOIN : 동일한 테이블을 JOIN
SELECT A.EMPLOYEE_ID, A.FIRST_NAME,
       A.MANAGER_ID, B.EMPLOYEE_ID,
       B.FIRST_NAME
FROM EMPLOYEES A, EMPLOYEES B --- A : 사원 / B : 상사
WHERE A.MANAGER_ID = B.EMPLOYEE_ID
      AND A.EMPLOYEE_ID = 168;