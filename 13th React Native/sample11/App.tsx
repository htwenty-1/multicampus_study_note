import React, { useState } from "react";
import { Alert, Button, SafeAreaView, Text, ToastAndroid } from "react-native";
import LikeButton from "./src/components/LikeButton";

// 1
function btnClick(){
  console.log("btnClick 클릭!")
}

// 2
const onPress = () =>{
  //Alert.alert("home", "home 클릭되었음")
  ToastAndroid.show("home button click!", ToastAndroid.SHORT)
}

export default function App() {

  // 3
  const [liked, setLiked] = useState(false)
  const toggleLiked = () => setLiked( !liked ) 
   
  return (
    <SafeAreaView>
      <Text>Hello Tsx</Text>

      <Button title="버튼" onPress={ btnClick }></Button>

      <Button title="home" onPress={ onPress } />

      <Button title={ liked ? "click on":"click off" } onPress={ toggleLiked } />
      
      <LikeButton />

    </SafeAreaView>
  )     
}