/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles.FX;

//import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
//import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.base.IFXLabelFloatControl;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
//import java.util.List;
//import javafx.scene.control.Accordion;
import javafx.event.EventHandler;
//import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.Border;
//import javafx.scene.layout.CornerRadii;
//import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
//import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;

import Utiles.Exepciones.*;
//import com.jfoenix.controls.JFXAlert;
import java.io.FileNotFoundException;
import java.io.IOException;
import Utiles.ClasesUtiles.Interfases.Funcionales.Creador;
import Utiles.ClasesUtiles.Interfases.Funcionales.Realizar;
import Utiles.ClasesUtiles.Interfases.Funcionales.Utilizar;
import Utiles.FX.Celdas.AutoCompleteComboBoxListener;
import Utiles.FX.Celdas.CellLista;
import Utiles.FX.Validadores.Validador;
import Utiles.MetodosUtiles.Archivo;
import clases.Tema;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.JFXTreeView;
import com.jfoenix.controls.base.IFXValidatableControl;
import com.jfoenix.controls.events.JFXDialogEvent;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
//import java.util.concurrent.LinkedBlockingQueue;
//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.StringProperty;
//import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Side;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javax.swing.Timer;
import visual.probar;

/**
 * Version 0.8
 *
 * @author Rene
 */
public abstract class VisualFX {

    public static void sincronizarTFContrazeña(JFXTextField tfV, JFXPasswordField pfV, Button visibilidadV, JFXTextField tf, JFXPasswordField pf, Button visibilidad, JFXTextField tfR, JFXPasswordField pfR, Button visibilidadR) {
        sincronizarTFContrazeña(tf, pf, visibilidad);
        sincronizarTFContrazeña(tfR, pfR, visibilidadR);
        sincronizarTFContrazeña(tfV, pfV, visibilidadV);
        tfR.visibleProperty().bindBidirectional(tf.visibleProperty());
        pfR.visibleProperty().bindBidirectional(pf.visibleProperty());

        tfV.visibleProperty().bindBidirectional(tf.visibleProperty());
        pfV.visibleProperty().bindBidirectional(pf.visibleProperty());

        tf.labelFloatProperty().bindBidirectional(pf.labelFloatProperty());
        tfR.labelFloatProperty().bindBidirectional(pfR.labelFloatProperty());
        tfV.labelFloatProperty().bindBidirectional(pfV.labelFloatProperty());
        
        Creador<Node> cVisi = () -> new MaterialIconView(MaterialIcon.VISIBILITY, "27"),
                cNoVisi = () -> new MaterialIconView(MaterialIcon.VISIBILITY_OFF, "27");
        Realizar r = () -> {
            if (tf.isVisible()) {
                visibilidadV.setGraphic(cNoVisi.crear());
                visibilidadR.setGraphic(cNoVisi.crear());
                visibilidad.setGraphic(cNoVisi.crear());
            } else {
                visibilidadV.setGraphic(cVisi.crear());
                visibilidadR.setGraphic(cVisi.crear());
                visibilidad.setGraphic(cVisi.crear());
            }

        };
        tf.visibleProperty().addListener(v -> r.realizar());

    }

    public static void sincronizarTFContrazeña(JFXTextField tf, JFXPasswordField pf, Button visibilidad, JFXTextField tfR, JFXPasswordField pfR, Button visibilidadR) {
        sincronizarTFContrazeña(tf, pf, visibilidad);
        sincronizarTFContrazeña(tfR, pfR, visibilidadR);
        tfR.visibleProperty().bindBidirectional(tf.visibleProperty());
        pfR.visibleProperty().bindBidirectional(pf.visibleProperty());
        tf.labelFloatProperty().bindBidirectional(pf.labelFloatProperty());
        tfR.labelFloatProperty().bindBidirectional(pfR.labelFloatProperty());
        Consumer<Button> e = v -> {
//            System.out.println("llamada");
            if (tf.isVisible()) {
//                System.out.println("ll uno");
                v.setGraphic(new MaterialIconView(MaterialIcon.VISIBILITY_OFF, "27"));
            } else {
//                System.out.println("ll dos");
                v.setGraphic(new MaterialIconView(MaterialIcon.VISIBILITY, "27"));
            }

        };
        visibilidadR.graphicProperty().addListener(v -> e.accept(visibilidad));
        visibilidad.graphicProperty().addListener(v -> e.accept(visibilidadR));
    }

    public static void sincronizarTFContrazeña(JFXTextField tf, JFXPasswordField pf, Button visibilidad) {
        tf.textProperty().bindBidirectional(pf.textProperty());
        tf.promptTextProperty().bindBidirectional(pf.promptTextProperty());
        tf.layoutYProperty().bindBidirectional(pf.layoutYProperty());
        tf.layoutXProperty().bindBidirectional(pf.layoutXProperty());

        EventHandler e = v -> {
//            System.out.println("se llamo");
            if (tf.isVisible()) {
//                System.out.println("uno");
                tf.setVisible(false);
                pf.setVisible(true);
                visibilidad.setGraphic(new MaterialIconView(MaterialIcon.VISIBILITY, "27"));
            } else {
//                System.out.println("dos");
                tf.setVisible(true);
                pf.setVisible(false);
                visibilidad.setGraphic(new MaterialIconView(MaterialIcon.VISIBILITY_OFF, "27"));
            }

        };
        addOnAction(visibilidad, e);
        e.handle(null);

    }

    public static void setRotateGraphic(double rotacion, Labeled... N) {
        for (int i = 0; i < N.length; i++) {
            N[i].getGraphic().setRotate(rotacion);
        }
    }

    public static void setRotateGraphic(double rotacion, Tab... N) {
        for (int i = 0; i < N.length; i++) {
            N[i].getGraphic().setRotate(rotacion);
        }
    }

    public static void setRbsBusqueda(int lengh, JFXButton b, JFXRadioButton RBs[], ToggleGroup tg) {
        b.getContextMenu().getItems().clear();
        for (int i = 0; i < lengh; i++) {
//            System.out.println("i="+i);
//            System.out.println("RBsBusquedaSecundarias[i].getText()="+RBsBusquedaSecundarias[i].getText());
            b.getContextMenu().getItems().add(new MenuItem("", RBs[i]));
        }
        VisualFX.selecPrimero(tg);
    }
    
    public static void setRbsBusqueda( JFXButton b, JFXRadioButton RBs[], ToggleGroup tg) {
        b.setContextMenu(new ContextMenu());
        b.getContextMenu().getItems().clear();
        for (int i = 0; i < RBs.length; i++) {
//            System.out.println("i="+i);
//            System.out.println("RBsBusquedaSecundarias[i].getText()="+RBsBusquedaSecundarias[i].getText());
            b.getContextMenu().getItems().add(new MenuItem("", RBs[i]));
        }
        VisualFX.selecPrimero(tg);
    }

    public static <E> void setPredicate(JFXTreeTableView<objetoTreeTableView> TV, TextInputControl TBusqueda, ToggleGroup t, Button BBusqueda, Callback<E, String> CDeTextoBusqueda, ToggleGroup TGSecundarios, Realizar actualizarRbs) {
        BBusqueda.setContextMenu(new ContextMenu());

        addOnSelected(TGSecundarios, v -> actualizarRbs.realizar());
        actualizarRbs.realizar();
        setPredicate(TV, TBusqueda, CDeTextoBusqueda, t, null, BBusqueda);

//         addOnSelected(t, v -> setTextBusqueda(TBusqueda, getText(t)));
    }

    public static <E> void setPredicate(JFXTreeTableView<objetoTreeTableView> TV, TextInputControl TBusqueda, Callback<E, String> CDeTextoBusqueda, ToggleGroup t, Creador<String> setTexEnBusqueda, Button BBusqueda) {
        showContextMenuOnAction(BBusqueda);
        Utiles.FX.TablasFX.<E>setPredicate(TV, TBusqueda, CDeTextoBusqueda);
        Utiles.FX.VisualFX.addOnSelected(t, v -> setTextBusqueda(TBusqueda, setTexEnBusqueda == null ? getText(t) : setTexEnBusqueda.crear()));
        setTextBusqueda(TBusqueda, setTexEnBusqueda == null ? getText(t) : setTexEnBusqueda.crear());
    }

    public static void setTextBusqueda(TextInputControl t, String a) {
        t.setPromptText("Buscar por " + a);
    }

    public static void setText(JFXRadioButton R[], String... S) {
        setText(R, 0, S);
    }

    public static void setText(JFXRadioButton R[], int i0, String... S) {
        for (int i = 0; i < S.length; i++) {
//            System.out.println("i="+i+" i0="+i0);
//            System.out.println("S[i]="+S[i]);
            R[i + i0].setText(S[i]);
        }
    }

    public static void setText(JFXRadioButton R[], String SS[][], String... S) {
        int i0 = 0;
        for (int i = 0; i < SS.length; i++) {
            setText(R, SS[i]);
            i0 += SS.length;
        }
        setText(R, i0, S);

    }

    public static void setText(JFXRadioButton R[], String SS0[], String SS1[], String... S) {
        setText(R, SS0);
        setText(R, SS0.length, SS1);
        setText(R, SS0.length + SS1.length, S);

    }

    public static void setText(JFXRadioButton R[], String SS[], String... S) {
        setText(R, SS);
        setText(R, SS.length, S);

    }

    public static void showContextMenuOnAction(Control... N) {
        for (int i = 0; i < N.length; i++) {
            final Control n = N[i];
            addOnAction(n, v -> showContextMenu(n));
        }
    }

    public static void showContextMenu(Control n) {
        if (n.getContextMenu() != null) {
            n.getContextMenu().show(n, Side.BOTTOM, 0, 0);
        }
    }

    public static <E> void select(ComboBox<E> c, E e) {
        c.getSelectionModel().select(e);
    }

    public static void soloNombres(Node... N) {
        for (int i = 0; i < N.length; i++) {
            N[i].setOnKeyTyped(v -> soloLetras(v));
        }
    }

    public static char getChar(KeyEvent event) {
        return event.getCharacter().charAt(0);
    }

    public static void soloLetras(KeyEvent event) {
        char a = Utiles.MetodosUtiles.MetodosUtiles.arreglarChar(getChar(event));
        // char a = event.getCharacter().charAt(0);
        // a =;
        if (!((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || a == ' ')) {
            event.consume();
        }

    }

    public static void soloNumeros(Node... N) {
        for (int i = 0; i < N.length; i++) {
            N[i].setOnKeyTyped(v -> soloNumeros(v));
        }
    }

    public static void soloNumeros(KeyEvent event) {
        char a = event.getCharacter().charAt(0);
        if (!(a >= '0' && a <= '9')) {
            event.consume();
        }

    }

    public static void addOnShowing(Stage s, Realizar r) {
        s.addEventHandler(WindowEvent.WINDOW_SHOWING, v -> r.realizar());
    }

    public static void addOnClosed(Stage s, Realizar r) {
        s.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, v -> r.realizar());
    }

    public static void resetear(TextField... T) {
        for (int i = 0; i < T.length; i++) {
            T[i].setText("");
        }
    }

    //Text icon = MaterialIconFactory.get().createIcon(MaterialIcon.VISIBILITY);
    //MaterialIconView icon = new MaterialIconView(MaterialIcon.VISIBILITY);
    //MaterialIconView icon = new MaterialIconView(MaterialIcon.VISIBILITY_OFF);
    //Text icon = MaterialIconFactory.get().createIcon(MaterialIcon.VISIBILITY_OFF);
    public static void visualizarContraseña(PasswordField P[], Button... B) {
        if (B.length > 0 && P.length > 0) {
            final MaterialIconView visible = new MaterialIconView(MaterialIcon.VISIBILITY),
                    noVisible = new MaterialIconView(MaterialIcon.VISIBILITY_OFF);;
            setGraphic(visible, B);
            addOnAction(v -> {
                boolean esVisible = B[0].getGraphic().equals(visible);
                setGraphic(esVisible ? noVisible : visible, B);
                //  P[0].set
            }, B);
        }

    }

    public static void setGraphic(Node graphic, Labeled... N) {
        for (int i = 0; i < N.length; i++) {
            N[i].setGraphic(graphic);
        }
    }

    public static void actualizarObs(ObservableList<objetoTreeTableView> ob, Object... A) {
        ob.clear();
        ob.addAll(objetoTreeTableView.getOb(A));
    }

    public static void iniSpinnerInteger(Spinner<Integer> e, int min, int max) {
        iniSpinnerInteger(e, min, max, min);
    }

    public static void iniSpinnerInteger(Spinner<Integer> e, int min, int max, int selec) {
        e.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, selec));
    }

    public static <E> void setValue(Spinner<E> e, E v) {
        e.getEditor().setText(v.toString());
    }

    public static boolean isHoverOr(JFXDialog... D) {
        for (int i = 0; i < D.length; i++) {
            if (D[i].isHover()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHoverOr(Stage... D) {
        for (int i = 0; i < D.length; i++) {
            if (D[i].isShowing()) {
                return true;
            }
        }
        return false;
    }

    public static void addOnSelected(ToggleGroup t, Consumer c) {
        t.selectedToggleProperty().addListener(v -> c.accept(v));
    }

    public static void addOnSelected(TreeTableView t, Consumer c) {
        t.getSelectionModel().getSelectedIndices().addListener((ListChangeListener) v -> c.accept(v));
    }

    public static <E> void addOnSelected(TableView<E> t, Consumer<E> c) {
        t.getSelectionModel().getSelectedIndices().addListener((ListChangeListener) v -> c.accept(getSeleccionado(t)));
    }
//
//
//    public static void copiarVisualDeAaB(RadioButton a, RadioButton b) {
//        b.setText(a.getText());
//        b.setGraphic(a.getGraphic());
//    }

    public static void setVisible(boolean b, Node NN[][], Node... N) {
        for (int i = 0; i < NN.length; i++) {
            setVisible(b, NN[i]);
        }
        setVisible(b, N);
    }

    public static void setVisible(boolean b, Node... N) {
        for (int i = 0; i < N.length; i++) {
            N[i].setVisible(b);
        }

    }

    public static void requestFocusConsecutivo(Node... N) {
        for (int i = 0; i < N.length; i++) {
            N[i].requestFocus();
        }
    }

    public static void setAutoCompleteComboBoxListenerYCSS(String claseCSS, JFXComboBox... CB) {
        for (int i = 0; i < CB.length; i++) {
            setAutoCompleteComboBoxListenerYCSS(claseCSS, CB[i]);
        }
    }

    public static void setAutoCompleteComboBoxListenerYCSS(String claseCSS, JFXComboBox CB) {
        AutoCompleteComboBoxListener autoCB = new AutoCompleteComboBoxListener(CB, "");
        // CB.getEditor().getStyleClass().add("JFXtextFielTextoBlanco");
        setEditorCSS(claseCSS, CB);
    }

    public static void setEditorCSS(String claseCSS, Node... N) {
        for (int i = 0; i < N.length; i++) {
            if (N[i] instanceof ComboBox) {
                ((ComboBox) N[i]).getEditor().getStyleClass().add(claseCSS);
                return;
            }
            if (N[i] instanceof DatePicker) {
                ((DatePicker) N[i]).getEditor().getStyleClass().add(claseCSS);
                // return;
            }
        }

    }

    // public static int asd = 0;
    public static void setOcultarJFXNodesList(JFXNodesList... N) {
        for (int i = 0; i < N.length; i++) {
            final JFXNodesList n = N[i];
            final Timer t = new Timer(3000, v -> {
                n.animateList(false);
            });
            t.setRepeats(false);

            addOnMousePressed(n.getChildren(), v -> {
                if ((!n.getChildren().isEmpty()) && (!n.getChildren().get(0).equals(v))) {
                    n.animateList();
                }

                t.start();
            });
        }

    }

    public static void alSeleccionar(ListView L, Realizar r) {
        L.getSelectionModel().selectedIndexProperty().addListener(v -> {
            r.realizar();
        });
    }

    public static String getText(ToggleGroup L) {
        return getSeleccionadoRB(L).getText();
    }

    public static RadioButton getSeleccionadoRB(ToggleGroup L) {
        return (RadioButton) L.getSelectedToggle();
    }

    public static <E> E getSeleccionado(ListView<E> L) {
        return L.getSelectionModel().getSelectedItem();
    }

    public static <E> E getSeleccionado(TableView<E> L) {
        return L.getSelectionModel().getSelectedItem();
    }

    public static boolean haySeleccionado(ListView L) {
        return getI(L) > -1;
    }

    public static int getI(TreeTableView L) {
        return L.getSelectionModel().getSelectedIndex();
    }

    public static int getI(ListView L) {
        return L.getSelectionModel().getSelectedIndex();
    }

    public static int getI(ToggleGroup t) {
        return t.getToggles().indexOf(t.getSelectedToggle());
    }

    public static void selecPrimero(ListView L) {
        if (!L.getItems().isEmpty()) {
            L.getSelectionModel().select(0);
        }
    }

    public static void selecPrimero(TableView L) {
        if (!L.getItems().isEmpty()) {
            L.getSelectionModel().select(0);
        }
    }

    public static void selecPrimero(TreeTableView L) {
//        if (((TreeTableColumn) L.getColumns().get(0)).getCellObservableValue(0) != null) {
        if (!L.getColumns().isEmpty() && ((TreeTableColumn) L.getColumns().get(0)).getCellObservableValue(0) != null) {
        }
        L.getSelectionModel().select(0);
        //System.out.println("sle");
//         }
    }

    public static void selecPrimero(ToggleGroup t) {
        if (!t.getToggles().isEmpty()) {
            t.selectToggle(t.getToggles().get(0));
        }

    }

    public static <E> void setCellFactory(ComboBox<E> L, Callback<E, String> C) {
        L.setCellFactory(v -> new CellLista<E>((a, b, c) -> {
            if (!c) {
                a.setText(C.call(b));
            }
        }));
    }

    public static <E> void setCellFactory(ListView<E> L, Callback<E, String> C) {
        L.setCellFactory(v -> new CellLista<E>((a, b, c) -> {
            if (!c) {
                a.setText(C.call(b));
            }
        }));
    }

    public static boolean responerException(Exception ex) {
        return responerException(ex, null);
    }

    public static boolean responerException(Exception ex, String respuestas[], Class... exepciones) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.getButtonTypes().clear();
        a.getButtonTypes().add(ButtonType.OK);
        // boolean tieneRespuesta=true;
        while (true) {
            if (ex instanceof NoEncontradoException || ex instanceof PINException
                    || ex instanceof ExisteException || ex instanceof NoPermitidoException
                    || ex instanceof IndiceFinalIncorrectoException || ex instanceof IndiceIncorrectoException
                    || ex instanceof IndiceInicialIncorrectoException) {
                a.setContentText(ex.getLocalizedMessage());
                break;
            }

            if (ex instanceof IOException) {
                a.setContentText("No se pudo guardar el archibo");
                break;
            }
            if (ex instanceof FileNotFoundException) {
                a.setContentText("No se encuentra el archibo");
                break;
            }
            if (ex instanceof NumberFormatException) {
                a.setContentText("No es un numero valido");
                break;
            }

            if (respuestas != null && exepciones != null && respuestas.length == exepciones.length && exepciones.length != 0) {
                for (int i = 0; i < exepciones.length; i++) {
                    if (ex.getClass().equals(exepciones[i])) {
                        a.setContentText(respuestas[i]);
                        break;
                    }
                }

            }

            a.setContentText("Ocurrio un error en el programa");
            break;
        }

        ex.printStackTrace();
        a.showAndWait();
        return !a.getContentText().equals("Ocurrio un error en el programa");
    }

    public static void dialogTransTOP(JFXDialog adicAsig) {
        adicAsig.setTransitionType(JFXDialog.DialogTransition.TOP);
        adicAsig.setOverlayClose(false);
    }

    public static TextFormatter<Double> textFormatterDouble = new TextFormatter<Double>(new StringConverter<Double>() {

        @Override
        public String toString(Double object) {
            return object == null ? "" : object.toString();
        }

        @Override
        public Double fromString(String string) {
            if (string == null || string.isEmpty()) {
                return null;
            } else {
                try {
                    double val = Double.parseDouble(string);
                    return val < 0 ? null : val;
                } catch (NumberFormatException ex) {
                    return null;
                }
            }
        }

    });

    public static void showAlertaError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR, mensaje, ButtonType.OK);
        alert.showAndWait();
    }

    public static void dialogoCerrarVentana(Stage primaryStage) {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent evt) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close this application?", ButtonType.YES, ButtonType.NO);
                ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
                if (ButtonType.NO.equals(result)) {
                    evt.consume();
                }

            }
        });
    }

    /**
     * le da movilidad a la ventana por arrastre del raton sobre root
     *
     * @param root
     * @param primaryStage
     * @return
     */
    public static Object move(Parent root, Stage primaryStage) {
        class auxiliar {

            double x, y;

            public auxiliar() {
                root.setOnMousePressed(e -> {
                    x = e.getSceneX();
                    y = e.getSceneY();
                });
                root.setOnMouseDragged(e -> {
                    primaryStage.setX(e.getScreenX() - x);
                    primaryStage.setY(e.getScreenY() - y);
                });
            }

        }
        return new auxiliar();
    }

    public static void trans(Scene s, Stage stage) {
        stage.initStyle(StageStyle.TRANSPARENT);
        s.setFill(Color.rgb(255, 255, 255, 0.01));
        move(s.getRoot(), stage);
    }

    public static void sinBordes(Scene s, Stage stage) {
        stage.initStyle(StageStyle.TRANSPARENT);
        s.setFill(Color.TRANSPARENT);
        // bordes(s, new CornerRadii(30));
        move(s.getRoot(), stage);
    }

    public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, JFXDialog dialog, Button botonesQueValidan[], Node... T) {
        return setValidator(creador, dialog, null, null, botonesQueValidan, T);
    }

    public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, Stage ventana, Button botonesQueValidan[], Node... T) {
        return setValidator(creador, null, null, new Object[]{ventana}, botonesQueValidan, T);
    }

    public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, JFXDialog dialog, Button botonADesactivar, Button botonesQueValidan[], Node... T) {
        return setValidator(creador, dialog, botonADesactivar, null, botonesQueValidan, T);
    }

    public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, Stage ventana, Button botonADesactivar, Button botonesQueValidan[], Node... T) {
        return setValidator(creador, null, botonADesactivar, new Object[]{ventana}, botonesQueValidan, T);
    }
//ObservableValue proidadesQueValidan[]

    public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, JFXDialog dialog, Object sacarPropiedadesQueValidan[], Button botonesQueValidan[], Node... T) {
        return setValidator(creador, dialog, null, sacarPropiedadesQueValidan, botonesQueValidan, T);
    }

    public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, Stage ventana, Node... T) {
        return setValidator(creador, null, null, new Object[]{ventana}, null, T);
    }

    public static ValidatorBase[] setValidator(JFXDialog dialog, Node... T) {
        return setValidator(null, dialog, null, null, null, T);
    }

    public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, final JFXDialog dialog, Node... T) {
        return setValidator(creador, dialog, null, null, null, T);
    }

    public static ValidatorBase[] setValidator(Stage s, Node... T) {
        return setValidator(null, null, null, new Object[]{s}, null, T);
    }

    public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, final JFXDialog dialog, Object sacarPropiedadesQueValidan[], Node... T) {
        return setValidator(creador, dialog, null, sacarPropiedadesQueValidan, null, T);
    }

    public static ValidatorBase[] setValidator(Button botonAdesactivar, TextInputControl... T) {
        return setValidator(() -> new RequiredFieldValidator("No puede estra vacio"), null, botonAdesactivar, null, botonAdesactivar != null ? new Button[]{botonAdesactivar} : null, T);
    }

    private static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, final JFXDialog dialog, final Button botonADesactivar, Object sacarPropiedadesQueValidan[], Button botonesQueValidan[], Node... T) {
        ValidatorBase V[] = new ValidatorBase[T.length];

        final IFXValidatableControl L[] = new IFXValidatableControl[T.length];
        for (int i = 0; i < T.length; i++) {

            V[i] = creador != null ? creador.crear() : new Validador();
            //    IFXLabelFloatControl              IFXValidatableControl
            if (T[i] instanceof IFXValidatableControl) {
                L[i] = (IFXValidatableControl) T[i];
                L[i].setValidators(V[i]);
                // System.out.println("dio");
            }

        }
        Realizar R = () -> {
//            if(T[0] instanceof TextField){
//            System.out.println("apreto "+((TextField) T[0]).getText());
//            }

            validar(L);
            if (botonADesactivar != null) {
                activarComponentes(esValido(V), botonADesactivar);
            }
        };
        if (botonADesactivar != null) {
            addOnMouseReleased(e -> R.realizar(), botonADesactivar);
        }
        for (int i = 0; i < T.length; i++) {
            //System.out.println("add");
            //   if (T[i] instanceof IFXLabelFloatControl) {
            ObservableValue o = getObservableValue(T[i]);
            if (o != null) {
                o.addListener(e -> R.realizar());
            }
//                if (T[i] instanceof TextField) {
//                    ((TextField) T[i]).textProperty().addListener(e -> R.realizar());
//                }
//                if (T[i] instanceof ComboBoxBase) {
//                    ((ComboBoxBase) T[i]).valueProperty().addListener(e -> R.realizar());
//                }
            T[i].focusedProperty().addListener(e -> R.realizar());
            // }
        }
        if (botonesQueValidan != null && botonesQueValidan.length != 0) {
            // System.out.println("aa");
            //addOnMouseReleased(e -> R.realizar(), botonesQueValidan);
            addOnMouseReleased(e -> R.realizar(), botonesQueValidan);
        }

        if (dialog != null) {
//            dialog.setOnDialogOpened(e->{System.out.println("abrio 22");});
//            dialog.hoverProperty().addListener(e -> {
//                  System.out.println("abrio");
//                if (dialog.isHover()) {
//                    R.realizar();
//                  
//                }
//            });
            //dialog.hoverProperty().addListener(e -> );
            addOnDialogOpened(dialog, e -> R.realizar());
        }
        if (sacarPropiedadesQueValidan != null) {
            setRealizarAObservableValues(R, sacarPropiedadesQueValidan);
//            ObservableValue proidadesQueValidan[] = getObservableValues(sacarPropiedadesQueValidan);
//            for (int i = 0; i < proidadesQueValidan.length; i++) {
//                proidadesQueValidan[i].addListener(e -> R.realizar());
//            }
        }

        return V;
    }

    public static void setRealizarAObservableValues(Realizar R, Object... N) {
        // LinkedList<Node> l = new LinkedList<>(Arrays.asList(N));
        LinkedList l = new LinkedList<>();
        for (int i = 0; i < N.length; i++) {
            if (N[i] instanceof Button) {
                addOnMouseReleased(R, (Button) N[i]);
                // l.remove(i);
                continue;
            }
            if (N[i] instanceof ListView) {
                ((ListView) N[i]).getItems().addListener((ListChangeListener) v -> R.realizar());
                //addOnMouseReleased(R, N[i]);
                // l.remove(i);
                continue;
            }
            l.add(N[i]);
        }

        ObservableValue proidadesQueValidan[] = getObservableValues(l.toArray(new Object[0]));
        for (int i = 0; i < proidadesQueValidan.length; i++) {

            proidadesQueValidan[i].addListener(e -> R.realizar());
        }
    }

    public static ObservableValue[] getObservableValues(Object... N) {
        LinkedList<ObservableValue> l = new LinkedList();
        for (int i = 0; i < N.length; i++) {
//            if (N[i] instanceof TableView) {
//                l.addAll(getObservableValuesTable((TableView) N[i]));
//                continue;
//            }
            ObservableValue o = getObservableValue(N[i]);
            if (o != null) {

                l.add(o);
            }
        }
        return l.toArray(new ObservableValue[0]);
    }

//    public static LinkedList<ObservableValue> getObservableValuesTable(TableView TV) {
//        LinkedList<ObservableValue> l = new LinkedList();
//        for (int i = 0; i < TV.getColumns().size(); i++) {
//            l.add(((TableColumn) TV.getColumns().get(0)).onEditCommitProperty());
//        }
//        return l;
//    }
    public static ObservableValue getObservableValue(Object n) {

        if (n instanceof DatePicker) {
            return ((DatePicker) n).getEditor().textProperty();
        }
        if (n instanceof ComboBox) {
            return ((ComboBox) n).getEditor().textProperty();
        }
        if (n instanceof ToggleButton) {
            return ((ToggleButton) n).selectedProperty();
        }
        if (n instanceof CheckBox) {
            return ((CheckBox) n).selectedProperty();
        }
        if (n instanceof Button) {
            return ((Button) n).clipProperty();
        }
//        if (n instanceof ListView) {
//            return ((ListView) n).getItems(;
//        }
        if (n instanceof TableView) {
            return ((TableView) n).editingCellProperty();
        }
        if (n instanceof TextInputControl) {
            //   System.out.println("clase ti" + n.getClass().getSimpleName());
            return ((TextInputControl) n).textProperty();
        }
        if (n instanceof JFXDialog) {
            return ((JFXDialog) n).hoverProperty();
        }
        if (n instanceof Stage) {
            return ((Stage) n).showingProperty();
        }
//        if (n instanceof ToggleGroup) {
//            return ((ToggleButton) n).selectedProperty();
//        }
//        if (n instanceof TextArea) {
//            System.out.println("clase tA" + n.getClass().getSimpleName());
//            return ((TextArea) n).textProperty();
//        }
        return null;
    }

//public static ValidatorBase[] setValidator(Creador<ValidatorBase> creador, JFXDialog dialog, final Button botonADesactivar, Button botonesQueValidan[], TextField... T) {
//        ValidatorBase V[] = new ValidatorBase[T.length];
//
//        final IFXLabelFloatControl L[] = new IFXLabelFloatControl[T.length];
//        for (int i = 0; i < T.length; i++) {
//            V[i] = creador.crear();
//            if (T[i] instanceof IFXLabelFloatControl) {
//                L[i] = (IFXLabelFloatControl) T[i];
//                L[i].setValidators(V[i]);
//            }
//
//        }
//        Realizar R = () -> {
//            validar(L);
//            if (botonADesactivar != null) {
//                realcionarComponentes(esValido(V), botonADesactivar);
//            }
//        };
//        for (int i = 0; i < T.length; i++) {
//            //System.out.println("add");
//            if (T[i] instanceof IFXLabelFloatControl) {
//                //    System.out.println("si");
//                final TextField t = T[i];
//                t.textProperty().addListener(e -> R.realizar());
//                t.focusedProperty().addListener(e -> R.realizar());
//            }
//        }
//        addOnMouseReleased(e -> R.realizar(), V);
//        if (dialog != null) {
//            addOnDialogOpened(dialog, e -> R.realizar());
//        }
//
//        return V;
//    }
    public static void addOnAction(EventHandler t, Node... N) {
        for (int i = 0; i < N.length; i++) {
            addOnAction(N[i], t);
        }
    }

    public static void addOnAction(Node e, EventHandler t) {
        e.addEventHandler(ActionEvent.ACTION, t);
        //e.addEventHandler(ActionEvent.ACTION, v->{System.out.println("onAc");});
        // e.ad
    }
//

    public static void addOnDialogOpened(JFXDialog e, EventHandler t) {
        e.addEventHandler(JFXDialogEvent.OPENED, t);
    }

    public static void addOnDialogClosed(EventHandler t, JFXDialog... D) {
        for (int i = 0; i < D.length; i++) {
            addOnDialogClosed(D[i], t);
        }

    }

    public static void addOnClosed(Realizar r, Stage... D) {
        for (int i = 0; i < D.length; i++) {
            addOnClosed(D[i], r);
        }

    }

    public static void addOnDialogClosed(JFXDialog e, EventHandler t) {
        e.addEventHandler(JFXDialogEvent.CLOSED, t);
    }

    public static void addOnMouseReleased(Realizar R, Node... N) {
        addOnMouseReleased(v -> R.realizar(), N);
    }

    public static void addOnMouseReleased(EventHandler t, Node... N) {
        for (int i = 0; i < N.length; i++) {
            addOnMouseReleased(N[i], t);
        }
    }

    public static void addOnMousePressed(ObservableList<Node> N, Utilizar<Node> u) {
        for (int i = 0; i < N.size(); i++) {
            final Node n = N.get(i);
            addOnMousePressed(n, v -> u.utilizar(n));
        }
    }

    public static void addOnMousePressed(EventHandler t, Node... N) {
        for (int i = 0; i < N.length; i++) {
            addOnMousePressed(N[i], t);
        }
    }

    public static void addOnMousePressed(Node e, EventHandler t) {
        e.addEventHandler(MouseEvent.MOUSE_PRESSED, t);
    }

    public static void addOnMouseReleased(Node e, EventHandler t) {
        e.addEventHandler(MouseEvent.MOUSE_RELEASED, t);
        // e.addEventHandler(MouseEvent.MOUSE_RELEASED, ss->{System.out.println("levanto");});
    }

//    public static void validar(ValidatorBase[]... L) {
//        for (int i = 0; i < L.length; i++) {
//            validar(L[i]);
//        }
//    }
//
//    public static void validar(ValidatorBase... L) {
//        for (int i = 0; i < L.length; i++) {
//            //System.out.println("i=" + i);
//            if (L[i] != null) {
//                // System.out.println("L[i]=" + L[i]);
//                L[i].validate();
//            }
//        }
//    }
    public static void validar(IFXValidatableControl... L) {
        for (int i = 0; i < L.length; i++) {
            //System.out.println("i=" + i);
            if (L[i] != null) {
                // System.out.println("L[i]=" + L[i]);
                L[i].validate();
            }
        }
    }

    public static boolean esValido(ValidatorBase... V) {
        for (ValidatorBase v : V) {
            if (v.getHasErrors()) {
                return false;
            }
        }
        return true;
    }

//    public static void relacionarValidador(ValidatorBase VV[][], Predicate seleccionarV[], Node... N) {
//        relacionarValidador(VV, seleccionarV, null, null, N);
//    }
    public static void relacionarValidador(ValidatorBase VV[][], Object nodosAEscuchar[], Node... N) {
        relacionarValidador(VV, nodosAEscuchar, null, N);
    }

    public static void relacionarValidador(ValidatorBase VV[][], Object nodosAEscuchar[], Predicate booleanoExtra, Node... N) {
        relacionarValidador(VV, null, null, nodosAEscuchar, booleanoExtra, N);
    }

//    public static<E extends ObservableValue> void aa(ObservableList<E> observableList) {
//    }
    public static <E extends ObservableValue> void relacionarValidador(ValidatorBase VV[][], ObservableList<E> observableList, Predicate booleanoExtra, Node... N) {
        relacionarValidador(VV, null, observableList, null, booleanoExtra, N);
    }

    public static <E extends ObservableValue> void relacionarValidador(ValidatorBase VV[][], Predicate seleccionarV[], Object nodosAEscuchar[], Predicate booleanoExtra, Node... N) {
        relacionarValidador(VV, seleccionarV, null, nodosAEscuchar, booleanoExtra, N);
    }

    public static <E extends ObservableValue> void relacionarValidador(ValidatorBase VV[][], Predicate seleccionarV[], ObservableList<E> observableList, Object nodosAEscuchar[], Predicate booleanoExtra, Node... N) {
        Realizar R = () -> {
            if (seleccionarV == null) {
//                if(booleanoExtra!=null){
//                System.out.println("booleanoExtra.test(VV)="+booleanoExtra.test(VV));
//                }else{System.out.println("null");}

                activarComponentes(VV, booleanoExtra, N);
            } else {
                LinkedList<ValidatorBase[]> l = new LinkedList<>();
                for (int i = 0; i < VV.length; i++) {
                    if (seleccionarV[i].test(i)) {
                        l.add(VV[i]);
                    }
                }
                ValidatorBase VV2[][] = new ValidatorBase[l.size()][];

                for (int i = 0; i < l.size(); i++) {
                    VV2[i] = l.get(i);
                }//l.toArray(new ValidatorBase[0][])
                activarComponentes(VV2, booleanoExtra, N);
            }

        };

        for (int i = 0; i < VV.length; i++) {
            for (int j = 0; j < VV[i].length; j++) {
                VV[i][j].hasErrorsProperty().addListener(v -> {
                    R.realizar();
                });
            }
        }
        if (nodosAEscuchar != null) {
            setRealizarAObservableValues(R, nodosAEscuchar);
        }
        if (observableList != null) {
            observableList.addListener((ListChangeListener) v -> {
                R.realizar();
                ChangeListener chl = (x, x2, x3) -> {
                    R.realizar();
                };
                observableList.forEach(v2 -> {
                    v2.removeListener(chl);
                    v2.addListener(chl);
                });

            });
//            observableList.forEach(v -> {
//               // if (v instanceof ObservableValue) {
//                    v.addListener((x, x2, x3) -> {
//                        R.realizar();
//                    });
//               // }
//
//            });
        }

    }

    public static void activarComponentes(boolean b, Node[]... N) {
        for (int i = 0; i < N.length; i++) {
            activarComponentes(b, N[i]);
        }
    }

    public static void activarComponentes(boolean b, Node NN[][], Node... N) {
        for (int i = 0; i < NN.length; i++) {
            activarComponentes(b, NN[i]);
        }
        activarComponentes(b, N);
    }

    public static void activarComponentes(boolean b, Node... N) {
        for (int i = 0; i < N.length; i++) {
            //  N[i].disableProperty().set(!b);
            N[i].setDisable(!b);
        }
    }

    public static void activarComponentes(ValidatorBase VV[][], Node... N) {
        activarComponentes(VV, null, N);
    }

    public static void activarComponentes(ValidatorBase VV[][], Predicate p, Node... N) {
        boolean valido = true;
        //  System.out.println("VV.length="+VV.length);
        for (int i = 0; i < VV.length; i++) {
            if (!esValido(VV[i])) {
                valido = false;
                break;
            }
        }
        // System.out.println("valido="+valido);
        activarComponentes(p != null ? p.test(N) && valido : valido, N);
    }

//    public static void relacionarComponentes(Realizar R, JFXDialog... D) {
//        addOnDialogClosed(v->{R.realizar();}, D);
//    }
    public static void relacionarComponentes(final JFXListView L, Node nesecitaTenerSelecionado, Node... N) {
        ListChangeListener listener = new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change c) {
                if (L.getItems().isEmpty()) {
                    activarComponentes(false, nesecitaTenerSelecionado);
                    activarComponentes(false, N);
                    return;
                }
//                activarComponentes(L.getSelectionModel().getSelectedItem()!=null, nesecitaTenerSelecionado);
//                 if (L.getTooltip() != null) {
//                System.out.println(L.getTooltip().getText());
//            }
////                System.out.println("!L.getSelectionModel().isEmpty()=" + !L.getSelectionModel().isEmpty());
////                System.out.println("L.getSelectionModel().getSelectedItem()!=null = " + (L.getSelectionModel().getSelectedItem() != null));
                boolean a = ((!L.getSelectionModel().isEmpty()) && L.getSelectionModel().getSelectedItem() != null);
//                System.out.println("(!L.getSelectionModel().isEmpty()) && L.getSelectionModel().getSelectedItem() != null= "+a);
                activarComponentes(a, nesecitaTenerSelecionado);

                activarComponentes(true, N);
            }
        };

        L.getSelectionModel().getSelectedIndices().addListener(listener);

        L.getItems().addListener(listener);
//        L.getItems().addListener(
//                b -> {
//           
//        });
    }

    public static void relacionarComponentes(final JFXTreeTableView TV, ObservableList ob[], Creador<ObservableList> c, Node soloNoVacia, Node... nesecitaTenerSelecionado) {
        Realizar R = () -> {
            if (c.crear().isEmpty()) {
                activarComponentes(false, nesecitaTenerSelecionado);
                activarComponentes(false, soloNoVacia);
                return;
            }
            activarComponentes(TV.getSelectionModel().getSelectedItem() != null, nesecitaTenerSelecionado);
            activarComponentes(true, soloNoVacia);
        };
        ListChangeListener listener = (ListChangeListener) v -> R.realizar();
        for (int i = 0; i < ob.length; i++) {
            ob[i].addListener(listener);
        }
        TV.getSelectionModel().getSelectedIndices().addListener(listener);
    }

    public static void relacionarComponentes(final JFXTreeTableView TV, ObservableList ob, Node soloNoVacia, Node... nesecitaTenerSelecionado) {
        Realizar R = () -> {
            if (ob.isEmpty()) {
                activarComponentes(false, nesecitaTenerSelecionado);
                activarComponentes(false, soloNoVacia);
                return;
            }
            activarComponentes(TV.getSelectionModel().getSelectedItem() != null, nesecitaTenerSelecionado);
            activarComponentes(true, soloNoVacia);
        };
        ListChangeListener listener = (ListChangeListener) v -> R.realizar();
        ob.addListener(listener);
        TV.getSelectionModel().getSelectedIndices().addListener(listener);
    }

    public static void relacionarComponentes(final ListView L, Node soloNoVacia, Node... nesecitaTenerSelecionado) {
        Realizar R = () -> {
            if (L.getItems().isEmpty()) {
                activarComponentes(false, nesecitaTenerSelecionado);
                activarComponentes(false, soloNoVacia);
                return;
            }
            activarComponentes(L.getSelectionModel().getSelectedItem() != null, nesecitaTenerSelecionado);
            activarComponentes(true, soloNoVacia);
        };

        ListChangeListener listener = (ListChangeListener) v -> R.realizar();
        L.getItems().addListener(listener);
        L.getSelectionModel().getSelectedIndices().addListener(listener);
    }

    public static void eliminarDeJFXList(JFXListView L) {

        ObservableList<Integer> ob = L.getSelectionModel().getSelectedIndices();
        int cant = 0;
        for (Integer o : ob) {
            L.getItems().remove(o - (cant++));
        }
    }

    public static void eliminarDeJFXTreeTable(JFXTreeTableView L, ObservableList items) {

        ObservableList<Integer> ob = L.getSelectionModel().getSelectedIndices();
        int cant = 0;
        for (Integer o : ob) {
            items.remove(o - (cant++));
        }
    }

//    public static void bordes(Scene s, CornerRadii c) {
////        if(s.getRoot() instanceof AnchorPane){
////            System.out.println("true");
////        }
//        
//        if (s.getRoot() instanceof AnchorPane) {
//            AnchorPane p = (AnchorPane) s.getRoot();
//          
//            boolean b = p.getBackground()==null;
//            System.out.println("b=" + b);
//            if (!b) {
//                List<BackgroundFill> l = p.getBackground().getFills();
//                System.out.println("uno");
//                if (!l.isEmpty()) {
//                    // Paint bf = l.get(0).getFill();
//                    l.set(0, new BackgroundFill(l.get(0).getFill(), c, l.get(0).getInsets()));
//                }
//                System.out.println("dos");
//            }
//
//        }
//
//    }
}
