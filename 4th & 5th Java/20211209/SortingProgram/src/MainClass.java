import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		// 정렬 프로그램 작성하기
		/*
			1. 사용자에게 몇개의 숫자를 정렬할 것인지 입력 받기
			2. 정렬할 숫자 입력 받기
			3. 오름차순/내림차순 여부 입력 받기
			4. 정렬 처리하기
			5. 결과 출력하기
		*/
		
		// 필요한 변수를 선언
		int sortCount;
		int wantSort;
		int p;
		int sortArr[] = null;
		int upDown[] = new int[1];
		
		
		
		
		// 사용자에게 몇개 숫자를 정렬할 것인지 입력 받기
		input(upDown);
		/*
		System.out.print("몇개의 숫자를 정렬하시겠어요? >>> ");
		sortCount = input.nextInt();
		
		// 정렬할 숫자 입력받기
		int sortArr[] = new int[sortCount];
		for (int i = 0; i < sortCount; i++) {
			System.out.print("정렬할 숫자를 입력해주세요! >> ");
			sortArr[i] = input.nextInt();
		}
		
		// 오름차순/내림차순 여부 입력 받기
		System.out.print("오름차순으로 하시려면 1, 내림차순으로 하시려면 2를 입력하세요. >> ");
		wantSort = input.nextInt();
		*/
		
		// 오름차순/내림차순 여부 입력받아 정렬해주기
		sorting(sortArr, wantSort);
		/*
		switch(wantSort) {
			case 1:
				
				break;
				
			case 2:
				for (int i = 0; i < sortArr.length-1; i++) {
					for (int j = i+1; j < sortArr.length; j++) {
						if(sortArr[i] < sortArr[j]) {
							
						}
					}
				}
				break;
			default:
				System.out.println("처음부터 다시 시도하세요.");
		}
		*/
		
		// 정렬 결과 출력하기
		result();
		//System.out.print(Arrays.toString(sortArr));
		
	}
	
	public static int[] input(int[] upDown) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇개의 숫자를 정렬하시겠어요? >>> ");
		int sortCount = sc.nextInt();
		
		// 정렬할 숫자 입력받기
		int sortArr[] = new int[sortCount];
		for (int i = 0; i < sortCount; i++) {
			System.out.print("정렬할 숫자를 입력해주세요! >> ");
			sortArr[i] = sc.nextInt();
		}
		
		// 오름차순/내림차순 여부 입력 받기
		System.out.print("오름차순으로 하시려면 1, 내림차순으로 하시려면 2를 입력하세요. >> ");
		upDown[0] = sc.nextInt();
		
		return upDown;
	}
	
	public static void sorting(int sortArr[], int upDown) {
		int p;
		for (int i = 0; i < sortArr.length-1; i++) {
			for (int j = i+1; j < sortArr.length; j++) {
				if(sortArr[i] > sortArr[j]) {
					p = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = p;
				}
			}
		}
	}
	
	public static void swap(int sortArr[], int i, int j) {
		int p = sortArr[i];
		sortArr[i] = sortArr[j];
		sortArr[j] = p;
	}
	
	public static void result(int sortArr[], int upDown) {
		String msg = "";
		if (upDown == 1) msg = "오름차순으로 정렬됨.";
		else 			 msg = "내림차순으로 정렬됨.";
		
		System.out.println(msg + " " + Arrays.toString(sortArr));
	}

}
