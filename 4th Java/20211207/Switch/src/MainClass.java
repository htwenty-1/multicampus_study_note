
public class MainClass {

	public static void main(String[] args) {
		/*
			Switch : if문과 비슷하다!
					 값이 명확해야함. == 범위를 지정할 수 없다.
					 실수(float)를 사용할 수 없다.
			
			형식:
				switch ( 대상이 되는 변수 ) {
				 
				  case 값1:
				      처리1;
				      break;
				  case 값2:
				  	  처리2;
				  	  break;
				  	    :
				  	    :
				  default:
				      처리n;		... 해당 값이 없을경우 처리(default 생략 가능)
				      break;
				
				}
		
		
		
		
		
		*/
		
		int number = 2;
		
		switch (number) {
			case 1:
				System.out.println("number is 1");
				break;
			case 2:
				System.out.println("number is 2");
				break;
			case 3:
				System.out.println("number is 3");
				break;
			default:
				System.out.println("number is " + number);
				break;
		}

	}

}
