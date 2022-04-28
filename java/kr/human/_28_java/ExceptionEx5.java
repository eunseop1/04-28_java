package kr.human._28_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx5 {
	public static void main(String[] args) {
		//외부자원에 접근할때는 예외처리가 필수
		/*
		//1.6까지의 전통적인 방법
		Scanner sc = null;
		try {
			sc = new Scanner(new File("src/main/resources/aguka.txt"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close();
		}
		*/
		Scanner sc = null;
		try {
			sc = new Scanner(new File("src/main/resources/aguka.txt"));
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			//여기다가 sc.close()를 하면 오류를 확인 못한다
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close();//위에서 사용한 자원들을 마무리 해주는 코드
		}
		
	}
}
