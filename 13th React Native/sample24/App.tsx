import React, { createContext, useContext } from "react";
import { Text, View } from "react-native";
import { CountProvider } from "./src/components/CountProvider";
import FirstComponent from "./src/components/FirstComponent";
import TextProvider from "./src/components/TextProvider";

// useContext, createContext : 값 넘기기, 단독으로 쓰일 수 없다.

/*
//// 간단한 예시
const ContextObj:any = createContext({});

const Welcome = () => {
  const messageText:Object = useContext(ContextObj);
  console.log(messageText);

  return (
    <Text>넘겨받은 값: {messageText}</Text>
  )
}

export default function App() {

  const message:String = "I love React";

  return (
    <View>
      <ContextObj.Provider value={message}>
        <Welcome />
      </ContextObj.Provider>
    </View>
  );
};
*/

//// 복잡한 예
export default function App() {

  // return (
  //   <View>
  //     <TextProvider>
  //       <FirstComponent />
  //     </TextProvider>
  //   </View>
  // )

  return (
    <View>
      <CountProvider>
        <FirstComponent />
      </CountProvider>
    </View>
  )
}