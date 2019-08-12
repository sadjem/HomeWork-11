import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Ball extends Figure {

    public Ball(GraphicsContext gc, double x, double y, List<Shape> shapes) {
        super(gc, x, y, shapes);
    }

    public void draw() {
        diameter = 50;
        gc.setFill(Color.RED);
        gc.fillOval(x, y, diameter, diameter);
    }
}
