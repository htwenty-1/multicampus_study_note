import React from "react";
import { View, Text, StyleSheet, Platform } from "react-native";

function Welcome(props:any) {
    return (
        <View>
            <Text style={styles.text}>Hello Welcome {props.name}</Text>
            <Text style={styles.text}>Age {props.age}</Text>
        </View>
    )
}

const styles = StyleSheet.create({
    text: {
        fontFamily: Platform.select({
          android: "serif"
        }),
        fontSize: 30
    }
})

export default Welcome;

