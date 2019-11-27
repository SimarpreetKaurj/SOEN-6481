package application;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ReceiptPreference extends Application {

	@FXML
	RadioButton email;
	@FXML
	RadioButton paper;
	final ToggleGroup radioGroup = new ToggleGroup();
	@FXML
	TextField emailAddress;
	StringProperty selectedMode = new SimpleStringProperty();
	StringProperty emailString = new SimpleStringProperty();

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("resources/SelectReceiptUI.fxml"));
		emailAddress = new TextField();
		ReceiptController controller = new ReceiptController(selectedMode, emailString);

		loader.setController(controller);

		Parent root = loader.load();
		email = new RadioButton("email");
		paper = new RadioButton("paper");

		ObservableList<Node> childList = root.getChildrenUnmodifiable();
		for (Node node : childList) {
			if (node instanceof javafx.scene.control.RadioButton) {

				((RadioButton) node).setToggleGroup(radioGroup);
			}
			if (node instanceof javafx.scene.control.TextField) {
				emailAddress = (TextField) node;
				((TextField) node).setVisible(false);
				((TextField) node).textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						emailString.set(newValue);
					}
				});
			}
		}

		radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {
				RadioButton rb = (RadioButton) radioGroup.getSelectedToggle();
				selectedMode.set(rb.getText());
				if (selectedMode.get().equals("Email Receipt")) {
					emailString.set(emailAddress.getText());
					emailAddress.setVisible(true);
				} else {
					emailAddress.setVisible(false);
				}

			}
		});

		primaryStage.setScene(new Scene(root));
		primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("resources/iGO.png")));
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
