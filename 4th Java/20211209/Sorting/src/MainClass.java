import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		
		/*
			정렬! sorting!!
			
			오름차순과 내림차순 정렬
			  - 첫번째를 기준으로 나머지와 비교
			  - 첫번째가 끝나면 두번째를 기준으로 나머지와 비교
			  - 원소의 끝까지 반복
			
			선택정렬
		*/
		
		int number[] = { 7, 9, 5, 4, 1, 3 };
		
		int result[] = sortArray(number);
		
		System.out.println(Arrays.toString(result));
		
		/*
		int temp;
		
		// 마지막과 마지막은 비교할 필요가 없으니까 범위를 i < number.length-1
		for (int i = 0; i < number.length - 1; i++) {
			// 자신과 같은 위치에 있는 것은 비교할 필요가 없으니까 j=i+1
			for (int j = i + 1; j < number.length; j++) {
				if (number[i] > number[j]) {	// 교환처리, 여기 부등호 방향만 바꿔주면 내림차순~~
					temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(number));
		*/
	}
	
	public static int[] sortArray(int[] numberArr) {
		
		int temp;
		// 마지막과 마지막은 비교할 필요가 없으니까 범위를 i < number.length-1
		for (int i = 0; i < numberArr.length - 1; i++) {
			// 자신과 같은 위치에 있는 것은 비교할 필요가 없으니까 j=i+1
			for (int j = i + 1; j < numberArr.length; j++) {
				if (numberArr[i] > numberArr[j]) {	// 교환처리, 여기 부등호 방향만 바꿔주면 내림차순~~
					temp = numberArr[i];
					numberArr[i] = numberArr[j];
					numberArr[j] = temp;
				}
			}
		}
		
		return numberArr;
	}

}
