import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Square extends Figure {

    public Square(GraphicsContext gc, double x, double y, List<Shape> shapes, double diameter) {
        super(gc, x, y, shapes, diameter);
    }

    @Override
    public void draw() {
        gc.setFill(Color.ORANGE);
        gc.fillRect(x, y, diameter, diameter);
    }
}
