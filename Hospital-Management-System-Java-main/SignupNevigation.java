import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class SignupNevigation extends Frame implements ActionListener,WindowListener{
	private WelcomePage welcomePage;

	public SignupNevigation(WelcomePage f){
		super("Signup Nevigation ");
		welcomePage=f;
		Button b=new Button("Sign up as Doctor");
		Button b2=new Button("Sign up as Paitent");
		Button b3=new Button("Sign up as Account Clerk");
		Button b4=new Button("Back");
		add(b);add(b2);add(b3);add(b4);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		addWindowListener(this);
		setLayout(new FlowLayout());
		setSize(270,400);
		setLocation(500,200);	
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Sign up as Doctor")){
			welcomePage.doctorSignup.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Sign up as Paitent")){
			welcomePage.patientSignup.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Sign up as Account Clerk")){
			welcomePage.accountClerkSignup.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Back")){
			this.setVisible(false);
			welcomePage.setVisible(true);
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