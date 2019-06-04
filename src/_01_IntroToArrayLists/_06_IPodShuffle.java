package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	 ArrayList<Song> songs = new ArrayList<Song>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				
 Song demo= new Song("demo.mp3");		
 Song teraghata = new Song("https://www.youtube.com/watch?v=mEMHF5W4zlY");
 Song thousandyears = new Song("https://www.youtube.com/watch?v=rtOvBOTyX00");
 Song nainadakyakasoor= new Song("https://www.youtube.com/watch?v=_Tvork-z5uc&start_radio=1&list=RD_Tvork-z5uc");
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

 
  songs.add(demo);
  songs.add(teraghata);
  songs.add(thousandyears);
  songs.add(nainadakyakasoor);
  
  JFrame f = new JFrame();
  f.setVisible(true);
  JButton b = new JButton("Surprise Me!");
  f.add(b);
  b.addActionListener(this);
  f.pack();
  
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int r = new Random().nextInt(4);
for(int i=0; i <4;i++){
	songs.get(r).play();
}
		
	}
}