# 함수

## 함수의 정의
---

- 기존에 학습했던 함수의 종류
  - 내장함수이며 다음과 같다.
  - `prompt()`, `alert()`, `document.write()`, `console.log();`

- 함수를 만들어보자! (사용자 정의 함수 or 사용자 함수)
  ```javascript
  // 익명함수
  let myFunction = function () {  }

  // 선언적 함수
  function myFunction () {  }
  ```

- 메인 루틴과 서브 루틴?
  - 메인 루틴 : 함수 바깥 블럭
  - 서브 루틴 : 함수 안 쪽 블럭
  ```javascript
  function add (a, b) {
    var c = a + b;
    return c;
  }

  var value;
  value = add(5, 7);
  document.write(`${value} <br/>`)
  ```

- 함수의 `return` : 함수 연산 결과 반환하고 종료한다.
  ```javascript
  function square(x) {
    return x * x;
  }

  square(3);  // 을 호출하면 square 함수에 인수를 전달하고 함수 내부에서 처리하여 return을 통해 square(3)에 반환값을 돌려준다
  ```

- 원의 둘레와 너비를 구하는 예시
  ```javascript
  function cWidth (r) {
    return r*r*3.14;
  }

  function cLength (r) {
    return r*2*3.14;
  }

  var radius = 30;
  var width = cWidth(r);
  var length = cLength(r);

  document.write(`원의 반지름은 ${r}cm 입니다.<br/>`)
  document.write(`원의 넓이는 ${width}cm<sup>2</sup> 입니다.<br/>`)
  document.write(`원의 둘레는 ${length}cm 입니다.<br/>`)
  ```

## 변수의 종류
---
- 전역 변수 : 스크립트 내 전체 범위에서 사용할 수 있는 변수
- 지역 변수 : 사용자 정의 내 함수에서 사용되는 변수

## 객체
---
### 객체는 자료형 여러개를 한번에 저장한다.
  ```javascript
  var myObj = {
    key1: value,
    key2: value,
    ...
  }
  ```
<br>

### 객체에서 원하는 자료 뽑아오기 예시
  ```javascript
  var person = {
    name: 'Marco Polo',
    age: 20,
    area: 'Rome',
  };

  document.write(`Name: ${person.name} <br/>`);
  document.write(`Age : ${person.age} <br/>`);
  document.write(`Area: ${person.area} <br/>`);
  ```
<br>

### &lt;참고사항&gt; 메서드란?
  - 객체가 어떻게 동작할 지 선언한 함수를 의미함

<br>

### 자바스크립트에서 사용할 수 있는 객체
  - 내장객체 : 미리 정의되어 있는 객체
  - 문서 객체 모델(DOM: Document Object Model)
    - 객체를 사용하여 웹 문서를 제어하는 것
  - 브라우저 객체 모델: 웹 문서를 관리하는 것
  - 사용자 정의 객체

<br>

### 내장객체
- `date()`: 날짜 정보를 불러와 줌
  - `getFullYear()`: 네자리수 년도
  - `getMonth()`: 월
  - `getDate()` : 일
  - `getDay()` : 요일

- `time()`: 시간 정보를 불러와 줌
  - `getHour()`: 시간
  - `getMinutes()`: 분
  - `getSecont()` : 초

- 정보를 가져올 때는 `get`, 수정할 때는 `set`을 사용한다.
- 현재 날짜 정보 가져오는 방법
  ```javascript
  const today = new Date();
  // new 생성자로 가져온다~~
  ```
- 수학 객체
  - `Math.max()` : 최대값
  - `Math.min()` : 최소값
  - `Math.round()` : 반올림
  - `Math.floor()` : 버림
  - `Math.sqrt()` : 제곱근

<br>

### 배열 객체
- 배열을 정의하는 방법?
  ```javascript
  // 첫번째 방법
  var arr = new Array(10, "String", true);

  // 두번째 방법
  var arr = [10, "String", true]

  // 세번째 방법
  var arr = new Array();
  arr[0] = 10;
  arr[1] = "String";
  arr[2] = true;
  ```

### 사용자 정의 객체
- 객체 리터럴: 데이터 값 자체, 속성과 메서드를 통해 작성한다!
  - 객체를 변수에 직접 담아주는, 중괄호 내부에 `key`와 `value`를 직접 담아주는 형태
- 생성자 함수와 `new` 생성자를 사용한다!!
  - 생성자 함수는 반드시!! 대문자로 시작한다~

### `for...in~` 반복문
- 기본형태 : `for(변수명 in 객체명) {...}`