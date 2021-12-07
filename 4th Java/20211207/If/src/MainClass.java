
public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 조건 제어문
		 * * if문			: 조건의 성립
		 * 
		 * ** 형식 : if(조건) { 조건이 true / false --> 처리 }
		 * 
		 * *** 조건~~ ==(equal), >(크다), <(작다), >=(크거나 같다), <=(작거나 같다), !=(not equal)
		 * *** 다수의 조건: &&(AND), ||(OR), !(NOT)
		 * 
		 * *************************************
		 * 
		 * * if else문		: 두 가지 중 하나
		 * 
		 * ** 형식 : if(조건) { 조건이 성립되면 처리 } else { 조건이 성립되지 않는다면 처리 }
		 * ** 삼항연산자 :  (조건) ? 값1 : 값2
		 * 
		 * * if else if문	: 조건을 분기
		 * 
		 * * switch문
		 * ------------------------------------
		 * 순환문(loop) --> 반복처
		 * * for문
		 * * while문
		 * * do...while문
		 * 
		 * ------------------------------------
		 * 순환문에 따른 제어자(키워드)
		 * * 독립적으로 사용할 수 없으며 순환문과 함께 쓴다.
		 * * break
		 * * continue
		 * 
		 * 
		 */
		
		// if문 예
		int number = 5;
		if ( number > 0 ) {
			System.out.println("number는 0보다 큽니다!");
		}
		
	    if ( number == 5 ) {
	    	System.out.println("number는 5입니다!");
	    }
	    
	    if ( number >= 5 ) {
	    	System.out.println("number는 5보다 크거나 같습니다!");
	    }
	    
	    boolean b = true;
	    
	    if ( b == true ) {
	    	System.out.println("b는 true입니다!");
	    }
		
	    if ( b ) {
	    	System.out.println("b는 true입니다!");
	    }
	    
	    b = false;
	    if ( b == false ) {
	    	System.out.println("B is false");
	    }
	    
	    if ( !b ) {
	    	System.out.println("B is true");
	    }
	    
	    if (number > 0 && number <= 10) {
	    	System.out.println("number는 0보다 크고 10보다 작거나 같습니다!");
	    }
	    
	    if (number > 0 && number <=10 && b == false) {
	    	System.out.println("number는 0보다 크고 10보다 작거나 같아요! b는 false입니다~~");
	    }
	    
	    if (number > 0 || number > 10 ) {
	    	System.out.println("number는 0보다 크거나 10보다 크다!");
	    }
	    
	    // if ~ else 예시
	    
	    number = 60;
	    
	    if (number >= 70 ) {
	    	System.out.println("PASS");
	    } else {
	    	System.out.println("FAIL");
	    }
	    
	    String result = (number >= 50) ? "PASS" : "FAIL";
	    System.out.println(result);

	    int num = (number > 60) ? 10 : 5;
	    System.out.println(num);
	}

}
