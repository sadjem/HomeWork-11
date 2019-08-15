import java.util.ArrayList;
import java.util.List;

public class Group  implements Shape{
    private List<Shape> shapes = new ArrayList<>();
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

    @Override
    public void draw() {
        for(Shape shape : shapes){
            shape.draw();
        }
    }

    public void increaseSizeFigure() {
        for (Shape shape : shapes) {
            shape.increaseSizeFigure();
        }
    }

    public void decreaseSizeFigure() {
        for (Shape shape : shapes) {
            shape.decreaseSizeFigure();
        }
    }

    public void addShape(Shape shape1, Shape shape2) {
        shapes.add(shape1);
        shapes.add(shape2);
    }
}
