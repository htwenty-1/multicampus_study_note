package com.company;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // String data 3개 저장
        File newFile = new File("/Users/hwangduil/myfile/work.txt");

        try {
            if (newFile.createNewFile()) {
                System.out.println("파일 생성 완료");
            } else {
                System.out.println("파일 생성 실패");
            }
        } catch (Exception e) {
            System.out.println("파일을 생성할 수 없음");
        }

        try {
            FileWriter fw = new FileWriter(newFile);

            fw.write("홍길동");
            fw.write("24");
            fw.write("서울시");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // String data 3개 불러오기 --> 배열 저장

        String[] human = new String[3];
        try {
            FileReader fr = new FileReader(newFile);
            BufferedReader br = new BufferedReader(fr);

            String str = br.readLine();

            human[0] = str.substring(0, 3);
            human[1] = str.substring(3, 5);
            human[2] = str.substring(5);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 파일에 저장 -> println 한번만 사용해서 저장
        try {
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(Arrays.toString(human));
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 파일에서 불러오기 -> 배열의 [0]: 이름 -> 배열 [1]: 나이 -> 배열 [2]: 주소
        try {
            BufferedReader br = new BufferedReader(new FileReader(newFile));
            String str;

            while((str = br.readLine()) != null) {
                for (int i = 0; i < human.length; i++) {
                    human[i] = str;
                }
            }

            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(human));     // 뭐지...?

        // ----

        // 함수화
    }
}
