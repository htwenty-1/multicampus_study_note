import React from "react";
import { Text, View } from "react-native";

import { sampleCallbackFunc, User } from "./ObjectExportModule";

const newUser = new User("성춘향", 16)

export default function NamedImportModule() {
    
    sampleCallbackFunc()

    return (
        <View>
            <Text>NamedImportModule</Text>
            <Text>name:{ newUser.name }, age:{ newUser.age }</Text>
        </View>        
    )
}