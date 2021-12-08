import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		
		// 계산기를 만들어보자!
		
		// 값을 입력받기 위해 필요한 모듈
		Scanner scan = new Scanner(System.in);
	
		// 1번째 숫자 입력받기
		System.out.print("첫번째 숫자를 입력하세요 : ");
		int firstNum = scan.nextInt();
		
		// 연산자 입력 받기
		System.out.print("연산자를 입력해주세요 : ");
		String operator = scan.next();
		
		// 두번째 숫자 입력 받기
		System.out.print("두번째 숫자를 입력하세요 : ");
		int secondNum = scan.nextInt();
		
		
		// 입력받은 연산자에 따라 결과값 다르게 지정하기
		int answer = 0;
		
		switch (operator) {
			case "+":
				answer = firstNum + secondNum;
				break;
			case "-":
				answer = firstNum - secondNum;
				break;
			case "*":
				answer = firstNum * secondNum;
				break;
			case "/":
				answer = firstNum / secondNum;
				break;
			default:
				System.out.println("잘못된 연산자를 입력하였습니다!");
				break;
		}
		
		/* 처리는 switch문이 더 빠름
		if(operator.equals("+")) {
			answer = firstNum + secondNum;
		} else if (operator.equals("-")) {
			answer = firstNum - secondNum;
		} else if (operator.equals("*")) {
			answer = firstNum * secondNum;
		} else if (operator.equals("/")) {
			answer = firstNum / secondNum;
		}
		*/
		
		// 연산결과 출력하기
		System.out.println(firstNum + " " + operator + " " + secondNum + " = " + answer);		
	}
}