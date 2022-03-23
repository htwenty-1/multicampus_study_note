import React, { useEffect, useState } from "react";
import { SafeAreaView, StyleSheet, Text, View } from "react-native";
import { Camera, useCameraDevices } from "react-native-vision-camera";

/*
  필수 설치 패키지
  npm i react-native-vision-camera
*/

const LoadingView = () => {
  return (
    <View>
      <Text>Loading...</Text>
    </View>
  )
}

const App = () => {
  const [hasPermission, setHasPermission] = useState(false);
  const devices = useCameraDevices("wide-angle-camera");
  const device = devices.back;

  useEffect(() => {
    (async () => {
      const status = await Camera.requestCameraPermission();
      setHasPermission(status === 'authorized');
    })();
  }, []);

  if (device === null) return <LoadingView />
  return (
    <SafeAreaView style={styles.container}>
      {device != null &&
      hasPermission && (
        <>
          <Camera
            style={StyleSheet.absoluteFill}
            device={device}
            isActive={true}
          />
        </>
      )}
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  }
})

export default App;