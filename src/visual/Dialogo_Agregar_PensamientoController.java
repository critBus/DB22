/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeView;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import Utiles.FX.Celdas.AutoCompleteComboBoxListener;
import Utiles.FX.Celdas.CellLista;
import Utiles.FX.ConVentana;
import Utiles.FX.Validadores.Validador;
import Utiles.FX.objetoTreeTableView;
import clases.*;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.validation.base.ValidatorBase;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.ChoiceBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.StackPane;
import org.orm.PersistentException;

import static visual.probar.*;
import Utiles.FX.TablasFX;
import Utiles.FX.VisualFX;
import static Utiles.FX.VisualFX.select;
import static Utiles.FX.VisualFX.setPredicate;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.RecursiveTreeItem;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ToggleGroup;

public class Dialogo_Agregar_PensamientoController extends ConVentana implements Initializable {

//    private JFXDialog dialog;
    Pensamiento P[];
    private boolean apretoAgregarTema, apretoCrearCarta, apretoCrearArticulo, apretoCrearLibro;
    // private ObservableList<SimpleBooleanProperty> ObSeleccionados;
    private ObservableList<objetoTreeTableView> ob = FXCollections.observableArrayList();
    private ObservableList<objetoTreeTableView> obUbicacion = FXCollections.observableArrayList();
    private int idActual = -1;
    private ToggleGroup TGBusqueda;

    @FXML
    private StackPane Pstack;

    @FXML
    private JFXTextField TNombre;

    @FXML
    private TextArea TA;

    @FXML
    private JFXComboBox<String> CB;

    @FXML
    private JFXTextField TBuscar;

    @FXML
    private JFXButton BClearBusqueda;

    @FXML
    private JFXButton BBuscar;

    @FXML
    private ContextMenu CM;

    @FXML
    private JFXRadioButton RBCMPorNombre;

    @FXML
    private JFXRadioButton RBCMPorFecha;

    @FXML
    private JFXRadioButton RBCMPorAutor;

    @FXML
    private JFXRadioButton RBCMPorDisponibilidad;

    @FXML
    private JFXRadioButton RBCMPorUbicacion;

    @FXML
    private JFXRadioButton RBCMPorTipo;

    @FXML
    private JFXButton BAtras;

    @FXML
    private JFXButton BAceptar;

    @FXML
    private JFXButton BCrearTemas;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TV2;

    @FXML
    private JFXComboBox<Titulo> CBTitulos;

    @FXML
    private JFXButton BAgregarTitulos;

    @FXML
    private JFXTextField TLugar;

    @FXML
    private JFXButton BEliminarTitulos;

    @FXML
    private JFXButton BClearTitulos;

    @FXML
    private JFXNodesList NLCrearTitulo;

    @FXML
    private JFXButton BCrearTitulos;

    @FXML
    private JFXButton BCrearCarta;

    @FXML
    private JFXButton BCrearArticulo;

    @FXML
    private JFXButton BCrearLibro;

    @FXML
    void apretoCrearArticulo(MouseEvent event) {
        dialogo_Agregar_ArticuloController.show();
        apretoCrearArticulo = true;
    }

    @FXML
    void apretoCrearCarta(MouseEvent event) {
        dialogo_Agregar_CartaController.show();
        apretoCrearCarta = true;
    }

    @FXML
    void apretoCrearLibro(MouseEvent event) {
        dialogo_Agregar_LibroController.show();
        apretoCrearLibro = true;
    }

    @FXML
    void apretoClearTitulos(MouseEvent event) {
        ob.clear();
        obUbicacion.clear();
    }

    @FXML
    void apretoEliminarTitulos(MouseEvent event) {

        int a = TV2.getSelectionModel().getSelectedIndex();
        ob.remove(a);
        obUbicacion.remove(a);
    }

    

    @FXML
    void apretoAgregarTitulos(MouseEvent event) {
        int indice = CBTitulos.getSelectionModel().getSelectedIndex();
        if (indice > -1) {
            ob.add(new objetoTreeTableView(CBTitulos.getItems().get(indice)));
            obUbicacion.add(new objetoTreeTableView(TLugar.getText().trim()));
        }
//        System.out.println("ob.size()="+ob.size());
//        System.out.println("agrego");
        crearCBTitulos();
    }

    @FXML
    void apretoCrearTitulos(MouseEvent event) {

    }

    @FXML
    void apretoCrearTemas(MouseEvent event) {
        dialogo_Agregar_TemaController.show();
        apretoAgregarTema = true;
    }

    @FXML
    void apretoAceptar(MouseEvent event) {
        try {
            //System.out.println(TV2.getColumns().get(0).getCellObservableValue(0));
            //    Pensamiento P = null;
//            if (idActual != -1) {
//                eliminarPensamiento(getPensamientoActual());
//              // getPensamientoActual().deleteAndDissociate();
//               idActual=-1;
//            }
            Pensamiento P = idActual == -1 || (P = getPensamientoActual()) == null ? PensamientoFactory.createPensamiento() : P;
            if (idActual != -1) {
//                try {
                eliminarPensamiento_TituloAll(P);
//                } catch (Exception ex) {
//                    System.out.println("ignorar tres");
//                    ex.printStackTrace();
//                }
            }
            P.setNombre(TNombre.getText().trim());
            P.setTema(TemaFactory.loadTemaByQuery("Nombre='" + CB.getValue().trim() + "'", null));
            P.setContenido(TA.getText().trim());
            P.setPalabrasClave(getPalabrasClave(TA.getText().trim()));
            //if (idActual == -1) {
            try {
                P.save();
            } catch (Exception ex) {
                System.out.println("ignorar cuatro");
                ex.printStackTrace();
            }
            //  }

            // System.out.println("ob.size()="+ob.size());
            for (int i = 0; i < ob.size(); i++) {
                PT Pt = createPensamiento_Titulo();
                Pt.setLugar(obUbicacion.get(i).<String>getValor());
                Pt.setPensamiento(P);
                Pt.setTitulo(ob.get(i).<Titulo>getValor());
                Pt.save();
//                Pt.getTitulo().pensamiento_Titulo.add(Pt);
//                P.pensamiento_Titulo.add(Pt);

            }
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

    @FXML
    void apretoBuscar(MouseEvent event) {

    }

    @FXML
    void apretoClearBusqueda(MouseEvent event) {
        TBuscar.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BAceptar.setDefaultButton(true);
    }

    @Override
    public void iniStage(Parent p) {
        super.iniStage(p); //To change body of generated methods, choose Tools | Templates.
        apretoAgregarTema = apretoCrearArticulo = apretoCrearCarta = apretoCrearLibro = false;
        NLCrearTitulo.setRotate(180);
        iniTGs();
        Utiles.FX.VisualFX.setOcultarJFXNodesList(NLCrearTitulo);
        crearCBTitulos();
        crearTabla2();
        Utiles.FX.VisualFX.setAutoCompleteComboBoxListenerYCSS(TEXT_FIEL_CLASE_CSS, CBTitulos, CB);
        iniSeguridad();

    }

    private void ponerNombreTitulo() {
//        System.out.println("poner");
        if (apretoAgregarTema) {
//            System.out.println("selec");
            select(CB, dialogo_Agregar_TemaController.getTTema().getText().trim());
//            CB.getEditor().setText(dialogo_Agregar_TemaController.getTTema().getText().trim());
            return;
        }
        if (apretoCrearArticulo) {
//            System.out.println("sele ar");
            select(CBTitulos, getTitulo(dialogo_Agregar_ArticuloController.getTTitulo().getText().trim()));
//            CBTitulos.getEditor().setText(dialogo_Agregar_ArticuloController.getTTitulo().getText().trim());
            return;
        }
        if (apretoCrearCarta) {
//            System.out.println("sele car");
            select(CBTitulos, getTitulo(dialogo_Agregar_CartaController.getTTitulo().getText().trim()));
//            CBTitulos.getEditor().setText(dialogo_Agregar_CartaController.getTTitulo().getText().trim());
            return;
        }
        if (apretoCrearLibro) {
//            System.out.println("sele libr");
            select(CBTitulos, getTitulo(dialogo_Agregar_LibroController.getTTitulo().getText().trim()));
//            CBTitulos.getEditor().setText(dialogo_Agregar_LibroController.getTTitulo().getText().trim());
//            return;
        }
        apretoAgregarTema = apretoCrearArticulo = apretoCrearCarta = apretoCrearLibro = false;
        CBTitulos.validate();
    }

    private String getBusqueda(Titulo t) {
        if (RBCMPorAutor.isSelected()) {
            return getAutoresString(t);
        }
        if (RBCMPorFecha.isSelected()) {
            return getFecha(t.getFecha());
        }
        if (RBCMPorNombre.isSelected()) {
            return t.getNombre() + "";
        }
        if (RBCMPorTipo.isSelected()) {
            return getTipoDeTitulo(t);
        }
        if (RBCMPorUbicacion.isSelected()) {
            for (int i = 0; i < ob.size(); i++) {
                if (ob.get(i).<Titulo>getValor().getId() == t.getId()) {
                    return obUbicacion.get(i).getValor().toString();
                }
            }

            return "";
        }
        return getDisponibilidadString(t);
    }

    private String getTextoEnBusqueda() {
        if (RBCMPorAutor.isSelected()) {
            return "Autores";
        }
        if (RBCMPorFecha.isSelected()) {
            return "Fecha";
        }
        if (RBCMPorNombre.isSelected()) {
            return "Nombre";
        }
        if (RBCMPorTipo.isSelected()) {
            return "Tipo";
        }
        if (RBCMPorUbicacion.isSelected()) {
            return "Ubicacion";
        }
        return "Disponibilidad";
    }

    private void iniSeguridad() {
        setPredicate(TV2, TBuscar, v -> getBusqueda((Titulo) v), TGBusqueda, () -> getTextoEnBusqueda(), BBuscar);

        Utiles.FX.VisualFX.relacionarComponentes(TV2, ob, BClearTitulos,  BEliminarTitulos);
        ValidatorBase V0[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existePensamiento()), getVentana(), new Button[]{BAceptar}, TNombre);
        // ValidatorBase V1[] = Utiles.FX.VisualFX.setValidator(null, dialog, TA);
        ValidatorBase V2[] = Utiles.FX.VisualFX.setValidator(getVentana(), CB);
        ValidatorBase V3[] = Utiles.FX.VisualFX.setValidator(getVentana(), TLugar);
        ValidatorBase V4[] = Utiles.FX.VisualFX.setValidator(() -> new Validador("Ya existe", s -> !existeTitulo()), getVentana(), new Button[]{BAceptar, BClearTitulos, BEliminarTitulos, BAgregarTitulos}, CBTitulos);
        Utiles.FX.VisualFX.relacionarValidador(new ValidatorBase[][]{V3, V4}, new Node[]{BAgregarTitulos, BClearTitulos, BEliminarTitulos}, v -> true, BAgregarTitulos);
//Utiles.FX.VisualFX.aa(ObSeleccionados);
        Utiles.FX.VisualFX.relacionarValidador(new ValidatorBase[][]{V0, V2}, new Object[]{BAgregarTitulos, BClearTitulos, BEliminarTitulos, TA, getVentana()}, v -> {
//            System.out.println("prueba=" + prueba++);
//            System.out.println("!ob.isEmpty()=" + !ob.isEmpty());
//            System.out.println("!TA.getText().isEmpty()=" + !TA.getText().isEmpty());
//            System.out.println("(!ob.isEmpty()) && (!TA.getText().isEmpty())=" + ((!ob.isEmpty()) && (!TA.getText().isEmpty())));
            return (!ob.isEmpty()) && (!TA.getText().isEmpty());
        }, BAceptar);
        Utiles.FX.VisualFX.addOnMousePressed(v -> {
            if ((apretoAgregarTema || apretoCrearArticulo || apretoCrearCarta || apretoCrearLibro) && isShowing()) {
                actualizarBD();

            }
        }, dialogo_Agregar_TemaController.getBAceptar(), dialogo_Agregar_ArticuloController.getBAceptar(), dialogo_Agregar_CartaController.getBAceptar(), dialogo_Agregar_LibroController.getBAceptar()
        );
        addOnClosed(() -> {
            if (!(Utiles.FX.VisualFX.isHoverOr(dialogo_Agregar_ArticuloController.getVentana(), dialogo_Agregar_CartaController.getVentana(), dialogo_Agregar_LibroController.getVentana(), dialogo_Agregar_TemaController.getVentana()))) {
                idActual = -1;
            }

        });
    }

    private void iniTGs() {
        TGBusqueda = new ToggleGroup();
        TGBusqueda.getToggles().addAll(RBCMPorAutor, RBCMPorDisponibilidad, RBCMPorFecha, RBCMPorNombre, RBCMPorTipo, RBCMPorUbicacion);
    }

    private boolean existeTitulo() {
        int indice = CBTitulos.getSelectionModel().getSelectedIndex();
        if (indice > -1) {
            // System.out.println("CBTitulos.getItems().get(indice)="+CBTitulos.getItems().get(indice));
            Titulo seleccionado = CBTitulos.getItems().get(indice);
            if (seleccionado != null) {
                for (int i = 0; i < ob.size(); i++) {
                    if (ob.get(i).<Titulo>getValor().getId() == seleccionado.getId()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private ListView<String> getListViewAutor(Titulo t) {
        ListView<String> item = new ListView<>();

        t.autor.getCollection().forEach(v -> {
            // System.out.println("((Autor) v).getNombre()="+((Autor) v).getNombre());
            item.getItems().add(((Autor) v).getNombre());
        });
        return item;
    }

    private ListView<String> getListViewDisponibilidad(Titulo t) {
        ListView<String> item = new ListView<>();
        t.disponibilidad.getCollection().forEach(v -> {
            item.getItems().add(((Disponibilidad) v).getUbicacion());
        });
        return item;
    }

    private boolean haySeleccionados() {
        // System.out.println("ObSeleccionados.size()="+ObSeleccionados.size());
        for (int i = 0; i < ob.size(); i++) {
            if (((Boolean) TV2.getColumns().get(0).getCellObservableValue(i).getValue())) {
                //  if (ObSeleccionados.get(i).getValue()) {
                // System.out.println("si");
                return true;
            }
        }

        return false;
    }

    private void crearTabla2() {
        // ObSeleccionados = FXCollections.observableArrayList();
        // JFXTreeTableView t = new JFXTreeTableView();
        TV2.setEditable(true);
//        System.out.println("ob=" + ob.size());
        TablasFX.setColumns(TV2, ob,
                //TablasFX.getTreeTableColumnCheckBox("Seleccionar", 50, ObSeleccionados),
                TablasFX.<Titulo>getTreeTableColumn("Ubicacion", ANCHO_NOMBRE, v -> objetoTreeTableView.<String>getValorDe(obUbicacion, ob, v)),
                TablasFX.getTreeTableColumn("Nombre", ANCHO_NOMBRE, Titulo::getNombre),
                TablasFX.getTreeTableColumn("Tipo", NORMAL, v -> getTipoDeTitulo((Titulo) v)),
                TablasFX.<Titulo, Autor>getTreeTableColumnList("Autores", ANCHO_NOMBRE, v -> v.autor.getCollection(), v -> {/*System.out.println("po"+probar.prueba++);*/ return v.getNombre();
                }),
                TablasFX.getTreeTableColumn("Biblioteca", NORMAL, v -> disponibleEnBiblioteca((Titulo) v) ? "si" : "no"),
                TablasFX.<Titulo, Disponibilidad>getTreeTableColumnList("Digital", LARGO, v -> disponibilidaDigital(v), v -> v.getUbicacion())
        //obUbicacion.get(2).<String>getValor()
        );

    }

    private void crearCBTitulos() {
        Utiles.FX.VisualFX.setCellFactory(CBTitulos, Titulo::getNombre);

//        CBTitulos.setCellFactory(v -> new CellLista<Titulo>((a, b, c) -> {
//            if (!c) {
//                a.setText(b.getNombre());
//            }
//        }));
    }

    private boolean existePensamiento() {
        for (int i = 0; i < P.length; i++) {

            if (P[i].getNombre().trim().equalsIgnoreCase(TNombre.getText().trim()) && P[i].getId() != idActual) {
                return true;
            }
        }
        return false;
    }

    private void actualizarBD() {
        actualizarBD(false);
    }

    private void actualizarBD(boolean establecerPredeterminado) {
        Platform.runLater(() -> {

            boolean estadoBotonAcepar = BAceptar.isDisable();
            try {
                Utiles.FX.VisualFX.activarComponentes(false, CB, BAceptar, TNombre, CBTitulos, TLugar);
                P = PensamientoFactory.listPensamientoByQuery(null, null);
                LinkedList<String> l = new LinkedList<>(Arrays.asList(CB.getItems().toArray(new String[0])));

                Tema T[] = TemaFactory.listTemaByQuery(null, null);
                String N[] = new String[T.length];
                for (int i = 0; i < T.length; i++) {
                    N[i] = T[i].getNombre();
                    if (l.contains(N[i])) {
                        l.remove(N[i]);
                    }
                }
                CB.getItems().clear();
                CB.getItems().setAll(N);

//                l = new LinkedList<>(Arrays.asList(CBTitulos.getItems().toArray(new String[0])));
                Titulo Ti[] = TituloFactory.listTituloByQuery(null, null);
//                N = new String[Ti.length];
//                for (int i = 0; i < T.length; i++) {
//                    N[i] = Ti[i].getNombre();
//                    if (l.contains(N[i])) {
//                        l.remove(N[i]);
//                    }
//                }

                CBTitulos.getItems().clear();
                CBTitulos.getItems().setAll(Ti);
                if (establecerPredeterminado) {
                    predeterminadoPensamientoActual();
                }
                ponerNombreTitulo();
//                ob.clear();
//                ob.addAll(objetoTreeTableView.getOb(Ti));
            } catch (Exception ex) {
                responerException(ex);
            }
            Utiles.FX.VisualFX.activarComponentes(true, CB, TNombre, CBTitulos, TLugar);
            // CB.setDisable(false);
//            TNombre.setDisable(false);
            BAceptar.setDisable(estadoBotonAcepar);
//            actualizarTabla();

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

        apretoAgregarTema = false;

        //crearSeguridad();
    }

    private void predeterminadoPensamientoActual() {
        if (idActual != -1) {
//            System.out.println("predeterminado");
            Pensamiento Pe = getPensamientoActual();
//            for (int i = 0; i < P.length; i++) {
//                if (P[i].getId() == idActual) {
//                    Pe = P[i];
//                    break;
//                }
//            }
            if (Pe != null) {
                TNombre.setText(Pe.getNombre());
                TA.setText(Pe.getContenido());
//                CB.getSelectionModel().select(Pe.getTema().getNombre());
                select(CB, Pe.getTema().getNombre());
//                CB.getEditor().setText(Pe.getTema().getNombre());

                ob.clear();
                obUbicacion.clear();

                PT PE[] = getPensamiento_TituloAll(Pe);
                // Pensamiento_Titulo PE[] = getPensamiento_TituloAll(Pe);
                for (int i = 0; i < PE.length; i++) {
                    ob.add(new objetoTreeTableView(PE[i].getTitulo()));
                    obUbicacion.add(new objetoTreeTableView(PE[i].getLugar()));
                }
//                Pe.pensamiento_Titulo.getCollection().forEach(v -> {
//                    Pensamiento_Titulo Pt = (Pensamiento_Titulo) v;
//                    ob.add(new objetoTreeTableView(Pt.getTitulo()));
//                    obUbicacion.add(new objetoTreeTableView(Pt.getLugar()));
//                });
            }
        }
    }

    private Pensamiento getPensamientoActual() {
        for (int i = 0; i < P.length; i++) {
            if (P[i].getId() == idActual) {
//                System.out.println("encontrado");
                return P[i];

            }
        }
        return null;
    }

}
