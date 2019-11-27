package application;

import java.util.regex.Pattern;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ReceiptController {
// selected mode of receipt
	StringProperty selectedMode = new SimpleStringProperty();
// email address entered  by the customer
	StringProperty emailString = new SimpleStringProperty();

	public ReceiptController(StringProperty selectedMode, StringProperty emailString) {
		this.selectedMode = selectedMode;
		this.emailString = emailString;
	}

	// Submit button on screen
	@FXML
	public void submit() {
		// if paper receipt is selected
		if (selectedMode.getValue().equals("Paper Receipt")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CONFIRMAITON");
			alert.setHeaderText("Thank you for choosing iGO");
			alert.setContentText("Please collect your receipt");
			alert.showAndWait(); // Show confirmation pop up on screen
			System.exit(0);// Exit system after successful execution
		}
		// if email receipt is selected
		else if (selectedMode.getValue().equals("Email Receipt")) {

			if (emailString.getValue().isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("INVALID EMAIL");
				alert.setHeaderText(null);
				alert.setContentText("Please enter valid email addresss");
				alert.showAndWait();// Show confirmation pop up on screen
			} else if (isValid(emailString.getValue())) { // Validate if email is in correct format
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("CONFIRMAITON");
				alert.setHeaderText("Thank you for choosing iGO");
				alert.setContentText("Receipt has been sent to your email : " + emailString.getValue());
				alert.showAndWait();// Show confirmation pop up on screen
				System.exit(0);// Exit system after successful execution
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("INVALID EMAIL");
				alert.setHeaderText(null);
				alert.setContentText("Please enter valid email address");
				alert.showAndWait();// Show confirmation pop up on screen
			}

		}

	}

	// Exit Button on screen
	@FXML
	public void exit() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Paper receipt is being dispensed");
		alert.showAndWait();
		System.exit(0);
	}

// Method to validate correct email address
	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);

		return pat.matcher(email).matches();
	}

}