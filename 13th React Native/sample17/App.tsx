import React from "react";
import { StyleSheet, Text, View, Image, SafeAreaView } from "react-native";
import { getJSDocReadonlyTag } from "typescript";

const colorList = [
  { color: '#00974A', val: '00974A' },
  { color: '#2e6067', val: '2e6067' },
  { color: '#a92127', val: 'a92127' },
  { color: '#030364', val: '030364' },
  { color: '#0d6729', val: '0d6729' },
  { color: '#ff290b', val: 'ff290b' },
];

export default function App() {

  return (
    // <View style={styles.container}>
    //   <Text style={styles.hello}>Hello</Text>
    //   <Text>World</Text>
    // </View>

    // <View style={{flexDirection: 'column', alignItems: 'center', backgroundColor: "#ff0000"}}>
    // <View style={{flexDirection: 'row', backgroundColor: '#ff0000'}}>
    // <View style={{flexDirection: 'column'}}>
    //   <Text style={{backgroundColor: '#ffff00', textAlign: 'center'}}>Hello</Text>
    //   <Text style={{textAlign: 'right'}}>World</Text>
    // </View>

    // 자간 넓히기 == letterSpacing
    // <View>
    //   <Text style={{letterSpacing: 1.5, fontSize: 20}}>3월 9일은 제20대 대통령 선거일입니다.</Text>
    // </View>

    // <View>
    //   <Image
    //     source={{uri: 'https://facebook.github.io/react-native/docs/assets/favicon.png'}}
    //     style={{width: 100, height: 100, resizeMode: 'contain', opacity: 0.5}}
    //   />
    //   <Image
    //     source={require('./src/assets/android.png')}
    //     style={{width: 300, height: 300, resizeMode: 'contain'}}
    //   />
    // </View>

    // <View style={styles.world}>
    //   <Text>Hello</Text>
    //   <Text>World</Text>
    // </View>



    <SafeAreaView>
      <View style={{padding: 16}}>
        {colorList.map((item) => (
          <View 
            key={item.color} 
            style={[styles.card, {backgroundColor: item.color}]}
          >
            <Text>{item.val}</Text>
          </View>
        ))}
      </View>
    </SafeAreaView>

  )
}

const styles = StyleSheet.create({
  // 스타일 작성
  // container: {
  //   flex: 1,
  //   backgroundColor: "#0000ff",
  //   alignItems: "center",
  //   justifyContent: "center"
  //   // marginLeft: "auto",
  //   // marginRight: "auto",
  //   // marginTop: "auto",
  //   // marginBottom: "auto",
  //   // margin: "auto"
  // },
  // hello: {
  //   backgroundColor: "#ff0000",
  // },
  // world: {
  //   borderWidth: 1,
  //   borderColor: 'gray',
  //   borderBottomLeftRadius: 5,
  //   borderTopRightRadius: 10
  // }

  container: {
    flex: 1
  },
  card: {
    marginVertical: 8,
    height: 96,
    borderWidth: 1,
    borderColor: '#000000',
    borderRadius: 8,
    transform: [  // move, rotation, scale
      { rotateX: '45deg' },
      { rotateZ: '0.785398rad' }
    ]
  }
})