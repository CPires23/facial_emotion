module org.com.facialrecognition {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.bytedeco.opencv;
    //requires org.bytedeco.opencv;

    opens org.com.facialrecognition to javafx.fxml;
    exports org.com.facialrecognition;
    exports org.com.facialrecognition.controller;
    opens org.com.facialrecognition.controller to javafx.fxml;
}