/*
 * Title: AnimatedClock
 * Author: Matthew Boyette
 * Date: 3/25/2013
 * 
 * This program displays an animated clock.
 */

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import api.gui.draw.Clock;
import api.gui.swing.ApplicationWindow;
import api.util.EventHandler;
import api.util.Support;

public class AnimatedClock
{
    public final static void main(final String[] args)
    {
        new AnimatedClock(args);
    }
    
    private boolean           isDebugging = false;
    private ApplicationWindow window      = null;
    
    public AnimatedClock(final String[] args)
    {
        this.setDebugging(Support.promptDebugMode(this.getWindow()));
        
        // Define a self-contained interface construction event handler.
        // @formatter:off
        EventHandler<AnimatedClock> myDrawGUI = new EventHandler<AnimatedClock>(this)
        {
            private final static long serialVersionUID = 1L;

            @Override
            public final void run(final ApplicationWindow window)
            {
                Container contentPane = window.getContentPane();
                Clock clock = new Clock(true);

                contentPane.setLayout(new FlowLayout());
                contentPane.add(clock);
                clock.startAnimation();
            }
        };

        this.setWindow(new ApplicationWindow(null, "Animated Clock Application", new Dimension(350, 300), this.isDebugging(), false, null, myDrawGUI));
        this.getWindow().setIconImageByResourceName("icon.png");
        // @formatter:on
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