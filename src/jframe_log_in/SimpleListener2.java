package jframe_log_in;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleListener2 implements ActionListener{
	
      private Jframe_log_in adapter;
      
     public  SimpleListener2 (Jframe_log_in adapter)
     {
    	 this.adapter=adapter;
     }
     public void actionPerformed(ActionEvent actionEvent)
     {
    	 adapter.jButton2_action_performed(actionEvent);
     }
}
