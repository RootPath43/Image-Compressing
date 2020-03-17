import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.sun.glass.ui.CommonDialogs.FileChooserResult;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JPanel;
import javax.swing.JLabel;  
import javax.swing.JPanel;
import java.awt.Canvas;

public class Frame  {

	protected static final Component JPanel = null;

	private JFrame frmCompressAnImage;

	/**
	 * Launch the application.
	 */
	JFileChooser fileChooser = new JFileChooser();
	
	

	
	
	private JTextField textField;
	public static String path;
	public BufferedImage bufferedImg, replaced;
	private JTextField textField2;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frmCompressAnImage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		frmCompressAnImage = new JFrame();
		frmCompressAnImage.setTitle("Compress An Image");
		frmCompressAnImage.setBounds(100, 100, 450, 300);
		frmCompressAnImage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCompressAnImage.getContentPane().setLayout(null);

		JLabel labelImage = new JLabel("");
		labelImage.setBounds(170, 56, 242, 173);
		frmCompressAnImage.getContentPane().add(labelImage);
		
		JButton chooseButton = new JButton("Choose");
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				//pop up menu for file choosing
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","jpeg");
				jfc.addChoosableFileFilter(filter);
				
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedOne = jfc.getSelectedFile();
					path = selectedOne.getAbsolutePath();
					
					//chosen image is being scaled and displayed
					ImageIcon imageIcon= new ImageIcon(path);
					Image img= imageIcon.getImage();
					Image imgScale = img.getScaledInstance(labelImage.getWidth(),labelImage.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon scaledIcon= new ImageIcon(imgScale);
					labelImage.setIcon(scaledIcon);
					//
					
			}

		
			}
		});
		
		          
		chooseButton.setBounds(20, 48, 89, 23);
		frmCompressAnImage.getContentPane().add(chooseButton);
		
		JButton compressButton = new JButton("Compress");
		compressButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// creating new file
			try {
				bufferedImg=ImageIO.read(new File(path));
				File file = new File(Math.random()+".jpg");
		       //running compression
				Compression.zip(bufferedImg,file,Double.parseDouble(textField.getText()));}
			catch(Exception e){
				textField2.setText("An Error has  accured");
				}
				textField2.setText("Operation completed");
			
			}
		});
		compressButton.setBounds(10, 136, 110, 23);
		frmCompressAnImage.getContentPane().add(compressButton);
		
		textField = new JTextField();
		textField.setBounds(125, 79, 22, 20);
		frmCompressAnImage.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(path);
		
		JLabel label = new JLabel("Chosen Image");
		label.setBounds(170, 22, 118, 23);

		
		
		frmCompressAnImage.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Rate of Compression :");
		lblNewLabel.setBounds(10, 82, 110, 14);
		frmCompressAnImage.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter between 1.0-0.0");
		lblNewLabel_1.setBounds(10, 105, 134, 20);
		frmCompressAnImage.getContentPane().add(lblNewLabel_1);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		textField2.setBounds(10, 170, 134, 20);
		frmCompressAnImage.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		
	
		
	
	}
}
