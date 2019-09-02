import processing.core.PApplet;
import processing.core.PVector;

// An extra type of FunPoint that has different properties depending on the key pressed.
public abstract class ExtraPoint {
  protected PApplet parent;

  ExtraPoint(PApplet parent) {
    this.parent = parent;
  }

  // Add the given location to this list of vectors.
  public abstract ExtraPoint add(PVector v);

  // Draws a line between this vector and the given vector.
  public abstract void drawLines(PVector v);

  // Displays the points.
  public abstract void display();

  // Gets the next point of this list of vectors.
  public abstract PVector nextFP();
}
