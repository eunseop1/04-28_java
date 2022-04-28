package kr.human._28_java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Account {//은행 계좌 정보
	private String accountNo;//계좌번호
	private String ownerName;//예금주
	private int balance;//잔액
	
	//입금
	public void deposit(int amount) {
		balance += amount;
		
	}
	
	//출금
	public int withdraw(int amount) throws Exception {//이 메서드는 예외를 발생시키는 메서드이다
		//이 메서드를 사용하는 쪽에서 반드시 예외처리 하도록 강제한다
		//(예외미루기) -> 쓰는 쪽에서 try-catch예외처리하라
		if(balance < amount) {
			throw new Exception("잔액이 부족합니다"); //예외 던지기
			//throw new RuntimeException("잔액이 부족합니다"); //-> RuntimeException은 예외처리가 선택이라 throws Exception 안써도 된다
		}
		balance -= amount;
		return amount;
	}
}
