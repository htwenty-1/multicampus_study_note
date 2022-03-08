import { useNavigation } from "@react-navigation/native";
import React from "react";
import { Button, StyleSheet, Text, View } from "react-native";

export default function HomeScreen() {

    // 어떤 뷰로든 이동할 수 있다.
    const navi = useNavigation();

    return (
        <View style={styles.container}>
            <Text>여기는 HomeScreen 입니다.</Text>
            {/* onPress에 App.tsx에서 지정한 이름을 넣어준다. */}
            <Button title="Detail로 이동" onPress={() => navi.navigate("Detail")} />
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