import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		
		
		// 자 이제 그러면 입력 받은 수를 각각 변환해 주는 프로그램을 작성해보자!
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Menu >>> ");
		System.out.println("1. 10진수를 2진수로 변경");
		System.out.println("2. 10진수를 8진수로 변경");
		System.out.println("3. 10진수를 16진수로 변경");
		System.out.println("4. 2진수를 10진수로 변경");
		System.out.println("5. 8진수를 10진수로 변경");
		System.out.println("6. 16진수를 10진수로 변경");
		System.out.print("원하시는 처리번호를 입력해주세요. >> ");
		
		int work = sc.nextInt();
		
		System.out.print("변경하고자 하는 숫자를 입력하세요. >> ");
		// 2, 8, 16진수를 고려해서 String으로 받는다.
		String numStr = sc.next();
		
		switch(work) {
			case 1:
				int num10 = Integer.parseInt(numStr);
				String num2 = Integer.toBinaryString(num10);
				System.out.println("10진수 " + numStr + "의 2진수는 " + num2 + "입니다.");
				break;
			case 2:
				int num102 = Integer.parseInt(numStr);
				String num8 = Integer.toOctalString(num102);
				System.out.println("10진수 " + numStr + "의 8진수는 " + num8 + "입니다.");
				break;
			case 3:
				int num103 = Integer.parseInt(numStr);
				String num16 = Integer.toHexString(num103);
				System.out.println("10진수 " + numStr + "의 16진수는 " + num16 + "입니다.");
				break;
			case 4:
				int num104 = Integer.parseInt(numStr, 2);
				System.out.println("2진수 " + numStr + "의 10진수는 " + num104 + "입니다.");
				break;
			case 5:
				int num105 = Integer.parseInt(numStr, 8);
				System.out.println("8진수 " + numStr + "의 10진수는 " + num105 + "입니다.");
				break;
			case 6:
				int num106 = Integer.parseInt(numStr, 16);
				System.out.println("16진수 " + numStr + "의 10진수는 " + num106 + "입니다.");
				break;
		}

	}

}
