Project 2 READ ME
Jesse Oberstein
IM 2250 Programming for Digital Media
WF 11:45am - 1:25pm


Instructions for running Project 2:

	- NOTE 1: If anything other than the start button is clicked when the program is initially run,
		the user may experience some errors within the program, and will have to restart it.
	- NOTE 2: Since events happen on both mousePressed and mouseClicked(), click and
		dragging the mouse will not allow the user to create a new vertex; this action simply
		creates adds one mouse click to the counter and then keeps the counter at that number
		until the mouse is released and clicked again.
	- DURATION: As long as the user would like the program to last.

	1.	Click the run button in Processing.
	2.	Click the on-screen start button.
	3.	Read the instructions, and then click anywhere to go to start creating things.
	4.	Click normally to create vertices.
	5.	Once at least 3 vertices are created, click on the original to close a shape, or press and
		hold the "s" button to automatically close a shape.
	6.	Closed shapes will automatically fill with a random color!
	7. 	Press and hold the "a" key to draw green vertices when creating a shape.
	8.	Press and hold the "c" key to draw randomly colored lines when creating a shape.
	9.	Press the "r" key to reset the canvas.
	10.	Press the "q" key to quit the program.


Problems that came up during the process:
	•	Getting the user-created shapes to become PShapes.
	•	I struggled with getting mousePressed variable to work because I tried to use it as a counter, but I ultimately
	triumphed by incrementing the counter of mouse clicks in the mouseClicked() method.
	Problems that I had because of only using the mousePressed variable:
	⁃	Only some of the time, new shapes were created from the last vertex of the previous shape when the "s" key is used to close a shape.  New shapes are meant to be created independently from other shapes, and should not be tied to them in any way. 
	⁃	I had a problem with single dots not connecting to shapes being made.
	•	Initially ran into trouble with extending class, but I figured it out in the end.  I tried to extend the
		SpecialPoint classes as a subclass of FunPoint, but I didn't want it to inherit all the fields of a 
		FunPoint, or be a list of vectors.  So the current implementation works best.


