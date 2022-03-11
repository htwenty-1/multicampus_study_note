import AsyncStorage from "@react-native-async-storage/async-storage";
import axios from "axios";
import React, { useState } from "react";
import { Alert, StyleSheet, Text, View } from "react-native";
import { Button, TextInput } from "react-native-paper";

export default function BbsWrite(props:any) {
    
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
        console.log(id);
        console.log(title);
        console.log(content);

        if (title.trim() === "") {
            Alert.alert("제목 입력 확인", "제목이 입력되지 않았습니다!");
        } else if (content.trim() === "") {
            Alert.alert("내용 입력 확인", "내용이 입력되지 않았습니다!")
        } else {
            axios.get("http://192.168.35.149:3000/insertBbs", 
            { params: {
                id: id,
                title: title,
                content: content
            }}
            ).then(function(resp){
                console.log(resp.data);

                if (resp.data === "ok") {
                    Alert.alert("등록 완료", "글이 등록되었습니다!");
                    // Bbs.tsx에서 bbslist가 bbswrite일 때 setBbslist를 이 컴포넌트 함수의 매개변수인 prop로 접근해서 글 등록이 성공하면 bbslist로 돌아감.
                    props.setBbslist("bbslist");
                } else {
                    Alert.alert("글이 등록되지 않았습니다.", "글이 정상적으로 등록되지 않았습니다. 확인해주세요.");
                }
                
            }).catch(function(err) {
                console.log(err);
                Alert.alert("에러 발생", "글을 등록하는 도중에 에러가 발생했습니다!");
            })
        }

        
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