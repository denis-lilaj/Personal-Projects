import java.awt.event.*;
public class WindowQuitter extends WindowAdapter  {
	
	public void windowsClosing (WindowEvent e)
	{
		System.exit(0);
	}

}
