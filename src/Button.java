import processing.core.PApplet;
import processing.core.PShape;

// Creates a button according to the specified parameters.
public class Button {
  private PApplet parent;
  private int x;
  private int y;
  private int len;
  private int high;
  private int col;
  private String type;
  
  Button(PApplet parent, int x, int y, int len, int high, int col, String type) {
    this.parent = parent;
    this.x = x;
    this.y = y;
    this.len = len;
    this.high = high;
    this.col = col;
    this.type = type;
  }
  
  // Displays this button. Displays a shape as this button if the given argument is a PShape.
  void displayButton(PShape shape) {
    switch (this.type) {
      case "rectangle":
        this.parent.fill(this.col);
        this.parent.rect(this.x, this.y, this.len, this.high);
        break;
      case "ellipse":
        this.parent.fill(this.col);
        this.parent.ellipse(this.x, this.y, this.len, this.high);
        break;
      case "shape":
        this.parent.shape(shape, this.x, this.y, this.len, this.high);
        break;
    }
  }
  
  // Is the mouse hovering over this button?
  boolean onButton() {
    return this.parent.mouseX >= (this.x - (this.len / 2))
        && this.parent.mouseX <= (this.x + this.len)
        && this.parent.mouseY >= (this.y - (this.high / 2))
        && this.parent.mouseY <= (this.y + this.high);
  }
}
