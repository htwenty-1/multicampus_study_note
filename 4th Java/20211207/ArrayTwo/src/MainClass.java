import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * Array : 같은 자료형의 묶음 변수들!
		 * 		   접근 및 관리는 index로 된다. index 범위는 0 ~ Array.length-1까지.
		 * 		   int Arr[] = new int[5]	index는 0 ~ 5-1까지.
		 * 
		 * 		   1차원 배열 : 데이터가 직선형으로 한 줄에 선형(행)을 이뤄 갖고 있음.
		 * 				0-0-0-0-0
		 * 		   int array[] = { 1, 2, 3, 4, 5 };
		 * 
		 * 
		 *         2차원 배열 : 데이터가 행과 열을 갖고 있음.
		 *         		0-0-0-0-0
		 *         		0-0-0-0-0
		 *         		0-0-0-0-0
		 *         int array2[][] = new int[3][4];    앞에 있는 []는 행의 숫자, 뒤에오는 []는 원소의 개수
		 *        
		 *         * 어느쪽으로 써도 상관이 없다!!
		 *         int array2[][] = new int[3][4];
		 *         int []array2[] = new int[3][4];
		 *         int [][]array2 = new int[3][4];
		 *         
		 *         int array3[][] = {
		 *         	  { 1, 2, 3, 4 },
		 *         	  { 5, 6, 7, 8 },
		 *         	  { 9, 10, 11, 12 }
		 *         }
		 * 
		 */
		
		int Array2[][] = new int[3][4];
		
		Array2[0][0] = 1;
		Array2[0][1] = 2;
		Array2[0][2] = 3;
		Array2[0][3] = 4;
		
		Array2[1][0] = 5;
		Array2[1][1] = 6;
		Array2[1][2] = 7;
		Array2[1][3] = 8;
		
		Array2[2][0] = 9;
		Array2[2][1] = 10;
		Array2[2][2] = 11;
		Array2[2][3] = 12;
		
		
		System.out.println(Arrays.toString(Array2[0]));
		
		int Arr23[][] = {
				{ 1, 2 },
				{ 3, 4 },
				{ 5, 6 }
		};
		
		System.out.println(Arr23[1][1]);
		System.out.println(Arr23[2][1]);
		
		System.out.print(Arr23[0].length);

	}

}
