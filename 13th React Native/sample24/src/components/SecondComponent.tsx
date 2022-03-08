import React, { useContext } from "react";
import { Text, View } from "react-native";
import ThirdComponent from "./ThirdComponent";

export default function SecondComponent() {

    
    return (
        <View>
            <Text>Second Component</Text>
            <ThirdComponent />
        </View>
    );
}