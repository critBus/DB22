/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.FX.ConVentana;
import Utiles.FX.Validadores.Validador;
import Utiles.FX.objetoTreeTableView;
import Utiles.MetodosUtiles.MetodosUtiles;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import clases.*;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXToggleButton;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;
import org.orm.PersistentException;

import static Utiles.MetodosUtiles.Tempus.getDate;
import static Utiles.MetodosUtiles.Tempus.getLocalDate;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.validation.base.ValidatorBase;
import java.time.LocalDate;
import java.util.function.Predicate;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import static visual.probar.*;
//PersistentException

public class Dialogo_Agregar_AutorController extends ConVentana implements Initializable {

    private Autor A[];
    private int idActual = -1;
//    private JFXDialog dialog;
    @FXML
    private AnchorPane PAnchor;

    @FXML
    private JFXTextField TNombre;

    @FXML
    private JFXListView<String> LV;

    @FXML
    private JFXButton BAtras;

    @FXML
    private JFXButton BAceptar;

    @FXML
    private JFXDatePicker DPFechaNacimiento;

    @FXML
    private JFXDatePicker DPFechaMuerte;

    @FXML
    private JFXToggleButton TBMuerte;

    @FXML
    private JFXButton BClear;

    @FXML
    private JFXButton BEliminarPalabra;

    @FXML
    void apretoAceptar(MouseEvent event) {
        try {
            //  Autor a = AutorFactory.createAutor();
            Autor a = idActual == -1 || (a = getAutorActual()) == null ? AutorFactory.createAutor() : a;
            a.setNombre(TNombre.getText());
            a.setFecha_Nacimiento(getDate(DPFechaNacimiento.getValue()));
            a.setFecha_Muerte(TBMuerte.isSelected() ? getDate(DPFechaMuerte.getValue()) : null);
            a.save();
        } catch (Exception ex) {
            responerException(ex);
        }
        close();

    }

    @FXML
    void apretoClear(MouseEvent event) {
          try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show( "Desea eliminar todos los Autores", () -> {
                try {
                    if (eliminarAutorAll().length > 0) {// /n
                        dialogo_solo_AceptarController.show( "No se eliminaron algunos porque hay \nTitulos  con un unico Autor");
                    } else {
                          LV.getItems().clear();
                      //  crearTablaAutor();
                    }

                    //Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVAutores, obAutores);
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
//        try {
//            eliminarAutorAll();
//            LV.getItems().clear();
//        } catch (Exception ex) {
//            responerException(ex);
//        }
    }

    @FXML
    void apretoEliminarPalabra(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show( "Desea eliminar este Autor", () -> {
                try {
                    if (eliminarAutor(getAutor(Utiles.FX.VisualFX.getSeleccionado(LV))).length > 0) {
                        dialogo_solo_AceptarController.show( "No se elimino porque hay Titulos donde\n este es el unico Autor");
                    } else {
                         Utiles.FX.VisualFX.eliminarDeJFXList(LV);
//                        actualizarAutores();
//                        crearTablaAutor();
                    }

                    //Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVAutores, obAutores);
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
        
//        try {
//            Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
//            System.out.println("a=" + a);
//            eliminarAutor(a);
//            Utiles.FX.VisualFX.eliminarDeJFXList(LV);
//        } catch (Exception ex) {
//            responerException(ex);
//        }

    }

    @FXML
    void apretoTBMuerte(MouseEvent event) {
        // System.out.println("TBMuerte.isSelected()="+TBMuerte.isSelected());
        Utiles.FX.VisualFX.activarComponentes(esSelected(), DPFechaMuerte);
    }

    private boolean esSelected() {
        //    return !TBMuerte.isDisable();
        return !TBMuerte.isSelected();
    }

    @FXML
    void apretoAtras(ActionEvent event) {
        close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
 BAceptar.setDefaultButton(true);
    }

    @Override
    public void iniStage(Parent p) {
        super.iniStage(p); //To change body of generated methods, choose Tools | Templates.
        Utiles.FX.VisualFX.setEditorCSS(TEXT_FIEL_CLASE_CSS, DPFechaNacimiento, DPFechaMuerte);
        iniSeguridad();
    }

    private void iniSeguridad() {
        Utiles.FX.VisualFX.relacionarComponentes(LV, BEliminarPalabra, BClear);
        ValidatorBase V0[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeAutor()), getVentana(), new Button[]{BAceptar, BClear, BEliminarPalabra}, TNombre);
        ValidatorBase V1[] = Utiles.FX.VisualFX.setValidator(() -> new Validador<DatePicker>("Esta fecha es Incorrecta", s -> {
            return esFechaAceptable(DPFechaNacimiento, true) && (!esSelected() || DPFechaMuerte.getValue() == null || DPFechaNacimiento.getValue().compareTo(DPFechaMuerte.getValue()) < 0);
        }), null, new Object[]{DPFechaMuerte, getVentana()}, new Button[]{}, DPFechaNacimiento);
        ValidatorBase V2[] = Utiles.FX.VisualFX.setValidator(() -> new Validador<DatePicker>("Esta fecha es Incorrecta", s -> {
            return esFechaAceptable(DPFechaMuerte, false) && (DPFechaNacimiento.getValue() == null || DPFechaNacimiento.getValue().compareTo(DPFechaMuerte.getValue()) < 0);
        }), null, new Object[]{DPFechaNacimiento, getVentana()}, new Button[]{}, DPFechaMuerte);
        Predicate P[] = MetodosUtiles.crearPredicate(3);
        P[2] = v -> TBMuerte.isSelected();
        Utiles.FX.VisualFX.relacionarValidador(new ValidatorBase[][]{V0, V1, V2}, P, new Object[]{TBMuerte, getVentana()}, null, BAceptar);
        addOnClosed(() -> {
            idActual = -1;
        });
        Utiles.FX.VisualFX.soloNombres(TNombre);
    }

    private boolean esFechaAceptable(JFXDatePicker D, boolean nacimiento) {
        //if(D.get){}
        LocalDate hoy = LocalDate.now(), d = D.getValue();
        if (hoy.getYear() < 2019) {
            return true;
        }
//        System.out.println("hoy="+hoy);
//        System.out.println("d.compareTo(hoy)="+d.compareTo(hoy));
//        System.out.println("d.compareTo(hoy)<0="+(d.compareTo(hoy)<0));
        return d.compareTo(hoy) < 0 && (nacimiento ? hoy.getYear() - d.getYear() > 20 : true);
    }

    public boolean existeAutor() {
        for (int i = 0; i < LV.getItems().size(); i++) {
            if (TNombre.getText().trim().equalsIgnoreCase(LV.getItems().get(i)) && A[i].getId() != idActual) {
                return true;
            }
        }
//        try {
//            Autor A[] = AutorFactory.listAutorByQuery(null, null);
//            for (int i = 0; i < A.length; i++) {
//                if (A[i].getNombre().equalsIgnoreCase(TNombre.getText().trim())) {
//                    return true;
//                }
//            }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
        return false;
    }

    private void actualizarBD() {
        actualizarBD(false);
    }

    @Override
    public void show() {
        show( -1);
    }

    public void show( int id) {

     getVentana().show();
        this.idActual = id;
        actualizarBD(true);

    }

    private void actualizarBD(boolean establecerPredeterminado) {
        Platform.runLater(() -> {

            boolean estadoBotonAcepar = BAceptar.isDisable();
            try {
                Utiles.FX.VisualFX.activarComponentes(false, LV, BAceptar, TNombre);
                A = AutorFactory.listAutorByQuery(null, null);
                String nombres[] = new String[A.length];
                for (int i = 0; i < A.length; i++) {
                    nombres[i] = A[i].getNombre();
                    //   LV.getItems().add(T[i].getNombre());
                }
                LV.getItems().clear();
                LV.getItems().addAll(nombres);

                if (establecerPredeterminado) {
                    predeterminadoActual();
                }
//                ob.clear();
//                ob.addAll(objetoTreeTableView.getOb(Ti));
            } catch (Exception ex) {
                responerException(ex);
            }
            Utiles.FX.VisualFX.activarComponentes(true, LV, TNombre);
            // CB.setDisable(false);
//            TNombre.setDisable(false);
            BAceptar.setDisable(estadoBotonAcepar);
//            actualizarTabla();

        });
    }

    private void predeterminadoActual() {
        if (idActual != -1) {
            Autor Au = getAutorActual();
            if (Au != null) {
                TNombre.setText(Au.getNombre());
                DPFechaNacimiento.setValue(getLocalDate(Au.getFecha_Nacimiento()));
                if (Au.getFecha_Muerte() != null) {
                    TBMuerte.setSelected(true);
                    DPFechaMuerte.setValue(getLocalDate(Au.getFecha_Muerte()));
                    DPFechaMuerte.requestFocus();
                }
                Utiles.FX.VisualFX.requestFocusConsecutivo(DPFechaNacimiento, TNombre);
            }
        }
    }

    private Autor getAutorActual() {
        for (int i = 0; i < A.length; i++) {
            if (A[i].getId() == idActual) {
                return A[i];

            }
        }
        return null;
    }

    public JFXListView<?> getLV() {
        return LV;
    }

   
    public JFXTextField getTNombre() {
        return TNombre;
    }

    public void setTNombre(JFXTextField TNombre) {
        this.TNombre = TNombre;
    }

    public JFXButton getBAceptar() {
        return BAceptar;
    }

}
