// A list of vectors.
public abstract class LoVec {
  LoVec() {
  }

  // Creates an empty LoVec.
  public abstract LoVec empty();

  // Add the given location to this list of vectors.
  public abstract LoVec add(PVector v);

  // Displays the points.
  public abstract void display();

  // Draws a line between this vector and the given vector.
  public abstract void drawLines(PVector v);

  // Draws a randomly colored line between this vector and the given vector.
  public abstract void drawColorLines(PVector v);

  // Is this List of Vectors empty?
  public abstract boolean isEmpty();

  // Calculates the size of this empty list of vectors.
  public abstract int size();

  // Get the initial point of this list of vectors.
  public abstract PVector initFP();

  // Is this list of vectors closed?
  public abstract boolean isClosed();

  // Gets the next point of this list of vectors.
  public abstract PVector nextFP();
}

