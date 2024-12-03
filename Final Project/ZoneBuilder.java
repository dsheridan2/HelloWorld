import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ZoneBuilder extends Application{

    
    int buttonCounter = 0;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        int row;
        int column;
        Station[] stationArray = new Station[16];

        for (int i = 0; i < 16; i++) {

            stationArray[i] = new Station(0, i + 1);
        }
        //Set tittle
        primaryStage.setTitle("Zone Creator");

        //Create grid pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background-color: skyblue;");
        //"#4b8bf2"

        //Create buttons
        Button generateFile = new Button();
        Button[] StationBtn = new Button[16];

        //Create text
        Text sceneTitle = new Text("Zone Builder");
        sceneTitle.setStyle("-fx-font-size: 24;");
        grid.add(sceneTitle, 4, 0);
        grid.setHalignment(sceneTitle, HPos.CENTER);
      
        //Create text box label
        Text comboLabel = new Text("Zone Number");
        grid.add(comboLabel, 0, 2);
        grid.setHalignment(comboLabel, HPos.CENTER);
      
        //Create combo box
        ComboBox ZoneNumber = new ComboBox<>();
        ZoneNumber.getItems().addAll(0, 1, 2, 3, 4, 5);
        ZoneNumber.getSelectionModel().selectFirst();
        grid.setHalignment(ZoneNumber, HPos.CENTER);
        grid.add(ZoneNumber, 0, 3);

        //Configure generate file button
        generateFile.setText("Generate Zone File");
        generateFile.setMinWidth(140);
        generateFile.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
        
        //Configure station buttons
        column = 2;
        for(int i = 0; i < 16; i++) {
            StationBtn[i] = new Button();
            StationBtn[i].setText("Configure Station " + (i + 1));
            StationBtn[i].setAlignment(Pos.CENTER);
            StationBtn[i].setMinWidth(140);
            StationBtn[i].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000");
            StationBtn[i].setDisable(true);
            
            if (i < 4) {
                row = 1;
            }
            else if (i < 8){
                row = 2;
            }
            else if (i < 12) {
                row = 3;
            }
            else {
                row = 4;
            }

            if (column > 5) {
                column = 2;
            }

            grid.add(StationBtn[i], column + 1, row);
            column++;
        }

        StationBtn[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[0].isUsed = !stationArray[0].isUsed;
                if (stationArray[0].isUsed) {
                    StationBtn[0].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[0].createStationPage();
                }
                else {
                     StationBtn[0].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[1].isUsed = !stationArray[1].isUsed;
                if (stationArray[1].isUsed) {
                    StationBtn[1].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[1].createStationPage();
                }
                else {
                     StationBtn[1].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[2].isUsed = !stationArray[2].isUsed;
                if (stationArray[2].isUsed) {
                    StationBtn[2].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[2].createStationPage();
                }
                else {
                     StationBtn[2].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[3].isUsed = !stationArray[3].isUsed;
                if (stationArray[3].isUsed) {
                    StationBtn[3].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[3].createStationPage();
                }
                else {
                     StationBtn[3].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[4].isUsed = !stationArray[4].isUsed;
                if (stationArray[4].isUsed) {
                    StationBtn[4].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[4].createStationPage();
                }
                else {
                     StationBtn[4].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[5].isUsed = !stationArray[5].isUsed;
                if (stationArray[5].isUsed) {
                    StationBtn[5].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[5].createStationPage();
                }
                else {
                     StationBtn[5].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[6].isUsed = !stationArray[6].isUsed;
                if (stationArray[6].isUsed) {
                    StationBtn[6].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[6].createStationPage();
                }
                else {
                     StationBtn[6].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[7].isUsed = !stationArray[7].isUsed;
                if (stationArray[7].isUsed) {
                    StationBtn[7].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[7].createStationPage();
                }
                else {
                     StationBtn[7].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[8].isUsed = !stationArray[8].isUsed;
                if (stationArray[8].isUsed) {
                    StationBtn[8].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[8].createStationPage();
                }
                else {
                     StationBtn[8].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[9].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[9].isUsed = !stationArray[9].isUsed;
                if (stationArray[9].isUsed) {
                    StationBtn[9].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[9].createStationPage();
                }
                else {
                     StationBtn[9].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[10].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[10].isUsed = !stationArray[10].isUsed;
                if (stationArray[10].isUsed) {
                    StationBtn[10].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[10].createStationPage();
                }
                else {
                     StationBtn[10].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[11].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[11].isUsed = !stationArray[11].isUsed;
                if (stationArray[11].isUsed) {
                    StationBtn[11].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[11].createStationPage();
                }
                else {
                     StationBtn[11].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[12].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[12].isUsed = !stationArray[12].isUsed;
                if (stationArray[12].isUsed) {
                    StationBtn[12].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[12].createStationPage();
                }
                else {
                     StationBtn[12].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[13].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[13].isUsed = !stationArray[13].isUsed;
                if (stationArray[13].isUsed) {
                    StationBtn[13].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[13].createStationPage();
                }
                else {
                     StationBtn[13].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[14].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[14].isUsed = !stationArray[14].isUsed;
                if (stationArray[14].isUsed) {
                    StationBtn[14].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[14].createStationPage();
                }
                else {
                     StationBtn[14].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });
        StationBtn[15].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stationArray[15].isUsed = !stationArray[15].isUsed;
                if (stationArray[15].isUsed) {
                    StationBtn[15].setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                    stationArray[15].createStationPage();
                }
                else {
                     StationBtn[15].setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
                }
            }
        });

        generateFile.setOnAction(new EventHandler<ActionEvent>() {
          
            @Override
            public void handle(ActionEvent event) {
                //printStations(stationArray);
                WriteFile.writeZone(stationArray);
            }
        });

        generateFile.setAlignment(Pos.CENTER);
        grid.add(generateFile, 4, 5);

        ZoneNumber.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < 16; i++) {
                    stationArray[i].setZone((int) ZoneNumber.getValue());
                    StationBtn[i].setDisable(false);
                    StationBtn[i].setStyle("-fx-border-color: #000000;");
                }
            }
        });

        Scene scene = new Scene(grid, Color.AZURE);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void printStations(Station[] array) {

        for (int i = 0; i < 16; i++){
            if (array[i].isUsed) {
                System.out.println("Zone " + array[i].getZone() + " Station " + array[i].getStation());
                if (array[i].getCamera()) System.out.println("Camera is used");
                if (array[i].getScanner()) System.out.println("Scanner is used");
                if (array[i].getTMD()) System.out.println("TMD is used");
                if (array[i].getFirst()) System.out.println("This station is first");
                if (array[i].getLast()) System.out.println("This station is last");

                for (int j = 0; j < 8; j++) {
                    if (array[i].getGenericIN(j) != null && array[i].getGenericIN(j) != "") System.out.println(array[i].getGenericIN(j));
                }

                for (int k = 0; k < 8; k++) {
                    if (array[i].getGenericOUT(k) != null && array[i].getGenericOUT(k) != "") System.out.println(array[i].getGenericOUT(k));
                }
            }
        }
    }
}

