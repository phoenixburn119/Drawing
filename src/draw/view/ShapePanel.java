package draw.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	private DrawingPanel drawing;
	
	public ShapePanel()
	{
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
	}
	
	public void addRectangle()
	{
		int xPosition = (int) (Math.random() * this.getWidth());
		int yPosition = (int) (Math.random() * this.getWidth());
		int width = (int) (Math.random() * 100);
		int height = (int) (Math.random() * 100);
		
		Rectangle currentRectangle = new Rectangle(xPosition, yPosition, width, height);
		rectangleList.add(currentRectangle);
	}
	
	public void addSquare()
	{
		int xPosition = (int) (Math.random() * getWidth());
		int yPosition = (int) (Math.random() * getHeight());
		int width = (int) (Math.random() * 100);

		
		Rectangle currentSquare = new Rectangle(xPosition, yPosition, width, width);
		squareList.add(currentSquare);
	}
	
	public void addEllipse()
	{
		int xPosition = (int)(Math.random() * getWidth());
		int yPosition = (int)(Math.random() * getHeight());
		int width = (int)(Math.random() * 200);
		int height = (int)(Math.random() * 200);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
		ellipseList.add(currentEllipse);
	}
	
	public void addCircle()
	{
		int xPosition = (int)(Math.random() * getWidth());
		int yPosition = (int)(Math.random() * getHeight());
		int width = (int)(Math.random() * 200);
		//int height = (int)(Math.random() * 2000);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, width);
		ellipseList.add(currentEllipse);
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int[3];
		xPoints[0] = (int)(Math.random() * 550);
		xPoints[0] = (int)(Math.random() * 550);
		xPoints[0] = (int)(Math.random() * 550);
		
		int [] yPoints = {(int)(int)(Math.random() * 550), (int)(Math.random() * 550), (int)(Math.random() * 550)};
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		triangleList.add(triangle);
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 9) + 3;
		int[] xPoints = new int [numberOfSides];
		int[] yPoints = new int [numberOfSides];
		
		for(int side = 0; side < numberOfSides; side++)
		{
			xPoints[side] = (int)(Math.random() * 500);
			yPoints[side] = (int)(Math.random() * 500);
		}
		
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
	}
	
	public void clear()
	{
		rectangleList.clear();
		squareList.clear();
		ellipseList.clear();
		circleList.clear();
		triangleList.clear();
		polygonList.clear();
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		this.setBackground(Color.CYAN);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		drawShapes(mainGraphics, rectangleList);
		drawShapes(mainGraphics, squareList);
		drawShapes(mainGraphics, ellipseList);
		drawShapes(mainGraphics, circleList);
		drawShapes(mainGraphics, triangleList);
		drawShapes(mainGraphics, polygonList);
		
		
		
		//Loops to do lists.
//		for(Rectangle current : rectangleList)
//		{
//			int red = (int)(Math.random() * (256));
//			int green = (int)(Math.random() * (256));
//			int blue = (int)(Math.random() * (256));
//			int alpha = (int)(Math.random() * (256));			
//			
//			mainGraphics.setColor(new Color(red,green,blue,alpha));
//			mainGraphics.fill(current);
//		}
//		
//		for(Rectangle current : squareList)
//		{
//			int red = (int)(Math.random() * (256));
//			int blue = (int)(Math.random() * (256));
//			int green = (int)(Math.random() * (256));
//			
//			mainGraphics.setColor(new Color(red,green,blue));
//			mainGraphics.fill(current);
//		}
		
//		for(Ellipse2D current : ellipseList)
//		{
//			int red = (int)(Math.random() * (256));
//			int blue = (int)(Math.random() * (256));
//			int green = (int)(Math.random() * (256));
//			
//			int penSize = (int)(Math.random() * 10) + 3;
//			
//			mainGraphics.setColor(new Color(red,green,blue));
//			mainGraphics.setStroke(new BasicStroke(penSize));
//			
//			mainGraphics.draw(current);
//		}
//		
//		for(Ellipse2D current : circleList)
//		{
//			int red = (int)(Math.random() * (256));
//			int blue = (int)(Math.random() * (256));
//			int green = (int)(Math.random() * (256));
//			
//			int penSize = (int)(Math.random() * 10) + 3;
//			
//			mainGraphics.setColor(new Color(red,green,blue));
//			mainGraphics.setStroke(new BasicStroke(penSize));
//			
//			mainGraphics.draw(current);
//		}
//		
//		for(Polygon currentTriangle : triangleList)
//		{
//				int red = (int)(Math.random() * (256));
//				int blue = (int)(Math.random() * (256));
//				int green = (int)(Math.random() * (256));
//				
//				int penSize = (int)(Math.random() * 10) + 3;
//				
//				mainGraphics.setColor(new Color(red,green,blue));
//				mainGraphics.setStroke(new BasicStroke(penSize));
//				
//				mainGraphics.draw(currentTriangle);
//		}
//		
//		for(Polygon current : polygonList)
//		{
//			int red = (int)(Math.random() * (256));
//			int blue = (int)(Math.random() * (256));
//			int green = (int)(Math.random() * (256));
//			
//			int penSize = (int)(Math.random() * 10) + 3;
//			
//			mainGraphics.setColor(new Color(red,green,blue));
//			mainGraphics.setStroke(new BasicStroke(penSize));
//			
//			mainGraphics.draw(current);
//		}
	}
	
	private void drawShapes(Graphics2D mainGraphics, ArrayList shapes)
	{
		for(Object current : shapes)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * (256));
			int green = (int)(Math.random() * (256));
			int blue = (int)(Math.random() * (256));
			int alpha = (int)(Math.random() * (256));			
			
			mainGraphics.setColor(new Color(red,green,blue,alpha));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			if(current instanceof Polygon)
			{
				mainGraphics.draw((Shape)current);
			}
			else
			{
				mainGraphics.fill((Shape)current);
			}
				
		}
	}
}
