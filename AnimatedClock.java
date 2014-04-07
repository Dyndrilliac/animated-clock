/*
	Title:  AnimatedClock
	Author: Matthew Boyette
	Date:   3/25/2013
	
	This program displays an animated clock.
*/

import api.gui.ApplicationWindow;
import api.gui.Clock;
import api.util.EventHandler;
import api.util.Support;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;

public class AnimatedClock
{
	public final static void main(final String[] args)
	{
		new AnimatedClock();
	}
	
	private boolean				isDebugging	= false;
	private ApplicationWindow	window		= null;
	
	public AnimatedClock()
	{
		this.setDebugging((Support.promptDebugMode(this.getWindow()) == JOptionPane.YES_OPTION));
		
		// Define a self-contained interface construction event handler.
		EventHandler myDrawGUI = new EventHandler(this)
		{
			@Override
			public final void run(final Object... arguments) throws IllegalArgumentException
			{
				if (arguments.length <= 0)
				{
					throw new IllegalArgumentException("myDrawGUI Error : incorrect number of arguments.");
				}
				else if (!(arguments[0] instanceof ApplicationWindow))
				{
					throw new IllegalArgumentException("myDrawGUI Error : argument[0] is of incorrect type.");
				}
				
				ApplicationWindow	window		= (ApplicationWindow)arguments[0];
				Container			contentPane	= window.getContentPane();
				Clock				clock		= new Clock(true);
				
				contentPane.setLayout(new FlowLayout());
				contentPane.add(clock);
				clock.startAnimation();
			}
		};
		
		this.setWindow(new ApplicationWindow(null, "Animated Clock Application", new Dimension(300, 300), this.isDebugging(), false, null, myDrawGUI));
		this.getWindow().setIconImageByResourceName("icon.png");
	}
	
	public final ApplicationWindow getWindow()
	{
		return this.window;
	}
	
	public final boolean isDebugging()
	{
		return this.isDebugging;
	}
	
	protected final void setDebugging(final boolean isDebugging)
	{
		this.isDebugging = isDebugging;
	}
	
	protected final void setWindow(final ApplicationWindow window)
	{
		this.window = window;
	}
}