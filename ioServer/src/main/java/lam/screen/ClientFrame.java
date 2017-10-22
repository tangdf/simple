package lam.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import org.springframework.stereotype.Component;
@Component
public class ClientFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@Resource
	private ServerConfig config;
	*/
	@Resource
	private SimpleClientCore simpleClientCore;
	@Resource
	private ServerCore serverCore;
	
	private Random random ;
	
	private JTextField jTextField0;
	private JButton jButton0;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JTextArea jTextArea0;
	private JLabel jLabel0;
	@PostConstruct
	public void init(){
		
		
		this.random = new Random();
		
		
		
		this.setTitle("server designed by SamPan");
	//this.setLocation(config.getLocationX(), config.getLocationY());
	//this.setSize(config.getWidth(), config.getHeight());
		this.setSize(800,500);
		this.setLayout(new FlowLayout());
		
		jLabel0= new JLabel("Lets talk!");
		jLabel0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jLabel0.setForeground(
						new Color(random.nextInt(200), 50, 100));
			}
		});
		jButton0 =new JButton("start server");
		jButton0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
				try {
					serverCore.manyToOneListenLoop();
					serverCore.OneToManyResponceLoop();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				jButton0.setEnabled(false);
				jButton1.setEnabled(true);
				
		}
		});
		
		
		jButton1 = new JButton("stop server");
		jButton1.setEnabled(false);
		jButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					serverCore.shutdownServer();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jButton1.setEnabled(false);
				jButton0.setEnabled(true);
				
			}
		});
		
		jButton2 =new JButton("send");
		jButton2.setEnabled(false);
		jButton2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				simpleClientCore.makeRequest(jTextField0.getText().trim());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jTextField0.setText("");
			

		}
		});
		
		jButton3 =new JButton("client connect to server");
		jButton3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

				try {
					simpleClientCore.connectToServer();
					simpleClientCore.analysisResponce();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jButton2.setEnabled(true);
		}
		});
		jButton4 =new JButton("client disconnect to server");
		jButton4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jButton2.setEnabled(false);
			try {
				simpleClientCore.disconnectToServer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}
		});
		
		jTextField0 = new JTextField(10);
		jTextArea0 = new JTextArea(8, 12);		
		
		this.add(jLabel0);
		this.add(jButton0);
		this.add(jButton1);
		this.add(jButton3);
		this.add(jButton4);
		this.add(jTextArea0);
		this.add(jTextField0);
		this.add(jButton2);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	public JTextField getjTextField0() {
		return jTextField0;
	}
	
	
	public JButton getjButton0() {
		return jButton0;
	}
	
	
	public JButton getjButton1() {
		return jButton1;
	}
	
	
	public JButton getjButton2() {
		return jButton2;
	}
	
	public JButton getjButton3() {
		return jButton3;
	}
	public JTextArea getjTextArea0() {
		return jTextArea0;
	}
	
	
	public JLabel getjLabel0() {
		return jLabel0;
	}
	
	
}
