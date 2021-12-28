
public class MainClass {

	public static void main(String[] args) {
		/*
		 
		 loop
		 
		 ** for는 어땠나?
		    for(초기화; 조건식; 연산식){
		      처리
		    }
		    
		 ** while loop의 형식?
		    변수 초기화;
		    while(조건식) {
		      처리;
		      연산식;
		    }
		 
		 ** 주의사항
		    - 연산식이 내부에 있기 때문에 연산식을 정상적으로 처리해주지 않으면
		      무한루프에 빠질 확률이 있기 때문에 조심하자!!
		 
		 ** do while loop의 형식?
		 	변수 초기화;
		    do {
		      처리;
		      연산식;
		    } while(조건식)
		    
		   while loop: 조건이 맞지 않으면 한번도 처리 하지 않는다.
		   do while loop: 조건이 맞지 않아도 한번 처리한 후 그 다음으로
		                  조건을 비교하여 연산을 처리한다.
		 
		 */
		
		int w;
		
		w = 0;
		
		while(w < 10) {
			System.out.println("while loop " + w);
			w++;
		}
		
		
		// 위의 예제를 for문으로 구현해보기
		int i;
		
		i = 0;
		
		for ( ; i < 10; ) {
			System.out.println("for loop" + i);
			i++;
		}
		
		/* 이렇게 하면 무한루프 돈다 이말이야~
		int count = 0;
		while( true ) {
			System.out.println(count);
		}
		*/
		
		/*
		   교양
		   
		   프로그램의 작동 원리
		   
		   1. 초기화 - initialize : 처음 시작할 때
		   2. 반복 - loop(무한) : 안쓰고 있으면 멈춰있는 것 같은데;; 사용자가 입력을 다시 할 때까지 커서가 깜빡이네?
		   3. 해방(메모리) - release : 프로그램을 끄면 사용하던 메모리가 삭제됨!!  
		*/
		
		// do while
		int dw;
		dw = 0;
		
		do {
			System.out.println("do while loop: " + dw);
			dw++;
		} while(dw < 10);
		// dw를 110으로 바꿔도 한번은 무조건 실행
		
		System.out.println("*************************");
		
		// while을 중첩하여 구구단 구현하기
		int p, q;
		p = q = 1;
		
		while (p < 10) {
			
			// q에 대한  while loop를 빠져나왔을 때 한 번 더 초기
			q = 1;
			while (q < 10) {
				System.out.print( p + " x " + q + " = " + (p*q) + " " );
				q++;
			}
			System.out.println();
			p++;
		}

	}

}
