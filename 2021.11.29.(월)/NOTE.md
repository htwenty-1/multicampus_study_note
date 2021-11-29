# 웹 페이지의 요소들을 꾸며주는 CSS(4)

## 블록요소와 인라인요소

1. 블록요소 : 개체가 한 행 전체 공간을 차지함.
2. 인라인요소 : 입력받은 공간만 차지함.

<br>

## 가시속성

---

### `display` : 요소의 인라인/블록 속성을 바꿔줌

|속성|의미|
|---|---|
|`display: block`|inline elements의 속성을 block으로 바꿔줌|
|`display: inline`|block elements의 속성을 inline으로 바꿔줌|
|`display: inline-block`|inline elements에는 margin 등의 효과를 적용할 수 없으므로 이러한 경우 `inline-block`을 사용한다.|
|`display: none`|보이지 않게 함. <br> `visibility: hidden;`과 다른점은 `visibility`는 공간을 유지한채 사라지지만 `display: none`은 공간까지 함께 사라진다.|

<br>

## 반응형 웹

---

### 반응형 웹이란?
- 웹 페이지 하나로도 데스크톱, 태블릿PC, 스마트폰에 맞게 디자인이 자동으로 반응해서 변경되는 웹피이지
- 장점
  - 개발 효율성이 높고 유지보수가 용이하다.
  - 모든 스마트 기기에서 접속할 수 있다.
  - 가로 모드로 맞추어서 레이아웃 변경을 할 수 있다.
- 단점
  - 최신버전의 웹 브라우저에서만 사용 가능하다.
- 개발 방법
  - 가변 그리드 레이아웃
  - 미디어 쿼리
  - 플렉스 박스

<br>

## 내용 전개

### 뷰포트 지정하기

|구분|의미|예시|
|---|---|---|
|width|너비|`width=xxx`|
|height|높이|`height=xxx`|
|initial-scale|초기 확대 비율|`initial-scale=2.0`|
|user-scalable|확대 및 축소가능여부|`user-scalable=no`|
|minimum-scale|최소 축소 비율|`minimum-scale=1.0`|
|maximum-scale|최대 축소 비율|`maximum-scale=2.0`|
|targer-densitydip|dpi 지정|`targer-densitydip=medium-dpi`|

<br>

### 그리드 너비 지정하기
(요소의 너비/컨텐츠 전체를 감싸는 요소의 너비) x 100

<br>

### 단위

|구분|의미|
|---|---|
|`px`|상대 크기|
|`%`|상대 크기|
|`em`|상대 크기(`1em = 16px`)|
|`url`||
|`rgb`, `rgba`, `hexa-decimal`||

* `em`은 부모요소가 자식요소에서 영향을 줄 수 있다. 그렇기 때문에 `rem`을 쓰면 부모요소의 영향을 받지 않는다.

<br>

### 실제 컨텐츠의 크기
- 실제 컨텐츠의 크기는 `width` + `padding-left` & `padding-right` + `border` 로 지정된다.
- 박스 모델의 너비
  - `box-sizing` : 모델 박스의 너비를 정의
    - `content-box` : 기본값
    - `border-box` : 컨텐츠의 너비를 전체 박스로 지정
      - (예) 너비 300, 좌우 padding이 30, 테두리를 2px로 정의했을 때, 원래 너비는 240
      - `box-sizing: border-box`로 지정하면 테두리 너비까지 감안하여 236px로 너비를 계산하게 된다.

<br>

### 가변 이미지
- css를 이용하는 방법
  - `max-width`를 사용한다.
- 속성을 이용하는 방법
  - `srcset`: 파일 이름을 넣어주고 뒤에 2x 등을 붙여준다.
  - 단, 높이 조정에 제한이 있으므로 `<picture />` 태그에 `<source />` 태그를 추가해준다.
    - 여기에서 미디어 쿼리를 사용할 수 있다.
    ```html
    <picture>
      <source srcset="./images/shop-large.jpg" media="(min-width: 1024px)">
      <source srcset="./images/shop-medium.jpg" media="(min-width: 768px)">
      <source srcset="./images/shop-small.jpg" media="(min-width: 320px)">
      <img src="images/shop.jpg" style="width: 100%">
    </picture>
    ```

<br>

## 미디어 쿼리

---

### 미디어 쿼리란?
- 미디어가 표시되는 장치에 따라 반응하도록 함.
- 규칙: `@media(<mediaQuery>) { css style }`
- 연산자

  |구분|의미|
  |---|---|
  |`and`|여러 조건을 연결해서 추가할 때|
  |`print`|프린터|
  |`screen`|화면|
  |`handheld`|손으로 들고다니는 장치|
  |`not`|해당 장치를 제외한|
  |`only`|해당 장치에서만|
  |`,`| 동일한 스타일 유형을 사용할 미디어의 유형과 조건이 있을 때|

- 미디어 쿼리의 다양한 조건

  |종류|설명|
  |---|---|
  |`width`, `height`|웹 페이지의 가로, 세로 너비와 높이|
  |`min-width`, `min-height`|웹 페이지의 가로, 세로 최소 너비와 높이|
  |`max-width`, `max-height`|웹 페이지의 가로, 세로 최대 너비 높이|
  |`device-width`, `device-height`|단말기의 너비, 높이|
  |`min-device-width`, `min-device-height`|단말기의 최소 너비, 높이|
  |`max-device-width`, `max-device-height`|단말기의 최대 너비, 높이|
  |`orientation: portrait`|단말기의 세로모드|
  |`orientation: landscape`|단말기의 가로모드|

- 미디어 쿼리를 적용하기
  - 외부 CSS 파일 연결(가장 많이 쓰는 방법)
    `@import url(css파일 경로) 미디어 쿼리 조건`

- 미디어 쿼리의 중단점
  - 서로 다른 css를 적용할 화면 크기

<br>

## 플렉스 박스

---

### 개요
- 그리드 레이아웃을 기준으로 플렉스 박스를 원하는 위치에 배치하는 것.
- 여유 공간에 따라 너비나 높이, 위치를 자유롭게 변형할 수 있다.

<br>

### `display` 속성

|구분|의미|
|---|---|
|`flex`|컨테이너 안의 플렉스 항목을 블록 레벨 요소로 배치;|
|`inline-flex`|컨테이너 안의 플렉스 항목을 인라인 레벨 요소로 배치;|

<br>

### `flex-direction` 속성

|구분|의미|
|---|---|
|`row`|주축을 가로로 지정. 왼쪽에서 오른족으로. 기본값.|
|`row-reverse`|주축을 가로로 지정 오른쪽에서 왼쪽으로|
|`column`|주축을 세로로 지정. 위에서 아래로.|
|`column-reverse`|주축을 세로로 지정. 아래에서 위로.|

<br>

### `flex-wrap` 속성

|구분|의미|
|---|---|
|`nowrap`|기본값|
|`wrap`|여러줄로 표시해줌|
|`wrap-reverse`|wrap과 반대순서. 여러줄을 역방향으로 표시해줌.|

<br>

### `order` 속성
- `flex` 항목의 배치 순서를 바꾼다.
- `order: N`을 선언하여 순서를 바꿔줄 수 있음.

<br>

### `flex` 속성
- `flex: 늘릴 비율, 줄일 비율, 기본값`의 순서로 입력한다.
  - 기본값: `flex: 1 1 0;`

<br>

### `flex` 항목 배치를 위한 속성

|구분|의미|
|---|---|
|`flex-start`|Items를 시작점(flex-start)으로 정렬, 기본값|
|`flex-end`|Items를 끝점(flex-end)으로 정렬|
|`center`|Items를 가운데 정렬|
|`space-between`|시작 Item은 시작점에, 마지막 Item은 끝점에 정렬되고 나머지 Items는 사이에 고르게 정렬됨|
|`space-around`|Items를 균등한 여백을 포함하여 정렬|