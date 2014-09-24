// Creates a button according to the specified parameters.
public class Button {
  private int x;
  private int y;
  private int len;
  private int high;
  private color col;
  private String type;
  
  Button(int x, int y, int len, int high, color col, String type) {
    this.x = x;
    this.y = y;
    this.len = len;
    this.high = high;
    this.col = col;
    this.type = type;
  }
  
  // Displays this button. Displays a shape as this button if the given argument is a PShape.
  public void displayButton(PShape shape) {
    if (this.type == "rectangle") {
      fill(this.col);
      rect(this.x, this.y, this.len, this.high);
    }
    else if (this.type == "ellipse") {
      fill(this.col);
      ellipse(this.x, this.y, this.len, this.high);
    }
    else if (this.type == "shape") {
      shape(shape, this.x, this.y, this.len, this.high);
    } 
  }
  
  // Is the mouse hovering over this button?
  public boolean onButton() {
    return mouseX >= (this.x - (this.len / 2))
        && mouseX <= (this.x + this.len)
        && mouseY >= (this.y - (this.high / 2))
        && mouseY <= (this.y + this.high);
  }
}
