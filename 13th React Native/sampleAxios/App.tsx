import axios from "axios";
import React, { useEffect, useState } from "react";
import { Text, View } from "react-native";

/*
      .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/
    :: Spring Boot ::                (v2.6.3)
    
*/

// item
/*
  item:any ===> 단일 데이터만.
  {item}:any ===> 여러개의 데이터를 JSON으로
*/
const ViewItem = ({item}:any) => {

  return (
    <View>
      <Text>{item.id} {item.name} {item.email}</Text>
    </View>
  )
}

// list
const ViewList = ({itemList}:any) => {

  return (
    <View>
      {/* map은 ()로 묶는다. */}
      {itemList.map((item:any) => (
        <ViewItem key={item.id} item={item} />
      ))}
    </View>
  )
}


// axios를 사용하여 비동기 통신하기
export default function App() {

  const [itemList, setItemList] = useState([]);

  let mounted = true;

  useEffect(() => {

    // const fetchData = async () => {
      try {

        // get으로 전송하는 예시
        // const emptyParam = /*await*/ axios.get(
        //   "http://192.168.35.149:3000/base", 
        //   {}    // 보낼 데이터가 없을 때는 {}
        // ).then(function(emptyParam) {
        //   console.log(emptyParam.data);
        // }).catch(function(err) {
        //   console.log(err);
        // });

        // android나 web에서 백엔드단에 POST로 전송할 때는 RequestBody 어노테이션을 작성하지 않아야 함.
        // const stringParam = /*await*/ axios.get(
        //   "http://192.168.35.149:3000/conParamGet", 
        //   { params: { title: "테스트 케이스 전송" } }
        // ).then(function(stringParam) {
        //   console.log(stringParam.data);
        // }).catch(function(err) {
        //   console.log(err);
        // });

        // dto타입
        // const dtoParam = /*await*/ axios.get(
        //   "http://192.168.35.149:3000/getMemberList",
        //   { params: {
        //     id: "park",
        //     pwd: "park123",
        //     name: "박철순",
        //     email: "이메일@이메일.com",
        //     auth: 1,
        //   }}
        // ).then(function(dtoParam) {
        //   console.log(dtoParam.data);
        // }).catch(function(err) {
        //   console.log(err);
        // })

        const dbTest = /*await*/ axios.get(
          "http://192.168.35.149:3000/dbTest",
          {}
        ).then(function(db) {
          console.log(db.data);
          console.log(db.data[0].id);
          setItemList(db.data);
        }).catch(function(err) {
          console.log(err);
        })

        // post로 전송하기 : 컨트롤러에서 @RequestBody는 사용하지 않고, 두번째 매개변수로 null을 넣어준다.
        // const dtoParam2 = /*await*/ axios.post(
        //   "http://192.168.35.149:3000/getMember",
        //   null,
        //   { params: {
        //     id: "aaa",
        //     pwd: "aaa"
        //   } }
        // ).then(function(dtoParam2) {
        //   console.log(dtoParam2.data);
        // }).catch(function(err) {
        //   console.log(err);
        // })

        // console.log(emptyParam.data);
        // console.log(stringParam.data);
        // console.log(dtoParam.data);

      } catch (e) {

        console.log(`에러 발생 : ${e}`);
      }
    // }

    // fetchData();

    return () => { mounted = false };
  }, []);

  return (
    <View>
      <Text>텍스트~</Text>
      <ViewList itemList={itemList} />
    </View>
  )
}