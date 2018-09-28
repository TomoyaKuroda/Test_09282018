package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignController implements Initializable {

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField widthTextField;

    @FXML
    private TextField messageTextField;

    @FXML
    private Button button;

    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    public void createSignButtonPushed() {
        boolean flag = false;
        StringBuffer errorMessage = new StringBuffer("");

        try {
            int tempHeight = Integer.parseInt(this.heightTextField.getText());
        } catch (NumberFormatException e) {
            errorMessage.append("Height field must contain a number\n");
            System.out.println(e);
            flag = true;
        }

        try {
            int tempWidth = Integer.parseInt(this.widthTextField.getText());
        } catch (NumberFormatException e) {
            errorMessage.append("Width field must contain a number\n");
            System.out.println(e);
            flag = true;
        }
        if (messageTextField.getText().isEmpty()) {
            errorMessage.append("message cannot be empty\n");
            flag = true;
        }
        if (flag) {
            messageLabel.setText(errorMessage.toString());
        } else {
            try {
                Sign newSign = new Sign(Integer.parseInt(this.heightTextField.getText()),
                        Integer.parseInt(this.widthTextField.getText()),
                        this.messageTextField.getText()
                );

                messageLabel.setText(newSign.toString());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                messageLabel.setText(e.getMessage());
            }
        }
    }

}
