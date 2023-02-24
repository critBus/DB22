/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.ClasesUtiles.Interfases.Funcionales.Realizar;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.effects.JFXDepthManager;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Dialogo_SobrescribirCotroller implements Initializable {

//    private TipoDeEntidad tipoDeEntidad;
//    private Object nuevoValor;
    private Realizar accion;
    private JFXDialog dialog;
    @FXML
    private AnchorPane PAnchor;

    @FXML
    private JFXButton BCancelar;

    @FXML
    private JFXButton BAceptar;

    @FXML
    void apretoAceptar(ActionEvent event) {
//        switch (tipoDeEntidad) {
//            case TEMA:
//               
//                break;
//        }
        accion.realizar();
        dialog.close();
    }

    @FXML
    void apretoCancelar(ActionEvent event) {
        dialog.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dialog = new JFXDialog();

        // dialog.setContent( new JFXRippler(PAnchor));
        dialog.setContent(PAnchor);
        dialog.setTransitionType(JFXDialog.DialogTransition.TOP);
        JFXDepthManager.setDepth(dialog, 6);
    }

    public void show(StackPane sp, Realizar r) {

        //dialog.setStyle("-fx-background-radius: 40; -fx-border-radius: 40; -fx-background-color: red; -fx-border-width: 5; -fx-border-color: orange;");
        dialog.show(sp);

    }

}
