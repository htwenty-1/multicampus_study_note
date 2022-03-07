import React, { useState } from "react";
import { Text, View } from "react-native";
import { RadioGroup, RadioButton } from 'react-native-flexi-radio-button';

const App = () => {

  const [checked, setChecked] = useState("first");

  return (
    <View>
      <RadioGroup
        size={24}
        thickness={2}
        color="#9575b2"
        highlightColor="#ccc8b9"
        selectedIndex={1}
        onSelect = {
          (index:any, value:any) => console.log(index, value)
        }
      >
        <RadioButton
          value="first" 
          status={checked === "first" ? "checked" : "uncheked"} 
          onPress={() => setChecked("first")}
        >
          <Text>Apple</Text>
        </RadioButton>
        <RadioButton
          value="second" 
          status={checked === "first" ? "checked" : "uncheked"} 
          onPress={() => setChecked("second")}
        >
          <Text>Banana</Text>
        </RadioButton>
        <RadioButton
          value="third" 
          status={checked === "first" ? "checked" : "uncheked"} 
          onPress={() => setChecked("third")}
        >
          <Text>Pear</Text>
        </RadioButton>
      </RadioGroup>
    </View>
  )
}

export default App;

