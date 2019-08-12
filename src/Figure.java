import javafx.scene.canvas.GraphicsContext;
import java.util.List;

public abstract class Figure implements Shape {
    protected GraphicsContext gc;
    protected double diameter;
    protected double x;
    protected double y;
    protected List<Shape> shapes;
    private  int STEP = 5;
    private int increaseFactor = 2;

    public Figure(GraphicsContext gc, double x, double y, List<Shape> shapes) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.shapes = shapes;
    }

    @Override
    public void moveRight() {
        x += STEP;
    }

    @Override
    public void moveLeft() {
        x -= STEP;
    }

    @Override
    public void moveUp() {
        y += STEP;
    }

    @Override
    public void moveDown() {
        y -= STEP;
    }


    public void increaseFigure () {
        diameter = diameter *increaseFactor;
    }
    @Override
    public abstract void draw();
}
