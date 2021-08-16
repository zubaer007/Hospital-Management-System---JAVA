import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DoctorAfterLogin extends Frame implements ActionListener{
	private TextArea ta;
	private WelcomePage welcomePage;
	public DoctorAfterLogin(WelcomePage f){
		super("Logged in as Doctor ");
		welcomePage=f;
		Label l=new Label("Patients List");
		ta=new TextArea(10,30);
		Button b=new Button("Show Patients");
		Button b2=new Button("Exit");
		add(l);add(ta);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(270,400);
		setLocation(500,200);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show Patients")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select patientName,problemType from patient");
				while(rs.next()){
					String str="Name :"+rs.getString("patientName")+"\n"+"Problame :"+rs.getString("problemType");
					ta.append(str+"\n\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
			//ta.append("my text\n");
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
	}
}