import React, { useState } from "react";
import { View, Text, TextInput, Button } from "react-native";

function MyFunc(props) {
  console.log(props.name);
  props.setText("i love money");
  return <Text>{props.name}</Text>;
}

export default function App () {

  const [inputTextValue, setInputTextValue] = useState("");
  const [text, setText] = useState("");

  const handleChange = (event) => {
    const {eventCount, target, text} = event.nativeEvent;
    setInputTextValue(text);
    // console.log(eventCount);
    // console.log(target);
  }

  const handleClick = () => {
    console.log(inputTextValue);
    console.log(text);
  }


  return(
    <View>
      {/* <MyFunc name="abc" setText={setText}></MyFunc> */}
      <Text>I Love {text}</Text>
      <TextInput value={inputTextValue} onChange={handleChange} placeholder="onChange" />
      <TextInput onChangeText={(text) => setText(text)} placeholder="onChangeText" />
      <Button title="button" onPress={handleClick} />
    </View>
  )
}