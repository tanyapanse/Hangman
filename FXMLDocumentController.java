/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author shilp
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label hiddenLBL;
    @FXML
    private Button submitBTN;
    @FXML
    private TextField letterTXT;
    @FXML
    private Label triesLBL;
    @FXML
    private boolean reduceTries = true;

    String word = "hello";
    String hidden = "";
    int tries = 10;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (tries != 0) {
        boolean correct = false;
        String newHidden = "";
        String letter = letterTXT.getText();
        
        for (int n = 0; n < word.length(); n++) {
            if (word.charAt(n) == letter.charAt(0)) {
                correct = true;
                newHidden += word.charAt(n);
            } else if (hidden.charAt(n) != '*'){
                newHidden += word.charAt(n);
            }
            else {
                newHidden += "*";
            }
        }
        hidden = newHidden;
        hiddenLBL.setText(newHidden);
        
        if (!correct && reduceTries) {
            tries--;
        }
        
        triesLBL.setText(Integer.toString(tries));
        
        if (tries == 0) {
            hiddenLBL.setText("Game over!");
        }
        } else {
            hiddenLBL.setText("Game over!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hidden = "";
        for (int i = 1; i <= word.length(); i++) {
            hidden += "*";
        }
        hiddenLBL.setText(hidden);
        triesLBL.setText(Integer.toString(tries));
    }
}
