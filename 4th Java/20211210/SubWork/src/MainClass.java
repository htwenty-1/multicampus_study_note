import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		// 2차원 배열을 1차원 배열로 변경해서 리턴하는 함수를 작성하세요.
		
		int from[][] = {
				{ 1, 2, 3, 4, 5, 6 },
				{ 7, 8, 9, 10, 11, 12 }
		};
		
		int result[] = arrayFunction(from);
		
		System.out.println(Arrays.toString(result));

	}
	
	public static int[] arrayFunction(int array[][]) {
		
		// parameter로 받은 배열을 1차원으로 만들어주기 위해 임의의 배열을 만듦.
		int to[] = new int[array.length * array[0].length];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				to[array[i].length * i + j] = array[i][j];
			}
		}
		
		return to;
	}
}

