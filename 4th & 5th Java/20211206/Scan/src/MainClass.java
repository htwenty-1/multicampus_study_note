import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainClass {
	public static void main(String[] args) throws Exception {
		
		// 입력받기 위한 것
		Scanner scan = new Scanner(System.in);
		
		/*
		int iNumber;
		
		System.out.print("정수 = ");
		iNumber = scan.nextInt();
		
		System.out.println("입력받은 수: " + iNumber);
		*/
		
		/*
		double dNumber;
		
		System.out.print("실수 = ");
		dNumber = scan.nextDouble();
		
		System.out.print("입력받은 수: " + dNumber);
		*/
		
		/*
		boolean b;
		
		System.out.print("True of False? = ");
		b = scan.nextBoolean();
		
		System.out.println("논리형: " + b);
		*/
		
		/*
		String str;
		
		System.out.print("string = ");
		str = scan.next();
		System.out.println("입력된 문자열: " + str);
		*/
		
		// 문장 입력 받을 때는 BufferedReader, 단어 입력 받을 때는 Scanner 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		System.out.print("string = ");
		str = br.readLine();
		System.out.println("입력된 문자열: " + str);
		
		
		// 입력(console) -> 저장(변수)
	}
}

