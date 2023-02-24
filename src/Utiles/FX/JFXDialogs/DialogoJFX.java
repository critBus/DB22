/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles.FX.JFXDialogs;

import com.jfoenix.controls.JFXDialog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Rene
 */
public abstract class DialogoJFX implements Initializable {

    JFXDialog dialog;
//    URL location;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        this.location = location;
//    }

    public void ini(Region PAnchor) {
        dialog = new JFXDialog();
        dialog.setContent(PAnchor);
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
    }

    public void show(StackPane sp) {
        dialog.show(sp);
    }

    ;

    public JFXDialog getDialog() {
        return dialog;
    }

    public void setDialog(JFXDialog dialog) {
        this.dialog = dialog;
    }

}
