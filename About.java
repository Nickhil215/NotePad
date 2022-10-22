package notepad;
import java.awt.Font;

import javax.swing.*;
public class About extends JFrame{

	
	About(){
		
		setTitle("Notepad-ABOUT");
		setBounds(550,200,450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		ImageIcon icon=new ImageIcon("about.png");
		setIconImage(icon.getImage());
		ImageIcon pic=new ImageIcon("notepad (2).png");
		JLabel iconLebel=new JLabel(pic);
		iconLebel.setBounds(100,50,80,80);
		add(iconLebel);
		
		JLabel topic=new JLabel("<html>welcome to my Notepad apk <br> im nikhil i created this </html>");
		topic.setBounds(100,50,350,300);
		Font font=new Font(Font.SANS_SERIF,Font.ITALIC,12);
		topic.setFont(font);
		add(topic);
		
 }
	public static void main (String []args) {
		new About().setVisible(true);
	}
}
