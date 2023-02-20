## Exercise GraphicEditor


First develop the class diagram of a hierarchical graphic editor that manipulates graphic elements: points, lines, squares, rectangles, circles, and ellipses. The meaning of hierarchical is that a special graphic element, namely a group, can contain graphic elements but also groups of graphic elements. Include in the class diagram the relevant methods to draw, move, resize, etc the graphic elements.

Develop an object diagram with various objects that illustrates the hierarchical aspects.

For the above object diagram, develop a sequence diagram that draws/moves all the graphic elements.

Develop the implementation of the various classes.

Where occurs polymorphism ?


---

To generate this site, go into the root directory of the project (where the `pom.xml` file is) and then type:

> `mvn clean site`

You'll find the generated site `index.html` in the `target/site` directory.

To compile and test your source code, still in the root directory, type:

> `mvn clean package`

To execute the `main` function (if any), type:

> `mvn exec:java`
