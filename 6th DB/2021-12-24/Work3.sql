/*
    온라인 마켓 테이블을 작성하라.
    PRODUCT(상품): 상품번호, 상품명, 상품가격, 상품설명
    CONSUMER(소비자): 소비자 ID, 이름, 나이
    CART(장바구니): 장바구니 번호, 소비자 ID, 상품번호, 수량

    상품테이블에 상품을 등록한다(원하는대로)
    소비자를 등록한다
    소비자가 쇼핑한 상품을 추가한다
    쇼핑한 상품을 출력한다
*/

create table PRODUCT(
    NUM integer,
    PNAME varchar2(50),
    PRICE integer,
    CONT varchar2(50),
    constraint PRO_NUM PRIMARY KEY(NUM)
);

create table CONSUMER(
    CID varchar2(15),
    CNAME varchar2(12),
    AGE integer,
    constraint USER_ID PRIMARY KEY(CID)
);

create table CART(
    CARTNO integer,
    CID varchar2(15),
    NUM integer,
    CNT integer,
    constraint IN_CART foreign key (NUM)
                 references PRODUCT(NUM),
    constraint USERS_ID foreign key (CID)
                 references CONSUMER(CID)
);

insert into PRODUCT (NUM, PNAME, PRICE, CONT)
values (1, '과자', 5000, '맛있는 과자');

insert into PRODUCT (NUM, PNAME, PRICE, CONT)
values (2, '우유', 6000, '맛없는 우유');

insert into PRODUCT (NUM, PNAME, PRICE, CONT)
values (3, '샐러드', 3000, '맛있는 샐러드');

insert into PRODUCT (NUM, PNAME, PRICE, CONT)
values (4, '빵', 2000, '맛없는 빵');

insert into CONSUMER(CID, CNAME, AGE)
values ('abc123', '홍길동', 30);

insert into CONSUMER(CID, CNAME, AGE)
values ('def987', '성춘향', 25);

insert into CONSUMER(CID, CNAME, AGE)
values ('qazwsx123', '홍두깨', 29);

insert into CART(cartno, cid, num, cnt)
values (1, 'abc123', 1, 2);
insert into CART(cartno, cid, num, cnt)
values (1, 'abc123', 3, 3);
insert into CART(cartno, cid, num, cnt)
values (2, 'qazwsx123', 1, 1);
insert into CART(cartno, cid, num, cnt)
values (3, 'def987', 2, 1);
insert into CART(cartno, cid, num, cnt)
values (2, 'qazwsx123', 4, 2);

select C.CNAME, P.PNAME, CA.CID
from CONSUMER C, PRODUCT P, CART CA
where P.NUM = CA.NUM AND C.CID = CA.CID
order by C.CNAME;