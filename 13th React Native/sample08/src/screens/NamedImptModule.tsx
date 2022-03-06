import React from "react";
import { Text, View } from "react-native";

import { sampleVar, sampleFunc, sampleNumFunc, list } from "./NamedExpModule"

export default function NamedImportModule() {
    return (
        <View>
            <Text>NamedImportModule</Text>
            <Text>{ sampleVar }</Text>
            <Text>{ sampleFunc() }</Text>
            <Text>{ sampleNumFunc(3, 7) }</Text>
            <View>{ list() }</View>
        </View>
    )
}