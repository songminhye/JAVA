package project01;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import javazoom.jl.player.Player;

public class MusicPlayer extends JPanel implements ActionListener{
	JFrame window = new JFrame("Music Player");
	JLabel info = new JLabel("JAVA_PROJECT(권김송차)");
	JButton addButton = new JButton("Add Music");
	JButton playButton = new JButton("▶");
	JButton stopButton = new JButton("■");
	JButton pauseButton = new JButton("||");
	JButton randomButton = new JButton("∝");
	ImageIcon im = new ImageIcon("cover.jpg");
	JLabel cover = new JLabel(im); 
	// 뮤직플레이어 UI 생성 버튼들

	Thread t =null;
	

	boolean bool;
	
	JComboBox list = new JComboBox();
	JFileChooser browser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Sound", "mp3");
	// 음악을 박스에 저장하기위해 JCombobox를 사용하여 mp3파일만 저장하게 선언하였다. 
	
	int returnValue;
	String[] musics = new String[50];
	String[] title = new String[50];
	int index = 0;
	File selectedFile;
	AudioInputStream ais;
	private String audioFile;
	private Player player;
	

	
	
	MusicPlayer()
	{
		this.setBackground(Color.WHITE);
		info.setFont(new Font("",Font.ITALIC,12));
		window.add(list,BorderLayout.PAGE_START);
		window.add(info,BorderLayout.PAGE_END);
		window.add(this);
		window.setSize(500,440);
		window.setLocation(300, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		browser.setFileFilter(filter);
		
		
		pauseButton.addActionListener(this);
		randomButton.addActionListener(this);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);
		addButton.addActionListener(this);
		
        JPanel panel1;
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(1000,300));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.add(cover);
		
		add(panel1);
	
		JPanel panel;
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 100));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
	
		
		panel.add(playButton);
		panel.add(stopButton);
		panel.add(pauseButton);
		panel.add(randomButton);
		panel.add(addButton);
	
		add(panel);
	}
	
	// 전반적인 플레이어 UI 생성
	
	
	
	
	public MusicPlayer(String file){
		this.audioFile = file;
	} //파일 불러오는 매소드
	
	

	public void playAudiofile(String[] musics, int i, int lastIndex, int pos) {
		 FileInputStream fis = null;
		 BufferedInputStream bis = null;
		try {
			for(int j=i;j<lastIndex;j++){
			fis=new FileInputStream(musics[j]);
		    bis=new BufferedInputStream(fis);
		    bis.skip(pos);
		    player=new Player(bis);
		    System.out.println("노래가 시작합니다.");
		    player.play();
		    System.out.println("노래가 끝남.");
			player.close();
			}
		    
		   }catch(Exception e){
		    e.printStackTrace();
		   } finally {
			  
		   }
		  
		  
		 } // 음악을 재생하는 매소드 


	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==addButton)
		{
			returnValue = browser.showOpenDialog(window);
			
			if(returnValue == browser.APPROVE_OPTION)
			{
				selectedFile = browser.getSelectedFile();
				musics[index] = selectedFile.toString();
				int lastIndex = musics[index].lastIndexOf("\\");
				title[index] = musics[index].substring(lastIndex+1);
				list.addItem("Song - " + index+"-"+title[index]);
				
				index++;
			} //만약 addButton을 누른다면 브라우저에서 골라진 파일이 musics배열에 저장되에 JComboBox에 저장된다.
		}
		else if(ae.getSource()==playButton)
		{
			
				try{
				for(int a=0; a<100; a++){
					int temp = a;

					if(list.getSelectedIndex() == a)
				  {
						bool = true;
						t= new Thread(new Runnable() {
							@Override
							public void run() {
								
								new MusicPlayer(musics[temp]).playAudiofile(musics, temp, index,0);
							}
						});
						t.start();
				  }

				else if(list.getSelectedIndex() == a+1)
				{
					t.suspend();
					t= new Thread(new Runnable() {
						@Override
						public void run() {
							
							new MusicPlayer(musics[temp+1]).playAudiofile(musics, temp+1, index,0);
						}
					});
					t.start();

					}
					
				
					
					
				}
		
			}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
		
		} // play버튼을 누른다면 앞에 생성한 플레이 매소드를 사용해서 음악이 재생된다. (한번재생하면 연속 재생된다)
			

		else if(ae.getSource()==pauseButton)
		{
			if(bool)
				t.suspend();
			else
				t.resume();
			bool = !bool;
		} // 음악을 일시정지 시킨다.
		
		else if(ae.getSource()==randomButton)
		{
			bool = true;
			t= new Thread(new Runnable() {
				@Override
				public void run() {
					
					int p = list.getSelectedIndex();
					for(int j=p;j<index;j++){
						
						FileInputStream fis = null;
						BufferedInputStream bis = null;
						int r = (int)(Math.random()*index) ;
								try {
									fis=new FileInputStream(musics[r]);
								    bis=new BufferedInputStream(fis);
								    bis.skip(0);
								    player=new Player(bis);
								    System.out.println("노래가 시작합니다.");
								    player.play();
								    System.out.println("노래가 끝남.");
									player.close();
								   }catch(Exception e){
								    e.printStackTrace();
								   } 
						
						
						}}
			});
			t.start();
		} // 음악을 랜덤 재생시킨다.
		
		else if(ae.getSource()==stopButton)
		{
			System.out.println("정지");
			bool = false;
			t.stop();
		} // 음악을 멈춘다.
	}
}