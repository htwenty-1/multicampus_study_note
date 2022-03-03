import React from "react";
import { Text, View } from "react-native";

export default function App() {

  const color = "red";
  const sampleObj = { color: color }
  console.log(sampleObj);
  console.log(sampleObj.color);

  const samObj1 = { color }
  console.log(samObj1)
  
  const user = {
    name: "kim",
    id: 23,
    age: 18,
  }

  console.log(user.name)
  console.log(user["id"])

  let points = {
    x: 100,
    y: 180
  }
  
  points.x = 150

  console.log(points)

  const pointObj = {
    a: 10,
    b: 20,
    c: 30
  }

  const keys = Object.keys(pointObj)
  console.log(keys)
  console.log(typeof(keys))

  const values = Object.values(pointObj)
  console.log(values)

  const posts = [
    {
      id: 1,
      contents: "Java",
      like: 4
    },
    {
      id: 2,
      contents: "Android",
      like: 3
    },
    {
      id: 3,
      contents: "React Native",
      like: 3.5
    }
  ];
  
  /*
  for (let i = 0; i < posts.length; i++) {
    console.log(`타이틀: ${posts[i].contents} ...... 점수: ${posts[i].like}`);
  }

  posts.forEach((post) => {
    return console.log(`타이틀: ${post.contents} ...... 점수: ${post.like}`);
  })
  */

  const objMap = posts.map((post) => {
    return `타이틀: ${post.contents} ...... 점수: ${post.like}`;
  });

  console.log(objMap);
  console.log(typeof objMap);


  return (
    <View>
      <Text>Hello TSX</Text>
    </View>
  )
}