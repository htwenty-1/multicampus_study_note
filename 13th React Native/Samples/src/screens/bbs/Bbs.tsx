import React, { useState } from "react";
import { Button, StyleSheet, Text, View } from "react-native";
import Bbslist from "./Bbslist";
import BbsWrite from "./BbsWrite";

const Bbs = () => {

    const [bbslist, setBbslist] = useState("bbslist");
    let child:any       // 장면 전환을 위한 변수

    if (bbslist === "bbslist") {
        // child = (<Text>Bbs List View</Text>)
        child = (<Bbslist />)
    } else if (bbslist === "bbswrite") {
        // child = (<Text>Bbs List Write</Text>)
        child = (<BbsWrite />)
    } else if (bbslist === "bbsdetail") {
        child = (<Text>Bbs List Detail</Text>)
    }

    return (
        <View>
            <View style={styles.menu}>
                <View style={styles.button}>
                    <Button title="글목록" onPress={(bbslist) => setBbslist("bbslist")} />
                </View>
                <View style={styles.button}>
                    <Button title="글추가" onPress={(bbslist) => setBbslist("bbswrite")} />
                </View>
            </View>

            <View>{child}</View>
        </View>
    )
}

const styles = StyleSheet.create({
    menu: {
        flexDirection: "row",
        flexWrap: "wrap",
    },
    button: {
        flex: 1,
        height: 50,
        margin: 1
    },
    childView: {
        height: 760
    }
})

export default Bbs;