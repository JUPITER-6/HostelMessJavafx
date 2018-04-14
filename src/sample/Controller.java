package sample;

import javax.management.Notification;
import javax.swing.*;
// we don't want this but is generated    import java.awt.event.ActionEvent;
import DataLayer.accountDetails;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

    @FXML
    private Button B1 = new Button();
    @FXML private PasswordField adPa = new PasswordField();
    @FXML private Button submitButton = new Button();
    @FXML private  Button user =new Button();
    @FXML private TextField usernameField = new TextField();
    @FXML private  PasswordField userPasswordField = new PasswordField();
    @FXML private TextField fullname = new TextField();
    @FXML private TextField dep = new TextField();
    @FXML private TextField username = new TextField();
    @FXML private TextField year = new TextField();
    @FXML private  PasswordField password = new PasswordField();
    @FXML private TextField delUser = new TextField();

    public void buttonClick(ActionEvent event){



    }

  /*  public  void pressButtonAdmin(ActionEvent event){

       //B1.setOnAction((event1) -> { System.out.println("hello");}); lamda for the below code
        B1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hi");

            }



        });
    }*/
   public void pressButtonAdmin (ActionEvent event) throws Exception{

       Parent adminLogin = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));

       Scene aL =new Scene(adminLogin);

       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       window.setScene(aL);
       window.show();
   }

   public  void isAdminPasswordCorrect(ActionEvent event) throws Exception{

        final String adminName = "xyz";
       accountDetails a1 = new accountDetails();
       String pwd = adPa.getText();
       if (a1.isPasswordCorrect(adminName,pwd) ){

           Parent admin = FXMLLoader.load(getClass().getResource("admin.fxml"));

           Scene aL =new Scene(admin);

           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(aL);
           window.show();


       } else {
           Alert errorAlert = new Alert(Alert.AlertType.ERROR);
           errorAlert.setHeaderText("wrong password");
           errorAlert.setContentText("pls enter correct password");
           errorAlert.showAndWait();
       }
   }
   public  void  userLogin(ActionEvent event)  throws  Exception{

       Parent user = FXMLLoader.load(getClass().getResource("user.fxml"));

       Scene aL =new Scene(user);

       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       window.setScene(aL);
       window.show();

   }

   public void  checkUserLogin(ActionEvent event) throws  Exception{

       String u_name = usernameField.getText();
       String pwd = userPasswordField.getText();

       accountDetails a3 = new accountDetails();
       accountDetails a4 =new accountDetails();
       Alert errorAlert = new Alert(Alert.AlertType.ERROR);
       Alert greet = new Alert(Alert.AlertType.INFORMATION);

       //un = request.getParameter("username");
       if (a3.isPasswordCorrect(u_name,pwd)) {

           Calendar cal = GregorianCalendar.getInstance();
           int hr = cal.get(Calendar.HOUR_OF_DAY);
           //System.out.println(cal.get(Calendar.HOUR_OF_DAY));

          // errorAlert.setHeaderText("wrong password");

           if(hr!= 8 && hr!=15 && hr!=22){
               errorAlert.setContentText("you are late");
               errorAlert.showAndWait();

           }
           else
           {
               if((hr==8 && (a4.isBf(u_name) == 0))) {
                   a3.setBf(u_name);
                   greet.setContentText("collect your token... enjoy your breakfast");
                   greet.showAndWait();
                   //request.setAttribute("message","collect your token... enjoy your breakfast");
               }
               else if(a4.isBf(u_name) == 1){
                   errorAlert.setContentText("you have already collected the token");
                   errorAlert.showAndWait();
                   //request.setAttribute("message","you have already collected the token");
               }


               if((hr==15 && (a4.isLu(u_name) == 0))) {
                   a3.setLu(u_name);
                   greet.setContentText("collect your token... enjoy your Lunch");
                   greet.showAndWait();
                   //request.setAttribute("message","collect your token... enjoy your Lunch");
               }
               else if(a4.isLu(u_name) == 1){
                   errorAlert.setContentText("you have already collected the token");
                   errorAlert.showAndWait();
                   //request.setAttribute("message","you have already collected the token");
               }


               if((hr==22 && (a4.isDi(u_name) == 0))) {
                   a3.setDi(u_name);
                   greet.setContentText("collect your token... enjoy your Dinner");
                   greet.showAndWait();
                   //request.setAttribute("message","collect your token... enjoy your Dinner");
               }
               else if(a4.isDi(u_name) == 1){
                   errorAlert.setContentText("you have already collected the token");
                   errorAlert.showAndWait();
                   //request.setAttribute("message","you have already collected the token");
               }
           }

           //request.getRequestDispatcher("/userLogin.jsp").forward(request, response);

           // request.getRequestDispatcher("/generateToken.jsp").forward(request, response);

       } else {
           errorAlert.setContentText("Invalid username  or  password");
           errorAlert.showAndWait();
       }
   }

   public void backToMainScene(ActionEvent event) throws  Exception{

       Parent user = FXMLLoader.load(getClass().getResource("sample.fxml"));

       Scene aL =new Scene(user);

       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       window.setScene(aL);
       window.show();
   }

   public void  gotoAddUser(ActionEvent event) throws Exception{
       Parent user = FXMLLoader.load(getClass().getResource("addStudent.fxml"));

       Scene aL =new Scene(user);

       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       window.setScene(aL);
       window.show();

   }
    public void  gotoDelUser(ActionEvent event) throws Exception{
        Parent user = FXMLLoader.load(getClass().getResource("DeleteUser.fxml"));

        Scene aL =new Scene(user);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(aL);
        window.show();

    }


    public  void addUser(ActionEvent event) throws  Exception{
        accountDetails a2 = new accountDetails();

        String department = dep.getText();
        String name = fullname.getText();
        String user_name = username.getText();
        String year_stud = year.getText();
        String pwd = password.getText();

        int year_in_int = Integer.parseInt(year_stud);

        if(a2.addUser(name,user_name,pwd,department,year_in_int)){
            Parent user = FXMLLoader.load(getClass().getResource("admin.fxml"));

            Scene aL =new Scene(user);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(aL);
            window.show();
        }
        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("account with this username already exists");
            errorAlert.showAndWait();

        }
    }


    public void backToAdmin(ActionEvent event) throws  Exception{

        Parent user = FXMLLoader.load(getClass().getResource("admin.fxml"));

        Scene aL =new Scene(user);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(aL);
        window.show();
    }

    public  void deleteUser(ActionEvent event) throws Exception{
       String u_name = delUser.getText();
        accountDetails a5 =new accountDetails();
        Alert mes =  new Alert(Alert.AlertType.INFORMATION);
        if(!a5.delete(u_name)){
            mes.setContentText("No account with this username exists");
            mes.showAndWait();

        }
        else {
            mes.setContentText("Account deleted");
            mes.showAndWait();
        }
    }


}
