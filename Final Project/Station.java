import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Station extends Application {
    
    int zoneNumber = 0;
    int stationNumber = 0;
    boolean isUsed = false;
    boolean hasCamera = false;
    boolean hasScanner = false;
    boolean hasTMD = false;
    boolean isFirst = false;
    boolean isLast = false;
    String[] genericIN = new String[8];
    String[] genericOut = new String[8];

    public Station(int zone, int station) {
        zoneNumber = zone;
        stationNumber = station;
    }

    public void createStationPage() {

        Stage stationStage = new Stage();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background-color: skyblue;");

        Button btnCamera = new Button();
        btnCamera.setText("Add Camera Block");
        btnCamera.setMinWidth(140);
        btnCamera.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
        btnCamera.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hasCamera = !hasCamera;
                if (hasCamera) btnCamera.setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                else btnCamera.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
            }
        });
        grid.add(btnCamera, 0, 0);

        Button btnScanner = new Button();
        btnScanner.setText("Add Scanner Block");
        btnScanner.setMinWidth(140);
        btnScanner.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
        btnScanner.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hasScanner = !hasScanner;
                if (hasScanner) btnScanner.setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                else btnScanner.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
            }
        });
        grid.add(btnScanner, 1, 0);
        
        Button btnTMD = new Button();
        btnTMD.setText("Add TMD Block");
        btnTMD.setMinWidth(140);
        btnTMD.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
        btnTMD.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hasTMD = !hasTMD;
                if (hasTMD) btnTMD.setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                else btnTMD.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
            }
        });
        grid.add(btnTMD, 2, 0);

        Button btnFirst = new Button();
        btnFirst.setText("First Station");
        btnFirst.setMinWidth(140);
        btnFirst.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
        btnFirst.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isFirst = !isFirst;
                if (isFirst) btnFirst.setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                else btnFirst.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
            }
        });
        grid.add(btnFirst, 0, 1);

        Button btnLast = new Button();
        btnLast.setText("Last Station");
        btnLast.setMinWidth(140);
        btnLast.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
        btnLast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isLast = !isLast;
                if (isLast) btnLast.setStyle("-fx-background-color: #A9A9A9;-fx-border-color: #000000;");
                else btnLast.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
            }
        });
        grid.add(btnLast, 1, 1);

        Button btnComplete = new Button();
        btnComplete.setText("Complete Station");
        btnComplete.setMinWidth(140);
        btnComplete.setStyle("-fx-background-color: #F5F5F5;-fx-border-color: #000000;");
        grid.add(btnComplete, 1, 4);

        TextField[] genericINArray = new TextField[8];
        for (int i = 0; i < 8; i++) {
            genericINArray[i] = new TextField();
            genericINArray[i].setMinWidth(140);
            genericINArray[i].setPromptText("Generic Input");
            grid.add(genericINArray[i], 0, 2 + i);
        }

        TextField[] genericOUTArray = new TextField[8];
        for (int i = 0; i < 8; i++) {
            genericOUTArray[i] = new TextField();
            genericOUTArray[i].setMinWidth(140);
            genericOUTArray[i].setPromptText("Generic Output");
            grid.add(genericOUTArray[i], 2, 2 + i);
        }

        btnComplete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < 8; i++) {
                    genericIN[i] = genericINArray[i].getText();
                    genericOut[i] = genericOUTArray[i].getText();
                }
                stationStage.close();
            }
        });

        stationStage.setTitle("Zone " + zoneNumber + ", Station " + stationNumber);
        stationStage.setScene(new Scene(grid));
        stationStage.show();
    }

    public void setZone(int zone) {

        zoneNumber = zone;

    }

    public int getZone() {

        return zoneNumber;

    }

    public void setStation(int station) {

        stationNumber = station;

    }

    public int getStation() {

        return stationNumber;

    }

    public void setCamera(boolean camera) {

        hasCamera = camera;

    }

    public boolean getCamera() {

        return hasCamera;

    }

    public void setScanner(boolean scanner) {

        hasScanner = scanner;

    }

    public boolean getScanner() {

        return hasScanner;
    }

    public void setTMD(boolean TMD) {

        hasTMD = TMD;
        
    }

    public boolean getTMD() {

        return hasTMD;

    }

    public void setFirst(boolean first) {

        isFirst = first;

    }

    public boolean getFirst() {

        return isFirst;
        
    }

    public void setLast(boolean last) {

        isLast = last;

    }

    public boolean getLast() {

        return isLast;

    }

    public void setGenericIN(String var, int slot) {

        genericIN[slot] = var;

    }

    public String getGenericIN(int slot) {

        return genericIN[slot];

    }

    public void setGenericOUT(String var, int slot) {

        genericOut[slot] = var;

    }

    public String getGenericOUT(int slot) {

        return genericOut[slot];
        
    }
}
