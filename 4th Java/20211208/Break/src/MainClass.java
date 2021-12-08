import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		   제어자 break와 continue
		   
		   * break == loop문을 멈춘다!
		   * 단독으로 사용할 수는 없다...
		     - switch문, for문, while문, do while문과 같이 사용한다.
		     - 특히 for문과 while문에서 많이 쓰인다.
		     - switch문에서의 사용 예시
		       switch(variable) {
		         case value:
		           processing;
		           break;
		         ...
		       }
		
			  - for문에서의 사용 예시
			    for (int i = 0; i < 100; i++) {
			      if(조건) {
			        break;	// 일정 조건을 할당하고 break를 주면 loop를 멈추고 그 loop를 빠져나온다.
			      }
			    }
			    
			  - while문에서의 사용 예시
			    int w = 0;
			    while(w < 100) {
			      if (조건) {
			        break;
			      }
			      w++
			    }
		
		*/
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println("for loop " + i);
			if (i == 5) {
				break;
			}
		}
		
		int array[] = { 1, 4, -7, 3, 8 };
		
		for(int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
			if (array[i] < 0) {
				break;
			}
		}
		
		/*
		Scanner sc = new Scanner(System.in);
		int number;
			while(true) {
			  System.out.print("숫자를 입력해주세요(>0): ");
			  number = sc.nextInt();
			
			  if (number > 0) {
				  break;
			  }
			System.out.println("양수를 입력해 주세요!");
		}
		*/
		
		// 이중 for문 탈출하기
		for(int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < 8; j++) {
				System.out.println("\tj = " + j);
				
				if (i == 5 && j == 3) {
					break;
				}
			}
		}
		
		// break문 하나당 for문 하나씩만 처리해줄 수 있기 때문에 위와 같은 예제는
		// 우선 9까지 전부 나열되고 i = 5에서만 j가 3인 경우까지 나온다.
		
		// 한번에 탈출하는 방법
		// 1. loop문의 개수에 맞게 break 설정
		
		boolean b = false;
		
		for(int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < 8; j++) {
				System.out.println("\tj = " + j);
				
				if (i == 5 && j == 3) {
					b = true;
				}
				if (b == true) {
					break;
				}

			}
			if (b == true) {
				break;
			}
		}
		
		System.out.println("****************************");
		
		// 2. break를 세팅 :goto
		getOut:for(int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < 8; j++) {
				System.out.println("\tj = " + j);
				
				if (i == 5 && j == 3) {
					break getOut;
				}
			}
		}
		
		
		
	}

}
