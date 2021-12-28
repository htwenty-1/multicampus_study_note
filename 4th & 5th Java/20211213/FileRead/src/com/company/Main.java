package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        File file = new File("/Users/hwangduil/myfile/newfile.txt");

        // 파일 읽기


        try {
            FileReader fr = new FileReader(file);
        /*
            // 한글자씩 읽기
            int ch = fr.read();

            while(ch != -1) {   // 파일 끝까지 도달하지 않은 경우
                System.out.println((char)ch);
                ch = fr.read();
            }
            fr.close();         // 작업이 끝나면 반드시 close 시켜줘야함.

        } catch (FileNotFoundException e) {     // 원래 익셉션 두개 따로 잡아줘야 하는데 Exception으로 퉁쳐버리든지 아니면 메인 함수에 throws 해주기
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        // 문장으로 읽기

            BufferedReader br = new BufferedReader(new FileReader(file));

            String str;

            while((str = br.readLine()) != null) {
                System.out.println(str);
            }

            br.close();

        } catch (FileNotFoundException e) {     // 원래 익셉션 두개 따로 잡아줘야 하는데 Exception으로 퉁쳐버리든지 아니면 메인 함수에 throws 해주기
            e.printStackTrace();
        } catch (IOException e) {
         e.printStackTrace();
        }
    }
}
