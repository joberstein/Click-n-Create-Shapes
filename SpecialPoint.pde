// Draws a blue point that connects a red line to the starting point and the point drawn before it each time.
class SpecialPoint extends ExtraPoint {
  private PVector loc;

  SpecialPoint(PVector loc) {
    this.loc = loc;
  }

  // Add the given location to this list of vectors.
  public SpecialPoint add(PVector v) {
    return new SpecialPoint(v);
  }

  // Draws a line between this vector and the given vector.
  public void drawLines(PVector v) {
    stroke(#FF0000);
    line(this.loc.x, this.loc.y, v.x, v.y);
  }

  // Displays the points.
  public void display() {
    fill(#009FFF);
    ellipse(this.loc.x, this.loc.y, 10, 10);
  }

  // Gets the next point of this list of vectors.
  public PVector nextFP() {
    return this.loc;
  }
}

