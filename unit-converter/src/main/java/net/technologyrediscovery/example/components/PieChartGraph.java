package net.technologyrediscovery.example.components;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class PieChartGraph
{

     public double diameter;

     private Graphics2D graphics;

     private double lastEndPoint = 0;

     public ArrayList<Slice> slices;

     private double centerX;

     private double centerY;

     public PieChartGraph(Graphics g) {
         this.graphics = (Graphics2D) g;
         this.slices = new ArrayList<>();
     }

     public Ellipse2D.Double drawCircle(int x, int y, int radius, Color color, double total) {

         this.slices = new ArrayList<>();
         centerX = x;
         centerY = y;
         diameter = radius;

         Ellipse2D.Double ellipse = new Ellipse2D.Double(centerX, centerY, diameter, diameter);

         graphics.setColor(color);
         graphics.fill(ellipse);
         return ellipse;
     }

    public Slice aggregateSlice(Color bg, Color fg) {
        double endPoint = ((60 * 360) / 6) + lastEndPoint;

        System.out.println(lastEndPoint + ", " + endPoint);

        Slice slice = new Slice(bg, fg, centerX, centerY, diameter, diameter, lastEndPoint, endPoint - lastEndPoint, Arc2D.PIE);
        slices.add(slice);

        graphics.setColor(slice.getBackgroundColor());
        graphics.fill(slice);

        lastEndPoint = endPoint;
        return slice;
    }

}
