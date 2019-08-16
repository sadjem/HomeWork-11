import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();
    private int index = 0;

    public Board(GraphicsContext gc) {
        this.gc = gc;
        shapes.add(new Ball(gc, 300, 300, shapes, 50));
        shapes.add(new Square(gc, 50, 50, shapes, 50));
    }

    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void nextFigure() {
        index++;
        if (index >= shapes.size()) {
            index = 0;
        }
    }

    public void previousFigure() {
        index--;
        if (index < 0) {
            index = shapes.size() - 1;
        }
    }

    public void keyPressed(KeyEvent event) {
        gc.clearRect(0, 0, gc.getCanvas().getHeight(), gc.getCanvas().getWidth());
        Shape shape = shapes.get(index);
        if (event.getCode() == KeyCode.RIGHT) {
            shape.moveRight();
        }
        if (event.getCode() == KeyCode.LEFT) {
            shape.moveLeft();
        }
        if (event.getCode() == KeyCode.UP) {
            shape.moveUp();
        }
        if (event.getCode() == KeyCode.DOWN) {
            shape.moveDown();
        }
        if (event.getCode() == KeyCode.Q) {
            shape.increaseSizeFigure();
        }
        if (event.getCode() == KeyCode.W) {
            shape.decreaseSizeFigure();
        }
        if (event.getCode() == KeyCode.PAGE_DOWN) {
            nextFigure();
        }
        if (event.getCode() == KeyCode.PAGE_UP) {
            previousFigure();
        }
        if (event.getCode() == KeyCode.E) {
            shapes.add(new Ball(gc, 50, 70, shapes, 70));
        }
        if(event.getCode() == KeyCode.R){
            shapes.add(new Square(gc,100,170,shapes,50));
        }
        if (event.getCode() == KeyCode.G) {
            groupFigure();
        }
        if (event.getCode() == KeyCode.DELETE) {
            shapes.remove(index);
        }
        draw();
    }

    private void groupFigure() {
        Shape shape1 = shapes.get(index);
        Shape shape2 = shapes.get(index - 1);
        Group group = new Group();
        group.addShape(shape1, shape2);
        shapes.remove(shape1);
        shapes.remove(shape2);
        shapes.add(group);
        index = shapes.size() - 1;
    }

    public void save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String output = gson.toJson(shapes);
        try {
            saveToFile(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile(String output) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("test.txt")))) {
            writer.write(output);
        }

    }
}
