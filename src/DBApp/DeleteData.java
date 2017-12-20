package DBApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class DeleteData {
    private Alert dalert = new Alert(Alert.AlertType.INFORMATION);
    private Connection delConn = null;
    private String SQLQuery = null;
    private PreparedStatement delSt = null;
    private FXMLLoader fxmlLoader = null;
    private Parent root1 = null;
    private Stage stage = null;
    private String reqName = null;
    private String checkQuery=null;
    private ResultSet delResultSet = null;

    @FXML
    TextField txtName;

    public void DeleteAllData() throws SQLException {
        try {
            delConn = DBConnector.getConnection();
            SQLQuery = "TRUNCATE TABLE fxdb.fxtable";
            checkQuery = "SELECT * FROM fxdb.fxtable";
            delResultSet = delConn.createStatement().executeQuery(checkQuery);
            if (delResultSet.next()){
                delSt = delConn.prepareStatement(SQLQuery);
                delSt.executeUpdate();
                dalert.setTitle("Data Deleted Successfully");
                dalert.setHeaderText(null);
                dalert.setContentText("All Data Deleted");
                dalert.showAndWait();
            }
            else {
                dalert.setTitle("Data Deletion Failed");
                dalert.setHeaderText(null);
                dalert.setContentText("No Data Found");
                dalert.showAndWait();
            }

        } catch (SQLException se) {
            System.err.print(se);
        } finally {
            if (delSt != null) {
                delSt.close();
            }
            if (delResultSet != null) {
                delResultSet.close();
            }
            if (delConn != null) {
                delConn.close();
            }
        }
    }

    @FXML
    private void ShowDetails() throws IOException {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("ReadDataWindow.fxml"));
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setTitle("Read Data");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    @FXML
    private void DeleteRequiredData() throws SQLException {
        reqName = txtName.getText();
        SQLQuery = "DELETE FROM fxdb.fxtable WHERE uname='" + reqName + "';";
        checkQuery = "SELECT * FROM fxdb.fxtable WHERE uname='"+reqName+"';";
        if (reqName.isEmpty()) {
            dalert.setTitle("No Input Found");
            dalert.setHeaderText(null);
            dalert.setContentText(" Enter required Name to be deleted ");
            dalert.showAndWait();
        } else {
            try {
                delConn = DBConnector.getConnection();
                delResultSet = delConn.createStatement().executeQuery(checkQuery);
                if (delResultSet.next()){
                    delSt = delConn.prepareStatement(SQLQuery);
                    delSt.executeUpdate();
                    dalert.setTitle("Data Deleted Successfully");
                    dalert.setHeaderText(null);
                    dalert.setContentText("Required Data Deleted");
                    dalert.showAndWait();
                }
                else {
                    dalert.setTitle("Data Deletion Failed");
                    dalert.setHeaderText(null);
                    dalert.setContentText("Required Data Not Found");
                    dalert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (delSt != null) {
                    delSt.close();
                }
                if (delResultSet != null) {
                    delResultSet.close();
                }
                if (delConn != null) {
                    delConn.close();
                }
            }
        }
    }
}