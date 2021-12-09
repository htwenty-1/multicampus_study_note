import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// 변수의 문자가 숫자로만 되어있는지 아니면 다른 문자인지 판별하는 프로그램을 작성하세요.
		
		
		/*
			char str = "A"
			출력 : 숫자가 아닙니다.
		*/
		
		char ch = '9';
		
		int ascc = (int)ch;
		boolean x = true;
		
		if (ascc < 48 || ascc > 57) {
			x = false;
		}
		
		if (x) {
			System.out.println("숫자임");
		} else {
			System.out.println("문자임");
		}
		
		
		
		
		// 입력된 문자열이 모두 숫자로 되어 있는지 아니면 모두 숫자로 되어 있지 않는지 판별하는 프로그램을 작성하세요.
		
		// 필요 변수 선언
		char p = 0;
		boolean q = true;
		
		// 값 입력 받기
		Scanner input = new Scanner(System.in);
		System.out.print("아무 숫자나 입력하세요~>> ");
		String str = input.next();
		
		// i를 입력받은 값의 길이만큼 1씩 증가하며 반복
		// p를 입력받은 값의 i번째 값으로 넣어주고 p가 0의 아스키코드와 9의 아스키코
		for(int i = 0; i < str.length(); i++) {
			p = str.charAt(i);
			if (p < '0' || p > '9') {
				q = false;
				break;
			}
		}
		
		if (q == true) {
			System.out.println("숫자로만 되어 있네요");
			int Number = Integer.parseInt(str);
			
		} else {
			System.out.println("문자도 껴있는 것 같은데요");
		}
		
		// 영단어를 입력받아 toUpperCase나 toLowerCase를 사용하지 않고 모두 대문자로 바꿔주는 프로그램을 작성하세요.
		
		System.out.println("영단어를 입력하세요 >> ");
	    String word = input.next();
	    String res = "";
	    
	    for(int i = 0; i < word.length(); i++) {
	    	char c1 = word.charAt(i);
	    	int n = (int)c1;
	    	
	    	if(n >= 97) {
	    		n -= 32;
	    	}
	    	
	    	res += (char)n;
	    }
	    System.out.println(res);

	}

}
