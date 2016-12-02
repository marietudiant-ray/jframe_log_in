package jframe_log_in;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Jframe_log_in extends JFrame {
	private Connection connection=null;
	private Statement statement=null;
	private ResultSet result=null;
	private final String url="jdbc:mysql://localhost:3306/internship";
	private final String user="root";
	private final String password="mari901214";
	
	
	public JButton jButton1=new JButton();
	public JButton jButton2=new JButton();
	public JTextField JUser=new JTextField();
	public JPasswordField JPass=new JPasswordField();
	public JLabel jLabel1=new JLabel();
	public JLabel jLabel2=new JLabel();
	public JLabel jLabel3=new JLabel();
	public static int count=3;
	Mypanel mp;
	
	public Jframe_log_in()
	{
		jbInit();
	}
	
	public static void main(String[] args)
	{
		Jframe_log_in jf=new Jframe_log_in();
	}
	
	private void jbInit()
	{
		setTitle("登陆界面");
		mp=new Mypanel();
		mp.setLayout(null);

		
		jButton1.setBounds(new Rectangle(50,250,100,45));
		jButton1.setText("登陆");
		jButton1.setFont(new Font("楷体",Font.PLAIN,16));
		jButton1.setForeground(Color.DARK_GRAY);
		jButton1.addActionListener(new SimpleListener1(this));
		jButton2.addActionListener(new SimpleListener2(this));
		jButton2.setText("退出");
		jButton2.setFont(new Font("楷体",Font.PLAIN,16));
		jButton2.setForeground(Color.darkGray);
		jButton2.setBounds(new Rectangle(250,250,100,45));
		JUser.setBounds(new Rectangle(200,50,150,50));
		JPass.setBounds(new Rectangle(200,150,150,50));
		jLabel1.setText("用户名：");
		jLabel1.setFont(new Font("楷体",Font.PLAIN,16));
		jLabel1.setForeground(Color.yellow);
		jLabel1.setBounds(new Rectangle(50,50,100,50));
		jLabel2.setText("密码：");
		jLabel2.setFont(new Font("楷体",Font.PLAIN,16));
		jLabel2.setForeground(Color.yellow);
		jLabel2.setBounds(new Rectangle(50,150,100,50));
		jLabel3.setText("Ray");
		jLabel3.setFont(new Font("宋体",Font.BOLD,20));
		jLabel3.setForeground(Color.cyan);
		jLabel3.setBounds(0, 0, 100, 50);;
        mp.add(jButton1);
		mp.add(jButton2);
		mp.add(jLabel1);
		mp.add(jLabel2);
		mp.add(JPass);
		mp.add(JUser);
		mp.add(jLabel3);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(mp);
		this.setBounds(300, 200, 400, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}	
	
	
	public void jButton1_actionPerformed(ActionEvent actionEvent) throws SQLException
	{
      
	        String jusername=JUser.getText().trim();
	         char[] s=JPass.getPassword();
	        String jpassword=new String(s);
        if(jusername.equals("")||jpassword.equals(""))
           {
    	      JOptionPane.showMessageDialog(this, "对不起，请输入用户名或者密码", "错误", JOptionPane.ERROR_MESSAGE);
           }
        else
        {
    	  try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection=DriverManager.getConnection(url, user, password);
			String sql="select * from 用户 where name="+"\""+jusername+"\";";
			statement=connection.createStatement();
			result=statement.executeQuery(sql);
			if(result.next())
			     {
			     	if(result.getString(2).equals(jpassword))
			       	{
					JOptionPane.showMessageDialog(this, "验证成功", "成功登陆", JOptionPane.INFORMATION_MESSAGE);
				    }
				    else
				    {
					  JOptionPane.showMessageDialog(this, "您输入的密码错误", "密码错误", JOptionPane.ERROR_MESSAGE);
					  count--;
					  String str="";
					  str+="你还有"+count+"次机会!";
					  JOptionPane.showMessageDialog(this, str);
			     	}
		         }
			 else
			 {
				 JOptionPane.showMessageDialog(this,"您输入的用户并不存在","用户不存在",JOptionPane.ERROR_MESSAGE);
			 }
		       } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     finally{
    	      if(result !=null) result.close();
    	      if(statement !=null) statement.close();
    	      if(connection !=null) connection.close();
            } 
        }
      
      if(count==0)
      {
    	JOptionPane.showMessageDialog(this, "you have failed three times, you can't log_in this time!");
    	System.exit(0);
      }	
    
   }
	
	
	public void jButton2_action_performed(ActionEvent actionEvent)
	{
		System.exit(0);
	}
}
 
	

	
	
	
		
	

