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
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dialogo_Agregar_AdministradorController extends ConVentana implements Initializable {

//    private JFXDialog dialog = new JFXDialog();
    Administrador P[];
    Usuario U[];
    private int idActual = -1;
    @FXML
    private StackPane Pstack;

    @FXML
    private JFXTextField TNombre;

    @FXML
    private JFXTextField TCuenta;

    @FXML
    private JFXPasswordField TP;

    @FXML
    private JFXPasswordField TPConfimar;

    @FXML
    private JFXButton BVibilidadContraseña;

    @FXML
    private JFXButton BVibilidadReafirmar;

    @FXML
    private JFXTextField TCargo;

    @FXML
    private JFXButton BAtras;

    @FXML
    private JFXButton BAceptar;

    @FXML
    private JFXTextField TFContraseña;

    @FXML
    private JFXTextField TFReafirmarContraseña;

    @FXML
    void apretoAceptar(MouseEvent event) {
        try {
            Administrador P = idActual == -1 || (P = getAdministradorActual()) == null ? createAdministrador() : P;
            P.setCargo(TCargo.getText().trim());
            createUsuario(idActual, P, TNombre, TCuenta, TP);
            try {
                P.save();
            } catch (Exception ex) {
                System.out.println("ignorar cuatro");
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            responerException(ex);
        }
//        if(dialog!=null&&dialog.getContent()!=null&&dialog.getDialogContainer()!=null){
//        dialog.close();
//        }

        close();
    }

    @FXML
    void apretoAtras(MouseEvent event) {
        close();
    }

    @FXML
    void apretoVibilidadContraseña(MouseEvent event) {

    }

    @FXML
    void apretoVibilidadReafirmar(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // iniDialog();
        BAceptar.setDefaultButton(true);
    }

    private void iniSeguridad() {
        eventoCancelarIdActual();
        ValidatorBase V0[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeAdministrador()), getVentana(), TNombre);
        ValidatorBase V1[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeUsuario()), getVentana(), TCuenta);
        ValidatorBase V2[] = Utiles.FX.VisualFX.setValidator(getVentana(), TCargo);
        ValidatorBase V3[] = Utiles.FX.VisualFX.setValidator(() -> new Validador(REQUISITOS_CONTRASEÑA, s -> TP.getText().length() >= 8), getVentana(), TP,TFContraseña);
        ValidatorBase V4[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Es diferente", s -> TP.getText().equals(TPConfimar.getText())), null, new Object[]{TP, getVentana()}, TPConfimar,TFReafirmarContraseña);
        Utiles.FX.VisualFX.relacionarValidador(new ValidatorBase[][]{V0, V1, V2, V3, V4}, new Object[]{getVentana()}, BAceptar);
        Utiles.FX.VisualFX.validar(TNombre, TCuenta, TCargo, TP, TPConfimar,TFContraseña,TFReafirmarContraseña);

        Utiles.FX.VisualFX.soloNombres(TNombre);
        Utiles.FX.VisualFX.sincronizarTFContrazeña(TFContraseña, TP, BVibilidadContraseña, TFReafirmarContraseña, TPConfimar, BVibilidadReafirmar);
    }

    private boolean existeAdministrador() {
        for (int i = 0; i < P.length; i++) {
            if (P[i].getUsuario().getNombre().trim().equalsIgnoreCase(TNombre.getText().trim()) && P[i].getUsuarioId() != idActual) {
                return true;
            }
        }
        return false;
    }

    private boolean existeUsuario() {
        for (int i = 0; i < U.length; i++) {
            if (U[i].getNombreDeCuenta().trim().equalsIgnoreCase(TCuenta.getText().trim()) && U[i].getId() != idActual) {
                return true;
            }
        }
        return false;
    }

    private void eventoCancelarIdActual() {
        addOnClosed(() -> {
            idActual = -1;
        });
//        Utiles.FX.VisualFX.addOnDialogClosed(dialog, v -> {
//            idActual = -1;
//        });
    }

//    private void iniDialog() {
//        //dialog = new JFXDialog();
//        dialog.setContent(Pstack);
//        dialog.setTransitionType(JFXDialog.DialogTransition.LEFT);
//        JFXDepthManager.setDepth(dialog, 6);
//    }
    private void actualizarBD() {
        actualizarBD(false);
    }

    private void actualizarBD(boolean establecerPredeterminado) {
        Platform.runLater(() -> {

            boolean estadoBotonAcepar = BAceptar.isDisable();
            try {
                Utiles.FX.VisualFX.activarComponentes(false, BAceptar, TNombre, TCuenta, TCuenta, TP, TPConfimar);
                P = getAdministradorAll();
                U = getUsuarioAll();
                if (establecerPredeterminado) {
                    predeterminadoActual();
                }
            } catch (Exception ex) {
                responerException(ex);
            }
            Utiles.FX.VisualFX.activarComponentes(true, TNombre, TCuenta, TCuenta, TP, TPConfimar);
            BAceptar.setDisable(estadoBotonAcepar);
        });
    }

    @Override
    public void show() {
//        System.out.println("adminsitrador");
        show(-1);
    }

    public void show(int id) {
//        iniDialog();
        BAtras.setVisible(true);
        getVentana().show();
        this.idActual = id;
        ini();

    }

    public void ini() {
        actualizarBD(true);
    }

    @Override
    public void iniStage(Parent p) {
        super.iniStage(p); //To change body of generated methods, choose Tools | Templates.
        iniSeguridad();
    }

    private void predeterminadoActual() {
        if (idActual != -1) {
            Administrador Pe = getAdministradorActual();
            if (Pe != null) {
                TNombre.setText(Pe.getUsuario().getNombre());
                TCuenta.setText(Pe.getUsuario().getNombreDeCuenta());
                TP.setText(Pe.getUsuario().getContrasena());
                TPConfimar.setText(Pe.getUsuario().getContrasena());
                TCargo.setText(Pe.getCargo());

            }
        }
    }

    private Usuario getUsuarioActual() {
        return getUsuario(idActual);
    }

    private Administrador getAdministradorActual() {
        return getAdministrador(idActual);
    }

    public StackPane getPstack() {
        return Pstack;
    }

    public JFXButton getBAceptar() {
        return BAceptar;
    }

    public JFXButton getBAtras() {
        return BAtras;
    }

}
