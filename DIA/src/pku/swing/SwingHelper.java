package pku.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingHelper
{
	public static void drawPoint(Rectangle r,JLabel map)
	{
		ImageIcon imageIcon = new ImageIcon("map//point.jpg");
		JLabel label = new JLabel(imageIcon);
		
		//buttonStart.setLayout(null);
		/*label.setLocation(1, 1);
		label.setSize(600, 450);*/
		label.setBounds(r);
		label.setVisible(true);

		map.add(label);
		map.repaint();
		
	}
	public static void drawLine(Rectangle r,JLabel map,Graphics g,JFrame jf)
	{
		paint(g,jf);
	}
	public static void paint(Graphics g,JFrame jf) {   
	    Graphics2D g2d = (Graphics2D) g;   
	    Stroke stroke = g2d.getStroke();   
	    Color color = g2d.getColor();   
	       
	    // draw line   
	    g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));   
	    g2d.setColor(Color.GREEN);   
	    g2d.drawLine(100, 100, 500, 500);   
	    g2d.setStroke(stroke);   
	    g2d.setColor(color);   
	       
	    jf.paintComponents(g2d);   
	}  
}
