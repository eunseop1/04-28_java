package kr.human._28_java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//clone 메서드는 깊은 복사를 지원해준다
//clone메서드는 protected 이므로 반드시 Cloneable 인터페이스를 구현하고 clone 메서드를 오버라이딩 해야 한다.
//Cloneabledms 표시만 해놓은 표시 인터페이스
//clone()메서드는 접근하려면 오버라이딩 필요
@AllArgsConstructor
@NoArgsConstructor
@Data
class CloneClass implements Cloneable {
	String name;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}

public class CloneEx {
	public static void main(String[] args) {
		CloneClass c1 = new CloneClass("한사람");
		CloneClass c2 = c1; // 얕은 복사 : 주소가 복사된다

		System.out.println(c1 + " : " + c2);
		c2.setName("바뀐놈");
		System.out.println(c1 + " : " + c2);// 둘다 바뀜

		// 깊은 복사: 내용이 복사
		CloneClass c3 = new CloneClass();
		c3.setName(c1.getName());
		System.out.println(c1 + " : " + c3);
		c3.setName("다른놈");
		System.out.println(c1 + " : " + c3);// 다른 객체라서 하나만 변경
		// 깊은 복사시 멤버가 많으면 노가다 -> 쉬운 방법은 없나? clone()메서드를 이용하면 된다

		System.out.println();

		try {
			CloneClass c4 = (CloneClass) c1.clone();// clone의 타입이 오브젝트이기에 (CloneClass)캐스팅을 한다 -> 그리고 try-catch
			System.out.println(c1 + " : " + c4);
			c4.setName("또 다른놈");
			System.out.println(c1 + " : " + c4);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//깊은 복사를 많이 해야 할일이 생기면 클래스를 만들어주는게 더 편리하다
		
	}
}
