import React from "react";
import { StyleSheet, Text, View } from "react-native";

export default function Flexbox() {
    return (
        <View style={style.container}>
            <Text style={style.item}>Item 1</Text>
            <Text style={style.item}>Item 2</Text>
            <Text style={style.item}>Item 3</Text>
            <Text style={style.item}>Item 4</Text>
            <Text style={style.item}>Item 5</Text>
            <Text style={style.item}>Item 6</Text>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        flexDirection: 'row',
        flexWrap: 'wrap'
    },
    item: {
        width: 100,
        height: 100,
        borderWidth: StyleSheet.hairlineWidth,
        borderColor: '#ff0000',
    }
})