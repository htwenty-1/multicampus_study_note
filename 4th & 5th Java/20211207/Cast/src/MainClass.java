
public class MainClass {
	public static void main(String[] args) {
		
		/*
		 * 자료형			용량			우선순
		 * boolean 		1byte		낮음
		 * byte			1byte		 |
		 * short		2byte		 |
		 * int			4byte		 |
		 * long			8byte		 | --- long < float 주
		 * float		4byte		 | --- 용량 때문에 long이 더 커보일 수 있지만 그렇지 않다는 거~
		 * double		8byte		높음
		 * 
		 * char			2byte
		 * String		글자의 개수에 따라 달라짐(글자당 2byte)
		 * 
		 * (자료)형 변환
		 * * 자동 (자료)형 변환 -> 작은 그릇에 있는걸 큰 그릇에 옮길 때
		 * * 강제 (자료)형 변환 -> Cast변환 : 큰 그릇에 있는 것을 작은 것으로 옮길 때
		*/
		
		// 자동 (자료)형 변환
		short sh = 12345;	// 2byte 변수
		int num;			// 4byte 변수
		
		num = sh;			// 이것이 자동 자료형 변환
		
		System.out.println(num);
		
		num = 23456;
		sh = (short)num;	// 이것이 강제 자료형 변환
		System.out.println(sh);
		
		long l = 123456789L;
		float f;
		
		f = l;
		System.out.println(f);	// 1.23456792E8
		
		double d = 1.234e3;
		/*
		 * 1.234e3에서 e3은 10^3 === 1.23 * 1000 
		*/
		System.out.println(d);
		
		d = 2.34e-2;
		/*
		 * 2.34e-2 ---> e-2 = 1/10의 제곱 == 0.01 ===> 2.34 * 0.01 == 0.0234
		*/
		
		System.out.println(d);
		
		
		// 왜 Cast가 필요한가? 소수점 계산할 때 강제 자료형 변환?
		int number1, number2;
		float fnum;
		
		number1 = 3;
		number2 = 2;
		
//		fnum = number1 / number2;		---> 1.0이 나오니까 잘못된 계산...
		
		fnum = (float)number1 / number2;
		
		System.out.println(fnum);
	}
}
