import React, { useContext } from "react";
import { Button, Text, View } from "react-native";
import { CountContext } from "./CountProvider";
import { TextContext } from "./TextProvider";

export default function ThirdComponent() {

    // const textData = useContext(TextContext);

    // return (
    //     <View>
    //         <Text>Third Component</Text>
    //         <Text>{textData}</Text>
    //     </View>
    // );

    const [count, setCount]:any = useContext(CountContext);

    const btnClick = () => {
        setCount((pcount:any) => pcount + 1)
    }

    return (
        <View>
            <Text>Third Component</Text>
            <Text>현재 카운트 : {count}</Text>
            <Button title="+1 증가" onPress={btnClick} />
        </View>
    )
}