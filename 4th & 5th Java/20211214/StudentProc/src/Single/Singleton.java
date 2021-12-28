package Single;

import dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

public class Singleton {

    private static Singleton single = null;

    public List<StudentDto> list = null;

    private Singleton() { list = new ArrayList<StudentDto>(); }

    public static Singleton getInstance() {
        if(single == null) {
            single = new Singleton();
        }
        return single;
    }

}
