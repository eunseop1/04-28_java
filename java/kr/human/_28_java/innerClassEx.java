package kr.human._28_java;
/*
 * 내부 클래스 : 클래스 안의 클래스를 만든다 -> 책으로는 9장
 * 				묶어 놓는 것이 관리가 더 효과적일때 사용, 외부클래스의 변수에 접근하기 위해서
 * 인스턴스 내부 클래스
 * 정적 내부 클래스 : static이 붙은 내부 클래스
 * 로컬 내부 클래스 : 메서드 안에 만든 클래스 . 메서드 안에서만 사용
 */

class Outer {
	private int outer = 11;// 내부 클래스로 하면 getter과 setter가 필요없기에 편리해진다
	static int sOuter = 22;
	// 인스턴스 내부 클래스

	class InstanceInner {
		int ii = 33;

		public void show() {
			System.out.println(outer);
			System.out.println(sOuter);
			System.out.println(ii);
		}
		/*
		 * public static void staticShow() {//static에서는 static만 사용가능하다.
		 * //System.out.println(outer);//static이 아니기에 사용 불가능 System.out.println(sOuter);
		 * //System.out.println(ii);//인스턴스이기에 사용 불가능 }//사용불가능
		 */
	}

	// 정적 내부 클래스
	static class StaticInner {
		int si = 44;
		static int ssi = 55;
		int x = 10;

		public void show() {
			class LocalClass {// 로컬 클래스: 메서드 안에서 사용, 다만 실제로는 거의 안쓴다
				public void show() {
					System.out.println(x); // 1.7이전에는 final인 지역변수만 접근 가능했다
				}
			}

			LocalClass localClass = new LocalClass();
		}

		public static void staticShow() {
			// System.out.println(outer);//인스턴스 변수라서 Outer클래스를 만들어야 사용 가능

			System.out.println(sOuter);// static 클래스안에서는 static멤버만 사용 가능
			System.out.println(si);
			System.out.println(ssi);
		}
	}
}

public class innerClassEx {
	interface Show {
		void showMessage(String message);
	}

	public static void main(String[] args) {
		Outer outer = new Outer();
		System.out.println(outer.sOuter);
		System.out.println(Outer.sOuter);

		// 인스턴스 내부 클래스의 객체 생성
		Outer.InstanceInner ii = outer.new InstanceInner();
		ii.show();

		// 정적 내부 클래스의 객체 생성
		Outer.StaticInner si = new Outer.StaticInner();
		si.show();// 인스턴스 메서드의 호출
		Outer.StaticInner.staticShow();// 정적 메서드의 호출
		// 보통 윈도우나 안드로이드에서 사용하지 업무에서는 유지보수의 편의를 위해서 이런식으로 안한다.

		// 인터페이스는 껍데기라 구현이 안되어 있는데 만약 new를 붙이고 엔터를 치면?
		new Show() {// 익명 내부 클래스 : 다른 곳에서는 사용하지 않고 이곳에서만 한번만 일회성으로 쓸때

			@Override
			public void showMessage(String message) {
				// TODO Auto-generated method stub
				System.out.println("[" + message + "]");
			}
		}.showMessage("익명 내부클래스의 호출");
		// 이름도 없는 객체로 호출 -> 인터페이스를 구현함과 동시에 객체를 생성해서 케서드까지 호출
		// 한번 실행하고 버릴 때 쓴다
		new Show() {

			@Override
			public void showMessage(String message) {
				// TODO Auto-generated method stub
				System.out.println("[" + message + "]");
			}
		}.showMessage("익명 내부클래스의 호출");

	}
}
