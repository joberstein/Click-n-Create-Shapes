// An extra type of FunPoint that has different properties depending on the key pressed.
public abstract class ExtraPoint {

  ExtraPoint() {
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
