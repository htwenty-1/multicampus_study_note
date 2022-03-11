import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import Login from "./src/screens/members/Login";
import Account from "./src/screens/members/Account";
import Bbs from "./src/screens/bbs/Bbs";

/*
    필수 설치 패키지 목록
    npm install @react-navigation/native
    npm install @react-navigation/native-stack
    npm install react-native-safe-area-context
    npm install react-native-gesture-handler
    npm install react-native-screens
    npm install watcher

    npm i @react-native-async-storage/async-storage
*/

const Stack = createNativeStackNavigator();

const App = () => {

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="login">
        <Stack.Screen name="login" component={Login} options={{title: "로그인"}} />
        <Stack.Screen name="account" component={Account} options={{title: "회원가입"}} />
        <Stack.Screen name="bbs" component={Bbs} options={{title: "게시판"}} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}

export default App;