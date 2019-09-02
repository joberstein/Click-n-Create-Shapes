import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PShape;
import processing.core.PVector;
import utils.ColorUtils;

import java.awt.*;

public class Application extends PApplet {

    private String instructions = "Click on the button below to get started!";
    private String howtoplay = "How To Play:";
    private String howto = "To play, simply click around at least three times to create a new shape."
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

    private String havefun = "\nHave fun!";

    // A PFont variable that will be set to the Apple Casual font.
    private PFont appcas;

    // Loads the arrow image as a PShape.
    private PShape arrow;

    // The button on the start page, used to navigate to the instructions page.
    private Button startButton = new Button(this, 500, 380, 50, 50, color(255, 20, 20), "ellipse");

    // The button on the instructions page, used to navigate to the game page.
    private Button arrowButton = new Button(this, 700, 530, 270, 130, color(255), "shape");

    // Keeps track of the number of pages visited.
    private int page;

    // A shape defined by user clicks.
    private PShape shape;

    // Creates a variable for empty lists of vectors.
    private LoVec empty = new EmptyLoVec(this);

    // Sets the list of vectors to empty.
    private LoVec fpn = empty;

    // Makes a boolean variable that determines if a shape created by a list of vectors is closed.
    boolean closed = fpn.isClosed();

    public static void main(String[] args) {
        PApplet.main("Application");
    }

    public void setup() {
        appcas = loadFont("AppleCasual-48.vlw");
        arrow = loadShape("Arrow.svg");
        displayStartPage();
    }

    public void settings() {
        size(1000, 720, P2D);
    }

    // Displays the start page.
    private void displayStartPage() {
        background(255);
        fill(ColorUtils.getRGB("#2CB400"));
        textFont(appcas, 40);
        text(instructions, 165, 320);
        fill(0);
        ellipse(500, 380, 80, 80);
        fill(255);
        ellipse(500, 380, 60, 60);
        startButton.displayButton(null);
        page = 0;
    }


    // Displays the instructions page.
    private void displayInstructionsPage() {
        background(255);
        fill(ColorUtils.getRGB("#439DF5"));
        textFont(appcas, 60);
        text(howtoplay, 300, 50);
        fill(ColorUtils.getRGB("#B67CD3"));
        textFont(appcas, 30);
        text(howto, 20, 105);
        fill(ColorUtils.getRGB("#F05E61"));
        textFont(appcas, 70);
        text(havefun, 330, 620);
        arrowButton.displayButton(arrow);
        page = 1;
    }


    // Displays a blank page to start the game.
    private void displayGamePage() {
        background(255);
        fpn = empty;
        page = 2;
    }


    // Make a new starting point.
    private void createStartingVertex() {
        fpn = fpn.add(new PVector(mouseX, mouseY));
        fpn.drawLines(fpn.nextFP());
        shape = createShape();
        shape.beginShape();
        shape.vertex(mouseX, mouseY);
        fpn.display();
    }


    // Keep creating verticies for the shape and connect them.
    private void connectVertices() {
        fpn = fpn.add(new PVector(mouseX, mouseY));
        shape.vertex(mouseX, mouseY);
        fpn.drawLines(fpn.nextFP());
    }


    // If "a" is held down, make the point clicked a green vertex.
    private void createGreenVertex() {
        ExtraPoint cpn = new ColoredPoint(this, new PVector(mouseX, mouseY));
        cpn.drawLines(fpn.nextFP());
        fpn.add(new PVector(mouseX, mouseY));
        shape.vertex(mouseX, mouseY);
        cpn.display();
    }


    // If "s" is held down, close the current shape from this new point.
    private void automaticClose() {
        ExtraPoint spn = new SpecialPoint(this, new PVector(mouseX, mouseY));
        fpn = fpn.add(new PVector(mouseX, mouseY));
        fpn = fpn.add(new PVector(fpn.initFP().x, fpn.initFP().y));
        spn.drawLines(fpn.initFP());
        spn.drawLines(fpn.nextFP());
        spn.display();
    }


    // If the shape has at least 3 vertices and the user has closed
    // the shape, fill it with a random color.
    private void closeShape() {
        if (fpn.isClosed()) {
            shape.vertex(mouseX, mouseY);
            shape.vertex(fpn.initFP().x, fpn.initFP().y);
            fill(random(255), random(255), random(255), 0);
            shape.endShape();
            shape.setFill(color(random(255), random(255), random(255), 255));
            fill(random(255), random(255), random(255), 0);
            shape(shape);
            fpn = empty;
        }
    }


    // Run the shape creation game.
    private void startGame() {
        if (fpn.size() == 0) {
            createStartingVertex();
        }
        if (fpn.size() > 0) {
            connectVertices();
        }
        // If "c" is held down, make the line drawn between the clicked point
        // and the previous point a random color.
        if (fpn.size() > 1 && keyPressed && key == 'c') {
            fpn.drawColorLines(fpn.nextFP());
        }
        if (fpn.size() > 1 && keyPressed && key == 'a') {
            createGreenVertex();
        }
        if (fpn.size() > 3 && keyPressed && key == 's') {
            automaticClose();
        }
        if (fpn.size() > 3) {
            closeShape();
        }
    }


    public void draw() {
        // Wipes the screen when the 'r' button is pressed.
        if (keyPressed && key == 'r') {
            displayGamePage();
        }

        // If "q" is pressed, quit the program.
        if (keyPressed && key == 'q') {
            exit();
        }
    }


    public void mouseClicked() {
        if (startButton.onButton() && page == 0) {
            displayInstructionsPage();
        }
        else if (arrowButton.onButton() && page == 1) {
            displayGamePage();
        }
        else if (page == 2) {
            startGame();
        }
    }
}
