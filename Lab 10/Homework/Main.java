import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    int click = 0;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Display Flags");
        stage.setWidth(500);
        stage.setHeight(600);
        
        ArrayList<Image> flags = new ArrayList<>();
        double imgSize = (stage.getWidth() / 5) + 5;

        for (int i = 1; i <= 10; i++) {
            flags.add(new Image(getClass().getResourceAsStream("Images/" + i + ".png")));
        }

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        
        GridPane gPane = new GridPane();
        gPane.setPadding(new Insets(50));
        gPane.setAlignment(Pos.CENTER);
        gPane.setVgap(20);
        gPane.setHgap(20);

        ArrayList<Pane> panes = new ArrayList<>();
        panes.add(hBox);
        panes.add(vBox);
        panes.add(gPane);

        for (int i = 0; i < panes.size(); i++) {
            if(panes.get(i) instanceof GridPane)continue;
            ArrayList<Integer> ranList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                int ranNum = new Random().nextInt(flags.size());
                for (int k = 0; k < ranList.size(); k++) {
                    if (ranList.get(k).equals(ranNum)) {
                        ranNum = new Random().nextInt(flags.size());
                        k = 0;
                    }
                }
                ranList.add(ranNum);

                ImageView iView = new ImageView();
                iView.setImage(flags.get(ranNum));
                iView.setFitWidth(imgSize);
                iView.setFitHeight(imgSize);
                panes.get(i).getChildren().add(iView);
            }
            
        }
        
        ArrayList<Integer> ranList = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                int ranNum = new Random().nextInt(flags.size());
                for (int k = 0; k < ranList.size(); k++) {
                    if (ranList.get(k).equals(ranNum)) {
                        ranNum = new Random().nextInt(flags.size());
                        k = 0;
                    }
                }
                ranList.add(ranNum);
                
                ImageView iView = new ImageView();
                iView.setImage(flags.get(ranNum));
                iView.setFitWidth(imgSize);
                iView.setFitHeight(imgSize);
                
                gPane.add(iView, i, j);
            }
        }

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        Button btn1 = new Button("Change layout");

        root.getChildren().add(btn1);

        btn1.setOnMouseClicked(e -> {
            click++;
            Pane p1 = panes.get(new Random().nextInt(panes.size()));
            
            while(p1.hashCode() == root.getChildren().get(root.getChildren().size()-1).hashCode() ){
                p1 = panes.get(new Random().nextInt(panes.size()));
            }
            
            if (click > 1) {
                root.getChildren().remove(root.getChildren().size() - 1);
            }
            root.getChildren().add(p1);
            
        });

        click++; // lazy... :Z
        root.getChildren().add(panes.get(new Random().nextInt(panes.size())));
        
        Scene scene = new Scene(root);

        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}