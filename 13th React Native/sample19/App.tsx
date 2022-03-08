import React from "react";
import { StyleSheet, View } from "react-native";
import Flexbox from "./src/components/Flexbox";
import { MarginPadding } from "./src/components/MarginPadding";
import { WidthHeight } from "./src/components/WidthHeight";

const App = () => {

  return (
    <View style={style.container}>
      <WidthHeight />
      <MarginPadding />
      <Flexbox />

      <View style={style.box} />
    </View>
  )
}

const style = StyleSheet.create({
  container: {
    flex: 1
  },
  box: {
    width: 150,
    height: 100,
    backgroundColor: '#ff0000',
    position: 'absolute',  // 우측하단
    right: 16,
    bottom: 16
  }
})

export default App;