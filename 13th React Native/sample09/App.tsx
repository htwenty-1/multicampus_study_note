import React from "react";
import { SafeAreaView, Text } from "react-native";

import NamedImportModule from "./src/screens/ObjectImportModule";

export default function App() {

  return (
    <SafeAreaView>
      <Text>App</Text>
      <NamedImportModule></NamedImportModule>
    </SafeAreaView>
  )
}