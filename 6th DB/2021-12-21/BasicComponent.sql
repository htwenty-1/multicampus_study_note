SELECT * FROM employees;        -- query문, cmd + return

-- 주석문
-- 한줄 주석
/*
범위주석
*/

-- table의 구조 : row와 column
/*
    how to make table?
    CREATE TABLE 테이블명 (
      컬럼명1 자료형,
      컬럼명2 자료형,
           :
           :
    )
*/

/*
    자료형(Java와 비교)
    *VARCHAR2, CHAR, LONG == String      ... MYSQL은 VERCHAR
    INTEGER, *NUMBER == int
    NUMBER == double        ... NUMBER는 정수형, 실수형 다 됨
    *DATE == Date
*/

-- VARCHAR2
drop table TB_VARCHAR;

CREATE TABLE TB_VARCHAR (
    COL1 VARCHAR2(10 BYTE),
    COL2 VARCHAR2(10),
    COL3 VARCHAR2(20)
);

/*
    INSERT INTO 테이블명(컬럼명, 컬럼명, ...)
    VALUES(value, value, value ...)
*/

SELECT * FROM TB_VARCHAR;

INSERT INTO TB_VARCHAR(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');                -- 영문은 1자당 1바이트

INSERT INTO TB_VARCHAR(COL1, COL2, COL3)
VALUES ('가나다', '가나다', '가나다');           -- 한글은 1자당 3바이트

SELECT COL1, COL2, COL3, lengthb(COL1), lengthb(COL2), lengthb(COL3)
FROM TB_VARCHAR;

-- LONG, 최대 2GB까지 저장 가능
-- 테이블당 최대 1개의 컬럼만 사용 가능함

CREATE TABLE TB_LONG(
    COL LONG
);

INSERT INTO TB_LONG(COL)
VALUES ('ABCDEFGHIJKLMNOPQURTUVWXYZ');

SELECT * FROM TB_LONG;

/*
책에 대한 데이터를 만든다? 이런 느낌!
CREATE TABLE BOOK(
    TITLE VARCHAR2(200),
    CONTENTS LONG
)
*/

-- 숫자(정수형, 실수형)
-- INTEGER형 - 정수
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES (12345, 67890);              -- 따옴표로 묶어도 들어가긴 함

/*
integer에 소수점 넣으면 소수점이 잘려서 들어감
*/

SELECT * FROM TB_INTEGER;

-- NUMBER 자료형으로 정수와 실수를 모두 사용해보자
CREATE TABLE TB_NUMBER(
    COL1 NUMBER,        -- 그냥 숫자만
    COL2 NUMBER(5),     -- 5자리 정수(소수점 찍으면 반올림되어 저장됨)
    COL3 NUMBER(5, 2),  -- 5자리 수 중 소수점은 둘째자리까지
    COL4 NUMBER(*, 2)   -- 모든 수의 소수점 둘째자리까지
);

INSERT INTO TB_NUMBER(COL1, COL2, COL3, COL4)
VALUES (1234.5678, 12345.6, 123.456, 1234567.8909);

SELECT * FROM TB_NUMBER;

-- 날짜 DATE
-- 연도, 월, 일, 시, 분, 초
DROP TABLE TB_DATE;
CREATE TABLE TB_DATE (
    COL1 DATE,
    COL2 DATE
);

-- SYSDATE == date of system == today's date and time
INSERT INTO TB_DATE(COL1, COL2)
VALUES (SYSDATE, SYSDATE-1);    -- -1하면 하루 뺀 날짜

SELECT * FROM TB_DATE;

--- 외부에서 들어온 날짜가 2021-12-31 11:50:10(문자열)이라면
INSERT INTO TB_DATE(COL1, COL2)
-- VALUES (SYSDATE, '2021-12-31 11:50:10');    -- FAIL
VALUES (SYSDATE, '2021-12-31');               -- OKAY

INSERT INTO TB_DATE(COL1, COL2)
VALUES (SYSDATE, '2021/12/31');               -- OKAY

INSERT INTO TB_DATE(COL1, COL2)
VALUES (SYSDATE, TO_DATE('2021-12-31 11:50:10', 'YYYY-MM-DD HH:MI:SS'));

SELECT * FROM TB_DATE;