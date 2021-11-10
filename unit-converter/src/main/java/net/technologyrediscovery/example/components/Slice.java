package net.technologyrediscovery.example.components;

import java.awt.*;
import java.awt.geom.Arc2D;

public class Slice extends Arc2D.Double
{

    private final Color bg;

    private Color fg;

    public Slice(Color bg, Color fg, double x, double y, double w, double h, double start, double extent, int type) {
        super(x, y, w, h, start, extent, type);
        this.bg = bg;
        this.fg = fg;
    }

    public Color getBackgroundColor() {
        return this.bg;
    }

}
