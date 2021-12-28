package com.company;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String name[] = { "홍길동", "성춘향", "일지매" };

        File file = new File("/Users/hwangduil/myfile/workAnswer.txt");

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (int i = 0; i < name.length; i++) {
                pw.println(name[i]);
            }
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        String[] student = null;
        int count = 0;
        String str;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((str = br.readLine()) != null) {
                count++;
            }

            // System.out.println(count);
            student = new String[count];
            int n = 0;
            br = new BufferedReader(new FileReader(file));  // 초기화(처음부터 다시 읽기)
            while((str = br.readLine()) != null) {
                student[n] = str;
                n++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i]);
        }

        /* ******************************************************************************************* */

        String human[] = { "홍길동", "24", "서울시" };

        // 파일에 저장하고 println을 한번만 사용해서 저장
        // 파일에서 불러와서 배열에 저장

        File file1 = new File("/Users/hwangduil/myfile/member.txt");

        try {
            PrintWriter pw1 = new PrintWriter(new BufferedWriter(new FileWriter(file1)));
            String str1 = human[0] + "-" + human[1] + "-" + human[2];   // 홍길동-24-서울시 : 토큰을 넣어서 끊어줍시다

            pw1.println(str1);
            pw1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        String mem = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            String str2;
            while ((str2 = br1.readLine()) != null) {
                mem = str2;
            }
            br1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // System.out.println(mem);

        String split[] = mem.split("-");

        System.out.println(Arrays.toString(split));
    }

}
