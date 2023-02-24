/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import Utiles.FX.Celdas.AutoCompleteComboBoxListener;
import Utiles.FX.Celdas.CellLista;
import Utiles.FX.ConVentana;
import Utiles.FX.Validadores.Validador;
import Utiles.FX.objetoTreeTableView;
import clases.*;
import static visual.probar.*;
import static Utiles.FX.VisualFX.setValue;
import Utiles.FX.TablasFX;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.validation.base.ValidatorBase;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class Dialogo_Agregar_EstudianteController extends ConVentana implements Initializable {

    Estudiante P[];
    Usuario U[];
    private int idActual = -1;

    @FXML
    private StackPane Pstack;

    @FXML
    private AnchorPane PAnchor;

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
    private JFXTextField TCarrera;

    @FXML
    private JFXButton BAtras;

    @FXML
    private JFXButton BAceptar;

    @FXML
    private Spinner<Integer> ESCurso;

    @FXML
    private Spinner<Integer> ESNumero;
 @FXML
    private JFXTextField TFContraseña;

    @FXML
    private JFXTextField TFReafirmarContraseña;
    @FXML
    void apretoVibilidadContraseña(MouseEvent event) {

    }

    @FXML
    void apretoVibilidadReafirmar(MouseEvent event) {

    }

    @FXML
    void apretoAceptar(MouseEvent event) {
        try {
//            Usuario u = idActual == -1 || (u = getUsuarioActual()) == null ? createUsuario() : u;
//            u.setNombre(TNombre.getText().trim());
//            u.setContraseña(TP.getText().trim());
//            u.setNombreDeCuenta(TCuenta.getText().trim());
//            u.setPermisos(EN_LA_BIBLIOTECA);
//            try {
//                u.save();
//            } catch (Exception ex) {
//                System.out.println("ignorar cuatro");
//                ex.printStackTrace();
//            }
//            
            Estudiante P = idActual == -1 || (P = getEstudianteActual()) == null ? createEstudiante() : P;
            P.setCarrera(TCarrera.getText().trim());
            P.setCurso(ESCurso.getValue());
            P.setIdentificador(ESNumero.getValue());
            createUsuario(idActual, P, TNombre, TCuenta, TP);
            try {
                P.save();
            } catch (Exception ex) {
                System.out.println("ignorar cuatro");
                ex.printStackTrace();
            }

//           P.setUsuario(u);
//           u.setEstudiante(P);
//            System.out.println("creo");
        } catch (Exception ex) {
            responerException(ex);
        }
        close();
    }

    @FXML
    void apretoAtras(MouseEvent event) {
        close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 BAceptar.setDefaultButton(true);
    }

    @Override
    public void iniStage(Parent p) {
        super.iniStage(p);//To change body of generated methods, choose Tools | Templates.
        Utiles.FX.VisualFX.iniSpinnerInteger(ESCurso, 1, 5);
        Utiles.FX.VisualFX.iniSpinnerInteger(ESNumero, 1, 999);
        iniSeguridad();
    }

    private void iniSeguridad() {
        eventoCancelarIdActual();
        ValidatorBase V0[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeEstudiante()), getVentana(), TNombre);
        ValidatorBase V1[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeUsuario()), getVentana(), TCuenta);
        ValidatorBase V2[] = Utiles.FX.VisualFX.setValidator(getVentana(), TCarrera);
        ValidatorBase V3[] = Utiles.FX.VisualFX.setValidator(() -> new Validador(REQUISITOS_CONTRASEÑA, s -> TP.getText().length() >= 8), getVentana(), TP,TFContraseña);
        ValidatorBase V4[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Es diferente", s -> TP.getText().equals(TPConfimar.getText())), null, new Object[]{TP, getVentana()}, TPConfimar,TFReafirmarContraseña);
        Utiles.FX.VisualFX.relacionarValidador(new ValidatorBase[][]{V0, V1, V2, V3, V4}, new Object[]{getVentana()}, BAceptar);
        Utiles.FX.VisualFX.soloNombres(TNombre);
        Utiles.FX.VisualFX.sincronizarTFContrazeña(TFContraseña, TP, BVibilidadContraseña, TFReafirmarContraseña, TPConfimar, BVibilidadReafirmar);
    }

    private boolean existeEstudiante() {
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
    }

    private void actualizarBD() {
        actualizarBD(false);
    }

    private void actualizarBD(boolean establecerPredeterminado) {
        Platform.runLater(() -> {

            boolean estadoBotonAcepar = BAceptar.isDisable();
            try {
                Utiles.FX.VisualFX.activarComponentes(false, BAceptar, TNombre, TCarrera, TCuenta, TP, TPConfimar, ESCurso, ESNumero);
                P = getEstudianteAll();
                U = getUsuarioAll();
                if (establecerPredeterminado) {
                    predeterminadoActual();
                }
            } catch (Exception ex) {
                responerException(ex);
            }
            Utiles.FX.VisualFX.activarComponentes(true, TNombre, TCarrera, TCuenta, TP, TPConfimar, ESCurso, ESNumero);
            BAceptar.setDisable(estadoBotonAcepar);
        });
    }

    @Override
    public void show() {
        show(-1);
    }

    public void show(int id) {
 getVentana().show();
        this.idActual = id;
        actualizarBD(true);

    }

    private void predeterminadoActual() {
        if (idActual != -1) {
            Estudiante Pe = getEstudianteActual();
            if (Pe != null) {
                TNombre.setText(Pe.getUsuario().getNombre());
                TCuenta.setText(Pe.getUsuario().getNombreDeCuenta());
                TP.setText(Pe.getUsuario().getContrasena());
                TPConfimar.setText(Pe.getUsuario().getContrasena());
                TCarrera.setText(Pe.getCarrera());
                setValue(ESCurso, Pe.getCurso());
                setValue(ESNumero, Pe.getIdentificador());

            }
        }
    }

    private Usuario getUsuarioActual() {
//        for (int i = 0; i < P.length; i++) {
//            if (P[i].getUsuarioId() == idActual) {
////                System.out.println("encontrado");
//                return P[i];
//
//            }
//        }
        return getUsuario(idActual);
    }

    private Estudiante getEstudianteActual() {
//        for (int i = 0; i < P.length; i++) {
//            if (P[i].getUsuarioId() == idActual) {
////                System.out.println("encontrado");
//                return P[i];
//
//            }
//        }
        return getEstudiante(idActual);
    }

    

}
