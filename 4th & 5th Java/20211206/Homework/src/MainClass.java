import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		// 과제 1: println, print 사용
		System.out.println("========================================");
		System.out.println("| 이름   나이    전화번호          주소      |");
		System.out.println("========================================");
		System.out.println("| 홍길동  20    010-111-2222    경기도     |");
		System.out.println("| 일지매  18    02-123-4567     서울      |");
		System.out.println("========================================");
		System.out.println();
		
		/////////////////////////////////////////////////////////////
		// 과제 2: print와 escape sequence 사용
		System.out.println("========================================");
		System.out.println("\\ name   age phone         address     \\");
		System.out.println("========================================");
		System.out.println("\\ \"홍길동\" 20  010-111-2222 \'경기도\'\t\\");
		System.out.println("\\ \"일지매\" 18  02-123-4567  '서울\'  \t\\");
		System.out.println("========================================");
		System.out.println();

		/////////////////////////////////////////////////////////////
		// 과제 3: 변수를 사용
		
		// 각 행마다 1+n번으로 부여하고 공통그룹을 한줄로 묶음
		String name1;		String name2;		String name3;
		int age1;			int age2;			int age3;
		boolean gender1;	boolean gender2;	boolean gender3;
		String phone1;		String phone2;		String phone3;
		double h1;			double h2;			double h3;
		String addr1;		String addr2;		String addr3;
		
		// 변수마다 값을 선언
		name1 = "홍길동";		name2 = "일지매";		name3 = "장옥정";
		age1 = 20;			age2 = 18;			age3 = 14;
		gender1 = true;		gender2 = true;		gender3 = false;
		
		phone1 = "010-111-2222";			phone2 = "02-123-4567";
		phone3 = "02-345-7890";
		
		h1 = 175.12;		h2 = 180.01;		h3 = 155.78;
		addr1 = "경기도";		addr2 = "서울";		addr3 = "부산";
		
		System.out.println("=================================================================");
		System.out.println("\\\tname\tage\tgender\tphone\t\theight\taddress\t\\");
		System.out.println("=================================================================");
		System.out.println("\\\t" + "\"" + name1 + "\"\t" + age1 + "\t" + gender1 + "\t" + phone1 + "\t" + h1 + "\t" + "\"" + addr1 + "\"" + "\t" + "\\");
		System.out.println("\\\t" + "\"" + name2 + "\"\t" + age2 + "\t" + gender2 + "\t" + phone2 + "\t" + h2 + "\t" + "\"" + addr2 + "\"" + "\t" + "\\");
		System.out.println("\\\t" + "\"" + name3 + "\"\t" + age3 + "\t" + gender3 + "\t" + phone3 + "\t" + h3 + "\t" + "\"" + addr3 + "\"" + "\t" + "\\");
		System.out.println("=================================================================");
		System.out.println();

		/////////////////////////////////////////////////////////////
		// 과제 4: scan, print 사용
		Scanner scan = new Scanner(System.in);
		
		String name;
		System.out.print("이름은? ");
		name = scan.next();
		System.out.println("이름은" + name + "입니다!");
		
		int age;
		System.out.print("나이는? ");
		age = scan.nextInt();
		System.out.println("나이는" + age + "세 입니다!");
		
		String gender;
		System.out.print("성별은? (man 또는 woman) ");
		gender = scan.next();
		System.out.println("성별은" + gender + "입니다!");
		
		String phone;
		System.out.print("전화번호는? (하이픈 포함) ");
		phone = scan.next();
		System.out.println("전화번호는" + phone + "입니다!");
		
		double h;
		System.out.print("키는? (cm단위로, 소수점 둘째 자리까지) ");
		h = scan.nextDouble();
		System.out.println("키는" + h + "cm입니다!");
		
		String addr;
		System.out.print("사는 곳은? (시/도만 입력) ");
		addr = scan.next();
		System.out.println("사는 곳은" + addr + " 입니다!");
		System.out.println();

		/////////////////////////////////////////////////////////////
		// 과제 5: 두 개의 정수 값을 입력 받고 x, y 변수에 저장한 후에 x, y 값을
		// 출력하도록 프로그램을 작성하세요.
		
		int x, y;
		
		int temp;
		
		x = 1;
		y = 2;
		
		temp = x;
		x = y;
		y = temp;
		
		System.out.println("x = "+ x + " y= " + y);
		
	
	}
}
