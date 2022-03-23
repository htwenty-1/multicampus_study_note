import React from "react";
import { StyleSheet, Text, View } from "react-native";

export default function SettingScreen() {

    return (
      <View style={style.container}>
          <Text>SettingScreen</Text>
      </View>
    )
}

const style = StyleSheet.create({
    container: {
        backgroundColor: '#ff0000'
    }
})