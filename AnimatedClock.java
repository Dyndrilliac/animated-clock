/*
	Title:  AnimatedClock
	Author: Matthew Boyette
	Date:   3/25/2013
	
	This program displays an animated clock.
*/
import api.gui.*;
import api.util.*;

import java.awt.*;
import javax.swing.*;

public class AnimatedClock
{
	public static final void main(final String[] args)
	{
		ApplicationWindow mainWindow = null;
		int choice = Support.promptDebugMode(mainWindow);
		
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
		
		if (choice == JOptionPane.YES_OPTION)
		{
			mainWindow = new ApplicationWindow(null, "Animated Clock Application", new Dimension(300, 300), true, false, 
				true, null, myDrawGUI);
		}
		else if (choice == JOptionPane.NO_OPTION)
		{
			mainWindow = new ApplicationWindow(null, "Animated Clock Application", new Dimension(300, 300), false, false, 
				true, null, myDrawGUI);
		}
		else
		{
			return;
		}
		
		mainWindow.drawGUI();
		mainWindow.setVisible(true);
	}
}
