import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AccountClerkAfterLogin extends Frame implements ActionListener{
	private TextArea ta;
	private WelcomePage welcomePage;
	public AccountClerkAfterLogin(WelcomePage f){
		super("Logged in as Account Clerk");
		welcomePage=f;
		Label l=new Label("Staff and Nurse List");
		ta=new TextArea(10,30);
		Button b=new Button("Show Staff list");
		Button b2=new Button("Show Nurse list");
		Button b3=new Button("Exit");
		add(l);add(ta);
		add(b);add(b2);add(b3);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(270,400);
		setLocation(500,200);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show Staff list")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select staffName,staffSalary from staff");
				while(rs.next()){
					String str="Name :"+rs.getString("staffName")+"\n"+"Salary :"+rs.getString("staffSalary");
					ta.append(str+"\n\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
			//ta.append("my text\n");
		}
		if(s.equals("Show Nurse list")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select nurseName,nurseSalary from nurse");
				while(rs.next()){
					String str="Name :"+rs.getString("nurseName")+"\n"+"Salary :"+rs.getString("nurseSalary");
					ta.append(str+"\n\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
	}
}