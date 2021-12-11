import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		// 2차원 배열을 1차원 배열로 변경해서 리턴하는 함수를 작성하세요.
		
		int from[][] = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }
		};
		
		int result[] = arrayFunction(from);
		
		System.out.println(Arrays.toString(result));
		
		
		

	}
	
	public static int[] arrayFunction(int array[][]) {	// 함수의 prototype
		
		// parameter로 받은 배열을 1차원 배열로 만들어주기 위해 1차원 배열의 크기를 정해줌.
		// 행의 수 * 각 행의 원소 수 == 2차원 배열이 행 안의 요소 수를 일괄적으로 맞춰준다는 전제를 깔고...
		int to[] = new int[array.length * array[0].length];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				to[array[i].length * i + j] = array[i][j];
			}
		}
		
		/* 이렇게도 작성할 수 있음!
		 int count = 0;
		  for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				to[ count ] = array[i][j];
				count++;
			}
		}
		*/
		
		return to;
	}
}

