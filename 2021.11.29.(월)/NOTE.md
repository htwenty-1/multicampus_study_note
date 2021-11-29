# 웹 페이지의 요소들을 꾸며주는 CSS(4)

## 블록요소와 인라인요소

1. 블록요소 : 개체가 한 행 전체 공간을 차지함.
2. 인라인요소 : 입력받은 공간만 차지함.

<br>

## 가시속성
### `display` : 요소의 인라인/블록 속성을 바꿔줌

#### `display: block`
- inline elements의 속성을 block으로 바꿔줌

#### `display: inline`
- block elements의 속성을 inline으로 바꿔줌

#### `display: inline-block`
- inline elements에는 margin 등의 효과를 적용할 수 없으므로 이러한 경우 `inline-block`을 사용한다.

#### `display: none`
- 보이지 않게함.
- `visibility: hidden;`과 다른점은 `visibility`는 공간을 유지한채 사라지지만 `display: none`은 공간까지 함께 사라진다.