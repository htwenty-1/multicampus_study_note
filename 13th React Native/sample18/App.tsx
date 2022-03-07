import React from "react";
import { StyleSheet, View, Text } from "react-native";

// flex: 화면을 화면의 크기 비율로 나누는 것

export default function App() {

  return (
    <View style={style.container}>
      <View style={style.caseOne} />
      <View style={style.caseTwo}>
        <Text>second display area</Text>
      </View>
      <View style={style.caseThree} />
    </View>
  )
}

const style = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#ff0000',
    // flexDirection: 'row',
    width: 300,
  },
  caseOne: {
    flex: 1,
    backgroundColor: '#ffff00'
  },
  caseTwo: {
    flex: 1,
    backgroundColor: '#0000ff'
  },
  caseThree: {
    flex: 8,
    backgroundColor: '#00ff00',
    // width: 200, 
    height: 300
  }
})