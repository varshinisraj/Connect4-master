module com.internshala.connect4master {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.internshala.connectfour to javafx.fxml;
    exports com.internshala.connectfour;
}