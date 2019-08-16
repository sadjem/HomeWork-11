import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.List;

public class Triangle extends Figure {

    public Triangle(GraphicsContext gc, double x, double y, List<Shape> shapes, double diameter) {
        super(gc, x, y, shapes, diameter);
    }

    @Override
    public void draw() {
        gc.setFill(Color.GREEN);
        gc.fillPolygon(new double[]{x + diameter / 2, x + diameter, x}, new double[]{y, y + diameter, y + diameter}, 3);
    }
}
