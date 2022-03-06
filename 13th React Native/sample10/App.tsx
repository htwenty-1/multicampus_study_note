import React, { useState } from "react";
import { Button, Text, View } from "react-native";
/* 
class App extends React.Component {

  constructor(props: any){
    super(props)

    this.state = {
      count: 0
    }    
  }
  render() {
      return (
        <View>
          <Text>You clicked { this.state.count } times</Text>  

          <Button title="Click me"
                      onPress={ ( ) => this.setState({ count: this.state.count + 1  }) } />
        </View>
      )
  }
}
export default App
 */


// function App () {
const App = () => {

  const [count, setCount] = useState( 0 )   // hook
  //       get     set                        초기값
  
  return (
    <View>
        <Text>You clicked { count } times</Text>  

        <Button title="Click me"
                    onPress={ ( ) => setCount(count + 1) } />
    </View>
  )
}

export default App
