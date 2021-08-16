import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class PatientSignup extends Frame implements ActionListener,WindowListener{
	private TextField tf;
	private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	private TextField tf5;
	private TextField tf6;
	private TextField tf7;
	private TextField tf8;
	private WelcomePage welcomePage;
	public PatientSignup(WelcomePage f){
		super("Patient Register");
		welcomePage=f;
		Label l=new Label("User Name");
		Label l2=new Label("Password (Must be 4 charecter)");
		Label l3=new Label("Confirm Password");
		Label l4=new Label("phone Number");
		Label l5=new Label("Address");
		Label l6=new Label("Gender");
		Label l7=new Label("Age");
		Label l8=new Label("Problem");
		TextField tf=new TextField(28);
		TextField tf2=new TextField(28);
		TextField tf3=new TextField(28);
		TextField tf4=new TextField(28);
		TextField tf5=new TextField(28);
		TextField tf6=new TextField(28);
		TextField tf7=new TextField(28);
		TextField tf8=new TextField(28);
		Button b=new Button("Register");
		Button b2=new Button("Cancle");
		Button b3=new Button("Back");
		add(l);add(tf);
		add(l2);add(tf2);
		add(l3);add(tf3);
		add(l4);add(tf4);
		add(l5);add(tf5);
		add(l6);add(tf6);
		add(l7);add(tf7);
		add(l8);add(tf8);
		add(b);add(b2);add(b3);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		addWindowListener(this);
		setLayout(new FlowLayout());
		setSize(270,600);
		setLocation(500,200);	
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		System.out.println(s);
		if(s.equals("Register")){
			if(tf.getText().length()==0 || tf2.getText().length()==0){
				JOptionPane.showMessageDialog(this,"You Must Type");
			}
			else if( tf2.getText().length()!=4)
			{
				JOptionPane.showMessageDialog(this,"password must be 4 charecter");
			}
			else{
				String q="insert into patient values(null,'"+tf.getText()+"','"+tf2.getText()+"','"+tf5.getText()+"','"+tf4.getText()+"','"+tf7.getText()+"','"+tf6.getText()+"','"+tf8.getText()+"')";
				DataAccess da=new DataAccess();
				da.updateDB(q);
				welcomePage.setVisible(true);
				this.setVisible(false);
			}
		}
		else if(s.equals("Cancle")){
			this.setVisible(false);
		}
		else if(s.equals("Back")){
			this.setVisible(false);
			welcomePage.signupNevigation.setVisible(true);
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e)
    {
		//this.setVisible(false);
		System.exit(0);
		System.out.println("Window closing");
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}