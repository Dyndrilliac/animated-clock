/*
	Title:  AnimatedClock
	Author: Matthew Boyette
	Date:   3/25/2013
	
	This program displays an animated clock.
*/

import api.gui.*;
import api.util.*;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;

public class AnimatedClock
{
	private static boolean debugMode = false;
	
	public static final void main(final String[] args)
	{
		ApplicationWindow mainWindow = null;
		int               choice     = Support.promptDebugMode(mainWindow);
		
		debugMode = (choice == JOptionPane.YES_OPTION);
		
		// Define a self-contained interface construction event handler.
		EventHandler myDrawGUI = new EventHandler()
		{
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
				
				ApplicationWindow window      = (ApplicationWindow)arguments[0];
				Container         contentPane = window.getContentPane();
				Clock             clock       = new Clock(true);
				
				contentPane.setLayout(new FlowLayout());
				contentPane.add(clock);
				clock.startAnimation();
			}
		};
		
		mainWindow = new ApplicationWindow(null, "Animated Clock Application", new Dimension(300, 300), debugMode, false, 
			null, myDrawGUI);
		
		mainWindow.setIconImageByResourceName("icon.png");
	}
}