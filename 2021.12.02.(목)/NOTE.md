# JavaScript Tutorial

## Document Object Model(DOM, 문서 객체 모델)

### 선택자로 접근하는 함수

- `getElementById()`: `id` 선택자로 접근하는 함수
- `getElemtnsByClassName()` : `class` 선택자로 접근하는 함수
- `getElementsByTagName()` : 태그 선택자로 접근하는 함수
- `querySelector()` 또는 `querySelectorAll()` : 다양한 방법으로 선택자에 접근하는 함수

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

### HTML 태그 속성을 가져오거나 수정하는 함수

- `getAttribute()`
- `setAttribute()`
  ```javascript

  ```
