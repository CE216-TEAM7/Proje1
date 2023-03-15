module com.example.ce216proje1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ce216proje1 to javafx.fxml;
    exports com.example.ce216proje1;
}