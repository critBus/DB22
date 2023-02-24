/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

//import com.jfoenix.animation.alert.JFXAlertAnimation;
//import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
//import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTextField;
//import com.jfoenix.controls.base.IFXLabelFloatControl;
//import com.jfoenix.validation.RequiredFieldValidator;
import java.io.IOException;
//import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static visual.probar.*;

public class LoginController implements Initializable {

    //private Stage ventana;
    @FXML
    private StackPane Pstack;

    @FXML
    private StackPane Pstack2;

    @FXML
    private AnchorPane panel;
    @FXML
    private JFXTextField TUsuario;

    @FXML
    private JFXPasswordField TContraseña;

    @FXML
    private JFXButton BLogin;

    @FXML
    private JFXButton BCerrar;

    @FXML
    private JFXButton BMinimizar;

    @FXML
    private JFXTextField TFC;
    @FXML
    private JFXButton BVibilidadContraseña;


    @FXML
    void apretoVibilidadContraseña(MouseEvent event) {
       
    }

    @FXML
    void apretoCerrar(ActionEvent event) {

//        di.show(Pstack);
//        Platform.runLater(() -> dialogo_CerrarCotroller.show(Pstack));
        dialogo_CerrarCotroller.show();

    }

    Region veil = new Region();

    @FXML
    void apretoLogin(ActionEvent event) {
        if ((usuarioActual = getUsuario(TUsuario.getText().trim(), TContraseña.getText().trim())) != null) {
            Platform.runLater(() -> {
                stage_Ventana_Login.hide();
                // stage_Cargando.show();
                stage_Ventana_Principal.show();
            });
        } else {
            dialogo_solo_AceptarController.show(USUARIO_INCORRECTO);
        }

    }

    @FXML
    void apretoMinimizar(ActionEvent event) {
        stage_Ventana_Login.setIconified(true);
    }

    public SimpleObjectProperty<Boolean> usuarioValido;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utiles.FX.VisualFX.setValidator(BLogin, TUsuario, TContraseña, TFC);//, TFC
        Utiles.FX.VisualFX.addOnShowing(stage_Ventana_Login, () -> Utiles.FX.VisualFX.resetear(TUsuario, TContraseña));
        BLogin.setDefaultButton(true);
         Utiles.FX.VisualFX.sincronizarTFContrazeña(TFC, TContraseña, BVibilidadContraseña);
        

    }

//    public Stage getVentana() {
//        return ventana;
//    }
//
//    public void setVentana(Stage ventana) {
//        this.ventana = ventana;
//    }
}
