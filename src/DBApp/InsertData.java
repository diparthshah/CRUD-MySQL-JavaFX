package DBApp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtMail;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private String name,age,mail;
    private Connection InsConn=null;
    private Statement InsSt=null;
    private String SQLQuery=null;
    private Alert ialert = new Alert(Alert.AlertType.INFORMATION);


    private void getUserData(){
        name = txtName.getText();
        age = txtAge.getText();
        mail = txtMail.getText();
    }
    private boolean ValidateUserData(){
        getUserData();
        System.out.println("LOG :: Entering Validation Stage");

        if(name.isEmpty()){
            System.out.println("\n Name field is empty");
            alert.setTitle("Incomplete Data Input");
            alert.setHeaderText("Information in Name field is missing");
            alert.setContentText("Please fill data in Name field");
            alert.showAndWait();
            return false;
        }
        else if(age.isEmpty()){
            System.out.println("\n Age field is empty");
            alert.setTitle("Incomplete Data Input");
            alert.setHeaderText("Information in Age field is missing");
            alert.setContentText("Please fill data in Age field");
            alert.showAndWait();
            return false;
        }

        else if(mail.isEmpty()){
            System.out.println("\n Mail field is empty");
            alert.setTitle("Incomplete Data Input");
            alert.setHeaderText("Information in Mail field is missing");
            alert.setContentText("Please fill data in Mail field");
            alert.showAndWait();
            return false;
        }

        else{
            return true;
        }
    }

    private void InsertDataIntoDB() throws SQLException{

        try {
            InsConn=DBConnector.getConnection();
            InsSt=InsConn.createStatement();
            SQLQuery = "INSERT INTO fxdb.fxtable values('"+name+"','"+age+"','"+mail+"');";
            InsSt.executeUpdate(SQLQuery);
            System.out.println("\n LOG :: DATA INSERTED");
        }catch (SQLException e){
            System.err.print(e);
        }finally {
            if(InsSt!=null){
                InsSt.close();
            }
            if(InsConn!=null){
                InsConn.close();
            }
        }

    }
    public void Register() throws SQLException{
        boolean valResult = ValidateUserData();
        if(valResult){
            InsertDataIntoDB();
            ialert.setTitle("Data Added Successfully");
            ialert.setHeaderText(null);
            ialert.setContentText("Required Data Inserted");
            ialert.showAndWait();
        }
        else{
            ialert.setTitle("Data Insertion Failed");
            ialert.setHeaderText(null);
            ialert.setContentText("Required Data Cannot be Added");
            ialert.showAndWait();
        }
    }

}