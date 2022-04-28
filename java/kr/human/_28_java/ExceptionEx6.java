package kr.human._28_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

class SectionNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5062244158195096112L;
	public SectionNotFoundException(String message) {
		super(message);
	}
}

public class ExceptionEx6 {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("src/main/resources/aguka.txt"));
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			throw new SectionNotFoundException("글이 없다");
			//여기다가 sc.close()를 하면 오류를 확인 못한다
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SectionNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close();//위에서 사용한 자원들을 마무리 해주는 코드
		}
	}
}
