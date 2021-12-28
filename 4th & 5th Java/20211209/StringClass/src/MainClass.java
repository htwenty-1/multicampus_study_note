
public class MainClass {

	public static void main(String[] args) {
		
		/*
			String : Wrapper Class
					 char[]로 이루어져 있음.
					 문자열을 편집할 수 있다.
					 정보를 취득할 수도 있다. 기타 등등...
		
		*/
		
		// String: 클래스 명칭, str: 클래스 변수 == Object(객체)
		String str;
		
		str = "안녕하세요";
		System.out.println(str);
		
		// 정석대로 생성하는 방법!!
		String str1 = new String("값");	// 가장 첫번째 값을 넣는 방법, 위의 방법과 동일한 결과를 보여준다...
		String str2 = "반가워요!";
		
		// 문자열의 결합
		String str3 = str + str2;
		System.out.println(str3);	// -> 안녕하세요반가워요!
		
		str3 += "건강하세요~~";
		System.out.println(str3);	// -> 안녕하세요반가워요!건강하세요~~
		
		// equals 함수 : 문자열을 비교하는 함수!
		String str4 = "world";
		String str5 = "world";
		
		if (str4 == str5) {
			System.out.println("같은 문자열");		// 이거는 값을 비교하는게 아니라 주소값을 비교하는거야
		};
		
		str5 = "worl";
		str5 += "d";
		
		if (str4 == str5) {
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");		// 이게 출력될걸?
		}
		
		// 제대로 값을 비교하려면 equals 함수를 써서 문자열 값 자체를 비교해라!!~~
		
		boolean b = str4.equals(str5);
		if (b == true) {
			System.out.println("같은 문자열");		// 결과는 이렇게!
		} else {
			System.out.println("다른 문자열");	
		}
		
		// indexOf 함수: 문자의 앞에서부터 위치를 반환해줌
		// lastIndexOf 함수 : 문자의 뒤에서부터 위치를 반환해줌
		String str6 = "Hello World";
		int index = str6.indexOf("l");
		int indexRev = str6.lastIndexOf("l");
		System.out.println(index);
		System.out.println(indexRev);
		
		// length
		int len = str6.length();
		System.out.println(len);
		
		// replace : 수정
		String str7 = "A*B*C*D";
		String repStr = str7.replace("*", "");
		System.out.print(repStr);
		
		
		// split : 토큰을 기준으로 문자열을 자른다
		// 예를 들어 홍길동+24+1996/10/15+서울시라면 +가 토큰이 되고 토큰을 기준으로 문자열을 자른다.
		
		String str8 = "홍길동-25-2001/05/1-서울시";
		// 애초에 자료형 자체가 
		String spStr[] = str8.split("-");
		System.out.println(spStr[0]);
		System.out.println(spStr[1]);
		System.out.println(spStr[2]);
		System.out.println(spStr[3]);
		
		for(int i = 0; i < spStr.length; i++) {
			System.out.println(spStr[i]);
		}
		
		
		// substring: 문자열을 범위로 자른다!
		String str9 = "안녕 반가워요 건강해!";
		String substr = str9.substring(3, 7);		//(시작위치, 이 위치 전까지) 3 ~ 6까지
		System.out.println(substr);
		
		
		// toUpperCase: 모두 대문자로 변경
		String str10 = "abcDEF";
		String upStr = str10.toUpperCase();
		System.out.println(upStr);
		
		// toLowerCase: 모두 소문자로 변경
		String lowStr = str10.toLowerCase();
		System.out.println(lowStr);
		
		// trim : 문자열의 앞뒤 공백을 없애줌
		String str11 = "     java   java  java             ";
		String trimStr = str11.trim();
		System.out.println(trimStr);
		
		// charAt: 인덱스에 해당하는 문자를 돌려받음
		String str12 = "가나다라마";
		char c = str12.charAt(2);
		System.out.println(c);
		
		// contains: 특정 문자를 포함하고 있는지 boolean 값으로 반환
		String str13 = "대전광역시 서구 둔산동";
		boolean b1 = str13.contains("서구");
		System.out.println(b1);
	}

}
