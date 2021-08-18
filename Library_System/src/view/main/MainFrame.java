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
		- �޸𸮸� �Ҵ�޾� ���� ���� ���α׷��� ���μ������ �մϴ�.
		- ���μ��� ���� ��ɾ� ������� �������� �������� ������.
		- �����߿� ���� �� ������ ���ÿ� ���� �����ϴ�.
		- ��� ���α׷������� Ư�� ���μ��� ������ ����Ǵ� �帧�� ����.


 		static void invokeLater(Runnable runnable)
 		�̺�Ʈ ����Ī �����忡 ���� Runnalbe.run()�� �����Ѵ�. �� �޼ҵ带 ȣ���ϸ� �̺�Ʈ ť�� runnable.run()�� ������ �ְ� �ٷ� �����Ѵ�.
 		 Thread(Runnable r)  �������̽� ��ü 
 		void run() �����尡 ������ �κ� ��� (�������̵� ���)
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
