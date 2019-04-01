import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;

import java.util.Random;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation.Status;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.paint.*;
import javafx.util.Duration;

public class Main extends Application {

    Bounds bounds;
    Pane pane;
    Stage stage;
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Ball");
        stage.setResizable(true);
        stage.setWidth(500);
        stage.setHeight(600);
        
        pane = new Pane();
        pane.setPrefSize(stage.getWidth(), stage.getHeight());
        CircleBounce circleB = new CircleBounce();
        Circle c1 = circleB.makeCircle(50, Color.BLACK, 50, 50);
        
        HBox hBox = new HBox(10);
        hBox.layoutXProperty().bind(stage.widthProperty().subtract(hBox.widthProperty()).divide(2));
        hBox.layoutYProperty().bind(stage.heightProperty().subtract(100));
        
        Button rightBtn = new Button("Right");
        rightBtn.setOnAction(e -> {
            circleB.moveX_right(15);
        });
        
        Button stopBtn = new Button("Stop");
        stopBtn.setOnAction(e -> {
            if (circleB.isRunning()) {
                circleB.stop();
                return;
            }
            circleB.draw();
        });
        
        Button leftBtn = new Button("Left");
        leftBtn.setOnAction(e -> {
            circleB.moveX_left(15);
        });
        
        hBox.getChildren().addAll(leftBtn, stopBtn, rightBtn);
        pane.getChildren().addAll(c1, hBox);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
        circleB.draw();
        
    }

    class CircleBounce {
        private Circle circle;
        Timeline timeLine;
        

        public Circle makeCircle(double radius, Paint fill, double xStart, double yStart) {
            circle = new Circle(radius, fill);
            circle.setLayoutX(xStart);
            circle.setLayoutY(yStart);

            bounds = pane.getBoundsInLocal();
            timeLine = new Timeline(new KeyFrame(Duration.millis(25), event));
            timeLine.setCycleCount(Animation.INDEFINITE);

            return circle;
        }

        public void draw() {
            timeLine.play();
        }

        public void stop() {
            timeLine.pause();
        }

        public boolean isRunning() {
            return timeLine.getStatus().equals(Status.RUNNING);
        }
        
        public void moveX_right(double x){
            if(circle.getLayoutX() >= bounds.getMaxX() - circle.getRadius())return;
            circle.setLayoutX(circle.getLayoutX() + x);
        }
        
        public void moveX_left(double x){
            if(circle.getLayoutX() <= bounds.getMinX() + circle.getRadius())return;
            circle.setLayoutX(circle.getLayoutX() - x);
        }
        
        Stop[] stop = {
            new Stop(0.125, Color.rgb( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255) )),
            new Stop(0.25, Color.rgb( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255) )),
            new Stop(0.375, Color.rgb( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255) )),
            new Stop(0.42, Color.rgb( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255) )),
            new Stop(0.59, Color.rgb( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255) )),
            new Stop(0.67, Color.rgb( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255) )),
            new Stop(0.89, Color.rgb( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255) )),
            new Stop(1, Color.rgb( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255) )),
        };
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            private int x = 3;
            private int y = 5;
            LinearGradient linearGradient = new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.REPEAT, stop);
            @Override
            public void handle(ActionEvent e) {
                circle.setLayoutX(circle.getLayoutX() + x);
                circle.setLayoutY(circle.getLayoutY() + y);
                circle.setFill(linearGradient);
                bounds = pane.getBoundsInLocal();

                if ( (circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius()) || circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius()))) {
                    x *= -1;
                }
                if ( (circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius()) || circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius())) ) {
                    y *= -1;
                }
              
                
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}