import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;
        shapes.add(new Ball(gc, 300, 300, shapes,50));
        shapes.add(new Square(gc, 50, 50, shapes, 50));
    }

    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void moveRight() {
        for (Shape shape : shapes) {
            shape.moveRight();
        }
    }

    public void moveLeft() {
        for (Shape shape : shapes) {
            shape.moveLeft();
        }
    }

    public void moveUp() {
        for (Shape shape : shapes) {
            shape.moveUp();
        }
    }

    public void moveDown() {
        for (Shape shape : shapes) {
            shape.moveDown();
        }
    }

    public void increaseSizeFigure() {
        for (Shape shape : shapes) {
            shape.increaseSizeFigure();
        }
    }

    public void decreaseSizeFigure() {
        for(Shape shape : shapes){
            shape.decreaseSizeFigure();
        }
    }
}
