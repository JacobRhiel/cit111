package net.technologyrediscovery.example.components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PieChart extends JComponent
{

    private Ellipse2D.Double ellipse;

    private double radius, slices;
    private Color color;

    private PieChartGraph graph;

    public PieChart(double radius, double slices, Color color) {
        this.radius = radius;
        this.slices = slices;
        this.color = color;

        setPreferredSize(new Dimension((int)(radius + 20), (int)(radius + 20)));
    }

    @Override
    public void paint(Graphics g)
    {
       super.paint(g);
       Graphics2D g2d = (Graphics2D) g;
       graph = new PieChartGraph(g);
       int x = (getX() + getWidth()) / 2;
       int y = (getY() + getHeight()) / 2;

        System.out.println(getWidth() + ", " + graph.diameter + ", " + radius);

       if(getWidth() < radius) {
           double radius = getWidth();
           x = x - ((int) radius / 2);
           y = y - ((int) radius / 2);
           ellipse = graph.drawCircle(x, y, (int) radius, Color.CYAN, 6);
       } else {
           x = (int) (x - (radius / 2));
           y = (int) (y - (radius / 2));
           ellipse = graph.drawCircle(x, y, (int) radius, Color.ORANGE, 6);
       }
        Color[] color = new Color[] { Color.ORANGE, Color.RED, Color.GREEN, Color.CYAN, Color.PINK, Color.YELLOW };
        for (int i = 0; i < 6; i++) {
            graph.aggregateSlice(color[i], Color.BLACK);
        }


    }
}
