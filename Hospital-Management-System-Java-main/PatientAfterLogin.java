import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PatientAfterLogin extends Frame implements ActionListener{
	private TextArea ta;
	private WelcomePage welcomePage;
	public PatientAfterLogin(WelcomePage f){
		super("Logged in as a Patient ");
		welcomePage=f;
		Label l=new Label("Available Doctors");
		ta=new TextArea(10,30);
		Button b=new Button("Show Doctors list");
		Button b2=new Button("Exit");
		Button b3=new Button("Bill");
		Button b4=new Button("Medical Record");
		Button b5=new Button("Back");
		add(l);add(ta);
		add(b);add(b3);add(b4);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(270,400);
		setLocation(500,200);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show Doctors list")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select doctorName,doctorSpecialist,doctorVisitingHour from doctor");
				while(rs.next()){
					String str="Name :"+rs.getString("doctorName")+"\n"+"Specialist in :"+rs.getString("doctorSpecialist")+"\n"+"Available in :"+rs.getString("doctorVisitingHour");
					ta.append(str+"\n\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
		else if(s.equals("Bill")){
			welcomePage.bill.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Medical Record")){
			welcomePage.medicalRecord.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Back")){
			this.setVisible(false);
			welcomePage.setVisible(true);
		}
	}
}