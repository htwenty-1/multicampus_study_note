import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/*
			학생 수만큼 점수를 입력받아 점수의 통계를 내려고 합니다.
      이 때, 총점, 평균, 그리고 최고점수를 구하고 입력 받은 점수 중에 90점 이상은 몇 명인지 출력해주는 프로그램을 작성해주세요. 그리고 90점 이상을 맞은 점수를 새로운 배열에 넣어주세요.
		*/

		// 필요한 변수 선언
		Scanner input = new Scanner(System.in);
		int count;
		int scoreArr[] = null;
		int score;
		double avg;
		int max;
		int high;
		
		// 학생 수 입력 받기
		System.out.print("학생 수를 입력해주세요 : ");
		count = input.nextInt();

		scoreArr = new int [count];	// 배열에 학생수만큼 원소를 갖겠다고 명시
		// 학생 수만큼 점수 입력 받기
		for (int i = 0; i < count; i++) {
			System.out.print((i+1) + "번 째 학생의 점수를 입력해주세요 : ");
			scoreArr[i] = input.nextInt();
		}

		// 총점 산출하기
		score = 0;
		for (int i = 0; i < scoreArr.length; i++) {
			score += scoreArr[i];
		}

		// 평균 산출하기
		// 주의사항!!! 부동소수점!!
		avg = (double)score / scoreArr.length;

		// 최고 점수 구하기(최댓값)
		max = scoreArr[0];
		for (int i = 0; i < scoreArr.length; i++) {
			if (scoreArr[i] > max) {
				max = scoreArr[i];
			}
		}

		// 90점이상 득점자 몇명인지
		high = 0;
		for (int i = 0; i < scoreArr.length; i++) {
			if (scoreArr[i] >= 90) {
				high++;
			}
		}

		// 90이상의 수를 새로운 숫자 배열에 넣기
		int highScore[] = new int[high];
		int n = 0;
		for (int i = 0; i < scoreArr.length; i++) {
			if (scoreArr[i] >= 90) {
				highScore[n] = scoreArr[i];
			}
		}

		// 모두 출력하기
		System.out.println("입력 받은 점수는 " + Arrays.toString(scoreArr) + "입니다.");
		System.out.println("입력한 점수의 총점은 " + score + "점 입니다.");
		System.out.println("입력한 점수의 평균은 " + avg + "점 입니다.");
		System.out.println("입력한 점수 중 최고점수는 " + max + "점 입니다.");
		System.out.println("90점 이상 득점자는 " + high + "명 입니다.");
		System.out.println(Arrays.toString(highScore));
	}

}
