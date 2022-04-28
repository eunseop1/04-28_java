package kr.human._28_java;

//롬복에도 @Equal를 사용하면 된다. 혹은 @Data로 처리해도 자동으로 오버라이딩 된다

class Some{//컴파일시 뒤에 자동으로 extends Object가 붙는다
//모든 클래스는 Object클래스에 있는 11개의 메서드를 바로 사용가능하다
	private String name;
	private int age;
	
	public Some() {
		
	}
	
	public Some(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
//웬만하면 직접 만들지 말고 자동으로 만들어서 써라
	@Override
	public String toString() {//대표적인 문자를 반환
		return "Some [name=" + name + ", age=" + age + "]";
	}
	
	//내용이 같으면 같은 객체로 판단하고 싶다? equals 메서드를 오버라이딩해야 한다
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Some other = (Some) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

public class ObjectEx {
	public static void main(String[] args) {
		Some some1 = new Some("한사람", 22);
		System.out.println(some1);
		
		Some some2 = new Some("한사람", 22);
		System.out.println(some2);
		
		System.out.println(some1==some2 ? "같은 사람" : "다른 사람"); //참조변수이기에 실제 저장된 주소를 비교해보니 다르다
		System.out.println(some1.equals(some2) ? "같은 사람" : "다른 사람");//해쉬코드로 비교해보니 같다
		System.out.println(some1.hashCode()==some2.hashCode() ? "같은 사람" : "다른 사람");
		
		//해시코드는 JVM이 객체를 구분하기 위해 붙이는 번호
		System.out.println(some1.hashCode());
		System.out.println(some2.hashCode());
	}
}
