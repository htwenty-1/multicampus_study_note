import React from "react";
import { StyleSheet, Text, View } from "react-native";

export const WidthHeight = () => {
    return (
        <View style={style.container}>
            <Text>200 x 100</Text>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        width: 200,
        height: 100,
        borderWidth: StyleSheet.hairlineWidth,
        borderColor: '#bbb',
    }
})