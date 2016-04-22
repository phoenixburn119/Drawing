package draw.view;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import draw.controller.DrawController;

public class DrawingPanel
{
	private DrawController baseController;
	private SpringLayout baseLayout;
	private JButton addRectangleButton;
	private ShapePanel shapePanel;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(DrawController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		addRectangleButton = new JButton("Add a Rectangle");
		rectangleList = new ArrayList<Rectangle>();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{

	}
	
	private void setupLayout()
	{
	
	}
	
	private void setupListeners()
	{
		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});
	}
	
	@Override
	protected void paintComonent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setStroke(new BasicStroke(2));
		mainGraphics.setColor(Color.ORANGE);
		mainGraphics.drawRect(50, 20, 200, 400);
		
		for(Rectangle current : rectangleList)
		{
			int red = (int)(Math.random() * (256));
			int blue = (int)(Math.random() * (256));
			int green = (int)(Math.random() * (256));
			
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(current);
		}
		
		
	}
}
