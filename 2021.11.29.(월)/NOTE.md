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