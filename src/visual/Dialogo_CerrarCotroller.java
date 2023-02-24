/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.FX.ConVentana;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.effects.JFXDepthManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Dialogo_CerrarCotroller extends ConVentana implements Initializable {

    // private JFXDialog dialog;
//    private Stage ventana;
    // private Scene scene;
    @FXML
    private JFXButton BCancelar;

    @FXML
    private JFXButton BCerrar;

    @FXML
    private AnchorPane PAnchor;

    @FXML
    void apretoCancelar(ActionEvent event) {
        close();
        //  dialog.close();
    }

    @FXML
    void apretoCerrar(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         BCerrar.setDefaultButton(true);
        //PAnchor.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(40), Insets.EMPTY)));
//        dialog = new JFXDialog();
//       
//                 // dialog.setContent( new JFXRippler(PAnchor));
//        dialog.setContent(PAnchor);
//        dialog.setTransitionType(JFXDialog.DialogTransition.TOP);
//        JFXDepthManager.setDepth(dialog, 6);
        // dialog.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(40), Insets.EMPTY)));
    }

//    public void iniStage(Parent p) {
//        //this.scene = s;
//        Scene s = new Scene(p);
//        ventana = new Stage();
//        ventana.setScene(s);
//        Utiles.FX.VisualFX.sinBordes(s, ventana);
//    }

//    public void show() {
//        ventana.showAndWait();
//        //dialog.setStyle("-fx-background-radius: 40; -fx-border-radius: 40; -fx-background-color: red; -fx-border-width: 5; -fx-border-color: orange;");
//        //  dialog.show(sp);
//    }

    @Override
    public String toString() {
        return "controlador";
    }

}
