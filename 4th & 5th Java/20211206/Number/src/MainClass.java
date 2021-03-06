
public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *	숫자(상수) : 지정한 숫자, 변할 수 없다!!
		 *  2진수 : 0, 1
		 *  8진수 : 0, 1, ..., 7, 8						ex) 9(10) == 011(8)
		 *  10진수 : 0 ~ 9
		 *  16진수 : 0, 1 , 2, ... 9, A, B, C, ..., F		ex) 15(10) == 0xF(hex)
		 *  
		 *  변수(공간개념) : 그릇으로 본다. 크기가 다양해~~ == variable
		 *  1. 변수를 선언해준다. 이 때 변수명을 작명해줘야해!!
		 *  2. 자료형을 지정해준다!
		 *  
		 *  자료형이란?
		 *  ** 문자, 숫자, 문자열, 논리값
		 *  
		 *  기본형태
		 *  ** 자료형_지정 변수명; ---> 변수의 선언 
		 *  ** 변수명 = 값;	---> 변수의 값의 대입 
		*/
		
		// 정수형 자료 선언하기 == integer
		int number;
		number = 123;
		
		int num;
		num = number;
		
		System.out.println(num);
		
		// 변수명 짓는 규칙
		/*
		 * 아래 두 변수는 다르다. 대소문자를 구분한다!
		 * * int a;
		 * * int A;
		 * 
		 * 예약어는 변수명으로 사용할 수 없다!
		 * * 프로그램에서 기존에 설정해 놓은 단어
		 *
		 * 앞에 숫자가 나오는 것은 변수명으로 쓸 수 없다!
		 * 숫자 자체도 쓸 수 없다..
		 * 
		 * 연산자를 변수명으로 사용할 수 없다! 변수명앞에 언더바를 붙이는 것도 방법이지만 최근들어 잘 사용하지 않는다!
		 * 
		 * 흔한 명칭은 사용을 피하는 것이 좋다.
		*/
		
		
		// 변수의 자료형 종류
		//
		/*
		 * 숫자 자료
		 * * 정수형
		 * ** byte형
		 * *** byte by;  ---> 1byte == 8bit == 0000 0000 =(꽉 채워진 형태)=> 1111 1111 => 0 ~ 255 표현 가능
		 * 				 ---> 				   그러나, 맨 앞에 있는 0은 부호비트야! 0이면 양수, 1이면 음수
		 *               --->				   -128 ~ 127까지 표현할 수 있다!!
		 */
		byte by;
		by = 127;
		
		/*
		 * ** short형
		 * *** short sh; ---> 2byte = 16bit 
		*/
		short sh;
		sh = 12345;
		
		/*
		 * ** int형 4byte = 32bit
		*/
		int i; 
		i = 232321334;
		
		/*
		 * ** long형: 8byte = 64bit
		 * ** Long을 쓰려면 뒤에 L을 붙여줘야해~
		*/
		long l;
		l = 4325655645324432L;
		
		/*
		 * * 실수
		 * ** float형, double
		 * *** float: 4byte 자료형, double: 8byte 자료
		 * *** float형을 쓸 때 뒤에 F를 붙여줘야
		*/
		float f;
		f = 123.45678F;
		
		double d;
		d = 12.3456789;
		
		// 숫자형 자료는 int와 double형을 주로 쓴다~
		
		/* 문자(열) 자료
		 * 단독 문자 : char ---> 2byte
		 * 문자열 : String ----> 근데 이건 자료형이 아니여, 사실은 wrapper class라는거여
		 *
		*/
		char c;
		c = 'A';
		c = 'b';
		c = '+';
		c = '한';
		
		String str;
		str = "Hello World!";
		
		System.out.println(str);
		
		/*
		 * 논리형 자료
		 * * true(1) / false(0)
		 * 
		*/
		boolean b;
		b = false;
		System.out.println(b);
		
	}
}
