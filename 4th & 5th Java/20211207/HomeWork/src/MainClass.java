import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// 편의점에서 물건을 구매합니다. 지불해야할 금액이 3210원일 때 10000원을 내면 거스름돈을 얼마 돌려받아야 할까요?
		// 이 때 5000원권이 p장, 1000원권이 q장, 500원 주화가 t개, 100원 주화가 x개, 50원 주화가 y개, 10원 주화가 z개를 거슬러줍니다.
		
		Scanner scan = new Scanner(System.in);
		
		int price;
		int origin;
		int exchange;
		
		System.out.print("지불해야할 금액은?(숫자만 입력) ");
		price = scan.nextInt();
		System.out.print("내가 낸 금액은?(숫자만 입력) ");
		origin = scan.nextInt();
		
		
		exchange = origin - price;
		
		// 거스름돈 별 지폐, 주화 개수
//		int exc5000 = exchange / 5000;
//		int exc1000 = (exchange - (5000 * exc5000)) / 1000;
//		int exc500 = (exchange - (5000 * exc5000) - (1000 * exc1000)) / 500;
//		int exc100 = (exchange - (5000 * exc5000) - (1000 * exc1000) - (500 * exc500)) / 100;
//		int exc50 = (exchange - (5000 * exc5000) - (1000 * exc1000) - (500 * exc500) - (100 * exc100)) / 50;
//		int exc10 = (exchange - (5000 * exc5000) - (1000 * exc1000) - (500 * exc500) - (100 * exc100) - (50 * exc50)) / 10;
		
		int exc5000 = exchange / 5000;
		int exc1000 = (exchange % 5000) / 1000;
		int exc500 = (exchange % 1000) / 500;
		int exc100 = (exchange % 500) / 100;
		int exc50 = (exchange % 100) / 50;
		int exc10 = (exchange % 50) / 10;
		
		System.out.println("거스름돈은 " + exchange + "원 입니다.");
		System.out.println("5000원권은 " + exc5000 + "장 입니다.");
		System.out.println("1000원권은 " + exc1000 + "장 입니다.");
		System.out.println("500원 주화는 " + exc500 + "개 입니다.");
		System.out.println("100원 주화는 " + exc100 + "개 입니다.");
		System.out.println("50원 주화는 " + exc50 + "개 입니다.");
		System.out.println("10원 주화는 " + exc10 + "개 입니다.");
		
		/*
		 	
		 	int myMoney = 10000;
		 	int price = 3210;
		  
		  	// 거스름돈
		  	int changeMoney = myMoney - price;
		  	
		  	// 5000원
		  	int m5000 = changeMoney / 5000;
		  	
		  	// 1000원
		  	int m1000 = (changeMoney % 5000) / 1000;
		  	
		  	// 500원
		  	int m500 = (changeMoney % 1000) / 500;
		  	
		  	// 100원
		  	int m100 = (changeMoney % 500) / 100;
		  	
		  	// 50원
		  	int m50 = (changeMoney % 100) / 50;
		  	
		  	// 10원
		  	int m10 = (changeMoney % 50) / 10;
		  
		  
		  
		*/
		

	}

}
