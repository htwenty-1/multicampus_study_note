
public class MainClass {
	public static void main(String[] args) {
		/*
		 * Operator: 연산자
		 *  
		 * * 사칙연산자 : +, -, *, /, % 
		 * * ++ : increment
		 * * -- : decrement
		*/
		
		int number1, number2;
		int result;
		
		number1 = 25;
		number2 = 3;
		
		result = number1 + number2;
		System.out.println(result);
		
		result = number1 - number2;
		System.out.println(result);
		
		result = number1 * number2;
		System.out.println(result);
		
		result = number1 / number2;		// 몫
		System.out.println(result);
		
		result = number1 % number2;		// 나머지
		System.out.println(result);
		
		// 나눗셈할 때 주의 : 분모가 0이면 Exception(예외) 즉 0으로 나눌 수 없다고 나온다...
		// 나머지를 구하는 연산도 분모에 0을 넣으면 Exception이 나오니까 하지않기
		
		
		// ++, --
		
		number1 = 0;
		
		// 자기 자신을 갱신하는 연산
		number1 = number1 + 1;
		System.out.println(number1);
		number1 += 1;
		System.out.println(number1);
		
		// increment == ++ == +1
		// decrement == -- == -1
		number1++;
		System.out.println(number1);
		number1--;
		System.out.println(number1);
		
		// increment와 decrement는 위치의 제약이 없다?
		++number1;
		System.out.println(number1);
		--number1;
		System.out.println(number1);
		
		// increment, decrement 사용시 주의사항
		int num1, num2;
		
		num1 = 0;
		num2 = 0;
		
//		num2 = num1++;
		// 연산 우선순위에 의해 num1을 num2에 대입한 후 1을 증가시킨다.
		// num2는 0이 나온다?

		num2 = ++num1;
		// num1에 +1을 해주고 num2에 저장시킨다.
		// num2는 1이 나온다?
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
	}
}
