import React from "react";
import { SafeAreaView, Text } from "react-native";

const global = "전역상수의 값";

const sampleFunc = () => {
  console.log("call sampleFunc");

  let local = "지역변수의 값";
  
  console.log(local);
  console.log(global);
}

export default function App() {

  sampleFunc();

  let ex1 = null;
  ex1 ?? console.log("this is null");

  ex1 = undefined
  ex1 ?? console.log("this is undefined");

  ex1 = "Hi nice to meet you"
  ex1 ?? console.log("this is not null")

  // function rectArea(width:number, height:number) {
  //   const result = width * height;
  //   return result;
  // }

  // const rectArea = (width = 7, height = 9) => width * height

  // console.log(rectArea(2, 4))
  // console.log(rectArea())

  // const func = (a, b, ...rest) => {
  //   console.log(rest)
  // }

  // func(1, 2, 3, 4, 5)

  const user = {
    name: "홍길동",
    message: "나는 성공할 것입니다."
  }

  const samFunc = ({message}) => console.log(message)
  samFunc(user)

  return(
    <SafeAreaView>
      <Text>Hello TSX World!</Text>
    </SafeAreaView>
  )
}