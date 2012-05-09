package montecarlo;

import java.awt.*;

import javax.swing.JPanel;

public class OvalPane extends JPanel{
	private static final long serialVersionUID = 1L;
	Image buf;
	Graphics gbuf;
	
	public OvalPane(){
	}
	
	public OvalPane(Panel pane){
		buf = pane.buf;
		gbuf = buf.getGraphics();
	}
	
	public void paint(Graphics g){
		g.drawImage(buf, 0, 0, this);
	}
}
