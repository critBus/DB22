/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

//import Utiles.FX.Validadores.TextFieldValidador;
import Utiles.FX.ConVentana;
import Utiles.FX.Validadores.Validador;
import static Utiles.FX.VisualFX.getSeleccionado;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import clases.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
//PersistentException
import org.orm.PersistentException;
//import validadores.palabraValidator;
import static visual.probar.*;

public class Dialogo_Agregar_TemaController2 extends ConVentana implements Initializable {

    private Tema T[];
    private int idActual = -1;

//    private JFXDialog dialog;
    @FXML
    private AnchorPane PAnchor;

    @FXML
    private JFXTextField TTema;

    @FXML
    private JFXListView<String> LV;

//    @FXML
//    private JFXTextField TPalabra;
//
//    @FXML
//    private JFXButton BAgregar;
    @FXML
    private JFXButton BAtras;

    @FXML
    private JFXButton BAceptar;

    @FXML
    private JFXButton BClear;

    @FXML
    private JFXButton BEliminarPalabra;

    @FXML
    private StackPane PStack;

    @FXML
    void apretoAceptar(MouseEvent event) {
        try {
            Tema t = idActual == -1 || (t = getTemaActual()) == null ? TemaFactory.createTema() : t;
            t.setNombre(TTema.getText().trim());
            t.save();

        } catch (Exception ex) {
            responerException(ex);
        }
        close();
        //System.out.println("lo lograte");
    }

    public LinkedList<String> getPalabrasActuales() {
        LinkedList<String> r = new LinkedList();
        for (int i = 0; i < LV.getItems().size(); i++) {
            r.add(LV.getItems().get(i).toLowerCase());
        }
        return r;
    }

    @FXML
    void apretoAtras(MouseEvent event) {
        close();
    }

    @FXML
    void apretoClear(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show( "Desea eliminar todos los Temas?/nSe liminaran todos los Pensamietos!", () -> {
                try {
                    eliminarTemaAll();
                     LV.getItems().clear();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
        
//        
//        try {
//            eliminarTemaAll();
//            LV.getItems().clear();
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
    }

    @FXML
    void apretoEliminarPalabra(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar este Tema?/nSe liminaran los pensamietos Relacionados!", () -> {
                try {
                    eliminarTema(getTema(getSeleccionado(LV)));
                    Utiles.FX.VisualFX.eliminarDeJFXList(LV);
                  
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }

//        try {
//            Tema t = TemaFactory.loadTemaByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
//            eliminarTema(t);
//            Utiles.FX.VisualFX.eliminarDeJFXList(LV);
//        } catch (Exception ex) {
//            Logger.getLogger(Dialogo_Agregar_TemaController2.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BAceptar.setDefaultButton(true);
    }

    @Override
    public void iniStage(Parent p) {
        super.iniStage(p); //To change body of generated methods, choose Tools | Templates.
        Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeTema()), getVentana(), BAceptar, new Button[]{BAceptar, BClear, BEliminarPalabra}, TTema);
        Utiles.FX.VisualFX.relacionarComponentes(LV, BEliminarPalabra, BClear);
        addOnClosed(() -> {
            idActual = -1;
        });
    }

    public boolean existeTema() {
        for (int i = 0; i < LV.getItems().size(); i++) {
            if (TTema.getText().trim().equalsIgnoreCase(LV.getItems().get(i)) && T[i].getId() != idActual) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void show() {
        show(-1);
    }

    public void show(int id) {
        // System.out.println("a2");
        getVentana().show();
        this.idActual = id;
        actualizarBD(true);

    }

    private void actualizarBD() {
        actualizarBD(false);
    }

    private void actualizarBD(boolean establecerPredeterminado) {
        Platform.runLater(() -> {
            boolean estadoBotonAcepar = BAceptar.isDisable();
            Utiles.FX.VisualFX.activarComponentes(false, LV, BAceptar);
            try {

                T = TemaFactory.listTemaByQuery(null, null);
                String nombres[] = new String[T.length];
                for (int i = 0; i < T.length; i++) {
                    nombres[i] = T[i].getNombre();
                    //   LV.getItems().add(T[i].getNombre());
                }
                LV.getItems().clear();
                LV.getItems().addAll(nombres);
                if (establecerPredeterminado) {
                    predeterminadoPensamientoActual();
                }
            } catch (Exception ex) {
                responerException(ex);
            }
            Utiles.FX.VisualFX.activarComponentes(true, LV);
            BAceptar.setDisable(estadoBotonAcepar);
        });

    }

    private void predeterminadoPensamientoActual() {
        if (idActual != -1) {
            Tema Te = getTemaActual();
            if (Te != null) {
                TTema.setText(Te.getNombre());
                TTema.requestFocus();
            }
        }
    }

    private Tema getTemaActual() {
        for (int i = 0; i < T.length; i++) {
            if (T[i].getId() == idActual) {
                return T[i];

            }
        }
        return null;
    }

    public JFXListView<?> getLV() {
        return LV;
    }

    public JFXTextField getTTema() {
        return TTema;
    }

    public void setTTema(JFXTextField TTema) {
        this.TTema = TTema;
    }

    public JFXButton getBAceptar() {
        return BAceptar;
    }

}
