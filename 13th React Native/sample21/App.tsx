import React, { useEffect, useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <Clock />
    </View>
  )
}

const Clock = () => {
  const [date, setDate] = useState(() => new Date());

  const tick = () => setDate(new Date())

  useEffect(() => {
    const timeInstance = setInterval(() => { tick() }, 1000)
    // console.log('serInterval');

    return () => {
      clearInterval(timeInstance);
      // console.log('clearInterval');
    }
  }, [])

  return (
    <View style={styles.container}>
      <Text style={styles.timeText}>현재시간</Text>
      <Text style={styles.timeText}>{date.toLocaleTimeString()}</Text>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#e9e9e9',
    alignItems: 'center',
    justifyContent: 'center',
  },
  timeText: {
    fontSize: 30,
    fontWeight: 'bold',
  }
})