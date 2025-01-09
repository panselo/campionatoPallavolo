module com.example.campionatopallavolo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.campionatopallavolo to javafx.fxml;
    exports com.example.campionatopallavolo;
}