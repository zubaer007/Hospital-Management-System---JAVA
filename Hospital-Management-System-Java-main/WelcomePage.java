import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class WelcomePage extends Frame implements ActionListener, WindowListener{
	public Login login;
	public SignupNevigation signupNevigation;
	public DoctorSignup doctorSignup;
	public PatientSignup patientSignup;
	public AccountClerkSignup accountClerkSignup;
	public PatientAfterLogin patientAfterLogin;
	public DoctorAfterLogin doctorAfterLogin;
	public AccountClerkAfterLogin accountClerkAfterLogin;
	public MedicalRecord medicalRecord;
	public Bill bill;
	public WelcomePage(){
	    super("Welcome Page");		
		login=new Login(this);
		signupNevigation=new SignupNevigation(this);
		doctorSignup=new DoctorSignup(this);
		patientSignup=new PatientSignup(this);
		accountClerkSignup=new AccountClerkSignup(this);
		patientAfterLogin = new PatientAfterLogin(this);
		doctorAfterLogin=new DoctorAfterLogin(this);
		accountClerkAfterLogin = new AccountClerkAfterLogin(this);
		medicalRecord= new MedicalRecord(this);
		bill = new Bill(this);
	
		Label w=new Label("Welcome to Hospital Management System"); 
		Button l=new Button("Login");
		Button s=new Button("Signup");
		add(l);add(s);
		l.addActionListener(this);
		s.addActionListener(this);
		addWindowListener(this);
		setLayout(new FlowLayout());
		setSize(280,400);	
        setLocation(500,200);		
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(s);
		if(s.equals("Signup")){
			signupNevigation.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Login")){
			login.setVisible(true);
			this.setVisible(false);
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