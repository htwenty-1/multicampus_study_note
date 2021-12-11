import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		// 아스키 코드 값을 입력하면 문자를 확인할 수 있는 함수를 작성하라.
		// static char ascToChar(int asc)
		System.out.println("아스키 코드 값을 입력하시면 문자로 바꿔줍니다.");
		System.out.print("아스키 코드 값을 입력하세요 >> ");
		int asc = input.nextInt();

		char print = ascToChar(asc);
		System.out.println("아스키 코드 \"" + asc + "\"를 문자로 변환하면 \"" + print + "\"입니다.");
		
		
		// 두수의 나눗셈을 하는 함수를 작성하라. 하나의 함수에서 몫과 나머지를 구한다.
		System.out.println("****************************************");
		System.out.println("입력 받은 두 수의 몫과 나머지를 구해드립니다!");
		System.out.print("나누려는 수를 입력하세요 >> ");
		int x = input.nextInt();
		System.out.print("몇으로 나눌까요? >> ");
		int y = input.nextInt();
		
		// division(x, y);
		int tag[] = new int[1];
		int ret = division(x, y, tag);
		System.out.println("몫은 \"" + ret + ", \"나머지는 \"" + tag[0] + "\" 입니다.");
		
		
		// 두점 사이의 거리를 구하는 함수를 작성하라. 
		// static double distance(double x1, double y1, double x2, double y2)
		// 	root (y2 - y1)2승 + (x2 - x1)2승
		System.out.println("****************************************");
		System.out.println("두 점사이의 거리를 구해드립니다!");
		System.out.print("첫번째 x좌표를 입력하세요. >> ");
		double x1 = input.nextInt();
		System.out.print("첫번째 y좌표를 입력하세요. >> ");
		double y1 = input.nextInt();
		System.out.print("두번째 x좌표를 입력하세요. >> ");
		double x2 = input.nextInt();
		System.out.print("두번째 y좌표를 입력하세요. >> ");
		double y2 = input.nextInt();

		double result = distance(x1, x2, y1, y2);
		
		System.out.println("두 점 사이의 거리는 " + result + "입니다.");
		

		// 입력된 숫자가 정수인지 실수인지 확인할 수 있는 함수를 작성하라.
		// static boolean isDouble(String snumber)
		System.out.println("****************************************");
		System.out.println("입력한 숫자가 정수인지 실수인지 판단합니다.");
		System.out.print("숫자를 입력해주세요. >> ");
		String number = input.next();
		
		boolean b = isDouble(number);
		
		if (b == true) {
			System.out.println("입력하신 숫자는 실수형(float)입니다.");
		} else {
			System.out.println("입력하신 숫자는 정수형(integer)입니다.");
		}
		

	}

	// 아스키코드 값을 문자로 변환
	public static char ascToChar(int asc) {
		char character = (char) asc;
		return character;
	}
	
	// 몫과 나머지를 구하는 함수
	/*
	public static void division(int p, int q) {
		int quotient = p / q;
		int rest = p % q;
		System.out.println("몫은 \"" + quotient + ", \"나머지는 \"" + rest + "\" 입니다.");
	}
	*/
	
	// public static int division(int p, int q, int* tag)
	public static int division(int p, int q, int[] tag) {
		int r = p / q;
		tag[0] = p % q;
		return r;
	}
	
	// 두 점사이의 거리를 구하는 함수
	public static double distance(double x1, double x2, double y1, double y2) {
		double refX = Math.pow(x2 - x1, 2);
		double refY = Math.pow(y2 - y1, 2);
		double result = Math.sqrt(refY + refX);
		
		return result;
	}
	
	// 입력된 숫자가 정수인지 실수인지 확인하는 함수
	public static boolean isDouble(String sNumber) {
		boolean numCheck = false;
		for (int i = 0; i < sNumber.length(); i++) {
			int n = sNumber.charAt(i);
			if (n == '.') {
				numCheck = true;
				break;
				//return true;
			}
		}		
		return numCheck;
		//return false;
	}
	
}
