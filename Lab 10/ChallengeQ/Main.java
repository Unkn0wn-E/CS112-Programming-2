import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{
    Rectangle rect;

    @Override
    public void start (Stage stage){
        stage.setTitle("Resizable Rectangle");
        stage.setWidth(500);
        stage.setHeight(300);
        
        rect = new Rectangle(stage.getWidth()/1.2, stage.getHeight()/3);
        rect.setFill(Color.RED);
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(rect);
        
        Scene scene = new Scene(stackPane);
        
        stage.widthProperty().addListener((a,b,c)->{
            rect.setWidth(c.intValue()/1.2);
        });
        
        stage.heightProperty().addListener((a,b,c)->{
           rect.setHeight(c.intValue()/3); 
        });
        
        stage.setScene(scene);
        stage.show();
                
    }
    
    public static void main(String[] args){
        launch(args);
    }
}