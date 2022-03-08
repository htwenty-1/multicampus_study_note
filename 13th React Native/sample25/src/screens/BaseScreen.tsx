import React from "react";
import { StyleSheet, Text, View } from "react-native";

export default function BaseScreen() {

    return (
      <View style={styles.container}>
          <Text>BaseScreen</Text>
      </View>
    )
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#00ff00'
    }
})