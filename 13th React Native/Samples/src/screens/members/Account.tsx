import axios from "axios";
import React, { useState } from "react";
import { Image, 
         StyleSheet, 
         Text, 
         View, 
         TouchableHighlight,
         TextInput,
         Alert
} from "react-native";

const Account = ({navigation}:any) => {

    const [id, setId] = useState("");
    const [msg, setMsg] = useState("");  // 아이디 중복검사 체크 메시지
    const [pwd, setPwd] = useState("");
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");

    // 아아디 중복확인
    function idChecker() {

        // console.log("idChecker 버튼이 클릭됨.");
        console.log(`id: ${id}`);
        if (id.trim() === "") {
            Alert.alert("아이디 입력 확인", "아아디가 입력되지 않았습니다.");
            setId("");
        }

        axios.post("http://192.168.35.149:3000/getId",
            null,
            { params: {id: id} }
        ).then(function(response) {
            console.log(response.data);

            if (response.data === "ok") {
                setMsg("사용할 수 있는 아이디입니다.");
            } else {
                setMsg("사용할 수 없는 아이디입니다.");
                setId("");
            }
        }).catch(function(err) {
            console.log(`error message: ${err}`);
        })
    }

    // 회원가입
    function regi() {

        if (id.trim() === "") {
            Alert.alert("아이디 입력 확인", "아아디가 입력되지 않았습니다.");
        } else if (pwd.trim() === "") {
            Alert.alert("비밀번호 입력 확인", "비밀번호가 입력되지 않았습니다.");
        } else if (name.trim() === "") {
            Alert.alert("이름 입력 확인", "이름이 입력되지 않았습니다.");
        } else if (email.trim() === "") {
            Alert.alert("이메일 입력 확인", "이메일이 입력되지 않았습니다.");
        } else {
            axios.post("http://192.168.35.149:3000/addMember", 
                        null, 
                        { params: { id: id, 
                                    pwd: pwd, 
                                    name: name, 
                                    email: email 
                                  } 
                        }
            ).then(function(response) {
                console.log(response);

                if (response.data === "ok") {
                    Alert.alert("회원가입", "회원가입 되었습니다!", 
                                [{text: "확인", 
                                    onPress: () => navigation.navigate("login")
                                }]);
                } else {
                    Alert.alert("회원가입", "가입되지 않았습니다.");
                }
            }).catch(function(err) {
                console.log(err);
            })
        }
    }

    return (
        <View style={styles.container}>
            <Image 
                source={require("../../assets/welcome.jpg")}
                style={styles.logo}
            />

            {/* value를 id로 지정해서 id 입력 검사시 유효하지 않은 아이디를 입력한 경우 외부 함수의 setId를 적용함. */}
            <View style={styles.inputView}>
                <TextInput
                    style={styles.textInput}
                    placeholder="아이디"
                    value={id}
                    underlineColorAndroid="transparent"
                    onChangeText={(id) => setId(id)}
                />
            </View>

            <View style={styles.idTextContainer}>
                <Text style={styles.idText}>
                    {msg}
                </Text>

                <TouchableHighlight 
                    style={[styles.buttonContainer, 
                            styles.sendBtn]}
                >
                    <Text style={styles.buttonText}
                          onPress={() => idChecker()}
                    >
                        ID 중복확인
                    </Text>
                </TouchableHighlight>
            </View>

            <View style={styles.inputView}>
                <TextInput
                    style={styles.textInput}
                    textContentType="password"
                    placeholder="비밀번호"
                    underlineColorAndroid="transparent"
                    onChangeText={(pwd) => setPwd(pwd)}
                    secureTextEntry={true}
                />
            </View>

            <View style={styles.inputView}>
                <TextInput
                    style={styles.textInput}
                    placeholder="이름"
                    underlineColorAndroid="transparent"
                    onChangeText={(name) => setName(name)}
                />
            </View>
            
            <View style={styles.inputView}>
                <TextInput
                    style={styles.textInput}
                    placeholder="전자메일"
                    underlineColorAndroid="transparent"
                    onChangeText={(email) => setEmail(name)}
                />
            </View>

            <TouchableHighlight 
                style={[styles.buttonContainer, 
                       styles.sendBtn]}
                onPress={() => regi()}
            >
                <Text style={styles.buttonText}>회원가입</Text>
            </TouchableHighlight>

        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#fff"
    },
    logo: {
        justifyContent: "center",
        marginBottom: 60,
    },
    inputView: {
        borderBottomColor: "#f5fcff",
        backgroundColor: "#dcdcdc",
        borderRadius: 30,
        borderBottomWidth: 1,
        width: 300,
        height: 45,
        marginBottom: 20,
        flexDirection: "row",
        alignItems: "center",
    },
    textInput: {
        height: 45,
        marginLeft: 16,
        borderBottomColor: "#fff",
        flex: 1,
    },
    buttonContainer: {
        width: 100,
        height: 45,
        flexDirection: "row",
        justifyContent: "center",
        alignItems: "center",
        marginBottom: 20,
        borderRadius: 30,
    },
    sendBtn: {
        backgroundColor: "#ff4500",
    },
    idTextContainer: {
        height: 45,
        flexDirection: "row",
        justifyContent: "center",
        alignItems: "center",
        width: 100,
        borderRadius: 20
    },
    idText: {
        marginLeft: 20,
        marginBottom: 20,
        width: 180
    },
    buttonText: {
        color: "#fff"
    }
})

export default Account;