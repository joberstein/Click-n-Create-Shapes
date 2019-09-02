import processing.core.PApplet;
import processing.core.PVector;
import utils.ColorUtils;

// Draws a green point which otherwise acts as a normal point.
public class ColoredPoint extends ExtraPoint {
  private PVector loc;

  ColoredPoint(PApplet parent, PVector loc) {
    super(parent);
    this.loc = loc;
  }

  // Add the given location to this list of vectors.
  public ColoredPoint add(PVector v) {
    return new ColoredPoint(this.parent, v);
  }

  // Draws a line between this vector and the given vector.
  public void drawLines(PVector v) {
    this.parent.stroke(ColorUtils.getRGB("#000000"));
    this.parent.line(this.loc.x, this.loc.y, v.x, v.y);
  }

  // Displays the points.
  public void display() {
    this.parent.fill(ColorUtils.getRGB("#02B424"));
    this.parent.ellipse(this.loc.x, this.loc.y, 5, 5);
  }

  // Gets the next point of this list of vectors.
  public PVector nextFP() {
    return this.loc;
  }
}

