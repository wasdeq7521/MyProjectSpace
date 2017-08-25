package practice.helloworld;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HelloWorld extends JFrame {

	private JLabel jLabel;
	private JTextField jTextField;
	private JButton jButton;
	 
	public HelloWorld() {
		super();
		this.setSize(300,200);
	    this.getContentPane().setLayout(null);
	    this.add(getJLabel(), null);
	    this.add(getJTextField(), null);
	    this.add(getJButton(), null);
	    this.setTitle("HelloWorld");
	}
	
	private JLabel getJLabel() {

	      if(jLabel == null) {

	         jLabel = new javax.swing.JLabel();

	         jLabel.setBounds(34, 49, 53, 18);

	         jLabel.setText("Name:");

	      }

	      return jLabel;

	   }
	
	private JTextField getJTextField() {

	      if(jTextField == null) {

	         jTextField = new javax.swing.JTextField();

	         jTextField.setBounds(96, 49, 160, 20);

	      }

	      return jTextField;

	   }

	 

	   private JButton getJButton() {

	      if(jButton == null) {

	         jButton = new javax.swing.JButton();

	         jButton.setBounds(103, 110, 71, 27);

	         jButton.setText("OK");

	      }

	      return jButton;

	   }
	   
	   public static void main(String[] args)

	   {

	      HelloWorld w = new HelloWorld();

	      w.setVisible(true);

	   }
	
}
