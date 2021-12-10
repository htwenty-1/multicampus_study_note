import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		    Function : 함수
		    - 독립적이다. 소속이 없다.
			- 함수의 목적: 중복된 작업을 요구하는 코드를 뭉탱이로 묶어뒀다가 필요할 때만 호출해서 쓴다 --> 간소화!
			- 함수에 들어가는 값(parameter, 매개변수)의 양은 정해져있지 않지만 나오는 값(return value)은 0 또는 1개이다.
			
			Method : class에 소속되어 있는 함수.
			
			형식
			* 돌아오는 값이 있는 함수
			  돌아오는 값의 자료형  함수명(들어가는 값의 자료형, 들어가는 값의 자료형, ...) {
			         
			         처리;
			         
			         return 돌려줄 값;
			  }
			 
			 * 돌아오는 값이 없는 함수
			   void
		*/
		
		int i = functionName('A');	// 'A' == argument
		System.out.println(i);
		
		
		String st = "abcDEF";
		String upSt = toUpperCase(st);
		System.out.println(upSt);
		
		functionNames();
		
		functionNames2(6.2, 0);
		
		functionName2();
		
		String str = "hello";
		System.out.println(str.length());
		
		char c = str.charAt(1);
		System.out.println(c);
		
		
		// 배열 복사
		int array[] = { 11, 22, 33 };
		int arrAlias[] = array;		// 배열의 주소가 복사됨
		
		System.out.println(array);
		System.out.println(arrAlias);	// 배열 주소 참조
		
		arrAlias[1] = 27;
		System.out.println(arrAlias[1]);
		System.out.println(array[1]);	// 같은 원소를 참조한다.
		
		// 배열을 parameter로 넘기는 방법
		int arrayNum[] = { 1, 2, 3, 4, 5 };
		functionName3(arrayNum[0],arrayNum[1], arrayNum[2], arrayNum[3], arrayNum[4]);
		System.out.println(Arrays.toString(arrayNum));
		
		functionName4(arrayNum);
		System.out.println(Arrays.toString(arrayNum));
		
		
		int arr[] = functionName5(arrayNum);
		System.out.println(Arrays.toString(arr));
		
	}
	
	// public static void main도 결국 함수이기 때문에 함수 안에 함수를 선언해주진 않으므로 바깥 스코프에 만들어줌.
	// 함수 이름도 변수명 만드는 규칙과 동일하게 적용한다.
	public static int functionName(char c) {
		System.out.println("functionName(char c) 호출");
		
		return 1;
	}
	
	
	
	public static String toUpperCase(String str) {
		String s = "";
		for(int i = 0; i < str.length(); i++) {
			int n = str.charAt(i);
			if (n >= 97) {
				n -= 32;
			}
			
			s += (char)n;
		}
		
		return s;
	}
	
	
	
	public static void functionNames() {
		System.out.println("functionNames를 호출함.");
	}
	
	
	
	public static void functionNames2(double d, int n) {
		double result;
		if (n == 0) {
			System.out.println("0으로는 계산할 수 없습니다.");
			return;
		}	// void형이라서 return을 못쓰는건 아니지만 필요없다면 굳이 쓰지 않아도 됨.
			// 만약 return을 걸어주면 아래 값들은 실행이 안되게 된다~~
		result = d / n;
		System.out.println("결과값은? " + result);
	}
	
	
	public static int functionName2() {
		System.out.println("functionName2() 호출");
		return 3;
	}
	
	
	
	// 배열을 건들어주는 함수
	// value 값을 할당
	public static void functionName3(int a1, int a2, int a3, int a4, int a5) {
		a1 *= 2;
		a2 *= 2;
		a3 *= 2;
		a4 *= 2;
		a5 *= 2;
	}
	
	// 배열의 주소를 할당: void
	public static void functionName4(int array[]) {
		for(int i = 0; i < array.length; i++) {
			array[i] *= 2;
		}
	}
	
	
	// 배열은 어차피 주소를 할당해서 값을 조회, 변경하는 것이기 때문에 굳이 return을 받으려고 할 필요가 없을수도 있다~~
	public static int[] functionName5(int array[]) {
		for(int i = 0; i < array.length; i++) {
			array[i] *= 2;
		}
		return array;
	}
 
}
