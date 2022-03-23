import React from "react";
import { StyleSheet, Text, View } from "react-native";

export default function HomeScreen() {

    return (
      <View style={style.container}>
          <Text>SettingScreen</Text>
      </View>
    )
}

const style = StyleSheet.create({
    container: {
        backgroundColor: '#0000ff'
    }
})