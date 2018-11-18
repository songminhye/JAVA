package project01;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class login extends Frame implements ActionListener {
	MenuBar bar;
	Menu fileMenu;
	MenuItem loginItem, joinItem, windowClose;
	Label welcom,intro,member1,member2,member3,member4;

	Panel loginP, joinP; // 로그인 Panel, 회원가입 Panel

	Label loginIdLabel, loginPwdLabel; // 로그인 라벨(글자들)
	Button loginBtn, loginCancelBtn; //로그인 버튼 선언
	TextField loginIdText, loginPwdText; // 로그인에 사용자가 써넣을 텍스트 공간 선언

	Label joinIdLabel, joinPwdLabel, joincheckLabel, joinAgeLabel; // 회원가입
	Button joinBtn, joinCancelBtn;
	TextField joinIdText, joinPwdText, joincheckText, joinAgeText;

	private RandomAccessFile raf; //RandomAccessFile을 쓰기위한 변수 선언
	private RandomAccessFile raf2;

	login() {
		bar = new MenuBar(); // 메뉴
		fileMenu = new Menu("Menu");
		loginItem = new MenuItem("Login");
		joinItem = new MenuItem("Join");
		windowClose = new MenuItem("Close"); //메뉴 탭들과 패널이 연결되는 것을 알림
		
		welcom = new Label("좌측상단의 Menu탭을 누르시오", Label.CENTER);
		welcom.setFont(new Font("",0,20));
		intro = new Label("MP3 Player", Label.CENTER);
		intro.setFont(new Font("",0,50));
		member1 = new Label("조장 : 송민혜", Label.CENTER);
		member2 = new Label("조원 : 권덕규", Label.CENTER);
		member3 = new Label("조원 : 김민석", Label.CENTER);
		member4 = new Label("조원 : 차명진", Label.CENTER);//라벨과 조원정리, 안내
		
		fileMenu.add(loginItem);
		fileMenu.add(joinItem);
		fileMenu.add(windowClose);
		fileMenu.addActionListener(this); // 이벤트 처리
		
		bar.add(fileMenu);
		
		setMenuBar(bar);
		
		loginForm(); // 메소드 호출
		joinForm();
		
		setLayout(new GridLayout(0,1,0,10));
		add(intro);
		add(member1);
		add(member2);
		add(member3);
		add(member4);
		add(welcom);

		addWindowListener( // 무명클래스 창 닫기
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
			System.out.println(e.getActionCommand()); // 어떤값이 넘어오는지 테스트용
		} else if (e.getActionCommand().equals("Join")) {
			add(joinP);
			setVisible(true);
			System.out.println(e.getActionCommand()); // 어떤값이 넘어오는지 테스트용
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
			} // 회원가입시 RandomTest.txt에 회원가입정보를 씀
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
						// true 값이면 frame 생성 (뮤직플레이어로 들어감)
					} else {
						System.exit(0);// 아니면 꺼짐
					}
					raf2.close();
				}

			} catch (IOException exception) {
				System.out.println("Error opening file: " + e);
			}// 로그인창에서의 RandomAccessFile을 이용한 읽기, 매칭
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
		loginP.add(loginBtn);//로그인 패널 화면에서 버튼과 텍스트, 라벨을 어떻게 구현했는지
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
		joinP.add(joinBtn);// 회원가입 패널 화면에서 버튼과 텍스트, 라벨을 어떻게 구현했는지


	}

}