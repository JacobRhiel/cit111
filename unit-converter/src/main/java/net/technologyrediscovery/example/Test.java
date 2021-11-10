package net.technologyrediscovery.example;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import javax.swing.*;

public class Test
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new PieChartPanel());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}

class PieChartPanel extends JPanel
{
    BufferedImage image;
    final int PAD = 30;
    Font font;
    NumberFormat nf;
    boolean showConstructionMarkers;

    public PieChartPanel()
    {
        font = new Font("lucida sans regular", Font.PLAIN, 20);
        nf = NumberFormat.getPercentInstance();
        showConstructionMarkers = true;
        addMouseListener(new Visibility(this));
        addComponentListener(new ComponentAdapter()
        {
            public void componentResized(ComponentEvent e)
            {
                image = null;
            }
        });
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if(image == null)
            createChartImage();
        g2.drawImage(image, 0, 0, this);
    }

    private void createChartImage()
    {
        int[] data = { 100, 100, 100, 100, 100 };
        Color[] color = new Color[] { Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.PINK };
        int w = getWidth();
        int h = getHeight();
        int cx = w/2;
        int cy = h/2;
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, w, h);
        g2.setPaint(Color.black);
        // draw circle
        int dia = Math.min(w,h) - 2*PAD;
        g2.draw(new Ellipse2D.Double(cx - dia/2, cy - dia/2, dia, dia));
        double total = 0;
        for(int j = 0; j < data.length; j++)
            total += data[j];
        double theta = 0, phi = 0;
        double x, y;
        for(int j = 0; j < data.length; j++)
        {
            // draw leading edge of pie slice
            x = cx + (dia/2) * Math.cos(theta);
            y = cy + (dia/2) * Math.sin(theta);
            g2.setColor(Color.ORANGE);
            g2.draw(new Line2D.Double(cx, cy, x, y));
            // angle of pie slice
            phi = (data[j]/total) * 2 * Math.PI;
            if(showConstructionMarkers)
            {
                // draw centerline of slice
                g2.setXORMode(Color.cyan);
                x = cx + (dia/2) * Math.cos(theta + phi/2);
                y = cy + (dia/2) * Math.sin(theta + phi/2);
                g2.draw(new Line2D.Double(cx, cy, x, y));
                g2.setPaintMode();
            }

            // mark text center on centerline
            x = cx + (9*dia/24) * Math.cos(theta + phi/2);
            y = cy + (9*dia/24) * Math.sin(theta + phi/2);
            if(showConstructionMarkers)
            {
                g2.setPaint(Color.blue);
                g2.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
                g2.setPaint(Color.black);
            }

            // draw text for data value inside pie slice
            g2.setFont(font);
            String s = String.valueOf(data[j]);
            FontRenderContext frc = g2.getFontRenderContext();
            float textWidth = (float)font.getStringBounds(s, frc).getWidth();
            LineMetrics lm = font.getLineMetrics(s, frc);
            float sx = (float)(x - textWidth/2);
            float sy = (float)(y + lm.getAscent()/2);
            g2.drawString(s, sx, sy);

            // locate text center for outer, percent values
            x = cx + (dia/2 + 4*PAD/5) * Math.cos(theta + phi/2);
            y = cy + (dia/2 + 4*PAD/5) * Math.sin(theta+ phi/2);
            if(showConstructionMarkers)
            {
                g2.setPaint(Color.red);
                g2.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
                g2.setPaint(Color.black);
            }

            // show percent values on outside of circle
            s = nf.format(data[j]/total);
            textWidth = (float)font.getStringBounds(s, frc).getWidth();
            lm = font.getLineMetrics(s, frc);
            sx = (float)(x - textWidth/2);
            sy = (float)(y + lm.getAscent()/2);
            g2.drawString(s, sx, sy);

            theta += phi;
        }
        g2.dispose();
    }

    public void toggleVisibility()
    {
        showConstructionMarkers = !showConstructionMarkers;
        image = null;
        repaint();
    }
}

/**
 * double-click PieChartPanel to reveal/hide construction lines
 */
class Visibility extends MouseAdapter
{
    PieChartPanel pie;

    public Visibility(PieChartPanel pcp)
    {
        pie = pcp;
    }

    public void mousePressed(MouseEvent e)
    {
        if(e.getClickCount() > 1)
            pie.toggleVisibility();
    }
}