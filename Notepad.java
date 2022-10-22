package notepad;

import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class Notepad extends JFrame implements ActionListener {
	
	JMenuBar menubar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenu edit=new JMenu("Edit");
	JMenu help=new JMenu("Help");
	
	JMenuItem i1=new JMenuItem("New");
	JMenuItem i2=new JMenuItem("Open File");
	JMenuItem i3=new JMenuItem("Save");
	JMenuItem i4=new JMenuItem("Save as");
	JMenuItem i5=new JMenuItem("Print");
	JMenuItem i6=new JMenuItem("Exit");
	
	
	JMenuItem i7=new JMenuItem("Select All");
	JMenuItem i8=new JMenuItem("Cut");
	JMenuItem i9=new JMenuItem("Copy");
	JMenuItem i10=new JMenuItem("Paste");
	JMenuItem i11=new JMenuItem("Delete");
	JMenuItem i12=new JMenuItem("Find");
	
	JMenuItem about=new JMenuItem("About");
	JTextArea text=new JTextArea();
	
	Notepad(){
		setTitle("NotePad app");
		setBounds(100,100,800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon=new ImageIcon("notepad.png");
		setIconImage(icon.getImage());
		
		setJMenuBar(menubar);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		
		
		file.add(i1);
		file.add(i2);
		file.add(i3);
		file.add(i4);
		file.add(i5);
		file.add(i6);
		
		edit.add(i7);
		edit.add(i8);
		edit.add(i9);
		edit.add(i10);
		edit.add(i11);
		edit.add(i12);
		
		
		help.add(about);
	JScrollPane ading =new JScrollPane(text);//it is for add text area in notepad
	ading.setBorder(BorderFactory.createEmptyBorder());
	add(ading);//adding scrollpane in notepad bcz it contains textarea
	ading.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//eleminate the horizontal scrollbar
	ading.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);// enable the vertical scrollbar
	
	Font f1=new Font(Font.SANS_SERIF,Font.PLAIN,18);//chng the font type ,size ,style
	text.setFont(f1);
	text.setLineWrap(true);//to forword text to next line
	text.setWrapStyleWord(true);//to forword text to next line
	
	
	
	
	i1.addActionListener(this);
	i2.addActionListener(this);
	i3.addActionListener(this);
	i4.addActionListener(this);
	i5.addActionListener(this);
	i6.addActionListener(this);
	i7.addActionListener(this);
	i8.addActionListener(this);
	i9.addActionListener(this);
	i10.addActionListener(this);
	i11.addActionListener(this);
	i12.addActionListener(this);
	
	about.addActionListener(this);
	
	
	
//	Short cut key's
	i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
	i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
	i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
	i4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
	i5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
	i6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
	i7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_DOWN_MASK));
	i8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
	i9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
	i10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
	i11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,KeyEvent.CTRL_DOWN_MASK));
	about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
	 
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new Notepad().setVisible(true);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equalsIgnoreCase("New")) {
			
			text.setText(null);//reset the text area
			
		}else if (e.getActionCommand().equalsIgnoreCase("Open File")) {
			
			JFileChooser filechooser=new JFileChooser();//to open new file saving window
			FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Filter (.txt)","txt");
			filechooser.setAcceptAllFileFilterUsed(false);
			filechooser.addChoosableFileFilter(textFilter);
			
			int action=filechooser.showSaveDialog(null);
			if(action!=JFileChooser.APPROVE_OPTION) {
				return;
			}
			else {
				try {
					BufferedReader reader=new BufferedReader(new FileReader(filechooser.getSelectedFile()));
					text.read(reader,null);
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
			
			
			
			
			
		}else if (e.getActionCommand().equalsIgnoreCase("Save")) {
			
			JFileChooser filechooser=new JFileChooser();//to open new file saving window
			FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Filter (.txt)","txt");
			filechooser.setAcceptAllFileFilterUsed(false);
			filechooser.addChoosableFileFilter(textFilter);
			
			int action=filechooser.showSaveDialog(null);
			if(action!=JFileChooser.APPROVE_OPTION) {
				return;
			}else {
				String fileName=filechooser.getSelectedFile().getAbsolutePath().toString();
				if(!fileName.contains(".txt")) {
					fileName+=".txt";
				}
				try {
					BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
					text.write(writer);
				}catch(IOException ex) {
					ex.printStackTrace();
				}
				
			}
			
			
			
			
		}else if (e.getActionCommand().equalsIgnoreCase("Print")) {
			
			try {
				text.print();
			} catch (PrinterException ex) {
				// TODO Auto-generated catch block
				Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE,null,ex);
			}
			
			
			
			
			
		}else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
			
			System.exit(0);
			
			
		}else if (e.getActionCommand().equalsIgnoreCase("Cut")) {
			
			
			text.cut();
			
			
			
		}else if (e.getActionCommand().equalsIgnoreCase("Copy")) {
			
			text.copy();
			
		}else if (e.getActionCommand().equalsIgnoreCase("Paste")) {
			
			text.paste();
			
		}else if (e.getActionCommand().equalsIgnoreCase("Select All")) {
			
			text.selectAll();
			
		}else if (e.getActionCommand().equalsIgnoreCase("About")) {
			
			new About().setVisible(true);
			
		}else if (e.getActionCommand().equalsIgnoreCase("Find")) {
			
		}else if (e.getActionCommand().equalsIgnoreCase("Delete")) {
			
		}
		 
		
	}

}
