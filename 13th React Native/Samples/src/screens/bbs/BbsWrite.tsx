import AsyncStorage from "@react-native-async-storage/async-storage";
import axios from "axios";
import React, { useState } from "react";
import { StyleSheet, Text, View } from "react-native";
import { Button, TextInput } from "react-native-paper";

export default function BbsWrite() {
    
    const [id, setId] = useState("");
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");

    const loginData = async () => {
        try {
            let user = await AsyncStorage.getItem("login");
            
            if (user !== null) {
                setId((JSON.parse(user)).id);
            }
        } catch (err) {
            console.log(err);
        }
    }

    loginData();

    const bbsWriteBtn = () => {
        axios.get("http://192.168.35.149:3000/insertBbs", {params: {userId: id, title: title, content: content}})
    }

    return (
        <View>
            <Text style={styles.text}>새 글 등록하기</Text>
            <View style={{alignItems: "center"}}>
                <TextInput
                    style={styles.textInput}
                    mode="outlined"
                    label="작성자"
                    value={id}
                    editable={false} 
                />

                <TextInput
                    style={styles.textInput}
                    mode="outlined"
                    label="제목"
                    value={title}
                    onChangeText={(title) => setTitle(title)}
                />

                <TextInput
                    style={styles.textArea}
                    placeholder="내용"
                    multiline={true}
                    numberOfLines={20}
                    value={content}
                    onChangeText={(content) => setContent(content)}
                />

                <Button
                    mode="outlined"
                    style={styles.btn}
                    onPress={bbsWriteBtn}
                >
                    작성 완료
                </Button>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    text: {
        marginTop: 10,
        fontSize: 30,
        textAlign: "center"
    },
    textInput: {
        marginTop: 20,
        fontSize: 16,
        width: 500,
        height: 40,
        backgroundColor: "#e3e3e3"
    },
    textArea: {
        fontSize: 16,
        borderWidth: 1,
        marginTop: 20,
        backgroundColor: "#e3e3e3",
        textAlignVertical: "top",
        width: 500
    },
    btn: {
        marginTop: 20,
        marginVertical: 8
    }
})