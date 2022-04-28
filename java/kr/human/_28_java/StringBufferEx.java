package kr.human._28_java;

public class StringBufferEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer("한사람");
		StringBuffer sb2 = new StringBuffer("한사람");
		
		System.out.println(sb1 == sb2 ? "같다":"다르다");
		System.out.println(sb1.equals(sb2) ? "같다":"다르다");
		//같은지 판단 못함
		
		//String으로 바꿔서 비교해야 한다
		System.out.println(sb1.toString().equals(sb2.toString())? "같다":"다르다");
		
		System.out.println("용량: "+sb1.capacity()); //기본값 19
		sb1.append("하하하하하");
		sb1.append("하하하하하");
		sb1.append("하하하하하");
		sb1.append("하하하하하");//계속 추가시키면
		
		System.out.println("용량: "+sb1.capacity());//자동으로 용량을 늘린다
		//계속 용량이 증가되면 메모리 이동이 내부적으로 일어나서 속도의 저하를 가져올수 있다
		//어느정도의 크기가 들어갈지 예측가능하면 처음에 용량을 지정할수있다
		StringBuffer sb3 = new StringBuffer();
		StringBuffer sb4 = new StringBuffer(100);
		System.out.println("용량: "+sb3.capacity());
		System.out.println("용량: "+sb4.capacity());
		
		int i = 100;//기본자료형
		Integer ii =200;//객체형(참조형변수)
		//JDK 1.5 이전 구버전에서는 사용했었다. 1.5 이후에는 자동으로 된다
		int j = Integer.valueOf(ii);//객체형을 기본자료형으로 바꿔준다 -> UnBoxing
		Integer jj = new Integer(i);//기본자료형을 객체형으로 바꿔준다 -> Boxing
		
		int k = ii;//AutoUnBoxing
		Integer kk = i;//AutoBoxing
		
		System.out.println("-".repeat(50));
		i = Integer.valueOf("123");//리턴값이 Integer형 객체
		ii = Integer.parseInt("123");//리턴값이 int형 자료형-> 빠르다
		
		System.out.println(i);
		System.out.println(ii);
	}

}
