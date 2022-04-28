package kr.human._28_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx7 {
	public static void main(String[] args) {
		// JDK 1.7부터는 자동 닫기 기능 지원
		try (Scanner sc = new Scanner(new URL("https://www.naver.com/").openStream());) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
