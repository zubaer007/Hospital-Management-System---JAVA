import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class Login extends Frame implements ActionListener,WindowListener{
	private TextField tf;
	private TextField tf2;
	private WelcomePage welcomePage;
	public Login(WelcomePage f){
		super("Login ");
		welcomePage=f;
		Label l=new Label("User Name");
		Label l2=new Label("Password");
		tf=new TextField(28);
		tf2=new TextField(28);
		tf2.setEchoChar('*');
		Button b=new Button("Login");
		Button b2=new Button("Cancel");
		Button b3=new Button("Back");
		add(l);add(tf);
		add(l2);add(tf2);
		add(b);add(b2);add(b3);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		addWindowListener(this);
		setLayout(new FlowLayout());
		setSize(280,400);
		setLocation(500,200);	
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			DataAccess da=new DataAccess();
			
			String typedName=tf.getText();
			String typedPass=tf2.getText();
			
			if(typedPass.length()==3)
			{
			String q="select doctorName,password from doctor";
			ResultSet rs=null;	
			try{
				rs=da.getData(q);
				while(rs.next()){
					String n = rs.getString("doctorName");
					String p= rs.getString("password");
					if(n.equals(typedName) && p.equals(typedPass)){
						System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						welcomePage.doctorAfterLogin.setVisible(true);
						this.setVisible(false);
						break;
					}
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"DB Error");
			}
			}
			
			else if(typedPass.length()==4)
			{
			String q="select patientName,password from patient";
			ResultSet rs=null;	
			try{
				rs=da.getData(q);
				while(rs.next()){
					String n = rs.getString("patientName");
					String p= rs.getString("password");
					if(n.equals(typedName) && p.equals(typedPass)){
						System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						welcomePage.patientAfterLogin.setVisible(true);
						this.setVisible(false);
						break;
					}
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"DB Error");
			}
			}
			
			else if(typedPass.length()==5)
			{
			String q="select clerkName,password from accountClerk";
			ResultSet rs=null;	
			try{
				rs=da.getData(q);
				while(rs.next()){
					String n = rs.getString("clerkName");
					String p= rs.getString("password");
					if(n.equals(typedName) && p.equals(typedPass)){
						System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						welcomePage.accountClerkAfterLogin.setVisible(true);
						this.setVisible(false);
						break;
					}
					/*else if(n!=typedName || p!=typedPass){
						JOptionPane.showMessageDialog(this,"Not Matched.");
					}*/
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"DB Error");
			}
			}
		}
		else if(s.equals("Cancel")){
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
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}