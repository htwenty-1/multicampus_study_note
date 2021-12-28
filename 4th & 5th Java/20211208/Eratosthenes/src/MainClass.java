import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		
		// 필요 변수 선언
		Scanner input = new Scanner(System.in);
		int last;
		int numArr[] = null;
		
		// 범위 수 입력받기
		System.out.print("2부터 어디까지의 소수를 구할까요? ");
		last = input.nextInt();
		
		// 1부터 입력받은 수까지 배열에 저장하기
		numArr = new int[last];
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = i+1;
		}
		
		// 2를 제외한 2의 배수 제거하기
		for(int i = 0; i < numArr.length; i++) {
			int multi2 = numArr[i] % 2;
			if (numArr[i] != 2 && multi2 == 0) {
				numArr.remove(i);
			}
		}
		
		System.out.println(Arrays.toString(numArr));

	}

}
