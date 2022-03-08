import React, { useState, useCallback } from 'react';
import { View, Button, Text } from 'react-native';

// useCallback: 함수 재사용

const MyButton = React.memo(({ counterState, buttonValue }:any) => {
  console.log(`${buttonValue}가 클릭됨.`)
  return <Button title={buttonValue} onPress={counterState} />
})


export default function App() {

  const [countStateA, setCountStateA] = useState(0);
  const [countStateB, setCountStateB] = useState(0);

  const countIncrementA = useCallback(() => setCountStateA(countStateA + 1), [countStateA]);
  const countIncrementB = useCallback(() => setCountStateB(countStateB + 1), [countStateB]);

  return (
    <View>
      <Text>A Button {countStateA}</Text>
      <MyButton counterState={countIncrementA} buttonValue='A Button' />
      <Text>A Button {countStateB}</Text>
      <MyButton counterState={countIncrementB} buttonValue='B Button' />
    </View>
  )
}