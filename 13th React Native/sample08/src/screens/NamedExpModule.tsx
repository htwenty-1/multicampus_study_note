import React from "react"
import { Text, View } from "react-native"

// 변수
const sampleVar = "sample variable"

// 함수
const sampleFunc = () => "sampleFunc() 호출함"

const sampleNumFunc = (num1:number, num2:number) => 
    (num1 * num2)

// object == json
const json = [
    {
        seq: 1,
        title: 'apple',
        content: '사과'
    },
    {
        seq: 2,
        title: 'banana',
        content: '바나나'
    },
    {
        seq: 3,
        title: 'grape',
        content: '포도'
    },
]

const list = () => {
    return json.map((element) => {
        return (
            <View key={element.seq} style={{margin: 10}}>
                <Text>{ element.seq } { element.title }</Text>
                <Text>{ element.content }</Text>
            </View>
        )
    })
}

export { sampleVar, sampleFunc, sampleNumFunc, list }

