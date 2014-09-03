// Draws a green point which otherwise acts as a normal point.
public class ColoredPoint extends ExtraPoint {
  private PVector loc;

  ColoredPoint(PVector loc) {
    this.loc = loc;
  }

  // Add the given location to this list of vectors.
  public ColoredPoint add(PVector v) {
    return new ColoredPoint(v);
  }

  // Draws a line between this vector and the given vector.
  public void drawLines(PVector v) {
    stroke(#000000);
    line(this.loc.x, this.loc.y, v.x, v.y);
  }

  // Displays the points.
  public void display() {
    fill(#02B424);
    ellipse(this.loc.x, this.loc.y, 5, 5);
  }

  // Gets the next point of this list of vectors.
  public PVector nextFP() {
    return this.loc;
  }
}

