import axios from "axios";
import React, { useEffect, useState } from "react";
import { FlatList, Image, StyleSheet, Text, View, TouchableOpacity } from "react-native";
// import { TouchableOpacity } from "react-native-gesture-handler";

/*
    일반적으로 화면단을 설정할 때 컨텐츠가 화면을 벗어나면 스크롤뷰를 설정해야 화면을 내려서 볼 수 있지만,
    플랫 리스트를 사용하면 스크롤뷰가 내장되어 있기 때문에 별도로 설정하지 않아도 된다.
*/

// test data
// const data = [
//     {
//         "userId": "admin",
//         "title": "테스트 데이터 제목입니다.",
//         "readCount": 10
//     },
//     {
//         "userId": "guest",
//         "title": "게스트입니다.",
//         "readCount": 1
//     },
//     {
//         "userId": "hJunPark",
//         "title": "박군입니다.",
//         "readCount": 100
//     }
// ]

function Item ({id, title, readCount, seq, props}:any) {

    function itemClick(seq:number) {
        console.log('itemClick');
        console.log(seq);

        axios.get("http://192.168.35.149:3000/getBbsDetail", {params: {seq: seq}}).then(function(resp) {
            console.log(resp.data);
            props.setBbs(resp.data);
        }).catch(function(err) {
            console.log(err);
        })
        
        // 이동 시 가져갈 정보

        // detail 페이지로 이동
        props.setBbslist("bbsdetail")
    }

    return (
        <View style={styles.item}>
            <TouchableOpacity onPress={() => itemClick(seq)}>
                <View style={styles.idRow}>
                    <Image style={styles.image} 
                           source={require("../../assets/dog.png")}
                    />
                    <Text style={styles.title}>{title}</Text>
                </View>
                <View style={styles.idRow}>
                    <Text style={styles.userId}>{id}</Text>
                    <Text style={styles.readCount}>{readCount}</Text>
                </View>
            </TouchableOpacity>
        </View>
    )
}

const Bbslist = (props:any) => {

    function renderItem({item}:any) {

        // 제목이 긴 경우 줄여서 표현해 줄 함수
        function strLength(str:String) {
            if(str.length > 18) {
                return str.substring(0, 17) + "...";
            } else {
                return str;
            }
        }
        
        return (
            <Item
                id={`작성자: ${item.userId}`} 
                title={strLength(item.title)} 
                readCount={`조회수: ${item.readCount}`} 
                seq={item.seq}
                props={props}
            />
        )
    }

    const [data, setData] = useState([]);

    useEffect(() => {

        axios.get("http://192.168.35.149:3000/getBbsList", {})
        .then(function(resp) {
            console.log(resp);
            setData(resp.data);
        })
        .catch(function(err) {
            console.log(err);
        });
    }, [])

    return (
        <View style={styles.scrollView}>
            <FlatList data={data} renderItem={renderItem} />
        </View>
    )    
}

const styles = StyleSheet.create({
    
    item: {
         backgroundColor: "#d7d9f4",
         padding: 10,
         marginVertical: 2,
         marginHorizontal: 8,
         borderColor: "#ff0000",
         borderRadius: 15,
         borderStyle: "solid",
         borderWidth: 2,
    },
    image: {
        width: 50,
        height: 50,
        marginTop: 15
    },
    title: {
        fontFamily: "roboto-regular",
        paddingLeft: 20,
        color: "#400040",
        height: 60,
        width: 500,
        fontSize: 26,
    },
    userId: {
        fontFamily: "roboto-regular",
        //backgroundColor: "#ffff00",
        color: "#121212",
        height: 30,
        width: 166,
        fontSize: 20,
        marginLeft: 80,
        marginTop: 8
    },
    readCount: {
        fontFamily: "roboto-regular",
        //backgroundColor: "#00ff00",
        color: "#121212",
        height: 30,
        width: 211,
        fontSize: 20,
        marginLeft: 51,
        marginTop: 8,
        textAlign: "center",
    },
    idRow: {
        height: 40,
        flexDirection: "row",
        marginLeft: 5,
    },
    scrollView: {
        height: 760
    }
});

export default Bbslist;