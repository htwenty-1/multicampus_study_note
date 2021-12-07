import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// 편의점에서 물건을 구매합니다. 지불해야할 금액이 3210원일 때 10000원을 내면 거스름돈을 얼마 돌려받아야 할까요?
		// 이 때 5000원권이 p장, 1000원권이 q장, 500원 주화가 t개, 100원 주화가 x개, 50원 주화가 y개, 10원 주화가 z개를 거슬러줍니다.
		
		Scanner scan = new Scanner(System.in);
		
		int price;
		int origin;
		int exchange;
		
		System.out.println("지불해야할 금액은? ");
		price = scan.nextInt();
		System.out.println("내가 낸 금액은? ");
		origin = scan.nextInt();
		
		
		exchange = origin - price;
		
		System.out.println("거스름돈은 " + exchange + "원 입니다.");
		
		
		// 거스름돈 별 지폐, 주화 개수
		int exc5000, exc1000, exc500, exc100, exc50, exc10;
		exc5000 = exchange / 5000;
		exc1000 = (exchange - (5000 * exc5000)) / 1000;
		exc500 = (exchange - (5000 * exc5000) - (1000 * exc1000)) / 500;
		exc100 = (exchange - (5000 * exc5000) - (1000 * exc1000) - (500 * exc500)) / 100;
		exc50 = (exchange - (5000 * exc5000) - (1000 * exc1000) - (500 * exc500) - (100 * exc100)) / 50;
		exc10 = (exchange - (5000 * exc5000) - (1000 * exc1000) - (500 * exc500) - (100 * exc100) - (50 * exc50)) / 10;
		
		System.out.println("거스름돈 중 5000원권은 " + exc5000 + "장이고, 1000원권은 " + exc1000 + "장이고, 500원 주화는" + exc500 + "개이고, 100원 주화는" + exc100 + "개이고, 50원과 10원 주화는 각각" + exc50 + "개, " + exc10 + "개 입니다.");
		

	}

}
