import React, { useMemo, useState } from 'react';
import { Text, View, Button } from 'react-native';


// useMemo: 연산된 값을 렌더링할 때 재사용하는 경우에 씀.
// useMemo(함수, [검사할 배열])

const square = (param:number) => {
  const testData = [ Array(10).keys ];
  testData.forEach(() => {
    console.log(`계산중 ... 루프처리 ${testData.length}`);
  });

  return param * param
};



export default function App() {
  const [countStateA, setCountStateA] = useState(0);
  const [countStateB, setCountStateB] = useState(0);

  function countResultA() {
    setCountStateA((prevCnt) => prevCnt + 1);
    console.log("A + 1 버튼이 클릭됨.");
  }

  function countResultB() {
    setCountStateB((prevCnt) => prevCnt + 1);
    console.log("B + 1 버튼이 클릭됨.");
  }

  // 일반적인 경우 예제
  // const sqrArea = square(countStateB)

  // useMemo
  const sqrArea = useMemo(() => square(countStateB), [countResultB])

  return (
    <View>
      <Text>계산결과 A: {sqrArea}</Text>
      <Button title="계산: A + 1" onPress={countResultA} />
      
      <Text>계산결과 B: {sqrArea}</Text>
      <Button title="계산: B + 1" onPress={countResultB} />

      <Text>정사각형 면적</Text>
      <Text>계산 결과 x 계산 결과 = {sqrArea}</Text>
    </View>
  )
}