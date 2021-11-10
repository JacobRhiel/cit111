package net.technologyrediscovery.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;

public class ImageDisplayPanel extends JPanel implements MouseMotionListener {

    private Map<Integer, Arc2D> slices = new HashMap<>();

    private Map<Integer, Boolean> hoverKey = new HashMap<>();

    public ImageDisplayPanel() {
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;

        String[] strings = new String[] { "Gun 1", "Gun 2", "Gun 3", "Gun 4", "Gun 5" };
        Color[] color = new Color[] { Color.ORANGE, Color.RED, Color.GREEN, Color.CYAN, Color.PINK, Color.YELLOW };
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        int slices = 5;
        int startingAngle = 0;
        int theta = 0;
        for (int index = 0; index < slices; index++) {
            if(hoverKey.containsKey(index)) {
                if(hoverKey.get(index)) {
                    graphics2D.setColor(Color.BLACK);
                } else graphics2D.setColor(color[index]);
            } else graphics2D.setColor(color[index]);
            System.out.println(graphics2D.getColor());

            int dia = 250;
            graphics2D.fillArc(0, 0, 250, 250, startingAngle, 72);
            Arc2D arc = new Arc2D.Double(0, 0, 250, 250, startingAngle, 72, Arc2D.PIE);
            graphics2D.draw(new Line2D.Double(125, 125, (dia/2) * Math.cos(theta), (dia/2) * Math.sin(theta)));
            double phi = (20) * (2 * Math.PI);
            if(!this.slices.containsKey(index))
            {
                this.slices.put(index, arc);
            }

            System.out.println(phi);
            graphics2D.setXORMode(Color.cyan);
            double x = arc.getCenterX() + (dia/2) * Math.cos(theta + phi/2);
            double y = arc.getCenterY() + (dia/2) * Math.sin(theta + phi/2);
            System.out.println(x + ", " + y);
            graphics2D.draw(new Line2D.Double(arc.getCenterX(), arc.getCenterY(), x, y));
            graphics2D.setPaintMode();

            x = arc.getCenterX() + (9*dia/24) * Math.cos(theta + phi/2);
            y = arc.getCenterY() + (9*dia/24) * Math.sin(theta + phi/2);
            graphics2D.setPaint(Color.blue);
            graphics2D.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
            graphics2D.setPaint(Color.black);

            String s = strings[index];
            Font font = graphics2D.getFont();
            FontRenderContext frc = graphics2D.getFontRenderContext();
            float textWidth = (float)font.getStringBounds(s, frc).getWidth();
            LineMetrics lm = font.getLineMetrics(s, frc);
            float sx = (float)(x - textWidth/2);
            float sy = (float)(y + lm.getAscent()/2);
            graphics2D.drawString(s, sx, sy);

            startingAngle += 72;
            theta += phi;
        }
        graphics2D.dispose();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point position = e.getPoint();
        for (Map.Entry<Integer, Arc2D> entry : slices.entrySet()) {
            int index = entry.getKey();
            Arc2D slice = entry.getValue();
            hoverKey.put(index, slice.contains(position));
            repaint();
        }
    }
}
