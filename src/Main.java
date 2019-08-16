import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/*
    1. Можно добавить не менее 3 типов фигур +
    2. У выбранной фигуры можно менять размер и двигать ее +
    3. Фигуру можно удалить +
    4. Фигуры можно объеденять в группы (агрегация) и клонировать +-
    5. Реализовать сохранение/загрузку состояния в файл -

    LEFT - move left;
    RIGHT = move right;
    UP - move up;
    DOWN - move down;
    Q - increase size figure;
    W - decrease size figure;
    PAGE_UP, PAGE_DOWN - change figure;
    E,R,T = add Ball, Square, Triangle;
    G - create group from 2 last figures;
    DELETE - delete figure or group.
 */
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
        board.draw();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                board.keyPressed(event);
            }
        });
      //  board.save();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        closed = true;
    }
}
