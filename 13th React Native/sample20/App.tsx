import React, { useEffect, useState } from "react";
import { Button, Text, View } from "react-native";

/*
export default function App() {

  // useState : getter와 setter의 한 쌍으로 이해
  const [text, setText] = useState("텍스트");

  const btnClick = () => {
    setText("바뀐 텍스트");
  }

  return (
    <View>
      <Text>원래 텍스트: {text}</Text>
      <Button title="확인" onPress={btnClick} />
    </View>
  )
}
*/

/*
function Welcome(props:any) {

  function onClickHandler() {
    props.setText("바뀐 텍스트");
  }

  return (
    <View>
      <Text>Welcome</Text>
      <Button title="button" onPress={onClickHandler}></Button>
    </View>
  )
}

export default function App() {

  // useState : getter와 setter의 한 쌍으로 이해
  const [text, setText] = useState("텍스트");

  return (
    <View>
      <Text>원래 텍스트: {text}</Text>
      <Welcome setText={setText} />
    </View>
  )
}
*/

// useEffect: 컴포넌트가 렌더링 될 때마다 특정 작업을 실행하는 hook
// componentDidMount + componentDidUpdate + componentWillUnmount
function Welcome(props:any) {

  console.log("start");

  useEffect(() => {     // == document.addEventListener("DOMContentLoaded", function(){})
    props.setText("useEffect로 바뀌는 텍스트");
    console.log("useEffect 작동")
  })

  // function onClickHandler() {
  //   props.setText("바뀐 텍스트");
  // }

  console.log("end");

  return (
    <View>
      <Text>Welcome</Text>
      {/* <Button title="button" onPress={onClickHandler}></Button> */}
    </View>
  )
}

export default function App() {

  // useState : getter와 setter의 한 쌍으로 이해
  const [text, setText] = useState("텍스트");

  return (
    <View>
      <Text>텍스트: {text}</Text>
      <Welcome setText={setText} />
    </View>
  )
}