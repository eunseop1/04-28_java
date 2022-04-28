package kr.human._28_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두개의 정수 입력 : ");
		
		//예외가 발생할 소지가 있는 부분을 try블록으로 감싸다
		try {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int result = x / y;

			System.out.println(x + "/" + y + " = " + result);
		} catch (ArithmeticException | InputMismatchException e) {//JDK1.7이상 지원, 여러개의 예외를 지정
			// TODO: handle exception
			System.out.println("숫자만 입력해야 합니다");
			System.out.println("예외발생 : " + e.getMessage());
			e.printStackTrace();//예외추적
			
		}catch (Exception e) {//이 catch는 모든 것을 받아주기에 마지막에 나와야 한다
			// TODO: handle exception
			System.out.println("알수없는 예외발생");//모든 예외 클래스의 조상클래스는 Exception이다. 모든 예외를 받아준다
		}finally {
			System.out.println("예외발생 유무와 상관없이 무조건 실행");
			//사용한 자원의 종료를 지정
		}
		//예외처리는 필수이다
		
		sc.close();

	}
}
