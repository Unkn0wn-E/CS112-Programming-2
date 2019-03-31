import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * Colors used:
 * Red: #fa7268
 * Green: #68fa72
 * Yellow: #fee96f
*/
public class Main extends Application {
    private File txtFile = new File("emp3.txt");
    private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private boolean idVali, nameVali, birthVali;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        primaryStage.setTitle("Employee information!");
        primaryStage.setResizable(false);
        
        format.setLenient(false);
        
        // Add GridPane //
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setAlignment(Pos.CENTER);
        // gridpane.setGridLinesVisible(true);

        // Add Labels To GridPane //
        VBox paneforLabel = new VBox(15);
        Label L1 = new Label("Employee ID");
        Label L2 = new Label("Employee Name");
        Label L3 = new Label("Birth Date");
        paneforLabel.getChildren().addAll(L1, L2, L3);
        gridpane.add(paneforLabel, 0, 0);

        // Add TextFields & Logic //
        VBox paneforTextField = new VBox(5);
        
        
        // ID TextField Initilaize & Validate
        TextField idTxtField = new TextField(){@Override public void paste(){}}; // disable paste
        idTxtField.setPromptText("Your ID");
        idTxtField.setOnKeyTyped(e->{
            if(idTxtField.getLength() >= 7) e.consume(); // only 7 numbers allowed
            if(!e.getCharacter().matches("\\d")) e.consume(); // numbers only allowed
        });
        idTxtField.setOnKeyReleased(e->{
            if(idTxtField.getLength() < 1){
                idTxtField.setStyle("-fx-control-inner-background: #fff;");
                idVali =false;
                return;
            };
            
            if(scanId(idTxtField.getText()) != null){ // if the id exist
                idTxtField.setStyle("-fx-control-inner-background: #fee96f;");
            }else{
                idTxtField.setStyle("-fx-control-inner-background: #68fa72;");
            }
            
            idVali = true;
        });
        
        
        // Name TextField Initilaize & Validate
        TextField nameTxtField = new TextField();
        nameTxtField.setPromptText("Your Name");
        nameTxtField.setOnKeyTyped(e->{
           if(!e.getCharacter().matches("[a-zA-Z]"))e.consume(); 
        });
        nameTxtField.setOnKeyReleased(e->{
            if(nameTxtField.getLength() > 2){
                nameTxtField.setStyle("-fx-control-inner-background: #68fa72;");
                nameVali = true;
            }else{
                nameTxtField.setStyle("-fx-control-inner-background: #fff;");
                nameVali = false;
            }
        });
        
        
        // BirthDate TextField Initilaize & Validate
        TextField birthTxtField = new TextField();
        birthTxtField.setPromptText("e.g. dd/mm/yyyy");
        birthTxtField.setOnKeyTyped(e->{
            if(!e.getCharacter().matches("[\\d/]"))e.consume();
        });
        birthTxtField.setOnKeyReleased(e->{
            if(birthTxtField.getLength() < 5){
                birthTxtField.setStyle("-fx-control-inner-background: #fff;");
                birthVali = false;
                return;
            };
            
            if(checkDate(birthTxtField.getText())){ // valid date
                birthTxtField.setStyle("-fx-control-inner-background: #68fa72;");
                birthVali = true;
            }else{
                birthTxtField.setStyle("-fx-control-inner-background: #fa7268;");
                birthVali = false;
            }
        });
        
        
        paneforTextField.getChildren().addAll(idTxtField, nameTxtField, birthTxtField);
        gridpane.add(paneforTextField, 1, 0);

        // Create RadioButton , HBox and ToggleGroup //
        ToggleGroup group = new ToggleGroup();

        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setSelected(true); // select male radio button by default
        maleRadio.setToggleGroup(group);
        
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(group);

        HBox paneforRadioButton = new HBox(2);
        paneforRadioButton.getChildren().addAll(maleRadio, femaleRadio);
        gridpane.add(new Label("Gender :"), 0, 2);
        gridpane.add(paneforRadioButton, 1, 2);

        // Add CheckBoxes AND VBox pane //
        CheckBox Ch1 = new CheckBox("Reading");
        CheckBox Ch2 = new CheckBox("Swimming");
        CheckBox Ch3 = new CheckBox("Computer");
        VBox checkBoxs_1 = new VBox(5, Ch1, Ch2, Ch3);

        CheckBox Ch4 = new CheckBox("Football");
        CheckBox Ch5 = new CheckBox("Driving");
        CheckBox Ch6 = new CheckBox("Travelling");
        VBox checkBoxs_2 = new VBox(5, Ch4, Ch5, Ch6);

        gridpane.add(new Label("Hobbies : "), 0, 3);
        gridpane.add(checkBoxs_1, 0, 4);
        gridpane.add(checkBoxs_2, 1, 4);

        // Footer //
        Label infoLabel = new Label();
        infoLabel.setAlignment(Pos.CENTER);
        infoLabel.setFont(new Font(16));
        
        HBox paneforButton = new HBox(10);
        Button B1 = new Button("SAVE");
        Button B2 = new Button("VIEW");
        paneforButton.getChildren().addAll(B1, B2);
        paneforButton.setAlignment(Pos.CENTER);
        paneforButton.setPadding(new Insets(0, 0, 20, 0));
        
        VBox footerBox = new VBox(10, infoLabel, paneforButton);
        footerBox.setAlignment(Pos.CENTER);
        
        // Add BorderPane and other panes //
        BorderPane pane = new BorderPane();
        pane.setCenter(gridpane);
        pane.setBottom(footerBox);

        // Save button Logic
        B1.setOnAction(e -> {
            // Check for all text field
            if(!nameVali || !idVali || !birthVali){
                String info = "";
                if(!nameVali) info+= "* Wrong Name\n";
                if(!idVali) info+= "* Wrong ID\n";
                if(!birthVali) info+= "* Wrong Birth Date\n";
                
                infoLabel.setTextFill(Color.rgb(255,0,0,0.8));
                infoLabel.setText(info);
                return;
            }
            
            // check if the id already exist
            if(scanId(idTxtField.getText()) != null){
                infoLabel.setTextFill(Color.rgb(255,0,0,0.8));
                infoLabel.setText("~ ID:"+idTxtField.getText()+" Already Exist!");
                return;
            }
            
            infoLabel.setText("");
            String oldTxt = getAllTxt(txtFile);
            try {
                txtFile.createNewFile();
                java.io.PrintWriter P1 = new java.io.PrintWriter(txtFile);

                P1.print("id:" + idTxtField.getText() + " | ");
                P1.print("name:" + nameTxtField.getText() + " | ");
                P1.print("birth:" + birthTxtField.getText() + " | ");

                P1.print("gender:");
                if (maleRadio.isSelected()) {
                     P1.print("M" + " | ");
                } else {
                    P1.print("F" + " | ");
                }

                P1.print("hobbies:");
                if (Ch1.isSelected()) {
                    P1.print("1");
                }
                if (Ch2.isSelected()) {
                    P1.print("2");
                }
                if (Ch3.isSelected()) {
                    P1.print("3");
                }
                if (Ch4.isSelected()) {
                    P1.print("4");
                }
                if (Ch5.isSelected()) {
                    P1.print("5");
                }
                if (Ch6.isSelected()) {
                    P1.print("6");
                }

                P1.print("\n");
                P1.print(oldTxt);
                P1.close();
            } catch (Exception ex) {
                System.out.println("An exception has been occured");
            }
            
            infoLabel.setTextFill(Color.rgb(0,255,0));
            infoLabel.setText("Done!");
        });
        
        B2.setOnAction(e->{
            String line = scanId(idTxtField.getText());
            if(line == null){ return;}; // (no id found)
            
            Pattern idCheck = Pattern.compile("id:\\b(\\d+)\\b");
            Pattern nameCheck = Pattern.compile("name:([a-zA-Z]+)");
            Pattern birthCheck = Pattern.compile("birth:\\b(\\d{1,2}/\\d{1,2}/\\d{4})\\b");
            Pattern genderCheck = Pattern.compile("gender:([MmFf])");
            Pattern hobbiesCheck = Pattern.compile("hobbies:([0-9]{0,6})");
            
            Matcher putName = nameCheck.matcher(line);
            if(putName.find()){
                nameTxtField.setText(putName.group(1));
            }
            
            Matcher putBirthDate = birthCheck.matcher(line);
            if(putBirthDate.find()){
                birthTxtField.setText(putBirthDate.group(1));
            }
            
            Matcher selectGender = genderCheck.matcher(line);
            if(selectGender.find()){
                String gender = selectGender.group(1);
                if(gender.equalsIgnoreCase("m")){
                    maleRadio.setSelected(true);
                }else{
                    femaleRadio.setSelected(true);
                }
            }
            
            Matcher selectHobbies = hobbiesCheck.matcher(line);
            if(selectHobbies.find()){
                String hobbies = selectHobbies.group(1);
                
                if(hobbies.contains("1")){
                    Ch1.setSelected(true);
                }else{Ch1.setSelected(false);}
                
                if(hobbies.contains("2")){
                    Ch2.setSelected(true);
                }else{Ch2.setSelected(false);}
                
                if(hobbies.contains("3")){
                    Ch3.setSelected(true);
                }else{Ch3.setSelected(false);}
                
                if(hobbies.contains("4")){
                    Ch4.setSelected(true);
                }else{Ch4.setSelected(false);}
                
                if(hobbies.contains("5")){
                    Ch5.setSelected(true);
                }else{Ch5.setSelected(false);}
                
                if(hobbies.contains("6")){
                    Ch6.setSelected(true);
                }else{Ch6.setSelected(false);}
            }
            
            infoLabel.setText("");
        });

        Scene scene = new Scene(pane, 300, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String getAllTxt(File file) {
        if(!file.exists())return "";
        StringBuilder sBuilder = new StringBuilder();
        try {
            Scanner sc = new Scanner(file);
            
            while(sc.hasNextLine()){
                sBuilder.append(sc.nextLine()+"\n");
            }
            
        } catch (FileNotFoundException e) {e.printStackTrace();}
        
        return sBuilder.toString();
    }
    
    // To check if the id is exist
    public String scanId(String id){
        if(!txtFile.exists())return null;
        if(id.length() < 1)return null;
        
        id = id.trim(); // remove whitespace
        String line = "";

        Scanner txtToSearch = new Scanner(getAllTxt(txtFile)); // get all the text from emp3.txt
        while(txtToSearch.hasNextLine()){
            line = txtToSearch.nextLine();
            
            Matcher m = Pattern.compile("id:\\b"+id+"\\b").matcher(line); // search for the id
            if(m.find()){return line;}; // if the id exist then return it
        }
        
        return null; // return -1 ( no id found )
    }
    
    // check date format
    public boolean checkDate(String s){
        
        try{
            Date date = format.parse(s);
            if(date.getYear() < 0 || date.getYear() > 118)return false;
        }catch(ParseException e){return false;}
        
        return true;
    }
    public static void main(String[] args) {launch(args);}
    
}