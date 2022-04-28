package kr.human._28_java;

public class SpeedEx {
	public static void main(String[] args) {
		String str = "";
		StringBuffer sBuffer = new StringBuffer();
		StringBuilder sBuilder = new StringBuilder();
		
		//String은 불변객체라서 변할수 없다. 연산을 하면 항상 새로운 객체를 만들어서 리턴
		long start = System.currentTimeMillis();
		for(int i = 0; i<10000; i++) {// 꽝을 1만개 만든다 => 1만개의 객체 생성
			str += "꽝";
		}
		System.out.println("실행시간: "+ (System.currentTimeMillis()-start) + "ms");
		
		//StringBuffer나 StringBuilder는 가변객체로 연산하면 자기 자신으로 변경
		//StringBuffer는 멀티 쓰레드 프로그램에 안전하게 설계
		//StringBuilder는 싱글 스레드 프로그램에만 안전하게 설계되어 나중에 발표
		start = System.currentTimeMillis();
		for(int i = 0; i<10000; i++) {// 꽝을 1만개 만든다 => 1개의 객체 생성
			sBuffer.append("꽝");
		}
		System.out.println("실행시간: "+ (System.currentTimeMillis()-start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i = 0; i<10000; i++) {// 꽝을 1만개 만든다 => 1개의 객체 생성
			sBuilder.append("꽝");
		}
		System.out.println("실행시간: "+ (System.currentTimeMillis()-start) + "ms");
	}
}
