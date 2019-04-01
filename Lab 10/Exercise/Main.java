import java.util.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Main extends Application {
    private Stage stage;

    private GridPane gPane;
    private final double sizeOfTile = 150;
    private HashMap<Pane, String> tile_index = new HashMap<>();

    String[][] win = { 
        { "00", "01", "02" },
        { "10", "11", "12" },
        { "20", "21", "22" },
        { "00", "10", "20" },
        { "01", "11", "21" },
        { "02", "12", "22" },
        { "02", "11", "20" },
        { "00", "11", "22" }
    };

    private int round = 0; // if round = 9 then the game is over

    private boolean xTurn = false;
    private boolean oTurn = true;
    private int xWins = 0;
    private int oWins = 0;
    
    private boolean stopGame = false;

    private ArrayList<String> x_Loc = new ArrayList<>();
    private ArrayList<String> o_Loc = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        primaryStage.setTitle("(X) " + xWins + " - " + oWins + " (O)");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        primaryStage.setWidth(458);
        primaryStage.setHeight(482);
        primaryStage.setResizable(false);

        Scene scene = new Scene(makeBoard());
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // Tile class //
    class Tile {
        boolean isFilled = false;
        String index = "";

        public Tile(String index) {
            this.index = index;
        }

        public StackPane getTile() {
            Rectangle rect = new Rectangle(sizeOfTile, sizeOfTile);
            rect.setFill(Color.TRANSPARENT);
            rect.setStroke(Color.web("#629ACC"));

            Shape shapeX = getX();
            shapeX.setVisible(false);
            Shape shapeO = getO();
            shapeO.setVisible(false);

            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(rect, shapeO, shapeX);
            tile_index.put(stackPane, index);

            stackPane.setOnMouseClicked(e -> {
                if (isFilled) return; // if the tile already filled then do nothing
                if (stopGame) return; 

                if (xTurn) {
                    round++;
                    x_Loc.add(tile_index.get(stackPane));

                    if (round >= 4) {
                        if (isWin(x_Loc)) {
                            stopGame = true;
                            xWins++;
                            stage.setTitle("(X) " + xWins + " - " + oWins + " (O)");
                        }
                    }

                    shapeX.setVisible(true);
                    xTurn = false;
                    oTurn = true;
                    isFilled = true;
                } else if (oTurn) {
                    round++;
                    o_Loc.add(tile_index.get(stackPane));

                    if (round >= 4) {
                        if (isWin(o_Loc)) {
                            stopGame = true;
                            oWins++;
                            stage.setTitle("(X) " + xWins + " - " + oWins + " (O)");
                        }
                    }

                    shapeO.setVisible(true);
                    oTurn = false;
                    xTurn = true;
                    isFilled = true;
                }

            });

            return stackPane;
        }
    }

    // Create The Board //
    private GridPane makeBoard() {
        gPane = new GridPane();
        gPane.setPrefHeight(stage.getHeight());
        gPane.setPrefWidth(stage.getWidth());
        for (int i = 0; i < 3; i++) { // col
            for (int j = 0; j < 3; j++) { // row
                StackPane tile = new Tile(i + "" + j).getTile();
                gPane.add(tile, j, i);
                GridPane.setHgrow(tile, Priority.ALWAYS);
                GridPane.setVgrow(tile, Priority.ALWAYS);
            }
        }

        return gPane;
    }

    // Logic //
    private boolean isWin(ArrayList<String> arr) {
        int threeCheck = 0;
        ArrayList<String> winnerLoc = new ArrayList<>();

        for (int i = 0; i < win.length; i++) {
            for (int j = 0; j < win[i].length; j++) {

                for (int k = 0; k < arr.size(); k++) {
                    if (win[i][j].equals(arr.get(k))) {
                        threeCheck++;
                        winnerLoc.add(arr.get(k));
                        break;
                    }
                }

            }

            if (threeCheck == 3) { // if someone win
                ArrayList<Pane> p = new ArrayList<>();
                for (String value : winnerLoc) {
                    for (Map.Entry<Pane, String> k : tile_index.entrySet()) {
                        if (k.getValue().equalsIgnoreCase(value)) {
                            p.add(k.getKey());
                        }
                    }
                }

                winnerAnimation(p);

                return true;
            } else {
                winnerLoc.clear();
                threeCheck = 0;
            }
        }

        if (round == 9) restartAnimation();; // if no one win

        return false;
    }

    // Restart the Game //
    private void restart() {
        stopGame = true;
        x_Loc.clear();
        o_Loc.clear();
        tile_index.clear();

        stage.setScene(new Scene(makeBoard()));
        round = 0;
        stopGame = false;
    }

    // Animation //
    private void winnerAnimation(ArrayList<Pane> winnerLoc) {
        ParallelTransition allAni = new ParallelTransition();

        for (Pane i : winnerLoc) {
            for (Node n : i.getChildren()) {
                if (n instanceof Rectangle) continue; // skip animate the rectangle
                
                FadeTransition transition = new FadeTransition();
                transition.setDuration(Duration.millis(new Random().nextInt(100) + 300));
                transition.setFromValue(1);
                transition.setToValue(0.2);
                transition.setAutoReverse(true);
                transition.setCycleCount(5);
                transition.setNode(n);
                allAni.getChildren().add(transition);
            }
        }

        allAni.play();
        allAni.setOnFinished(e -> {
            restart();
        });

    }

    private void restartAnimation() {
        ParallelTransition ani = new ParallelTransition();

        for (Map.Entry<Pane, String> k : tile_index.entrySet()) {
            for (Node n : k.getKey().getChildren()) {
                if (n instanceof Rectangle) continue;

                FadeTransition ft = new FadeTransition();
                ft.setDuration(Duration.millis(new Random().nextInt(100) + 300));
                ft.setFromValue(1);
                ft.setToValue(0.1);
                ft.setCycleCount(5);
                ft.setNode(n);
                ani.getChildren().add(ft);
            }
        }
        
        ani.setAutoReverse(true);
        ani.play();
        ani.setOnFinished(e -> {
            restart();
        });
        
    }

    // shapes //
    private Shape getX() {
        Line line1 = new Line(0, 0, 100, 100);
        line1.setFill(Color.BLACK);
        line1.setStrokeWidth(6);
        Line line2 = new Line(100, 0, 0, 100);
        line2.setFill(Color.BLACK);
        line2.setStrokeWidth(6);

        Shape shapeX = Shape.union(line1, line2);
        shapeX.setFill(Color.web("#E94141"));

        return shapeX;
    }

    private Shape getO() {
        Circle circle = new Circle(60);
        circle.setStroke(Color.web("#0086F4"));
        circle.setStrokeWidth(6);
        circle.setFill(Color.WHITE);

        return circle;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
