import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int count;	// 몇개를 정렬할지 변수 선언
		int number[] = null;
		int upDown;
		
		//user가 몇개를 정렬할지 입력받기
		System.out.print("몇 개의 숫자를 정렬하시겠습니까? >> ");
		count = sc.nextInt();
		
		// 숫자들 입력
		number = new int[count];	// 배열 확보
		for (int i = 0; i < number.length; i++) {
			System.out.print((i+1) + "번 째 수를 입력하세요! >> ");
			number[i] = sc.nextInt();
		}
		
		// 오름/내림차순 입력받기
		System.out.print("오름차순이면 1, 내림차순이면 2를 입력하세요! >> ");
		upDown = sc.nextInt();
		
		// 정렬처리
		int temp;	// 큰숫자, 작은숫자를 가리기 위해 swap지정
		for(int i = 0; i < number.length-1; i++) {
			// System.out.println("i = " + i);
			for(int j = i+1; j < number.length; j++) {
				// System.out.println("\tj = " + j);
				if(upDown == 1) {
					if (number[i] > number[j]) {	// 오름차순
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}
				} else {
					if (number[i] < number[j]) {	// 내림차순
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(number));
		
		
	}

}
