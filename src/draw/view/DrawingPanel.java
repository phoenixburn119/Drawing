package draw.view;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import draw.controller.DrawController;

public class DrawingPanel extends JPanel
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
		shapePanel = new ShapePanel();

		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(addRectangleButton);
		this.add(shapePanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 60, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -100, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 900, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addRectangleButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, addRectangleButton, 160, SpringLayout.WEST, this);
		
	}
	
	private void setupListeners()
	{
		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				for(int i = 0; i < 500; i++)
				{
				int xPosition = (int) (Math.random() * getWidth());
				int yPosition = (int) (Math.random() * getHeight());
				int width = (int) (Math.random() * 100);
				int height = (int) (Math.random() * 100);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				
				repaint();
				}
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
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
