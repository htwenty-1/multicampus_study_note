import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { NavigationContainer } from "@react-navigation/native";
import React from "react";
import  Icon from "react-native-vector-icons/Ionicons";
import BaseScreen from "./src/screens/BaseScreen";
import HomeScreen from "./src/screens/HomeScreen";
import SettingScreen from "./src/screens/SettingScreen";

/*
    npm install react-native-gesture-handler
    npm install @react-navigation/native
    npm install @react-navigation/bottom-tabs
    npm install react-native-safe-area-context
    npm install react-native-screens
    npm install react-native-vector-icons

    << android -> app -> src -> build.gradle >>
    project.ext.vectoricons = [
      iconFontNames: [ 'Ionicons.ttf', 'FontAwesome.ttf' ]
    ]

    apply from: "../../node_modules/react-native-vector-icons/fonts.gradle"
*/

const Tab = createBottomTabNavigator();

export default function App() {

  return (
    <NavigationContainer>
      <Tab.Navigator
        screenOptions = {
          ({route}) => (
            {tabBarIcon: ({focused, color, size}) => {
              let iconName;

              if (route.name === "메인") {
                iconName = focused ? "cafe" : "cafe-outline";
              } else if (route.name === "통계") {
                iconName = focused ? "podium" : "podium-outline";
              } else if (route.name === "설정") {
                iconName = focused ? "settings" : "settings-outline";
              } 

              return <Icon name={iconName} size={size} color={color}/>
            },
          })}
      >

        <Tab.Screen name="메인" component={HomeScreen} />
        <Tab.Screen name="통계" component={BaseScreen} />
        <Tab.Screen name="설정" component={SettingScreen} />
        
      </Tab.Navigator>
    </NavigationContainer>
  );
};