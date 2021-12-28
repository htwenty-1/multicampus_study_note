import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {
		/*
		 * 배열은 왜 나왔을까?
		 * int num1, num2, num3, num4, num5;
		 * 
		 * 프로그램의 규모에 따라서 너무 많은 변수를 선언하게 되면 관리하기가 어렵고,
		 * 이것을 더욱 효율적으로 관리하기 위해 만들어짐.
		 * 
		 * Array : 배열 == 같은 자료형 변수들의 묶음! == 변수들!!
		 * 		   배열의 목적은 변수관리! 변수들을 index_number로 구분하여 관리할 수 있다.
		 * 
		 * 형식 : 자료형 배열변수명[] = new 자료형[배열의 총 개수];
		 * 		 배열변수명[index_number]
		 * 
		 *       int arrName[] = new int[5]; -> 변수 5개를 선언했다! (new = 동적 할당 반대말은 static정적 할당)
		 *       arrName[0] = 11;
		 *       arrName[1] = 22;
		 *       arrName[2] = 33;
		 *       arrName[3] = 44;
		 *       arrName[4] = 55;
		 *       
		 * 메모리는 Stack, Heap, Static, System으로 나눠지는데,
		 * 우리가 변수를 선언하면 Stack의 특정 영역에 먼저 올라간다.
		 * 배열은 Heap에 입력된 byte만큼 올라간다. 단 배열의 변수는 Stack에 존재한다.
		 * Stack은 필요에 의해 확보가 되면 프로그램이 끝날때 까지 자리를 차지하는데, Heap은 사용을 하지 않으면 지워준다.      
		 *
		*/

//		어떻게 써도 상관없어!
		int array[] = new int[5];
//		int []array = new int[5];
//		int[] array = new int[5];
		
		System.out.println(array);	// [I@2a139a55  : heap 영역 주소
		
		System.out.println(array.length);  // 배열의 길이 : 5
		
		// 일반적인 변수에 대한 접근
		int num1 = 123;
		System.out.println(num1);
		
		// 배열에의 접근 방법
		System.out.println(array[0]);
		
		array[0] = 11;
		array[1] = 22;
		array[2] = 33;
		array[3] = 44;
		array[4] = 55;
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		
		// Array.toString()은 배열에 있는 요소의 값들을 조회해준다.
		System.out.println(Arrays.toString(array));

		
		// 선언과 초기화
		int number = 0;	// 선언과 동시에 초기화
		number = 1;		// 값의 갱신
		
		// 배열 선언과 초기화
		int Array[] = { 111, 222, 333, 444, 666 };
		System.out.println(Array[1]);
		
		char chArr[] = { 'h', 'e', 'l', 'l', 'o' };
		System.out.println(chArr.length);
		System.out.println(Arrays.toString(chArr));
		System.out.println(chArr);
		// println() 메서드는 출력할 내용을 문자열로 인식하기 때문에 문자열은 제대로 출력해준다.
		// int였을 때는 heap주소가 나왔었는데... 근데 또 String은 다르대...
		
		
		char c = 'A';
		System.out.println(c);		// c를 그대로 출력해줌
		System.out.println((int)c);	// ASCII를 출력해줌
		
		// REVIEW
		String strArr[] = { "Hello", "World", "This is Java" };
		System.out.println(strArr.length);
		System.out.println(Arrays.toString(strArr));
		System.out.println(strArr);
		System.out.println(strArr[0]);
		System.out.println(strArr[1]);
		System.out.println(strArr[2]);
		
		// int Arr[] = new int[5]; 와 같은 방법은 배열 항목의 개수를 정확히 모를 때 쓸 수가 있을 것이고
		// int Arr[] = { }; 와 같은 방법은 배열 항목의 개수를 정확히 알고 있을 때 쓰면 좋을것이
			
		System.out.println("-------------------------------------------");
		
		int myIntArr[] = new int [5];
		myIntArr[0] = 11;
		myIntArr[1] = 22;
		myIntArr[2] = 33;
		myIntArr[3] = 44;
		myIntArr[4] = 55;
		
		char myChArr[] = { 'H', 'e', 'l', 'l', 'o' };
		
		String myStrArr[] = { "Hello", "World", "This is Java" };
		
		System.out.println(myIntArr);
		System.out.println(Arrays.toString(myIntArr));
		
		System.out.println(myChArr);
		System.out.println(Arrays.toString(myChArr));
		
		System.out.println(myStrArr);
		System.out.println(Arrays.toString(myStrArr));
		
	}

}
