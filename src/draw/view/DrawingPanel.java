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
	private JButton addRectanglePanel;
	private JButton addSquarePanel;
	private JButton addEllipsePanel;
	private JButton addCirclePanel;
	private JButton addTrianglePanel;
	private JButton addPolygonPanel;
	private ShapePanel shapePanel;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(DrawController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		addRectangleButton = new JButton("Add a Rectangle");
		addRectanglePanel = new JButton("Add Rectangle");
		addSquarePanel = new JButton("Add Square");
		addEllipsePanel = new JButton("Add Ellipse");
		addCirclePanel = new JButton("Add Circle");
		addTrianglePanel = new JButton("Add Triangle");
		addPolygonPanel = new JButton("Add Polygon");
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
		this.add(addRectanglePanel);
		this.add(addSquarePanel);
		this.add(addEllipsePanel);
		this.add(addCirclePanel);
		this.add(addTrianglePanel);
		this.add(addPolygonPanel);
		this.add(shapePanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, addRectanglePanel, 155, SpringLayout.WEST, this);		
		baseLayout.putConstraint(SpringLayout.NORTH, addSquarePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, addSquarePanel, 270, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, addEllipsePanel, 385, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addCirclePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, addCirclePanel, 495, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addTrianglePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, addTrianglePanel, 620, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, addPolygonPanel, 745, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addEllipsePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addRectangleButton, 700, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 60, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -100, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 900, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, addRectangleButton, 160, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addPolygonPanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addRectanglePanel, 10, SpringLayout.NORTH, this);
	}
	
	private void setupListeners()
	{
		addRectanglePanel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			}
		});
		
		addSquarePanel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				repaint();
			}
		});
		
		addEllipsePanel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			}
		});
		
		addCirclePanel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			}
		});
		addTrianglePanel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});

		addPolygonPanel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
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
