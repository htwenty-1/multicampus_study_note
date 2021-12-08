import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/*
			사용자가 원하는 학생 수로 점수를 입력받는다.
			총점, 평균, 그리고 최고점수를 구한다.
			입력받은 점수 층에서 90점 이상의 학생 수는 몇명인가?
			그리고 그 점수들만을 새로운 배열에 저장하는 프로그램을 작성하시오.
		*/
		

		// 필요 변수 선언하기
		Scanner input = new Scanner(System.in);
		int students, studentsArr[], count;
		int sum, avg, max;
		int over90[];
		
		int faviNum, faviNumArr[];
		
		// 학생 수 입력 받기
		System.out.print("학생 수를 입력하세요 : ");
		students = input.nextInt();
		
		// 학생 수만큼 점수 입력 받아 배열에 넣어주기
		
		studentsArr = new int[students];
		
		for (int i = 0; i < studentsArr.length; i++) {
			System.out.print((i+1) + "번째 학생의 점수 : ");
			studentsArr[i] = input.nextInt();
		}
		
		// 총점, 평균, 최고점수 구하여 출력하기
		sum = 0;
		avg = 0;
		max = studentsArr[0];
		for (int j = 0; j < studentsArr.length; j++) {
			sum += studentsArr[j];
			avg = sum / studentsArr.length;
			if (studentsArr[j] > max) {
				max = studentsArr[j];
			}
			
		}
		System.out.println("입력한 점수의 총점은 " + sum + "점 입니다.");
		System.out.println("입력한 점수의 평균은 " + avg + "점 입니다.");
		System.out.println("입력한 점수 중 최대값은 " + max + "점 입니다.");
		
		// 90점 이상인 학생 수 출력하기
		count = 0;
		for (int k = 0; k < studentsArr.length; k++) {
			if (studentsArr[k] >= 90) {
				count++;
			}
		}
		System.out.println("90점 이상인 학생 수는 " + count + "명입니다.");
		
		//////////////////////////////////////
		
		/*
		   5개의 숫자를 입력받는 프로그램을 작성하시오.
		   단, 음수가 입력되면 다시 입력받게 한다.
		 */
		
		
		
		for (int s = 0; s < 5; s++) {
			faviNumArr = new int[s];
			System.out.print((s+1) + "번째 숫자를 입력해주세요: ");
			faviNumArr[s] = input.nextInt();
			System.out.println("당신이 입력하고 저정한 숫자는 " + faviNumArr[i] + "입니다!");
		}
	}

}
