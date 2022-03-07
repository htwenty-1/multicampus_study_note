import React from "react";
import { View } from "react-native";
import Flexbox from "./src/components/Flexbox";
import { MarginPadding } from "./src/components/MarginPadding";
import { WidthHeight } from "./src/components/WidthHeight";

const App = () => {

  return (
    <View>
      <WidthHeight />
      <MarginPadding />
      <Flexbox />
    </View>
  )
}

export default App;