/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.FX.ConVentana;
import Utiles.FX.Validadores.Validador;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import static visual.probar.*;
import static Utiles.FX.VisualFX.actualizarObs;
import static Utiles.FX.VisualFX.getI;
import Utiles.FX.VisualFX;
import static Utiles.FX.VisualFX.setValue;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTreeTableColumn;
import clases.*;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.validation.base.ValidatorBase;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.Node;

public class Dialogo_Configuracion_CuentaController extends ConVentana implements Initializable {

//    private JFXDialog dialog;
    // private Usuario usuarioActual;
    @FXML
    private StackPane Pstack;

    @FXML
    private Text TETipo;

    @FXML
    private Text TENombre;

    @FXML
    private Text TETipoDeParametro;

    @FXML
    private Text TEParametro;

    @FXML
    private Text TECurso;

    @FXML
    private Text TEValorDeCurso;

    @FXML
    private Text TEIdentificador;

    @FXML
    private Text TEValorDeIdentificador;

    @FXML
    private JFXButton BAtras;

    @FXML
    private JFXButton BAceptar;

    @FXML
    private Text TEParametro1;

    @FXML
    private JFXTextField TCuenta;

    @FXML
    private JFXPasswordField TPNueva;

    @FXML
    private JFXPasswordField TPConfimar;

    @FXML
    private JFXButton BVibilidadContraseñaNueva;

    @FXML
    private JFXButton BVibilidadReafirmar;

    @FXML
    private JFXPasswordField TPAnterior;

    @FXML
    private JFXButton BVibilidadContraseñaAnterior;
    @FXML
    private JFXTextField TFContraseñaAnterior;

    @FXML
    private JFXTextField TFContraseñaNueva;

    @FXML
    private JFXTextField TFReafirmarContraseña;

    @FXML
    void apretoAceptar(MouseEvent event) {
        try {
            if (TCuenta.getText().trim().equals(usuarioActual.getNombreDeCuenta())
                    && TPAnterior.getText().trim().equals(usuarioActual.getContrasena())
                    && contraseñaValida(TPNueva)
                    && TPNueva.getText().trim().equals(TPConfimar.getText().trim())) {

                usuarioActual.setContrasena(TPNueva.getText().trim());
                close();
                usuarioActual.save();
            } else {
                dialogo_solo_AceptarController.show(USUARIO_INCORRECTO);
            }

        } catch (Exception ex) {
            System.out.println("ignorar cuatro");
            ex.printStackTrace();
        }

    }

    @FXML
    void apretoAtras(MouseEvent event) {
        close();
    }

    @FXML
    void apretoVibilidadContraseña(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        iniDialog();
        BAceptar.setDefaultButton(true);
        Utiles.FX.VisualFX.sincronizarTFContrazeña(TFContraseñaNueva, TPNueva, BVibilidadContraseñaNueva, TFContraseñaAnterior, TPAnterior, BVibilidadContraseñaAnterior, TFReafirmarContraseña, TPConfimar, BVibilidadReafirmar);
    }

    @Override
    public void show() {
        // this.usuarioActual = u;
        resetearCampos();
        actualizarCampos();
        getVentana().show();
    }

    public void resetearCampos() {
        Utiles.FX.VisualFX.resetear(TPAnterior, TPConfimar, TPNueva);
    }

    public void actualizarCampos() {
        TETipo.setText(getTipoDeUsuario(usuarioActual) + ":");
        TENombre.setText(usuarioActual.getNombre());
        actualizarCamposExpecificos();
        Utiles.FX.VisualFX.setVisible(usuarioActual.getEstudiante() != null, TEValorDeCurso, TECurso, TEIdentificador, TEValorDeIdentificador);
    }

    private void actualizarCamposExpecificos() {
        if (usuarioActual.getEstudiante() != null) {
            TEValorDeCurso.setText(usuarioActual.getEstudiante().getCurso() + "");
            TEValorDeIdentificador.setText(usuarioActual.getEstudiante().getIdentificador() + "");
            actualizarParametro("Carrera:", usuarioActual.getEstudiante().getCarrera());
            return;
        }
        if (usuarioActual.getAdministrador() != null) {
            actualizarParametro("Cargo:", usuarioActual.getAdministrador().getCargo());
            return;
        }
        actualizarParametro("Especializacion:", usuarioActual.getProfesor().getEspecializacion());
    }

    private void actualizarParametro(String tipo, String valor) {
        TETipoDeParametro.setText(tipo);
        TEParametro.setText(valor);
    }
//    private void iniSeguridad() {
//        ValidatorBase V1[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Es incorrecta", s -> !TCuenta.getText().trim().equals(u.getNombreDeCuenta())), dialog, TCuenta);
//        ValidatorBase V2[] = Utiles.FX.VisualFX.setValidator(null, dialog, TEspecializacion);
//        ValidatorBase V3[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Minimo 8 caracteres", s -> TP.getText().length() >= 8), dialog, TP);
//        ValidatorBase V4[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Es diferente", s -> TP.getText().equals(TPConfimar.getText())), dialog, new Node[]{TP}, TPConfimar);
//        Utiles.FX.VisualFX.relacionarValidador(new ValidatorBase[][]{V0, V1, V2, V3, V4}, new Node[]{dialog}, BAceptar);
//    }

//    private void iniDialog() {
//        dialog = new JFXDialog();
//        dialog.setContent(Pstack);
//        dialog.setTransitionType(JFXDialog.DialogTransition.TOP);
//        JFXDepthManager.setDepth(dialog, 6);
//    }
}
