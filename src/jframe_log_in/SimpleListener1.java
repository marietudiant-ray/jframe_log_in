package jframe_log_in;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SimpleListener1 implements ActionListener{
	private Jframe_log_in adapter;
	SimpleListener1(Jframe_log_in adapter)
	{
		this.adapter=adapter;
	}
	
	public void actionPerformed(ActionEvent actionEvent)
	{
		try {
			adapter.jButton1_actionPerformed(actionEvent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
