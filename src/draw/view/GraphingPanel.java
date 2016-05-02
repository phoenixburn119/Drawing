package draw.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphingPanel extends JPanel
{
	private ArrayList<Rectangle> graphList;
	private ArrayList<Integer> infoList;
	
	public GraphingPanel()
	{
		graphList = new ArrayList<Rectangle>();
		infoList = new ArrayList<Integer>();
		
		buildInfoList();
		buildGraphList();
	}
	
	public void buildInfoList()
	{
		for(int i = 0; i < 14; i++)
		{
			int width = (int)(Math.random() * 225);
			infoList.add(width);
		}
	}
	
	public void buildGraphList()
	{
		for(int i = 0; i < 14; i++)
		{
			int width = infoList.get(i);
			int height = 40;
			int xPosition = 0;
			int yPosition = i * height;
			
			Rectangle currentRectangle = new Rectangle(xPosition, yPosition, width, height);
			graphList.add(currentRectangle);
		}
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		this.setBackground(Color.DARK_GRAY);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(Rectangle current : graphList)
		{
			int red = (int)(Math.random() * (256));
			int green = (int)(Math.random() * (256));
			int blue = (int)(Math.random() * (256));
			int alpha = (int)(Math.random() * (256));			
		
			mainGraphics.setColor(new Color(red,green,blue,alpha));
			mainGraphics.fill(current);
		}
	}
}
