import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MedicalRecord extends Frame implements ActionListener{
	private TextArea ta;
	private TextField tf;
	private WelcomePage welcomePage;
	public MedicalRecord(WelcomePage f){
		super("Medical Record");
		welcomePage=f;
		Label l=new Label("Record Details");
		Label l2=new Label("Search with Patient ID");
		ta=new TextArea(10,30);
		TextField tf=new TextField(28);
		Button b=new Button("Show Record");
		Button b2=new Button("Exit");
		Button b3=new Button("Back");
		add(l2);add(tf);
		add(l);add(ta);
		add(b);add(b3);add(b2);
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
		if(s.equals("Show Record")){
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=null;
				rs=da.getData("select checkupDate,drugs,reference from medicalrecord");
				while(rs.next()){
					String str="Date :"+rs.getString("checkupDate")+"\n"+"Medicine :"+rs.getString("drugs")+"\n"+"Required Test :"+rs.getString("reference");
					ta.append(str+"\n\n");
				}
			}catch(Exception ex){ex.printStackTrace();}

		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
		else if(s.equals("Back")){
			this.setVisible(false);
			welcomePage.patientAfterLogin.setVisible(true);
		}
	}
}