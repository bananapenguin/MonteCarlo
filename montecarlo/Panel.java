package montecarlo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Panel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JPanel north, south;
	OvalPane pane;
	JTextField f, res;
	JButton b;
	double result;
	
	Image buf;
	Graphics gbuf;
	
	long dot;

	long in;
	
	
	public Panel(Image buf){
		this.buf = buf;
		gbuf = buf.getGraphics();
		crossDraw();
		dot = 10000;
		pane = new OvalPane(this);
		createNorthPane();
		createSouthPane();
		
		setLayout(new BorderLayout());
		
		add(north, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		f.setHorizontalAlignment(JTextField.RIGHT);
	}
	
	public void createNorthPane(){
		north = new JPanel();
		f = new JTextField(Long.toString(dot), 10);
		b = new JButton("calc");
		north.add(b);
		north.add(f);
		f.setHorizontalAlignment(JTextField.RIGHT);
		b.addActionListener(this);
		
	}
	
	public void createSouthPane(){
		south = new JPanel();
		res = new JTextField(Double.toString(0), 10);
		res.setHorizontalAlignment(JTextField.RIGHT);
		south.add(res);
		
	}
	
	public void crossDraw(){
		int width = buf.getWidth(this);
		int height = buf.getHeight(this);
		gbuf.setColor(Color.BLACK);
		gbuf.drawOval((int)((width-200)/2), (int)((height-200)/2), 200, 200);
		gbuf.drawLine(0,(int)(height/2), width, (int)(height/2));
		gbuf.drawLine((int)(width/2), 0, (int)(width/2), height);
	}
	
	public void draw(){
		gbuf.setColor(Color.WHITE);
		gbuf.fillRect(0, 0, 300, 300);
		crossDraw();
		int width = buf.getWidth(this);
		int height = buf.getHeight(this);
		in=0;
		for(int i=0; i<dot; i++){
			int x = (int)(Math.random()*width);
			int y = (int)(Math.random()*height);
			if(Math.pow((x-width/2), 2)+Math.pow((y-height/2), 2)<=Math.pow(100,2) ){
				gbuf.setColor(Color.RED);
				in++;
			}else{
				gbuf.setColor(Color.BLUE);
			}
			gbuf.drawLine(x, y, x, y);
		}
		if(dot!=0)
		result = in*width*height/dot/Math.pow(100,2);
	}
	
	

	public void actionPerformed(ActionEvent arg0) {
		dot = Integer.parseInt(f.getText());
		draw();
		res.setText(Double.toString(result));
		repaint();
	}
}
