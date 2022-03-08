import React, { useContext } from "react";
import { Text, View } from "react-native";
import SecondComponent from "./SecondComponent";
import { TextContext } from "./TextProvider";

export default function FirstComponent() {

    // const textData = useContext(TextContext);
    // return (
    //     <View>
    //         <Text>First Component</Text>
    //         <Text>{textData}</Text>
    //         <SecondComponent />
    //     </View>
    // );

    return (
        <View>
            <Text>First Component</Text>
            {/* <Text>{textData}</Text> */}
            <SecondComponent />
        </View>
    );
}