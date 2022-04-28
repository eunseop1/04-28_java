package kr.human._28_java;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//윈도우 종료를 위한 외부클래스

public class WinEx {
	
	static class WinClose extends WindowAdapter{
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosing(e);
			System.exit(0);//프로그램 강제 종료, 콘솔에서는 0은 정상 종료, -1은 비정상종료 / 윈도우에서는 숫자는 의미없다
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("내부 클래스 예제"); //윈도우 만들고
		frame.setSize(500, 500);//크기 지정
		frame.setLocationRelativeTo(null);//화면 중앙
		
		//윈도우가 닫힐때 프로그램도 종료하라는 지정
		/*
		WinClose close = new WinClose();
		frame.addWindowListener(close);
		*/
		//그러나 종료는 한번만 사용하는 일회용이니까 익명으로 사용해보자
		
		frame.addWindowListener(new WinClose());//이렇게 두줄을 합쳐서 쓴다
		
		//내부클래스로 만드는 것이 관리상 편리하다 -> 하지만, 1회성 용도
		//익명 내부 클래스로 만들어서 쓰면 더 좋을 듯?
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);//프로그램 강제 종료, 콘솔에서는 0은 정상 종료, -1은 비정상종료 / 윈도우에서는 숫자는 의미없다
			}
		});
		//여기서는 내부 클래스보다는 익명 클래스가 더 편리하다.
		
		frame.setLayout(new FlowLayout());//컴포넌트들을 옆으로 배치하라는 배치관리자 지정
		//익명객체를 사용한것
		JButton button = new JButton("눌러줘");//버튼 생성
		//버튼 클릭시 이벤트 지정
		//버튼 마다 하는 일이 다 다른데 그때마다 클래스 지정하면 할일이 많아서 익명으로 하자
		button.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(button, "왜 눌러?");
			}
		});
		
		frame.add(button);//버튼 윈도우에 붙이다
		
		frame.setVisible(true);//보여준다
	}
}
