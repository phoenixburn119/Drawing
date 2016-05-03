package draw.view;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import draw.controller.DrawController;
import draw.view.DrawingPanel;

public class DrawFrame extends JFrame
{
	private DrawController baseController;
	private DrawingPanel basePanel;
	
	public DrawFrame(DrawController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	
	/*
	 * Will setup the frame for the panel.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(true);
		this.setTitle("Chatbot");
		this.setSize(1000,750);
		this.setVisible(true);
	}
	
	public DrawController getBaseController()
	{
		return baseController;
	}
}
