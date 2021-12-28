
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello World");
		/*
		  * C언어
		  *     ** 절차지향 언어 : 순서에 따라 프로그램이 실행됨.
		  *     ** pointer : 주소 --> 속도가 빠르다는 장점이 있지만 보안에 취약하다는 단점이 있음.
		  *     ** 함수 기반 
		  * C++
		  *     ** C언어의 단점을 보완하여 class 개념 도입 
		  * Java
		  *     ** 객체지향 언어 
		  *     ** 호환성이 좋다, 보안면에서 우수 
		  *     ** 객체지향이라고 해서 절차를 안따르는건 아니야~
		  * Python, Kotlin
		  *     ** 절차지향 + 객체지향 짬뽕?? ===> 둘다 섞어서 편하게 써~~
		  * Objective C
		  *     ** iOS에서 쓰이는 거 그런데 요즘에는 Swift 
		  *     
		  * 주석문은 Compile이 되지 않는다!! 
		*/
		
        // println과 print의 차이는 ln은 개행을 시켜준다고!! println()이라고 쓰면 개행만 해준다!!
        // 마지막 커서의 위치를 확인해봐!!
		System.out.println("안녕하세요");
		System.out.print("Hello");
		System.out.println();
		System.out.print("만나서 반가워요");
		
        // printf -> f == format!
		// d = decimal, s = string
		System.out.printf("%d", 123);
		System.out.printf("%d %s", 123, "성공을 기원합니다!");
		
		// escape sequence
		// \n(개행), \t(탭), \", \', \b(백스페이스), \\
		System.out.print("나는 끝까지 노력할 것이다\n");
		System.out.print("성공할\n 때까지\n");
		
		System.out.println("홍길동\t 24 서울시");
		System.out.println("박군\t 22 부산시");
		System.out.println("선우태영\t 25 강릉시");
		
		System.out.println("\"나는 문제 없어\"");
		System.out.println("나는 '문'제없어");
		System.out.println("나는 \'문\'제없어");
		
		System.out.println("나는 문제없어\b");
		System.out.println("\\나는 문제없어\\");
	}

}
