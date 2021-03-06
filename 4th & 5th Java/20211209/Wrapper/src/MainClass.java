
public class MainClass {

	public static void main(String[] args) {
		
		/*
			Wrapper Class
			
			- 일반 자료형(char, int, double)을 사용하기 편리하도록 객체로 구현해 놓은 것
			- String : 문자열을 다루기에 편리하도록 객체로 구현해 놓은것!!
			  * 문자열은 "문자열 = 문자 + 문자 + 문자" 구조로 이루어지는데 이렇게 하지 않아도 됨!!
			  * 원래의 문자열은 char chArr[] = { 'h', 'e', 'l', 'l', 'o' }와 같은 형식으로 만들어지는데 너무 불편해
			  * 그래서 String이라는 편리한 도구를 만들어줬따!!
			
			- 일반 자료형과 wrapper 클래스의 명칭을 서로 비교해보자!
			  ---------------------------------------------
			  일반 자료형			|		wrapper class(Obj.)
			  ---------------------------------------------
			  ---------------------------------------------
			  boolean			|		   Boolean
			  ---------------------------------------------
			  ---------------------------------------------
			  byte				|		   Byte				... 잘 안쓰잖어..
			  ---------------------------------------------
			  short				|		   Short
			  ---------------------------------------------
			  int				|		   Integer			... 중요!!
			  ---------------------------------------------
			  long				|		   Long
			  ---------------------------------------------
			  ---------------------------------------------
			  float				|		   Float
			  ---------------------------------------------
			  double			|		   Double			... 중요!!
			  ---------------------------------------------
			  ---------------------------------------------
			  char				|		   Character
			  char[]			|		   String			... 중요!!
			  ---------------------------------------------
			  
			- class는 데이터를 담는 그릇(자료형)에 공간이 구분되어 기능들이 들어있는? 게다가 자료도 담을 수 있는? 그런 느낌??으로 생각하면 좋겠다
			  (일반 자료형에다 기능들을 장착해놓은)
			  
			  
		
		
		*/
		
		
		// Integer == int 자료형과 동일하다! 그런데 이제 기능을 곁들인...
		int i = 123;
		Integer iObj = 123;
		// 원래 모양
		Integer inObj = new Integer(123);
		
		System.out.println("i = " + i);
		System.out.println("iObj = " + iObj);
		
		
		// class란? ===> 설계, 구성, 즉 object(객체)다!!
		// 이 안에는 변수, 함수(메서드)를 추가할 수도 있다!!
		// MyClass cls = new MyClass();		--> new 생성자로 동적할당 가능!
		
		//String str = "hello";
		// 원래 모양
		//String strObj = new String("hello");
		
		

		// 숫자 -> 문자열로 변경하는 경우
		Integer objNumber = 123;
		String str = objNumber.toString();
		System.out.println(str);		// 눈에는 숫자로 보이지만 문자열로 변환되었음!!
		
		int num = 123;
		String str1 = num + "";			// 뒤에 ""만 붙였을 뿐인데...?
		System.out.println(str1);
		
		double dnum = 123.456;
		String str2 = dnum + "";
		System.out.println(str2);
		
		
		// 문자열 -> 숫자로 변경하는 경우
		String str3 = "12345";
		int n = Integer.parseInt(str3);
		System.out.println(n);
		
		String str4 = "1234.5678";
		double d = Double.parseDouble(str4);
		System.out.println(d);
		
		
		
		// 2진수, 8진수, 10진수, 16진수 변수
		// 10진수 -> 2, 8, 16진수 변환
		int num10 = 16;
		String num2 = Integer.toBinaryString(num10);	// 2진수는 String으로 밖에 표현 못해... toBinaryString을 사용해서 2진수로~
					  // Integer.toOctalString(num10);	... 8진수
					  // Integer.toHexString(num10);	... 16진수
		System.out.println(num2);
		
        // 2, 8, 16진수 -> 10진수 변환
		String number2 = "10101100";
		int number10 = Integer.parseInt(number2, 2);		// parseInt의 기능: 문자열을 숫자로 바꾸기, 변수가 몇진수인지 알려줌.
					   // Integer.parseInt(num8, 8);		// 8진수는 8로
					   // Integer.parseInt(num16, 16);		// 16진수는 16으로!
		System.out.println(number10);
		
		////////////////////////////////////
		// 연습
		
		// 10진수를 8진수로
		int a = 150;
		String b = Integer.toOctalString(a);
		System.out.println(b);
		
		// 8진수를 10진수로
		int c = Integer.parseInt(b, 8);
		System.out.println(c);
		
		// 10진수를 2진수로
		String e = Integer.toBinaryString(a);
		System.out.println(e);
		
		// 2진수를 10진수로
		int f = Integer.parseInt(e, 2);
		System.out.println(f);
		
		// 10진수를 16진수로
		String g = Integer.toHexString(a);
		System.out.println(g);
		
		// 16진수를 10진수로
		int h = Integer.parseInt(g, 16);
		System.out.println(h);
		
	}

}
