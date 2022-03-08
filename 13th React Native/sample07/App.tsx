import React from "react";
import { View, Text, StyleSheet } from "react-native";
import Welcome from "./src/components/Welcome";

/*
function Welcome(props:any) {
  return (
    <View>
      <Text style={styles.text}>Hello Welcome {props.name}</Text>
      <Text style={styles.text}>Age {props.age}</Text>
    </View>
  )
}
*/

export default function App() {

  return(
    <View style={styles.container}>
      <Text>Hello TSX</Text>
      <Welcome name="gildong" age="20" />
      <Welcome name="chunhyang" age="25" />
      <Welcome name="jimae" age="28" />
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#ff99ff',
    alignItems: "center",
    justifyContent: "center"
  },
})