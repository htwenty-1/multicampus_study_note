
public class MainClass {

	public static void main(String[] args) {
		/*
		   loop문 == 순환문 == 반복문
		   
		    for문 : 지정 횟수에 따라서 반복하는 제어문
		 
		 	형식 : 
		 		   for ( 변수의(선언)초기화; 조건식; 연산식 ) {
		 		       처리
		 		   }
		 		   for문의 소괄호에서 초기화식을 선언하지 않았다면 
		 		   바깥 스코프에서 변수를 초기화 할 수도 있다.
		 		   
		    처리순서
		    		변수의 선언(1)
		    		for((3)		; (2)(6)(9)	; (5)(8)	) {
		    			처리(4)(7)
		    		}
		    		조건이 false가 될 때 (10)
		 */
		
		
		/* 변수의 유효범위를 생각했을 때 아래와 같은 방식은 그닥 좋지 않다.
		int n;
		
		for( n = 0; n < 2; n++ ) {
			
			System.out.println("for loop " + n);
		}
		*/
		
		// 이렇게 쓰는게 일반적이야~
		for(int i = 0; i < 10; i++) {
			System.out.println("이게 반복문이야~~");
		}
		
		/*
		for (int i = 10; i > 0; i--) {
			System.out.print(i + " ");
		}
		
		for (int i = 0; i < 10; i+=2) {
			System.out.print(i + " ");
		}
		*/
		
		// 1부터 10까지 숫자를 더한 합을 구하라!
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		/// 연습 1
		// 학생 5명의 국어 성적의 합계와 평균을 구해보자
		// 90, 85, 95, 100, 85
		int scoreArr[] = new int[6];
		scoreArr[0] = 90;
		scoreArr[1] = 85;
		scoreArr[2] = 95;
		scoreArr[3] = 100;
		scoreArr[4] = 85;
		scoreArr[5] = 75;
		
		int score = 0;
		
		for (int i = 0; i < scoreArr.length; i++) {
			
			score += scoreArr[i];
			
		}
		System.out.println(score);
		
		double avg = (double)score / scoreArr.length;
		
		System.out.println(avg);
		
		// for문 + if
		
		String names[] = { "홍길동", "일지매", "성춘향", "홍두깨" };
		
		// names 중에서 성춘향이 들어있는 부분을 꺼내라!
		int number = 0;
		for (int i = 0; i < names.length; i++) {
			number++;
			if (names[i].equals("성춘향")) {
				System.out.println("찾았습니다!! " + number + "번째!");
			}
		}
		
		// 학생의 최고 점수를 출력하라.
		
		int maxScore = scoreArr[0];		// 최고 점수를 담을 변수 선언하고 배열의 인덱스 0 참조
		for (int i = 0; i < scoreArr.length; i++) {
			if(scoreArr[i] > maxScore) {
				maxScore = scoreArr[i];
			}
		}
		System.out.println(maxScore);
		
		// for each문
		
		for (int num : scoreArr) {	// [0] ~ [n] ... JS의 for( n in arr )
			System.out.print(num + " ");
		}
		
		for (String name : names) {
			System.out.println(name + " ");
		}
		
		// for문 중첩
		/*
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			
			for (int j = 0; j < 5; j++) {
				System.out.println("\tj = " + j);
			}
		}
		*/
		
		// i * j
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i + " x " + j + " = " + (i * j) + " ");				
			}
			System.out.println();
		}
		
		int array2[][] = {
				{ 11, 12, 13, 14 },
				{ 21, 22, 23, 24 },
				{ 31, 32, 33, 34 },
		};
		
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				System.out.print(array2[i][j] + " ");
			}
			System.out.println();
		}
	}

}
