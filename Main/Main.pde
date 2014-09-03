String instructions = "Click on the button below to get started!";
String howtoplay = "How To Play:";
String howto = "To play, simply click around at least three times to create a new shape."
+ "\n"
+ "You can click as many times as you'd like, but just make sure that you"
+ "\n"
+ "close the current shape before trying to create a new shape!"
+ "\n"
+ "\n"
+ "Closing a shape is done by making at least 3 clicks, where the last click is"
+ "\n"
+ "on the initial click that was made."
+ "\n"
+ "\n"
+ "To draw special points, press and hold the 's' key while pressing the mouse."
+ "\n"
+ "\n"
+ "To draw a green point, press and hold the 'a' key while pressing the mouse."
+ "\n"
+ "\n"
+ "To draw a colored line, press and hold the 'c' key when making a new point."
+ "\n"
+ "\n"
+ "To clear any shapes you've drawn, press the 'r' key."
+ "\n"
+ "\n"
+ "To quit the program, press the 'q' key.";
String havefun = "\nHave fun!";
// The number of mouseclicks.
int count;
PShape shape;
// Creates a variable for empty lists of vectors.
LoVec empty = new EmptyLoVec();
// Sets the list of vectors to empty.
LoVec fpn = empty;
// Makes a boolean variable that determines if a shape created by a list of vectors is closed.
boolean closed = fpn.isClosed();
// A PFont variable that will be set to the Apple Casual font.
PFont appcas;
// A PShape variable that will be set to the arrow image.
PShape arrow;
// Values of the start buttons' boundaries.
float ex1, ex2, ey1, ey2;
// Values of the arrow's boundaries.
float ax1, ax2, ay1, ay2;


void setup() {
  size(1000, 720, P2D);
  background(255);
  // Loads the Apple Casual font.
  appcas = loadFont("AppleCasual-48.vlw");
  fill(#2CB400);
  textFont(appcas, 40);
  text(instructions, 165, 320);
  fill(0);
  ellipse(500, 380, 80, 80);
  fill(255);
  ellipse(500, 380, 60, 60);
  fill(255, 20, 20);
  ellipse(500, 380, 50, 50);
  // Loads the arrow image as a PShape.
  arrow = loadShape("Arrow.svg");
  // Sets the number of mouseclicks to 0.
  count = 0;
}

void draw() {
  // Calculated values of the start button boundaries.
  ex1 = 462.5;
  ex2 = 537.5;
  ey1 = 342.5;
  ey2 = 417.5;
  // Calculated values of the arrow boundaries.
  ax1 = 550;
  ax2 = 1000;
  ay1 = 430;
  ay2 = 720;

  // The start screen. If the user clicks on anything that is not the
  // start button, the program will remain on the start screen.  Use the
  // restart button to wipe the screen.
  if (mousePressed
    && ex1 <= mouseX && mouseX <= ex2
    && ey1 <= mouseY && mouseY <= ey2
    && count < 2) {
    background(255);
    fill(#439DF5);
    textFont(appcas, 60);
    text(howtoplay, 300, 50);
    fill(#B67CD3);
    textFont(appcas, 30);
    text(howto, 20, 105);
    fill(#F05E61);
    textFont(appcas, 70);
    text(havefun, 330, 620);
    shape(arrow, 700, 530, 270, 130);
  }

  // The instructions screen.  If the user clicks on anything that is not
  // the 'next' arrow more than twice, the program will remain on the instructions
  // screen.  Use the restart button to wipe the screen.
  if (mousePressed
    && ax1 <= mouseX && mouseX <= ax2
    && ay1 <= mouseY && mouseY <= ay2
    && count <= 4) {
    background(255);
    count = 6;
  }

  // Make a new starting point.
  // NOTE: Do not drag the mouse when creating a new shape. You can actually, but it
  // will look silly.  This is because dragging the mouse counts as a single mouseclick.
  if (mousePressed && count == 7) {
    fpn = fpn.add(new PVector(mouseX, mouseY));
    fpn.drawLines(fpn.nextFP());
    shape = createShape();
    shape.beginShape();
    shape.vertex(mouseX, mouseY);
    fpn.display();
  }

  // Keep creating verticies for the shape.
  if (count >= 7 && mousePressed) {
    fpn = fpn.add(new PVector(mouseX, mouseY));
    shape.vertex(mouseX, mouseY);
    fpn.drawLines(fpn.nextFP());
  }

  // Automatically close a shape with the point simultaneously created.
  if (count > 9 && keyPressed && key == 's' && mousePressed) {
    ExtraPoint spn = new SpecialPoint(new PVector(mouseX, mouseY));
    fpn = fpn.add(new PVector(mouseX, mouseY));
    fpn = fpn.add(new PVector(fpn.initFP().x, fpn.initFP().y));
    spn.drawLines(fpn.initFP());
    spn.drawLines(fpn.nextFP());
    spn.display();
  }

  // If 3 or more clicks have been made and the shape is closed, 
  // fill the shape with a random color.
  if (count > 9 && mousePressed && fpn.size() > 3) {
    if (fpn.isClosed()) {
      shape.vertex(mouseX, mouseY);
      shape.vertex(fpn.initFP().x, fpn.initFP().y);
      fill(random(255), random(255), random(255), 0);
      shape.endShape();
      shape.setFill(color(random(255), random(255), random(255), 255));
      fill(random(255), random(255), random(255), 0);
      shape(shape);
      fpn = empty;
      count = 6;
    }
  }

  // If "c" is pressed, make the line drawn between the clicked point
  // and the previous point a random color.
  if (count > 7 && keyPressed && key == 'c' && mousePressed) {
    fpn.drawColorLines(fpn.nextFP());
  }

  // If "a" is pressed, make the point clicked a green ellipse.
  if (count > 7 && keyPressed && key == 'a' && mousePressed) {
    ExtraPoint cpn = new ColoredPoint(new PVector(mouseX, mouseY));
    cpn.drawLines(fpn.nextFP());
    fpn.add(new PVector(mouseX, mouseY));
    shape.vertex(mouseX, mouseY);
    cpn.display();
  }

  // Wipes the screen when the 'r' button is pressed.
  if (keyPressed && key == 'r') {
    background(255);
    fpn = empty;
    count = 7;
  }

  // If "q" is pressed, quit the program.
  if (keyPressed && key == 'q') {
    exit();
  }
}

// If the mouse is clicked, increase the counter of mouseclicks by one.
void mouseClicked() {
  count++;
}
