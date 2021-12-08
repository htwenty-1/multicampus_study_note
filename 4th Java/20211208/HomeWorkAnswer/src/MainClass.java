import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*
			사용자가 원하는 학생수로 정수를 입력 받습니다.
			총점, 평균, 최고점수, 90점 이상인 학생수를 구하고
			90점 이상인 점수만 모아둘 수 있는 새로운 배열을 출력하는
			프로그램을 작성해주세요.		
		*/
		
		// 필요 변수 선언하기
		int count;
		int number[] = null;		// 동적할당을 해줘야 하는 객체의 초기화 == null
		
		// 입력받기
		// 몇명인지 입력받기
		System.out.print("몇명의 통계를 내시겠습니까? = ");
		count = sc.nextInt();
		
		// 배열에 입력받은 학생 수만큼 원소 개수 할당하기
		number = new int[count];
		
		// 학생 수만큼 점수 입력받기
		for (int i = 0; i < count; i++) {
			System.out.print((i + 1) + "번째 점수 = ");
			number[i] = sc.nextInt();
		}
		
		// 총점 구하기
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum += number[i];
		}
		
		// 평균 구하기
		double avg = (double)sum / number.length;
		
		
		// 최고점수 구하기
		int max = number[0];
		for (int i = 1; i < number.length; i++) {
			if(number[i] > max) {
				max = number[i];
			}
		}
		
		// 90점 이상인 학생 수 구하기
		int high = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] >= 90) {
				high++;
			}
		}
		
		//*********** 중요 *******************
		// 90점 이상 점수만으로 새로운 배열 출력하기
		int highCount[] = new int [high];
		int n = 0;
		for(int i = 0; i < number.length; i++) {
			if (number[i] >= 90) {
				highCount[n] = number[i];
				n++;
			}
		}
		
		System.out.println(Arrays.toString(number));
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("최고점수 : " + max);
		System.out.println("90점 이상 맞은 학생 수 : " + high);
		System.out.println(Arrays.toString(highCount));
		
		
		/////////////////////////////////////////////////////////////////////
		
		/*
			다섯개의 숫자를 입력받고 음수가 입력되면 다시 입력받는 프로그램을 작성해주세요.
		
		*/
		
		int inputNum[] = new int[5];
		int w = 0;
		
		while(w < 5) {
			
			System.out.print((w+1) + "번째 숫자 = ");
			int num = sc.nextInt();
			if (num > 0) {
				// 정상입력
				inputNum[w] = num;
			} else {
				System.out.println("0 이상의 수를 입력해주세요.");
				continue;
			}
			
			w++;
		}
		
		System.out.println(Arrays.toString(inputNum));
	}

}
