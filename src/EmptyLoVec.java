import processing.core.PApplet;
import processing.core.PVector;

// An empty list of vectors.
public class EmptyLoVec extends LoVec {

  EmptyLoVec(PApplet parent) {
    super(parent);
  }

  // Creates an empty LoVec.
  public LoVec empty() {
    return new EmptyLoVec(this.parent);
  }

  // Add the given location to this list of vectors.
  public LoVec add(PVector v) {
    return new FunPoint(this.parent, v, this);
  }

  // Displays the points.
  public void display() {}

  // Draws a line between this vector and the given vector.
  public void drawLines(PVector v) {}

  // Draws a randomly colored line between this vector and the given vector.
  public void drawColorLines(PVector v) {}

  // Get the initial point of this list of vectors.
  public PVector initFP() {
    throw new RuntimeException("initFP: No vector in empty list");
  }

  // Is this List of Vectors empty?
  public boolean isEmpty() {
    return true;
  }

  // Calculates the size of this list of vectors.
  public int size() {
    return 0;
  }

  // Is this list of vectors closed?
  public boolean isClosed() {
    return false;
  }

  // Gets the next point of this list of vectors.
  public PVector nextFP() {
    throw new RuntimeException("nextFP: No vector in empty list");
  }
}

