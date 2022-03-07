import React, { useState } from "react";
import { StyleSheet, View, Text, Button } from "react-native";
import { Checkbox } from "react-native-paper";

const App = () => {

  const [checked, setChecked] = useState(false);

  const handleCheck = () => {
    console.log(checked);
  }

  return(
    <View style={styles.container}>
      <View style={styles.checkboxContainer}>
        <Checkbox 
          status={checked ? 'checked' : 'unchecked'} 
          onPress={() => {setChecked(!checked)}} 
        />
        <Text style={styles.text}>Is CheckBox selected: {checked ? "👍" : "👎"}</Text>
      </View>
      <Button title="체크확인" onPress={handleCheck} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center"
  },
  checkboxContainer: {
    flexDirection: "row"
  },
  text: {
    marginTop: 5
  }
});

export default App;