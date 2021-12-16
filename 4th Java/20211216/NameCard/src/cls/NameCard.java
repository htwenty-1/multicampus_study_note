package cls;

public class NameCard {

    String name;
    String phone;
    String email;

    PrintNameCard pNameCard;

    public NameCard(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void setPrintNameCard(PrintNameCard p) {
        pNameCard = p;
    }

    public void print() {
        pNameCard.print(this);      // 현재 클래스의 instance 값을 넣어줌 == PrintNameCard의 print의 매개변수 nc로 이 클래스의 주소가 넘어가
    }

    PrintNamePhoneCard pNamePhoneCard;
    public void setPrintNamePhoneCard(PrintNamePhoneCard p) {
        pNamePhoneCard = p;
    }

    public void printPhone() {
        pNamePhoneCard.print(this);
    }

}
