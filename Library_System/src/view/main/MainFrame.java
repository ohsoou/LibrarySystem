package view.main;

import view.defaultcomponent.DefaultFrame;


public class MainFrame extends DefaultFrame{
	
	public MainFrame() {

		super();
		setFrame();
		
		setLayout(null);
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {

	}

	@Override
	public void setDesign() {
		add(new TopPanel());
		add(new CenterPanel());
		
	}
	/*
	 * 1. Thread 
		- 메모리를 할당받아 실행 중인 프로그램을 프로세스라고 합니다.
		- 프로세스 내의 명령어 블록으로 시작점과 종료점을 가진다.
		- 실행중에 멈출 수 있으며 동시에 수행 가능하다.
		- 어떠한 프로그램내에서 특히 프로세스 내에서 실행되는 흐름의 단위.


 		static void invokeLater(Runnable runnable)
 		이벤트 디스패칭 쓰레드에 의해 Runnalbe.run()을 실행한다. 이 메소드를 호출하면 이벤트 큐에 runnable.run()의 내용을 넣고 바로 리턴한다.
 		 Thread(Runnable r)  인터페이스 객체 
 		void run() 스레드가 실행할 부분 기술 (오버라이딩 사용)
	 */
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});

	}

	

}
