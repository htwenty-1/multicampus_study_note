package com.company;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        /*
            File이란? 저장 매(개)체 ---> Database(file 입출력)
        */

        // File file = new File("/Users/hwangduil");

        // 파일 조사
        /*
        String[] filelist = file.list();

        for (int i = 0; i < filelist.length; i++) {
            System.out.println(filelist[i]);
        }
        */


        // 폴더와 파일로 나눠서 보기
        /*
        File fileList[] = file.listFiles();

        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                System.out.println("[파일]" + fileList[i].getName());
            } else if(fileList[i].isDirectory()) {
                System.out.println("[폴더]" + fileList[i].getName());
            }
        }

        */

        // 파일 생성
        File newFile = new File("/Users/hwangduil/myfile/newfile.txt");

        try {
            if(newFile.createNewFile()) {
                System.out.println("파일 생성 성공!");
            } else {
                System.out.println("파일 생성 실패");
            }
        } catch (IOException e) {
            System.out.println("파일을 생성하지 못했습니다.");
        }


        // 폴더 생성하기
        File newDir = new File("/Users/hwangduil/myfile/newdir");
        try {
            if(newDir.mkdir()) {        // 여러개 만들때는 mkdirs()
                System.out.println("폴더 생성 성공!");
            } else {
                System.out.println("폴더 생성 실패");
            }
        } catch (Exception e) {
            System.out.println("폴더를 생성하지 못했습니다");
        }

        // 파일의 존재여부
        if(newFile.exists()) {
            System.out.println("newFile.txt가 존재합니다.");
        } else {
            System.out.println("newFile.txt가 존재하지 않습니다.");
        }

        // 읽기전용으로 만들어주기
        // newFile.setReadOnly();

        // 쓰기 가능 여부
        if(newFile.canWrite()) {
            System.out.println("쓰기 가능합니다.");
        } else {
            System.out.println("쓰기가 불가능합니다.");
        }

        // 파일 삭제
        // newFile.delete();

    }
}
