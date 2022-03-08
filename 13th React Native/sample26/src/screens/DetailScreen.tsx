import React from "react";
import { View, Text, Button, StyleSheet } from "react-native";

export default function DetailScreen() {

  return (
    <View style={styles.container}>
        <Text>여기는 DetailScreen 입니다.</Text>
    </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center'
    }
})