/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.FX.Celdas.AutoCompleteComboBoxListener;
import Utiles.FX.ConVentana;
import Utiles.FX.Validadores.Validador;
import static Utiles.FX.VisualFX.select;
import clases.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.validation.base.ValidatorBase;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import org.orm.PersistentException;
import static visual.probar.responerException;

import static Utiles.MetodosUtiles.Tempus.getDate;
import static Utiles.MetodosUtiles.Tempus.getLocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import javafx.scene.Parent;
import static visual.probar.*;
//PersistentException

public class Dialogo_Agregar_LibroController extends ConVentana implements Initializable {

    private int idActual = -1;
//    private JFXDialog dialog;
    Libro L[];
    private boolean apretoAgregarAutor = false;
    // ObservableList<String> A;
    @FXML
    private JFXTextField TTitulo;

    @FXML
    private JFXDatePicker DP;

    @FXML
    private Spinner<Integer> ESpiner;

    @FXML
    private JFXCheckBox CX;

    @FXML
    private JFXListView<String> LVInternet;

    @FXML
    private JFXTextField TInternet;

    @FXML
    private JFXButton BAgregarInternet;

    @FXML
    private JFXButton BClearInternet;

    @FXML
    private JFXButton BEliminarPalabraInternet;

    @FXML
    private JFXListView<String> LVAutores;

    @FXML
    private JFXButton BClearAutores;

    @FXML
    private JFXButton BEliminarPalabraAutores;

    @FXML
    private JFXComboBox<String> CBAutores;

    @FXML
    private JFXButton BAgregarAutores;

    @FXML
    private JFXButton BCrearAutores;

    @FXML
    private JFXButton BAtras;

    @FXML
    private JFXButton BAceptar;

    @FXML
    private StackPane Pstack;

    @FXML
    void apretoAceptar(MouseEvent event) {

        BAceptar.setDisable(true);
        close();

//        System.out.println("apreto aceptar");
//        System.out.println("id=" + idActual);
        try {

            //  Titulo T = TituloFactory.createTitulo();
            Titulo T = idActual == -1 || (T = getTituloActual()) == null ? TituloFactory.createTitulo() : T;

            if (idActual != -1) {
                eliminarTituloAutorAll(T);
                eliminarDisponibilidadAll(T);
                // T.disponibilidad.clear();
                //T.autor.clear();
            }
            T.setNombre(TTitulo.getText().trim());
            T.setFecha(getDate(DP.getValue()));
            for (int i = 0; i < LVAutores.getItems().size(); i++) {
                T.autor.add(AutorFactory.loadAutorByQuery("Nombre='" + LVAutores.getItems().get(i) + "'", null));
            }
            T.save();
            if (CX.isSelected()) {
                crearDisponibilidadFisica(T);
            }
            for (int i = 0; i < LVInternet.getItems().size(); i++) {
                crearDisponibilidad(T, LVInternet.getItems().get(i));
            }

            Libro l = idActual == -1 || (l = T.getLibro()) == null ? LibroFactory.createLibro() : l;
            //  Libro l = LibroFactory.createLibro();
            l.setTitulo(T);
            l.setEdicion(ESpiner.getValue());
            l.save();
            T.setLibro(l);

        } catch (Exception ex) {
            responerException(ex);
        }

    }

    @FXML
    void apretoAgregarAutores(MouseEvent event) {
        LVAutores.getItems().add(CBAutores.getEditor().getText().trim());

    }

    @FXML
    void apretoAgregarInternet(MouseEvent event) {
        LVInternet.getItems().add(TInternet.getText().trim());
    }

    @FXML
    void apretoAtras(MouseEvent event) {
        close();
    }

    @FXML
    void apretoClearAutores(MouseEvent event) {
        LVAutores.getItems().clear();
    }

    @FXML
    void apretoClearInternet(MouseEvent event) {
        LVInternet.getItems().clear();
    }

    @FXML
    void apretoCrearAutores(MouseEvent event) {
        dialogo_Agregar_AutorController.show();
        apretoAgregarAutor = true;
    }

    @FXML
    void apretoEliminarPalabraAutores(MouseEvent event) {
        Utiles.FX.VisualFX.eliminarDeJFXList(LVAutores);
    }

    @FXML
    void apretoEliminarPalabraInternet(MouseEvent event) {
        Utiles.FX.VisualFX.eliminarDeJFXList(LVInternet);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
 BAceptar.setDefaultButton(true);
    }

    @Override
    public void iniStage(Parent p) {
        super.iniStage(p); //To change body of generated methods, choose Tools | Templates.
        Utiles.FX.VisualFX.iniSpinnerInteger(ESpiner, 1, 99);
//        dialog = new JFXDialog();
//
//        ESpiner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, 1));
        Utiles.FX.VisualFX.setEditorCSS(TEXT_FIEL_CLASE_CSS, DP);
        Utiles.FX.VisualFX.setAutoCompleteComboBoxListenerYCSS(TEXT_FIEL_CLASE_CSS, CBAutores);
        iniSeguridad();
//        AutoCompleteComboBoxListener autoCB = new AutoCompleteComboBoxListener(CBAutores, "");
//
//        DP.getEditor().getStyleClass().add("JFXtextFielTextoBlanco");
//        CBAutores.getEditor().getStyleClass().add("JFXtextFielTextoBlanco");

//        dialog.setContent(Pstack);
//        dialog.setTransitionType(JFXDialog.DialogTransition.LEFT);
//        JFXDepthManager.setDepth(dialog, 6);
        Utiles.FX.VisualFX.addOnMousePressed(dialogo_Agregar_AutorController.getBAceptar(), v -> {
            if (apretoAgregarAutor && isShowing()) {
                actualizarBD(true, false);
                apretoAgregarAutor = false;
//                 CBAutores.getEditor().setText(dialogo_Agregar_AutorController.getTNombre().getText().trim());
//                  CBAutores.validate();
            }
        });
    }

    private void iniSeguridad() {
        Utiles.FX.VisualFX.relacionarComponentes(LVInternet, BEliminarPalabraInternet, BClearInternet);
        Utiles.FX.VisualFX.relacionarComponentes(LVAutores, BEliminarPalabraAutores, BClearAutores);
        ValidatorBase V0[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeLibro()), getVentana(), new Button[]{BAceptar}, TTitulo);
        ValidatorBase V1[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", esValidaDireccionWeb(TInternet, v -> !existeDireccion())), getVentana(), BAgregarInternet, new Button[]{BAceptar, BClearInternet, BEliminarPalabraInternet}, TInternet);
        ValidatorBase V2[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Esta fecha es Incorrecta", s -> esFechaAceptable()), getVentana(), DP);
        ValidatorBase V3[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeAutor()), getVentana(), BAgregarAutores, new Button[]{BAceptar, BClearAutores, BEliminarPalabraAutores}, CBAutores);
        Utiles.FX.VisualFX.relacionarValidador(new ValidatorBase[][]{V0, V2}, new Object[]{CX, BAgregarAutores, BAgregarInternet, LVAutores, LVInternet, getVentana()},
                v -> {
//                    System.out.println("prueba="+probar.prueba++);
//                    System.out.println("!LVInternet.getItems().isEmpty()="+!LVInternet.getItems().isEmpty());
//                    System.out.println("CX.isSelected()="+CX.isSelected());
//                    System.out.println("((!LVInternet.getItems().isEmpty()) || CX.isSelected())="+((!LVInternet.getItems().isEmpty()) || CX.isSelected()));
//                    System.out.println("!LVAutores.getItems().isEmpty()="+!LVAutores.getItems().isEmpty());
//                    System.out.println("(!LVInternet.getItems().isEmpty()) || CX.isSelected()) && !LVAutores.getItems().isEmpty()="+(((!LVInternet.getItems().isEmpty()) || CX.isSelected()) && !LVAutores.getItems().isEmpty()));
                    return ((!LVInternet.getItems().isEmpty()) || CX.isSelected()) && !LVAutores.getItems().isEmpty();

                }, BAceptar);
        addOnClosed(() -> {
            if (!(Utiles.FX.VisualFX.isHoverOr(dialogo_Agregar_AutorController.getVentana()))) {
//                System.out.println("1 id nega");
                idActual = -1;
            }

        });

    }

    private void actualizarBD() {
        actualizarBD(false, false);
    }

    private void actualizarBD(boolean seleccionarAutor, boolean predeterminado) {
        Platform.runLater(() -> {
            boolean estadoBotonAcepar = BAceptar.isDisable();
            try {
                BAceptar.setDisable(true);
                TTitulo.setDisable(true);
                L = LibroFactory.listLibroByQuery(null, null);

                CBAutores.setDisable(true);
                LinkedList<String> l = new LinkedList<>(Arrays.asList(CBAutores.getItems().toArray(new String[0])));

                Autor A[] = AutorFactory.listAutorByQuery(null, null);
                String N[] = new String[A.length];
                for (int i = 0; i < A.length; i++) {
                    N[i] = A[i].getNombre();
                    if (l.contains(N[i])) {
                        l.remove(N[i]);
                    }
                }
                l.forEach(v -> {
                    LVAutores.getItems().remove(v);
                });
                CBAutores.getItems().clear();
                CBAutores.getItems().setAll(N);

                if (seleccionarAutor) {
                    select(CBAutores, dialogo_Agregar_AutorController.getTNombre().getText());
//                    CBAutores.getEditor().setText(dialogo_Agregar_AutorController.getTNombre().getText().trim());
                    CBAutores.validate();

                }
                if (predeterminado) {
                    predeterminadoActual();
                }
            } catch (Exception ex) {
                responerException(ex);
            }
            CBAutores.setDisable(false);
            TTitulo.setDisable(false);
            BAceptar.setDisable(estadoBotonAcepar);
        });
    }

    private boolean esFechaAceptable() {
        LocalDate hoy = LocalDate.now(), d = DP.getValue();
        if (hoy.getYear() < 2019) {
            return true;
        }
        return d.compareTo(hoy) < 0;
    }

    private boolean existeAutor() {
        for (int i = 0; i < LVAutores.getItems().size(); i++) {
            if (CBAutores.getEditor().getText().trim().equalsIgnoreCase(LVAutores.getItems().get(i))) {
                return true;
            }
        }

        return false;
    }

    private boolean tieneCBAAutor() {
        for (int i = 0; i < CBAutores.getItems().size(); i++) {
            if (CBAutores.getEditor().getText().trim().equalsIgnoreCase(CBAutores.getItems().get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean existeDireccion() {
        for (int i = 0; i < LVInternet.getItems().size(); i++) {
            if (TInternet.getText().trim().equalsIgnoreCase(LVInternet.getItems().get(i))) {
                return true;
            }
        }

        return false;
    }

    private boolean existeLibro() {
        for (int i = 0; i < L.length; i++) {
            if (L[i].getTitulo().getNombre().trim().equalsIgnoreCase(TTitulo.getText().trim()) && L[i].getTitulo().getId() != idActual) {
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

        getVentana().show();
        this.idActual = id;
        actualizarBD(false, true);
        apretoAgregarAutor = false;

    }

    private void predeterminadoActual() {
        if (idActual != -1) {
            Libro L = getLibroActual();
            if (L != null) {
                TTitulo.setText(L.getTitulo().getNombre());
                DP.setValue(getLocalDate(L.getTitulo().getFecha()));
                ESpiner.getEditor().setText(L.getEdicion().intValue() + "");
                LVInternet.getItems().clear();
                CX.setSelected(false);
                //  final boolean biblioteca = true;
                L.getTitulo().disponibilidad.getCollection().forEach(v -> {
                    Disponibilidad d = (Disponibilidad) v;
                    if (d.getUbicacion().equals(EN_LA_BIBLIOTECA)) {
                        CX.setSelected(true);
                        return;
                        //biblioteca=false;
                    }
                    LVInternet.getItems().add(d.getUbicacion());

                });
                LVAutores.getItems().clear();
                L.getTitulo().autor.getCollection().forEach(v -> {
                    LVAutores.getItems().add(((Autor) v).getNombre());
                });
            }
        }
    }

    private Libro getLibroActual() {
        for (int i = 0; i < L.length; i++) {
            if (L[i].getTitulo().getId() == idActual) {
                return L[i];

            }
        }
        return null;
    }

    private Titulo getTituloActual() {
        for (int i = 0; i < L.length; i++) {
            if (L[i].getTitulo().getId() == idActual) {
                return L[i].getTitulo();

            }
        }
        return null;
    }

    

    public JFXButton getBAceptar() {
        return BAceptar;
    }

    public JFXTextField getTTitulo() {
        return TTitulo;
    }

}
