module edu.wit.cs.comp1050.javafx_maven_example {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens edu.wit.cs.comp1050.javafx_maven_example to javafx.fxml;
    exports edu.wit.cs.comp1050.javafx_maven_example;
}
