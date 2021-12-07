
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
		 * *************************************
		 * 
		 * * if else if문	: 조건을 분기
		 * 
		 * ** 형식 : if (조건 1) { 처리 1 } else if (조건 2) { 처리 2 } else if (조건 3) { 처리 3 } else { 처리 4 }
		 * 
		 * *************************************
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
	    
	    // if else if 예시
	    number = 95;
	    /*
	    if (number == 100) {
	    	System.out.println("A+ 입니다!");
	    } else if (number >= 90) {
	    	System.out.println("A 입니다!");
	    } else if (number >= 80) {
	    	System.out.println("B 입니다!");
	    } else if (number >= 70) {
	    	System.out.println(" C입니다!");
	    } else {
	    	System.out.println("재시험입니다!");
	    }
	    */
	    
	    // 조건문 안에 조건문 쓰기(조건문 중첩)
	       /*
	        * if(조건1) {
	        * 	if(조건2) {
	        *     처리1
	        *   } else {
	        *     처리2
	        *   }
	        * } 
	       */
	   
	    if (number >= 90) {
	    	if (number >= 95) {
	    		System.out.println("A+입니다!");
	    	} else {
	    		System.out.println("A입니다!");
	    	}
	    }
	    
	    String str1 = "안녕하세요";
	    String str2 = "안녕";
	    
	    str2 += "하세요";
	    
	    System.out.println(str2);
	    
	    if (str1 == str2) {
	    	System.out.println("같은 문자열 입니다.");
	    } else {
	    	System.out.println("다른 문자열 입니다.");
	    }
	    
	    // equals : 비교함수
	    // st1의 문자열과 str2의 문자열이 같은가 문자열 각 글자를 비교해줌!
	    if (str1.equals(str2)) {
	    	System.out.println("equals 같은 문자열!");
	    } else {
	    	System.out.println("equals 다른 문자열!");
	    }
	}

}
