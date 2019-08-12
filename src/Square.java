import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Square extends Figure {

    public Square(GraphicsContext gc, double x, double y, List<Shape> shapes) {
        super(gc, x, y, shapes);
    }

    @Override
    public void draw() {
        diameter = 30;
        gc.setFill(Color.ORANGE);
        gc.fillRect(x, y, diameter, diameter);
    }
}
