
public class MainClass {

	public static void main(String[] args) {
		
		/*
		  continue : skip(생략)
		
		  loop문과 같이 사용한다.
		  
		  ** 기본적인 형식
		  
		  while (조건) {
		    
		    처리1;
		    
		    처리2;
		    
		    if(조건){
		      continue;
		    }
		    
		    처리3;	<--- if 조건이 true면 처리3은 수행되지 않는다.
		  
		  }
		
		
		
		*/
		
		
		for(int i = 0; i < 10; i++) {
			
			System.out.println("i = " + i);
			
			System.out.println("for Start");
			
			if (i > 3) {
				continue;
			}
			
			// i가 4부터일 때 이 처리 생략된다.
			System.out.println("for End");
		}
		
		// while에 적용해보면 어떨까??
		/*
		int w = 0;
		while (w < 10) {
			System.out.println("w = " + w);
			System.out.println("while Start");
			
			if (w > 3) {
				continue;
			}
			
			System.out.println("while end");
			
			w++;
		}
		*/
		// 연산식이 마지막에 있어 w가 계속 4에 남아서 continue가 걸리기
		// 때문에 무한루프에 빠진다!

	}

}
