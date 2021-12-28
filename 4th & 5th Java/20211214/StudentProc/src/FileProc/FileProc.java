package FileProc;

import Single.Singleton;
import dao.StudentDao;
import dto.StudentDto;

import java.io.*;

public class FileProc {

    private File file;

    public FileProc(String fileName, File file) {
        file = new File("Users/users" + fileName + ".txt");
    }

    public void createFile() {
        try {
            if(file.createNewFile()) {
                System.out.printf("파일 생성에 성공함");
            } else {
                System.out.printf("파일 생성에 실패함");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        Singleton s = Singleton.getInstance();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;

            while((str = br.readLine()) != null) {
                String split[] = str.split("-");

                StudentDto dto = new StudentDto();
                dto.setNumber(Integer.parseInt(split[0]));
                dto.setName(split[1]);
                dto.setHeight(Double.parseDouble(split[2]));
                dto.setEng(Integer.parseInt(split[3]));
                dto.setMath(Integer.parseInt(split[4]));

                s.list.add(dto);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void write() {
        Singleton s = Singleton.getInstance();

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            for (int i = 0; i < s.list.size(); i++) {
                StudentDto dto = s.list.get(i);
                pw.println(dto.toString());
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
