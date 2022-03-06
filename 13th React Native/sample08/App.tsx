import React from "react";
import { Text, View } from "react-native";

import NamedImportModule from "./src/screens/NamedImptModule";

export default function App() {

  return (
    <View>
      <Text>Hello Tsx</Text>
      <NamedImportModule />
    </View>
  )
}