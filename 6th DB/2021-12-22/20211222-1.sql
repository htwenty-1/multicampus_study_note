/*
    DUAL ==> 가상 테이블, 임시 테이블 ===> 값만 확인해보고 싶을 때, 테이블이 직접 생성되진 않음.
*/

SELECT 1 FROM DUAL;
SELECT 1, 'A' FROM DUAL;
SELECT TO_DATE ('20211222', 'YYYY-MM-DD') FROM DUAL;

/*
    WHERE ==> 조건문 ==> java의 if문
    비교연산자 (>, <, >=, <=, !=, =, <>)
    NULL, IS NULL, IS NOT NULL
    AND, OR, ( ) - 우선되는 조건
*/

-- 이름이 Julia인 사람 찾기
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME = 'Julia';

-- 급여가 9000이상인 사원 찾기
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >= 9000;

-- 이름이 Shanta보다 큰 이름 == 철자를 비교해서 보다 나중에 나오는 이름
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME > 'Shanta';

-- 이름의 첫 글자가 J보다 큰 이름 ==> Ja부터 나옴
SELECT FIRST_NAME
FROM EMPLOYEES
-- WHERE FIRST_NAME > 'J';
WHERE FIRST_NAME < 'J';     -- J보다 앞의 이름

-- 상사가 없는 사원(MANAGER_ID 참조 == 사장)
SELECT FIRST_NAME FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;

SELECT FIRST_NAME, COMMISSION_PCT FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

-- AND
SELECT * FROM EMPLOYEES
WHERE FIRST_NAME = 'Shanta' AND LAST_NAME = 'Vollman';

-- 이름이 John이고 월급이 5000불 이상인 사람 구하기
SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE FIRST_NAME = 'John' AND SALARY >= 5000;

-- 2007년 12월 31일 이후에 입사한 사원 출력하기
SELECT FIRST_NAME, HIRE_DATE FROM EMPLOYEES
-- WHERE HIRE_DATE > '2007-12-31';
WHERE HIRE_DATE > TO_DATE('2007-12-31', 'YYYY-MM-DD');

--- ALL(=AND), ANY(=OR) : 자주 사용하진 않지만...
SELECT * FROM EMPLOYEES
WHERE FIRST_NAME = ALL('Julia', 'John');    -- == WHERE FIRST_NAME = 'Julia' AND FIRST_NAME = 'John'

SELECT * FROM EMPLOYEES
WHERE FIRST_NAME = ANY('Julia', 'John');

SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY = ANY(8000, 3200, 6000);

-- IN, NOT IN
SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY IN (8000, 3200, 6000);

SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY NOT IN (8000, 3200, 6000);

SELECT FIRST_NAME FROM EMPLOYEES
WHERE FIRST_NAME IN ('Julia', 'John');
-- == WHERE FIRST_NAME = 'Julia' OR FIRST_NAME ='John'

-- BETWEEN 범위 연산자(정의한 값을 포함해서 보여줌)
SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY >= 3200 AND SALARY <= 9000

SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY BETWEEN 3200 AND 9000;

SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY NOT BETWEEN 3200 AND 9000;

-- <> === !=
SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY != 9000;

SELECT FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY <> 9000;

-- LIKE
SELECT FIRST_NAME FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'G_ra_d';     -- _는 한글자

SELECT FIRST_NAME FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'K%y';        -- %는 글자수에 관계 없이

SELECT FIRST_NAME FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';         -- 첫글자가 A인 사람 전부

SELECT FIRST_NAME FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%y';         -- 마지막 글자가 y인 사람 전부

SELECT FIRST_NAME FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%e%';        -- 이름 철자 가운데 e가 들어가는 사람 전부

SELECT FIRST_NAME, HIRE_DATE FROM EMPLOYEES
WHERE HIRE_DATE LIKE '06%';

SELECT FIRST_NAME, PHONE_NUMBER FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '590%';