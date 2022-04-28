package kr.human._28_java;

public class StringEx {
	public static void main(String[] args) {
		String[] emails = "kimc@daum.net,leec@gmail.com,parkc@naver.com".split(",");
		//아이디만 뽑고 싶다
		//문자열.substring(n, m) n부터 m 전까지를 잘라서 가져온다
		//문자열.substring(n) n부터 끝까지 잘라서 가져온다
		
		//도메인만 뽑기
		for(String email : emails) {
			System.out.println(email.substring(email.indexOf("@")+1));
		}
		//아이디만 뽑기
		for(String email : emails) {
			System.out.println(email.substring(0, email.indexOf("@")));
		}
		
		System.out.println(emails[0].indexOf('@'));//처음으로 나온 위치. 인덱스는 문자도 되고 문자열도 가능하다
		System.out.println(emails[0].lastIndexOf('@'));//마지막으로 나온 위치
		
		String str = "우리나라좋은나라";
		System.out.println(str.replace("나라", "민족"));//변수에 대입하지 않는한 원본에 영향이 없고 연산을 할때 새로 만들어서 한것이다
		System.out.println(str);
		
		str = "하\t호\t히";
		System.out.println(str);
		str = str.replace("\t", "            ");
		System.out.println(str);
		str = str.replaceAll(" ", "");
		System.out.println(str);
		
		str = "하\t호\n히\r\n흐";
		System.out.println(str);
		str = str.replaceAll("\\s", "");// \\s는 빈칸, 탭등의 정규표현식 자체를 의미한다
		System.out.println(str);
		
		//개수세기
		str = "aabbccaassddff";
		int count = str.split("aa").length;//찾는 문자열을 기준으로 잘라서 배열을 만듬
		if(!str.endsWith("aa"))//찾는 문자열로 끝나지 않으면 배열 길이 -1이 개수가 된다
			count--;
		System.out.println(count+"번");
		
		str = "aabbccaassddffaa";
		count = str.split("aa").length;
		if(!str.endsWith("aa"))
			count--;
		System.out.println(count+"번");
		
		str = String.join("-->", emails);
		System.out.println(str);
		str = String.join("-->", "한놈", "두식이", "석삼", "너구리", "오징어");
		System.out.println(str);
	}
}
