import React from "react";
import { SafeAreaView, Text } from "react-native";

// export default class App extends React.Component {
  
//   name:String = '';

//   constructor(props:any) {
//     super(props)
//     this.name = "홍길동";    
//   }

//   render() {
      
//     return(
//       <SafeAreaView>
//         <Text>Hello TSX {this.name}</Text>
//       </SafeAreaView>
//     )

//   }

// }

export default function App() {
  
  let name:String = "홍길동";

  return (
    <SafeAreaView>
      <Text>Hello TSX {name}</Text>
    </SafeAreaView>
  )

}