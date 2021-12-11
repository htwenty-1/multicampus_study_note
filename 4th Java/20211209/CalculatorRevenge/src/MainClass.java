import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		
		// 멀캠 강사님 따라하다가 터져버린 계산기 재작성하기
		
		/*
			로직 정리하기
			0. 필요한 변수를 선언해주자.
			1. 첫번째 수를 입력받는다.
			1-1. 이 때 숫자가 아니면 처음으로 돌아간다.
			2. 연산자를 입력 받는다. (+, -, *, /)
			2-1. 이 때 연산자가 아니라면 처음으로 돌아간다.
			3. 두번째 숫자를 입력받는다.
			3-1. 이 때 숫자가 아니라면 처음으로 돌아간다.
			4. 각 연산자에 맞는 연산결과를 임의의 변수에 저장한다.
			5. 연산 결과를 출력한다.
		*/
		
		// 필요한 변수 선언
		Scanner input = new Scanner(System.in);
		String firstNum, secondNum;		// 입력받을 숫자들
		int firstNumber, secondNumber;
		String oper;					// 연산자
		int result = 0;					// 연산 결과를 담을 변수
		
		// 첫번째 숫자 입력 받기
		firstNum = numberInput("첫번째 숫자를 입력해주세요 >>> ");
		
		/*
		while(true) {
			p = true;
			System.out.print("첫번 째 숫자를 입력해 주세요 >>> ");
			firstNum = input.next();
			// 숫자가 아니라면 다시 입력 요청하기
			//// 문자가 입력되었을 경우 : 아스키코드로 숫자와 비교
			for (int i = 0; i < firstNum.length(); i++) {
				x = firstNum.charAt(i);
				if (x < 48 || x > 57) {
					p = false;
					break;
				}
			}
			
			if(p == true) {
				break;
			}
			
			// 잘못입력하면 메시지 띄워주기
			System.out.println("숫자를 정확히 입력하세요!");
			
		}
		*/
		
		
		// 연산자 입력 받기
		oper = operatorInput();
		/*
		while(true) {
			System.out.print("연산자를 입력해 주세요(+, -, *, /) >>> ");	
			oper = input.next();
			if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				break;
			}
			
			// 잘못입력하면 메시지 띄워주기
			System.out.println("올바른 연산자를 입력하세요!");
		}
		*/
		
		// 두번째 숫자 입력 받기
		secondNum = numberInput("두번째 숫자를 입력해주세요 >>> ");
		/*
		while(true) {
			p = true;
			System.out.print("두번 째 숫자를 입력해 주세요 >>> ");
			secondNum = input.next();
			// 숫자가 아니라면 다시 입력 요청하기
			//// 문자가 입력되었을 경우 : 아스키코드로 숫자와 비교
			for (int i = 0; i < secondNum.length(); i++) {
				x = secondNum.charAt(i);
				if (x < '0' || x > '9') {
					p = false;
					break;
				}
			}
			if(p == true) {
				break;
			}
			// 잘못입력하면 메시지 띄워주기
			System.out.println("숫자를 정확히 입력하세요!");
		}
		*/
		
		// 문자로 입력 받았던 것들을 숫자로 바꿔주기~
		firstNumber = Integer.parseInt(firstNum);
		secondNumber = Integer.parseInt(secondNum);
		
		// 연산하여 변수에 저장하기
		calculator(firstNumber, secondNumber, oper);
		/*
		switch (oper) {
			case "+":
				result = firstNumber + secondNumber;
				break;
			
			case "-":
				result = firstNumber - secondNumber;
				break;
				
			case "*":
				result = firstNumber * secondNumber;
				break;
			
			case "/":
				result = firstNumber / secondNumber;
				break;
				
			default:
				System.out.println("입력이 잘못되었습니다. 처음부터 다시 시도하세요.");
				break;
		}
		*/
		
		// 연산결과 출력해주기
		// System.out.println(result);
		resultPrint(firstNum, secondNum, oper, result);
	}
	
	public static String numberInput(String msg) {
		String numStr;
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.print(msg);
			numStr = input.next();
			boolean p = numCheck(numStr);
			// 숫자가 아니라면 다시 입력 요청하기
			//// 문자가 입력되었을 경우 : 아스키코드로 숫자와 비교
			/*
			for (int i = 0; i < numStr.length(); i++) {
				x = numStr.charAt(i);
				if (x < 48 || x > 57) {
					p = false;
					break;
				}
			}
			*/
			
			
			if(p == true) {
				break;
			}
			
			// 잘못입력하면 메시지 띄워주기
			System.out.println("숫자를 정확히 입력하세요!");
			
		}
		
		
		return numStr;
	}
	
	public static boolean numCheck(String numStr) {
		boolean okay = true;
		int x;
		for (int i = 0; i < numStr.length(); i++) {
			x = numStr.charAt(i);
			if (x < 48 || x > 57) {
				okay = false;
				break;
			}
		}
		return okay;
	}
	
	public static String operatorInput() {
		Scanner input = new Scanner(System.in);
		String oper = "";
		while(true) {
			System.out.print("연산자를 입력해 주세요(+, -, *, /) >>> ");	
			oper = input.next();
			if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				break;
			}
			
			// 잘못입력하면 메시지 띄워주기
			System.out.println("올바른 연산자를 입력하세요!");
		}
		
		return oper;
	}
	
	public static int calculator(int num1, int num2, String oper) {
		
		int result = 0;
		
		switch (oper) {
			case "+":
				result = num1 + num2;
				break;
			
			case "-":
				result = num1 - num2;
				break;
				
			case "*":
				result = num1 * num2;
				break;
			
			case "/":
				result = num1 / num2;
				break;
				
			default:
				System.out.println("입력이 잘못되었습니다. 처음부터 다시 시도하세요.");
				break;
		}
		
		return result;
	}
	
	public static void resultPrint(int num1, int num2, String oper, int result) {
		System.out.println(num1 + oper + num2 + " = " + result);
	}

}
