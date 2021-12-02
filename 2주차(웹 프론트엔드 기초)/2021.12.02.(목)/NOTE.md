# JavaScript Tutorial

## Document Object Model(DOM, 문서 객체 모델)

### 선택자로 접근하는 함수

- `getElementById()`: `id` 선택자로 접근하는 함수
- `getElemtnsByClassName()` : `class` 선택자로 접근하는 함수
- `getElementsByTagName()` : 태그 선택자로 접근하는 함수
- `querySelector()` 또는 `querySelectorAll()` : 다양한 방법으로 선택자에 접근하는 함수

<br>

### HTML 태그 속성을 가져오거나 수정하는 함수

- `getAttribute()`
- `setAttribute()`

  ```html
  <!-- 책 값을 계산하는 예제 -->
  <body>
    <div>
      <h1>책값을 계산해보자~</h1>
      <ul>
        <li>책 값: <span id="price"></span></li>
        <li>할인율: <span id="disc"></span>%</li>
        <li>배송료: <span id="fee"></span></li>
      </ul>
      <button onclick="priceCal(26000, 10, 3000)">지불할 금액</button>
      <div>지불할 금액은 <span id="result"></span>원입니다.</div>
    </div>

    <script>
      function priceCal(price, disc, fee) {
        var p = price * ((100 - disc) / 100) + fee;
        document.getElementById('price').innerHTML = price;
        document.getElementById('disc').innerHTML = disc;
        document.getElementById('fee').innerHTML = fee;
        document.getElementById('result').innerHTML = p;
      }
    </script>
  </body>
  ```

<br>

## 이벤트

### 마우스 이벤트

- `click` : 클릭
- `dbclick` : 더블클릭
- `mousedown` : 마우스를 누르고 있을 떼
- `mouseup`: 마우스를 뗄 때
- `mousemove` : 마우스를 움직일 때
- `mouseover` : 마우스를 올렸을 때
- `mouseout` : 마우스가 밖으로 나갔을 때

<br>

### 키보드 이벤트

- `keypress` : 키를 눌렀을 때
- `keydown` : 키를 누르는 동안
- `keyup` : 키를 뗄 때

<br>

### 문서 로딩 이벤트

- `abort` : 문서가 불려오기 전에
- `error` : 로딩되지 않았을 때
- `load` : 로딩이 끝났을 때
- `resize` : 화면 크기가 변했을 때
- `scroll` : 스크롤 될 때
- `unload` : 문서에서 벗어났을 때

<br>

### 폼 이벤트

- `blur` : 포커스가 사라졌을 때
- `change` : 상태가 변했을 때
- `focus` : 엘리먼트에 포커스가 생겼을 때
- `reset` : 폼이 다시 시작
- `submit` : 폼을 제출

<br>

### `addEventListener`
예제(`./DOM_Tutorial_6.html`) 참조

### `jQuery` 사용하기
- 기본적인 사용
  - `$("selector").method(paramater1, parameter2)`와 같은 형식으로 작성.
  - `jQuery`의 선택자 입력방법
    
    |종류|작성|
    |---|---|
    |전체 선택자|`$(*)`|
    |`id` 선택자| `$('#id')` |
    |`class` 선택자 | `$('.class')`|
    |태그 선택자|`$('tagName')` <br> (ex) p태그 선택 `$('p')`|
    |그룹 선택자|`$('selector, selector')`|
    |자식 선택자|`$('parent > child')`|
    |후손 선택자|`$('gparent gchild')`|

- 예제(`./jquery_tutorial.html`) 참조