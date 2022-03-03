import React from "react";
import { SafeAreaView, Text } from "react-native";

/*
export default function App() {

  const str = "Hello World";

  return (
    <SafeAreaView>
      <Text>Hello TSX World!</Text>
      <Text>{str}</Text>
    </SafeAreaView>
  );
}
*/

export default function App() {

  const isLoading:boolean = true

  // if(isLoading) {
  //   return(
  //     <SafeAreaView>  
  //       <Text>Loading...</Text>
  //     </SafeAreaView>
  //   )
  // } else {
  //   return (
  //     <SafeAreaView>
  //       <Text>Hello TSX World!</Text>
  //     </SafeAreaView>
  //   )
  // }

  // return (
  //   <SafeAreaView>
  //     {/* {isLoading && <Text>Loading...</Text>}
  //     {!isLoading && <Text>Hello TSX</Text>} */}
  //     {isLoading ? <Text>Loading...</Text> : <Text>Hello TSX</Text>}
  //   </SafeAreaView>
  // )

  // const child:any = isLoading ? (<Text>Loading...</Text>) : (<Text>Hello TSX</Text>);
  // return <SafeAreaView>{child}</SafeAreaView>;

  // const child = [
  //   <Text>Hello TSX World ... 1</Text>,
  //   <Text>Hello TSX World ... 2</Text>,
  //   <Text>Hello TSX World ... 3</Text>,
  // ]

  const child = [ 1, 2, 3 ].map(i => <Text>Hello TSX World ... {i}</Text>)

  return <SafeAreaView>{ child }</SafeAreaView>

}