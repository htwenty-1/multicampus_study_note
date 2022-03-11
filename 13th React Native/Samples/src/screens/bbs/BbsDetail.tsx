import React from "react";
import { SafeAreaView, StyleSheet, ScrollView, Text } from "react-native";
import { Avatar, Card, Headline, Paragraph } from "react-native-paper";

function BbsDetail(props:any) {
    
    let userName = props.bbs.userId.substring(0, 2);

    return (
        <SafeAreaView>
            <ScrollView 
                contentContainerStyle={styles.contentContainer}
            >
                <Headline>글 내용</Headline>
                <Card style={styles.card}>
                    <Card.Title 
                        title={props.bbs.title} 
                        subtitle={`작성자: ${props.bbs.userId}`}
                        left={props => 
                            <Avatar.Text{...props} 
                                label={userName}
                            /> 
                        } 
                    />
                    <Card.Content>
                        <Paragraph style={styles.content}>
                            {props.bbs.content}
                        </Paragraph>

                        <Text style={{textAlign: "right"}}>
                            조회수: {props.bbs.readCount}
                        </Text>

                        <Text style={{textAlign: "right"}}>
                            작성일: {props.bbs.wdate}
                        </Text>
                    </Card.Content>
                </Card>
            </ScrollView>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    contentContainer: {
        padding: 16,
    },
    card: {
        marginTop: 20,
    },
    content: {
        fontSize: 20
    }
})

export default BbsDetail;