import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Bill extends Frame implements ActionListener{
	private TextArea ta;
	private TextField tf;
	private WelcomePage welcomePage;
	public Bill(WelcomePage f){
		super("Bill");
		welcomePage=f;
		Label l=new Label("Total Bill");
		Label l2=new Label("Search with Patient ID");
		ta=new TextArea(10,30);
		TextField tf=new TextField(28);
		Button b=new Button("Show Bill");
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
		//int i=Integer.parseInt(tf.getText());
		ta.setText("");
		if(s.equals("Show Bill")){
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=null;
				rs=da.getData("select Bill from patient");
				while(rs.next()){
					String str="Total Due :"+rs.getInt("Bill");
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