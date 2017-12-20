package DBApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    private FXMLLoader fxmlLoader = null;
    private Parent root1=null;
    private Stage stage=null;

    @FXML
    private void create() throws IOException{
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("InsertDataWindow.fxml"));
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setTitle("Insert Data");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.err.print(e);
        }
    }

    @FXML
    private void read() throws IOException{
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("ReadDataWindow.fxml"));
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setTitle("Read Data");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.err.print(e);
        }
    }

    @FXML
    private void delete() throws IOException{
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("DeleteDataWindow.fxml"));
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setTitle("Delete Data");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.err.print(e);
        }
    }

    @FXML
    private void update() throws IOException{
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("UpdateDataWindow.fxml"));
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setTitle("Update Data");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.err.print(e);
        }
    }
}