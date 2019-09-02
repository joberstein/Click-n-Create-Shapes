import processing.core.PApplet;
import processing.core.PVector;

// A non-empty list of vectors.
public class FunPoint extends LoVec {
  private PVector loc;
  private LoVec rest;

  FunPoint(PApplet parent, PVector loc, LoVec rest) {
    super(parent);
    this.loc = loc;
    this.rest = rest;
  }

  // Creates an empty LoVec.
  public LoVec empty() {
    return new EmptyLoVec(this.parent);
  }

  // Add the given location to this list of vectors.
  public LoVec add(PVector v) {
    return new FunPoint(this.parent, v, this);
  }

  // Draws a line between this vector and the given vector.
  public void drawLines(PVector v) {
    this.parent.stroke(0);
    this.parent.line(this.loc.x, this.loc.y, v.x, v.y);
  }

  // Draws a randomly colored line between this vector and the given vector.
  public void drawColorLines(PVector v) {
    this.parent.stroke(getRandomRgbValue(), getRandomRgbValue(), getRandomRgbValue());
    this.parent.line(this.loc.x, this.loc.y, v.x, v.y);
  }

  private float getRandomRgbValue() {
    return this.parent.random(0, 255);
  }

  // Is this List of Vectors empty?
  public boolean isEmpty() {
    return false;
  }

  // Calculates the size of this empty list of vectors.
  public int size() {
    return this.rest.size() + 1;
  }

  // Get the initial point of this list of vectors.
  public PVector initFP() {
    if (this.rest.isEmpty()) {
      return this.loc;
    }
    else return this.rest.initFP();
  }

  // Is this list of vectors closed?
  public boolean isClosed() {
    if (this.size() < 3)
      return false;
    else {
      return this.loc.x + 5 >= this.initFP().x 
        && this.loc.x - 5 <= this.initFP().x
        && this.loc.y + 5 >= this.initFP().y
        && this.loc.y - 5 <= this.initFP().y;
    }
  }

  // Gets the next point of this list of vectors.
  public PVector nextFP() {
    if (this.rest.isEmpty())
      return this.loc;
    else {
      FunPoint rest = (FunPoint) this.rest;
      return rest.loc;
    }
  }

  // Displays the points.
  public void display() {
    this.parent.fill(0);
    this.parent.ellipse(this.loc.x, this.loc.y, 5, 5);
    this.rest.display();
  }
}

