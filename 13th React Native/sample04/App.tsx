import React from "react";
import { Text, View } from "react-native";

export default function App() {
  

  const x = 10;
  if( x=== 10 ) {
    console.log(`x = ${x}이다.`);
  }

  const color = "green";

  if (color === "yellow") {
    console.log("this is yellow");
  } else if(color === "Red") {
    console.log("this is not yellow");
  } else {
    console.log("何でもない");
  }

  const k = 100;
  switch(k) {
    case 1:
      console.log("5가 아니라 1임")
      break;
    case 2:
      console.log("5가 아니라 1임");
      break;
    case 5:
      console.log("5임");
      break;
    default:
      console.log("아무것도 아님")
      break;
  }

  for(let i = 0; i < 10; i++) {
    console.log(`${i}번째 루프`);
  }

  let user = {
    name: "성춘향",
    age: 16,
    address: "남원시"
  }

  for(let key in user) {
    console.log(`${key}: ${user[key]}`)
  }

  let arr = [10, 20, 30, 40, 50]

  for(let key in arr) {
    console.log(`${key}: ${arr[key]}`)
  }

  let w = 0;
  while(w < 5) {
    console.log(`${w} 번째 루프`)
    if(w === 3) {
      break;
    }
    w++;
  }

  return (
    <View>
      <Text>Hello TSX</Text>
    </View>
  )
}