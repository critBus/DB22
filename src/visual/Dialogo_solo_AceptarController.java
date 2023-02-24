/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.ClasesUtiles.Interfases.Funcionales.Realizar;
import Utiles.FX.ConVentana;
import Utiles.FX.JFXDialogs.DialogoJFX;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Dialogo_solo_AceptarController extends ConVentana {

    @FXML
    private AnchorPane PAnchor;

    @FXML
    private Text Te;

    @FXML
    private JFXButton BAceptar;

    @FXML
    void apretoAceptar(MouseEvent event) {
        close();
    }

    public void initialize(URL location, ResourceBundle resources) {
        BAceptar.setDefaultButton(true);
    }

    public void show(String mensaje) {
         Te.setText(mensaje);
        show();
        ///   getDialog().show(sp);
    }
}
