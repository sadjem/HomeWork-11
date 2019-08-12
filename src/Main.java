import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static int BOARD_HEIGHT = 500;
    private static int BOARD_WIDTH = 500;
    private boolean closed = false;
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simple Game");
        Canvas canvas = new Canvas();
        canvas.setHeight(BOARD_HEIGHT);
        canvas.setWidth(BOARD_WIDTH);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        board = new Board(gc);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                gc.clearRect(0, 0, BOARD_HEIGHT, BOARD_WIDTH);
                if (event.getCode() == KeyCode.RIGHT) {
                    board.moveRight();
                }
                if (event.getCode() == KeyCode.LEFT) {
                    board.moveLeft();
                }
                if (event.getCode() == KeyCode.UP) {
                    board.moveUp();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    board.moveDown();
                }
                if(event.getCode() == KeyCode.Q){
                    board.increaseFigure();
                }
                board.draw();
            }
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        closed = true;
    }
}