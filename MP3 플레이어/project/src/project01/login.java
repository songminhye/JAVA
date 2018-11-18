package project01;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class login extends Frame implements ActionListener {
	MenuBar bar;
	Menu fileMenu;
	MenuItem loginItem, joinItem, windowClose;
	Label welcom,intro,member1,member2,member3,member4;

	Panel loginP, joinP; // �α��� Panel, ȸ������ Panel

	Label loginIdLabel, loginPwdLabel; // �α��� ��(���ڵ�)
	Button loginBtn, loginCancelBtn; //�α��� ��ư ����
	TextField loginIdText, loginPwdText; // �α��ο� ����ڰ� ����� �ؽ�Ʈ ���� ����

	Label joinIdLabel, joinPwdLabel, joincheckLabel, joinAgeLabel; // ȸ������
	Button joinBtn, joinCancelBtn;
	TextField joinIdText, joinPwdText, joincheckText, joinAgeText;

	private RandomAccessFile raf; //RandomAccessFile�� �������� ���� ����
	private RandomAccessFile raf2;

	login() {
		bar = new MenuBar(); // �޴�
		fileMenu = new Menu("Menu");
		loginItem = new MenuItem("Login");
		joinItem = new MenuItem("Join");
		windowClose = new MenuItem("Close"); //�޴� �ǵ�� �г��� ����Ǵ� ���� �˸�
		
		welcom = new Label("��������� Menu���� �����ÿ�", Label.CENTER);
		welcom.setFont(new Font("",0,20));
		intro = new Label("MP3 Player", Label.CENTER);
		intro.setFont(new Font("",0,50));
		member1 = new Label("���� : �۹���", Label.CENTER);
		member2 = new Label("���� : �Ǵ���", Label.CENTER);
		member3 = new Label("���� : ��μ�", Label.CENTER);
		member4 = new Label("���� : ������", Label.CENTER);//�󺧰� ��������, �ȳ�
		
		fileMenu.add(loginItem);
		fileMenu.add(joinItem);
		fileMenu.add(windowClose);
		fileMenu.addActionListener(this); // �̺�Ʈ ó��
		
		bar.add(fileMenu);
		
		setMenuBar(bar);
		
		loginForm(); // �޼ҵ� ȣ��
		joinForm();
		
		setLayout(new GridLayout(0,1,0,10));
		add(intro);
		add(member1);
		add(member2);
		add(member3);
		add(member4);
		add(welcom);

		addWindowListener( // ����Ŭ���� â �ݱ�
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
					}
				});
	}

	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getActionCommand());
		removeAll();
		if (e.getActionCommand().equals("Login")) {
			add(loginP);
			setVisible(true);
			System.out.println(e.getActionCommand()); // ����� �Ѿ������ �׽�Ʈ��
		} else if (e.getActionCommand().equals("Join")) {
			add(joinP);
			setVisible(true);
			System.out.println(e.getActionCommand()); // ����� �Ѿ������ �׽�Ʈ��
		} else if (e.getActionCommand().equals("Close")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("OK")) {
			try {
				File f = new File("d:\\RandomTest.txt");
				raf = new RandomAccessFile(f, "rw");
				raf.seek(raf.length());
				raf.writeBytes(joinIdText.getText().toString() + " - " + joinPwdText.getText().toString() + " - "
						+ joincheckText.getText().toString() + " - " + joinAgeText.getText().toString() + " //");
				raf.close();
				
			} catch (IOException exception) {
				System.out.println("Error opening file: " + e);
			} // ȸ�����Խ� RandomTest.txt�� ȸ������������ ��
		} else if (e.getActionCommand().equals("LOGIN")) {
			try {
				String s;
				String ab;
				boolean c;

				s = loginIdText.getText().toString() + " - " + loginPwdText.getText().toString();

				File f = new File("d://RandomTest.txt");
				raf2 = new RandomAccessFile(f, "r");
				raf2.seek(0);
				ab = raf2.readLine();

				while (ab != null) {
					c = ab.contains(s);
					System.out.println(c);

					if (c == true) {
						MusicPlayer mp = new MusicPlayer();
						dispose();
						break;
						// true ���̸� frame ���� (�����÷��̾�� ��)
					} else {
						System.exit(0);// �ƴϸ� ����
					}
					raf2.close();
				}

			} catch (IOException exception) {
				System.out.println("Error opening file: " + e);
			}// �α���â������ RandomAccessFile�� �̿��� �б�, ��Ī
		}
	}

	public void loginForm() {
		loginP = new Panel();
		loginIdLabel = new Label("ID");
		loginIdLabel.setFont(new Font("",0,30));
		loginPwdLabel = new Label("PWD");
		loginPwdLabel.setFont(new Font("",0,30));
		loginIdText = new TextField(10);
		loginPwdText = new TextField(10);
		loginBtn = new Button("LOGIN");
		loginBtn.setFont(new Font("",0,25) );
		loginBtn.addActionListener(this);

		loginP.setLayout(new GridLayout(0,1,0,10));
		loginP.add(loginIdLabel);
		loginP.add(loginIdText);
		loginP.add(loginPwdLabel);
		loginP.add(loginPwdText);
		loginP.add(loginBtn);//�α��� �г� ȭ�鿡�� ��ư�� �ؽ�Ʈ, ���� ��� �����ߴ���
	}


	public void joinForm() {
		joinP = new Panel();
		joinIdLabel = new Label("ID");
		joinPwdLabel = new Label("PWD");
		joincheckLabel = new Label("PWD CHECK");
		joinAgeLabel = new Label("AGE");
		joinBtn = new Button("OK");
		joinBtn.addActionListener(this);
		joinIdText = new TextField(10);
		joinPwdText = new TextField(10);
		joincheckText = new TextField(10);
		joinAgeText = new TextField(10);

		joinP.setLayout(new GridLayout(0,1,0,10));
		joinP.add(joinIdLabel);
		joinP.add(joinIdText);
		joinP.add(joinPwdLabel);
		joinP.add(joinPwdText);
		joinP.add(joincheckLabel);
		joinP.add(joincheckText);
		joinP.add(joinAgeLabel);
		joinP.add(joinAgeText);
		joinP.add(joinBtn);// ȸ������ �г� ȭ�鿡�� ��ư�� �ؽ�Ʈ, ���� ��� �����ߴ���


	}

}