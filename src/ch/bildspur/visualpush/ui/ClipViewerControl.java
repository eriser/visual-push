package ch.bildspur.visualpush.ui;

import ch.bildspur.visualpush.video.Clip;
import processing.core.PGraphics;
import processing.core.PVector;

import java.awt.*;

/**
 * Created by cansik on 20/08/16.
 */
public class ClipViewerControl extends UIControl {
    Clip clip;
    int padding = 1;

    public ClipViewerControl(Clip clip)
    {
        super();
        this.clip = clip;
    }

    public ClipViewerControl(float x, float y, float width, float height)
    {
        this(null, x, y, width, height);
    }

    public ClipViewerControl(Clip clip, float x, float y, float width, float height)
    {
        this(clip);
        this.position = new PVector(x, y);
        this.width = width;
        this.height = height;
        this.strokeColor = Color.GRAY;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public void paint(PGraphics g)
    {
        PVector pos = getAbsolutePosition();

        //g.fill(fillColor.getRGB());
        g.noFill();
        g.stroke(strokeColor.getRGB());
        g.rect(pos.x, pos.y, width, height);

        if(clip != null)
            g.image(clip.getPreview(), pos.x + padding, pos.y + padding, width - padding, height - padding);

        super.paint(g);
    }
}
