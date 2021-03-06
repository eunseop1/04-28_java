package kr.human.java0428;

public class StringEx {
	public static void main(String[] args) {
		String[] emails = "kimc@daum.net,leec@gmail.com,parkc@naver.com".split(",");
		// 문자열.substring(n, m) : n부터 m전까지를 잘라서 가져온다.
		// 문자열.substring(n) : n부터 끝까지 잘라서 가져온다.
		// 도메인만 뽑아내고 싶다.
		for (String email : emails) {
			System.out.println(email.substring(email.indexOf("@") + 1));
		}
		// 아이디만 뽑아내고 싶다.
		for (String email : emails) {
			System.out.println(email.substring(0, email.indexOf("@")));
		}

		System.out.println("하하하하호호하하하".indexOf('호'));
		System.out.println("하하하하호호하하하".lastIndexOf('호'));

		String str = "우리나라좋은나라";
		System.out.println(str.replace("나라", "민족"));
		str = "하\t호\t히";
		System.out.println(str);
		str = str.replace("\t", "              ");
		System.out.println(str);
		str = str.replaceAll(" ", "");
		System.out.println(str);
		str = "하\t호\n히\r\n흐";
		System.out.println(str);

		str = str.replaceAll("\\s", "");
		System.out.println(str);

		str = "aabbccaassddff";
		int count = str.split("aa").length;
		if (!str.endsWith("aa"))
			count--;
		System.out.println(count + "번");

		str = "aabbccaassddffaa";
		count = str.split("aa").length;
		if (!str.endsWith("aa"))
			count--;
		System.out.println(count + "번");

	}
}
