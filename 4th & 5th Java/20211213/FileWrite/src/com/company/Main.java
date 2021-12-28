package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        File file = new File("/Users/hwangduil/myfile/myfile.txt");

        try {

            // normal한 쓰기
            /*
            FileWriter fw = new FileWriter(file);
            fw.write("안녕하세여");
            fw.write("hi hello~");
            fw.close();         // write는 빼먹지말고 close 꼭!!
            */

            // 추가 쓰기
            /*
            FileWriter fw = new FileWriter(file, true);
            fw.write("반갑습니다.");
            fw.close();
            */

            // 개행이 이루어지는 문장 쓰기
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("안녕하세요");
            pw.println("Nice to meet you");
            pw.println("건강하세요");

            pw.close();     // 이거만 지워도 됨
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
