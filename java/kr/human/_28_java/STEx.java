package kr.human._28_java;

import java.util.StringTokenizer;

public class STEx {
	public static void main(String[] args) {
		String str = "한놈,두식이,석삼,너구리,오징어";
		StringTokenizer st = new StringTokenizer(str);
		System.out.println(st.countTokens() + "개");
		
		StringTokenizer st2 = new StringTokenizer(str, ",");//구분자를 기준으로 토큰으로 나눈다
		System.out.println(st2.countTokens() + "개");
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		str = "한놈,두식이,석삼,,,너구리,,오징어";
		
		System.out.println(new StringTokenizer(str,",").countTokens() + "개");//연속된 구분자 무시
		System.out.println(str.split(",").length + "개");//구분자는 무조건 센다
		
		str = "사과=100,배=900,딸기=1000,감=300";
		//위의 문자열을 사과(100원) 형식으로 변경하여 출력하시오
		StringTokenizer st3 = new StringTokenizer(str, "=,",true);
		while(st3.hasMoreTokens()) {
			String temp = st3.nextToken();
			if(temp.equals(",")) System.out.println("원)"); //-> , 일때 원) 출력하고 줄바꿈
			else if(temp.equals("=")) System.out.print("("); // =이면 ( 출력
			else System.out.print(temp); // 값은 그냥 출력
		}
		System.out.println("원)"); // 마지막에는 ,이 없어서 마무리를 위해 적음
	}
}