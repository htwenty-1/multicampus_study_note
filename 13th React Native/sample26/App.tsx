import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { View } from "react-native";
import DetailScreen from "./src/screens/DetailScreen";
import HomeScreen from "./src/screens/HomeScreen";

/*
    npm install react-native-gesture-handler
    npm install @react-navigation/native
    npm install @react-navigation/native-stack
    npm install react-native-safe-area-context
    npm install react-native-screens
    npm install watcher (배포 중 오류 발생시)
*/

const Stack = createNativeStackNavigator();

export default function App() {

  return (
    <NavigationContainer>
      {/* 처음 접속시 initialRouteName에 지정된 경로에서 열림 */}
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen name="Home" component={HomeScreen} />
        <Stack.Screen name="Detail" component={DetailScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}