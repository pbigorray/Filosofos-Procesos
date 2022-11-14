module com.example.filosofosprocesos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.filosofosprocesos to javafx.fxml;
    exports com.example.filosofosprocesos;
}