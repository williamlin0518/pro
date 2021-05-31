module ProjectNewHYI {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.media;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
