import React from "react";
import { StyleSheet, Text, View } from "react-native";

export const MarginPadding = () => {
    
    return(
        <View style={style.container}>
            <Text>제목입니다.</Text>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        marginHorizontal: '10%',
        padding: 16,
        borderWidth: StyleSheet.hairlineWidth,
        borderColor: '#ff0000',
        backgroundColor: '#ffff00'
    }
})