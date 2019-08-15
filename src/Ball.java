import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Ball extends Figure {

    public Ball(GraphicsContext gc, double x, double y, List<Shape> shapes, double diameter) {
        super(gc, x, y, shapes, diameter);
    }

    public void draw() {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, diameter, diameter);
    }
}
