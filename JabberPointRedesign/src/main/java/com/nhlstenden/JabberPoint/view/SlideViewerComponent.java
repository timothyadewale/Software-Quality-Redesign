package com.nhlstenden.JabberPoint.view;

import com.nhlstenden.JabberPoint.model.Observer;
import com.nhlstenden.JabberPoint.model.Presentation;
import com.nhlstenden.JabberPoint.model.Slide;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SlideViewerComponent extends JComponent implements Observer
{
    private Presentation presentation;

    public SlideViewerComponent (Presentation presentation)
    {
        this.presentation = presentation;
        presentation.addObserver (this);
    }

    @Override
    public void update ()
    {
        repaint ();
    }

    @Override
    protected void paintComponent (Graphics g)
    {
        super.paintComponent (g);
        Slide slide = presentation.getCurrentSlide ();
        if (slide != null)
        {
            slide.draw (g, new Rectangle (0, 0, getWidth (), getHeight ()), this);
        }
    }
}
