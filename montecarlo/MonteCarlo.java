package montecarlo;


import java.awt.*;

import javax.swing.JApplet;

public class MonteCarlo extends JApplet{
	private static final long serialVersionUID = 1L;
	
	Image buf;
	Graphics gbuf;
	
	public void init(){
		setSize(300,368);
		
		buf = createImage(300,300);
		gbuf = buf.getGraphics();
		
		add(new Panel(buf));
	}

}
