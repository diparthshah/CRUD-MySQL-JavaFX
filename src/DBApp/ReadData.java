package DBApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReadData {

    @FXML
    TableView<UserDetails> tableUser;
    @FXML
    private TableColumn<UserDetails, String> columnName;
    @FXML
    private TableColumn<UserDetails, String> columnAge;
    @FXML
    private TableColumn<UserDetails, String> columnEmail;
    private ObservableList<UserDetails> data;
    private Connection ReadConn=null;

    public void loadDataFromDatabase() throws SQLException {
        try {
            ReadConn = DBConnector.getConnection();
            data = FXCollections.observableArrayList();
            ResultSet rs = ReadConn.createStatement().executeQuery("SELECT * FROM fxdb.fxtable");
            while (rs.next()) {
                data.add(new UserDetails(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }finally {
            if(ReadConn!=null){
                ReadConn.close();
            }
        }
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableUser.setItems(null);
        tableUser.setItems(data);
    }

}