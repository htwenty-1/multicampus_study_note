# 웹 페이지의 요소들을 꾸며주는 CSS(3)

## 어제 내용 복습
1. 박스모델
  - 구성 요소
    - `margin` : 외부요소와 외부요소 사이 간격
    - `padding` : 요소 내부 간격(`border`와 컨텐츠 사이 간격)
    - `border` : 경계선, 요소와 `margin` 사이 선
    - 컨텐츠 영역
  
  - `border` 속성
    - `border` : 경계선을 그려줄 때 사용
      - `border: '선두께' '선타입' '색상'`
      - `border-width` : 테두리 두께 지정, 아래와 같이 사용
        
        ``` css
        div {
          border-width: 5px 10px 5px 10px;
        }
        div {
          border-width: thick thin;
        }
        ```
      - `border-radius`: 모서리를 둥굴게, 박스 모델의 꼭짓점 부분에 원이 있다고 가정해서 둥글게 처리한다.
        - 부분적인 굴곡을 원하는 경우 `border-radius-top-left`처럼 위치를 밝혀 쓴다.
        - `box-shadow`로 그림자를 넣을 수 있다.
          - `box-shadow: 오른쪽 아래쪽 번짐정도 색상`

  - `margin` 속성
    - `margin: 20px`은 모든 방향으로 20px만큼 적용
    - `margin: 10px 20px`은 위아래 10px, 좌우 20px만큼 적용
    - `margin`은 위아래로 중첩이 일어남.
  
  - `padding` 속성
    - `margin`과 같은 원리
  
  - `background` 속성
    - `background-image`: 배경 이미지 설정
      
      ```css
      body {
        background-image: url("./img/image.png");
        background-repeat: no-repeat; /* 이미지 반복설정*/
        background-position: left   /* 왼쪽으로 위치 지정*/
      }
      ```
  
  - `float` 속성
    - html의 블록 엘리먼트는 위에서부터 아래로 쌓이는 구조인데 이를 깨고 정렬을 하기 위한 방법이다.
    - `float` 속성을 깨기 위해서 `clear`를 사용하는데 같은 방향으로 입력해주면 된다.
      ```css
      div {
        float: left;  /* 왼쪽 정렬 */
      }
      div {
        clear: left;  /* float를 깨주는 속성 */
      }
      ```

<br />

---

<br />

## 속성 선택자

|구분|해설|
|---|---|
|선택자[속성]|특정한 속성이 있는 태그를 선택|
|선택자[속성=값]|특정한 속성 내부 값이 특정 값과 같은 태그를 선택|

```html
...
<head>
  ...
  <style>
    input[type="text"] {
      background-color: tomato;
    }
    input[type="password"] {
      border: none;
    }
  </style>
</head>
<body>
  <form>
    <input type="text" />
    <input type="password" />
  </form>
</body>
```

<br />

---

<br />

## 후손 선택자와 자손 선택자
- 주요개념
  - 자손 선택자 : 직계의 개념
  - 후손 선택자 : 자손의 자손까지 포함한 개념

### 후손 선택자
- 후손 선택자는 다음과 같이 입력한다.
  - `selectorA selectorB { color: red; }`
    ```html
    ...
    <head>
    ...
      <style>
        div ul{
          color: coral;
        }
      </style>
    </head>
    <body>
      <div>
        <h1>첫째</h1>
        <h2>둘째</h2>
        <ul>
          <li>첫째 손자</li>
          <li>둘째 손자</li>
          <li>셋째 손자</li>
        </ul>
      </div>
    </body>
    ...
    ```
### 자손 선택자
- 자손 선택자는 다음과 같이 입력한다.
  - `selectorA > selectorB { color: red; }`
  - 단, 부모를 건너 뛰고 후손에게 바로 속성을 부여할 수는 없다.
    ```html
      <head>
      ...
      <style>
        /*부모가 hearder일 때 h1, h2, div, ul은 자식이기 때문에 속성을 물려 받는다.*/
        #header > h2 {
          color: coral;
        }

        /* 부모가 section일 때 li는 부모가 다르기 때문에 속성을 물려 받을 수 없다. */
        #section > h1 {
          color: crimson;
        }

        /* 후손 선택자에서 부모가 header일 때 손자인 li는 상속을 받는다. */
        #header li {
          color: yellowgreen;
        }
      </style>
    </head>
    <body>
      <div id="header">
        <h1>첫째</h1>
        <div id="section">
          <h1>손자</h1>
        </div>
        <h2>둘째</h2>
        <ul>
          <li>첫째 손자</li>
          <li>둘째 손자</li>
          <li>셋째 손자</li>
        </ul>
      </div>
      <h1>가족 외</h1>
    </body>
    ...
    ```

<br />

---

<br />

## 상태, 구조, 반응 선택자

### 상태 선택자

  |구분|해설|
  |---|---|
  |`:checked`|체크 상태의 input 태그 선택|
  |`:focus`|포커스를 맞춘 input 태그 선택|
  |`:enabled`|사용 가능한 input 태그 선택|
  |`:disabled`|사용 불가능한 input 태그 선택|

### 구조 선택자
- 특정한 위치에 있는 태그를 선택할 때 사용

  |구분|해설|
  |---|---|
  |`:first-child`|첫번째 자식요소|
  |`:last-child`|마지막 자식요소|
  |`:nth-child(n)`|형제 관계에서 앞에서 n번째로 등장하는 태그 선택|
  |`:nth-last-child(n)`|형제관계에서 뒤에서 n번째로 등장하는 태그 선택|
  |`n`|일반적으로 `2n` or `2n-1`의 형태를 입력하여 짝수번째, 홀수번째를 결정할 수 있다.|

### 반응 선택자
  - 사용자의 반응에 따라 선택하려고 할 때 사용한다.

    |구분|해설|
    |--|---|
    |`:active`|사용자가 마우스로 클릭한 상태|
    |`:hover`|사용자가 마우스를 올린 상태|

<br />

---

<br />

## 위치 속성
- 기본적인 개념

  |구분|해설|
  |---|---|
  |static|기본값, 좌상단부터 쌓임.|
  |absolute|절대 위치 좌표 설정(원하는 자리로 배치 가능!), <br /> 자식요소에 쓰기 위해서는 부모요소에 `relative` 필요|
  |relative|문서의 흐름에 따라 위치 지정|
  |fixed|브라우저 창을 기준으로 고정|

- <span style="background-color: rgba(255, 255, 0, 0.3)">**자식요소에게 `absolute`를 주면 부모요소는 반드시 `relative`를 줘야한다!!!**</span>

- `z-index`: 숫자를 부여하여 이 숫자가 클수록 앞에 위치한다.
  - 예를 들어 아래와 같다면 두번째 박스가 맨 위, 첫번째 박스가 그다음, 세번째 박스가 가장 밑으로 가게 된다.
    ```css
    .box:nth-child(1) {
      background-color: coral;
      left: 10px;
      top: 10px;
      z-index: 2;
    }

    .box:nth-child(2) {
      background-color: cornflowerblue;
      left: 50px;
      top: 50px;
      z-index: 1;
    }

    .box:nth-child(3) {
      background-color: darkkhaki;
      left: 100px;
      top: 100px;
      z-index: 3;
    }
    ```

- `overflow`: 입력한 요소의 범위에서 벗어났을 때 스크롤을 만들거나 숨길 수 있다.
  |구분|해설|
  |---|---|
  |hidden|범위에서 벗어난 요소 감추기|
  |scroll|범위에서 벗어난 요소를 스크롤로 보여주기|

  - 높이나 너비를 자동으로 고정하고자 할 때 다음과 같은 속성을 쓸 수 있다.

    |구분|해설|
    |---|---|
    |`over-flow-x: auto`|너비 자동|
    |`over-flow-y: auto`|높이 자동|

<br />

---

<br />

## 보이기 속성

- `visibility`: 요소를 보이게 하거나 보이지 않게함
  
  |구분|해설|
  |--|---|
  |`visible`|보이기|
  |`hidden`|숨김|

- `display` : 요소의 `inline`, `block`, `inline-block`, `flex` 등의 속성을 지정해 줄 수 있다.