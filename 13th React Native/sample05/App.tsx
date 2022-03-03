import React from "react";
import { Text, View } from "react-native";

export default function App() {

  // const shopping = ["Bread", "Ham", "Milk"];
  
  // for(let i in shopping) {
  //   console.log(shopping[i]);
  // }

  // 배열인지 객체인지
  const samArr = [];
  const samObj = {};

  console.log(Array.isArray(samArr));
  console.log(Array.isArray(samObj));

  const arrSam = ["red", "green", "blue"];

  console.log(arrSam.indexOf("green"));
  console.log(arrSam.length);

  // 정렬
  console.log(arrSam.sort())
  console.log(arrSam.reverse())

  const arrNum = [11, 2, 33, 4];
  console.log(arrNum.sort());                 // ASCII로 정렬되므로 정렬이 되지 않는다.
  
  console.log(arrNum.sort((a, b) => a - b))   // 오름차순
  console.log(arrNum.sort((a, b) => b - a))   // 내림차순


  return (
    <View>
      <Text>Hello TSX</Text>
    </View>
  )
}