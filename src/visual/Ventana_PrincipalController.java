/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.ClasesUtiles.Interfases.Funcionales.Creador;
import Utiles.FX.Celdas.CellLista;
import Utiles.FX.TablasFX;
import Utiles.FX.VisualFX;
import Utiles.FX.objetoTreeTableView;
import clases.Autor;
import clases.Disponibilidad;
import clases.Pensamiento;
import clases.PensamientoFactory;
import clases.Titulo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.orm.PersistentException;
import javafx.scene.text.Text;

import static Utiles.FX.VisualFX.setRbsBusqueda;
import static Utiles.FX.VisualFX.setTextBusqueda;
import static Utiles.FX.VisualFX.setPredicate;
import static Utiles.FX.VisualFX.getSeleccionado;
import static visual.probar.*;
import static reportes.MetodosReportes.*;
import clases.*;
import com.jfoenix.controls.JFXListView;
import static Utiles.FX.VisualFX.actualizarObs;
import static Utiles.FX.VisualFX.getI;
import static Utiles.FX.VisualFX.haySeleccionado;
import static Utiles.FX.VisualFX.getSeleccionado;
import static Utiles.FX.TablasFX.crearTabla;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import de.jensd.fx.glyphs.emojione.EmojiOne;
import de.jensd.fx.glyphs.emojione.EmojiOneView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.weathericons.WeatherIcon;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeTableRow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javax.swing.JRadioButton;
import org.orm.util.ORMSet;

public class Ventana_PrincipalController implements Initializable {

    private ObservableList<objetoTreeTableView> obPensamientos, obAutores, obLibros, obCartas, obArticulos, obTemas, obPensamientosSeleccionados;
    private ObservableList<Tema> temas;
    private ToggleGroup TGPrincipales, TGSecundarios, TGBusquedaAutores, TGBusquedaPensamientos, TGBusquedaLibros, TGBusquedaCartas, TGBusquedaArticulos, TGBusquedaPensamientosSeleccionados, TGBusquedaSecundaria, TGBusquedaPrincipal;
    private Stage ventana;
    private JFXRadioButton RBsSecundarios[], RBsBusquedaSecundarias[], RBsBusquedaPrincipal[];
    private JFXButton BsAgregar[], BsEditar[], BsEliminar[], BsClear[];

    @FXML
    private StackPane Pstack;

    @FXML
    private AnchorPane PTodo;

    @FXML
    private JFXButton BMinimizar;

    @FXML
    private JFXButton BCerrar;

    @FXML
    private JFXButton BClearBD;

    @FXML
    private JFXButton BActualizarBD;

    @FXML
    private JFXTabPane TabPrincipal;

    @FXML
    private Tab TabEntidades;

    @FXML
    private JFXTabPane Tab;

    @FXML
    private Tab TABAutores;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TVAutores;

    @FXML
    private JFXTextField TBuscarAutores;

    @FXML
    private JFXButton BClearBusquedaAutores;

    @FXML
    private JFXButton BBuscarAutores;

    @FXML
    private ContextMenu CMAutores;

    @FXML
    private JFXRadioButton RBCMAutoresPorNombre;

    @FXML
    private JFXRadioButton RBCMAutoresPorNacimiento;

    @FXML
    private JFXRadioButton RBCMAutoresPorMuerte;
    @FXML
    private JFXRadioButton RBCMAutoresPorTitulo;

    @FXML
    private JFXButton BEditarAutores;

    @FXML
    private JFXButton BEliminarAutores;

    @FXML
    private JFXButton BClearAutores;

    @FXML
    private JFXButton BCrearAutores;

    @FXML
    private JFXButton BReporteAutores;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TVPensamientos;

    @FXML
    private JFXTextField TBuscarPensamientos;

    @FXML
    private JFXButton BClearBusquedaPensamientos;

    @FXML
    private JFXButton BBuscarPensamientos;

    @FXML
    private ContextMenu CMPensamientos;

    @FXML
    private JFXRadioButton RBCMPensamientosPorNombre;

    @FXML
    private JFXRadioButton RBCMPensamientosPorPalabrasClave;

    @FXML
    private JFXRadioButton RBCMPensamientosPorContenido;

    @FXML
    private JFXRadioButton RBCMPensamientosPorTema;

    @FXML
    private JFXRadioButton RBCMPensamientosPorTitulos;

    @FXML
    private JFXButton BEditarPensamientos;

    @FXML
    private JFXButton BEliminarPensamientos;

    @FXML
    private JFXButton BClearPensamientos;

    @FXML
    private JFXButton BCrearPensamientos;

    @FXML
    private JFXButton BReportePensamientos;

    @FXML
    private Tab TAPLibros;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TVLibros;

    @FXML
    private JFXTextField TBuscarLibros;

    @FXML
    private JFXButton BClearBusquedaLibros;

    @FXML
    private JFXButton BBuscarLibros;

    @FXML
    private ContextMenu CMLibros;

    @FXML
    private JFXRadioButton RBCMLibrosPorNombre;

    @FXML
    private JFXRadioButton RBCMLibrosPorFecha;

    @FXML
    private JFXRadioButton RBCMLibrosPorAutor;

    @FXML
    private JFXRadioButton RBCMLibrosPorUbicacion;

    @FXML
    private JFXRadioButton RBCMLibrosPorEdicion;

    @FXML
    private JFXButton BEditarLibros;

    @FXML
    private JFXButton BEliminarLibros;

    @FXML
    private JFXButton BClearLibros;

    @FXML
    private JFXButton BCrearLibros;

    @FXML
    private JFXButton BReporteLibros;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TVArticulos;

    @FXML
    private JFXTextField TBuscarArticulos;

    @FXML
    private JFXButton BClearBusquedaArticulos;

    @FXML
    private JFXButton BBuscarArticulos;

    @FXML
    private ContextMenu CMArticulos;

    @FXML
    private JFXRadioButton RBCMArticulosPorNombre;

    @FXML
    private JFXRadioButton RBCMArticulosPorFecha;

    @FXML
    private JFXRadioButton RBCMArticulosPorAutor;

    @FXML
    private JFXRadioButton RBCMArticulosPorUbicacion;

    @FXML
    private JFXRadioButton RBCMArticulosPorPublicacion;

    @FXML
    private JFXRadioButton RBCMArticulosPorVolumen;

    @FXML
    private JFXButton BEditarArticulos;

    @FXML
    private JFXButton BEliminarArticulos;

    @FXML
    private JFXButton BClearArticulos;

    @FXML
    private JFXButton BCrearArticulos;

    @FXML
    private JFXButton BReporteArticulos;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TVCartas;

    @FXML
    private JFXTextField TBuscarCartas;

    @FXML
    private JFXButton BClearBusquedaCartas;

    @FXML
    private JFXButton BBuscarCartas;

    @FXML
    private ContextMenu CMCartas;

    @FXML
    private JFXRadioButton RBCMCartasPorNombre;

    @FXML
    private JFXRadioButton RBCMCartasPorFecha;

    @FXML
    private JFXRadioButton RBCMCartasPorAutor;

    @FXML
    private JFXRadioButton RBCMCartasPorUbicacion;

    @FXML
    private JFXRadioButton RBCMCartasPorDestinatario;

    @FXML
    private JFXButton BEditarCartas;

    @FXML
    private JFXButton BEliminarCartas;

    @FXML
    private JFXButton BClearCartas;

    @FXML
    private JFXButton BCrearCartas;

    @FXML
    private JFXButton BReporteCartas;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TVPensamientosSeleccionados;

    @FXML
    private JFXTextField TBuscarPensamientosSeleccionados;

    @FXML
    private JFXButton BClearBusquedaPensamientosSeleccionados;

    @FXML
    private JFXButton BBuscarPensamientosSeleccionados;

    @FXML
    private ContextMenu CMPensamientosSeleccionados;

    @FXML
    private JFXRadioButton RBCMPensamientosSeleccionadosPorNombre;

    @FXML
    private JFXRadioButton RBCMPensamientosSeleccionadosPorPalabrasClave;

    @FXML
    private JFXRadioButton RBCMPensamientosSeleccionadosPorContenido;

    @FXML
    private JFXRadioButton RBCMPensamientosSeleccionadosPorTitulos;

    @FXML
    private JFXListView<Tema> LVTemas;

    @FXML
    private JFXButton BEditarPensamientosSeleccionados;

    @FXML
    private JFXButton BEliminarPensamientosSeleccionados;

    @FXML
    private JFXButton BClearPensamientosSeleccionados;

    @FXML
    private JFXButton BCrearPensamientosSeleccionados;

    @FXML
    private JFXButton BEditarTema;

    @FXML
    private JFXButton BEliminarTema;

    @FXML
    private JFXButton BClearTema;

    @FXML
    private JFXButton BCrearTema;

    @FXML
    private JFXButton BReportePensamientosSeleccionados;

    @FXML
    private JFXButton BReporteTema;

    @FXML
    private Tab TabRelaciones;

    @FXML
    private JFXRadioButton RBTemas;

    @FXML
    private JFXRadioButton RBPensamientos;

    @FXML
    private JFXRadioButton RBLibros;

    @FXML
    private JFXRadioButton RBCartas;

    @FXML
    private JFXRadioButton RBArticulos;

    @FXML
    private JFXRadioButton RBAutores;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TVRelacionesPrincipal;

    @FXML
    private JFXTextField TBuscarRelacionesPrincipal;

    @FXML
    private JFXButton BClearRelacionesPrincipal;

    @FXML
    private JFXButton BBuscarRelacionesPrincipal;

    @FXML
    private JFXRadioButton RB1RelacionesSecundarias;

    @FXML
    private JFXRadioButton RB2RelacionesSecundarias;

    @FXML
    private JFXRadioButton RB3RelacionesSecundarias;

    @FXML
    private JFXRadioButton RB4RelacionesSecundarias;

    @FXML
    private JFXRadioButton RB5RelacionesSecundarias;

    @FXML
    private JFXTreeTableView<objetoTreeTableView> TVRelacionesSecundarias;

    @FXML
    private JFXTextField TBuscarRelacionesSecundarias;

    @FXML
    private JFXButton BClearBusquedaRelacionesSecundarias;

    @FXML
    private JFXButton BBuscarRelacionesSecundarias;

    @FXML
    private JFXButton BReporteSecundario;

    @FXML
    private JFXNodesList NLAgreagar;

    @FXML
    private JFXButton BAgregarTemas;

    @FXML
    private JFXButton BAutor;

    @FXML
    private JFXButton BAgregarLibro;

    @FXML
    private JFXButton BAgregarArticulo;

    @FXML
    private JFXButton BAgregarCarta;

    @FXML
    private JFXButton BAgregarPensamiento;

    @FXML
    private JFXNodesList NLReportes;

    @FXML
    private JFXButton BReporteTemas;

    @FXML
    private JFXButton BReporteAutor;

    @FXML
    private JFXButton BReporteLibro;

    @FXML
    private JFXButton BReporteArticulo;

    @FXML
    private JFXButton BReporteCarta;

    @FXML
    private JFXButton BReportePensamiento;

    @FXML
    private Text TENombre;

    @FXML
    private JFXButton BCuentas;

    @FXML
    private JFXButton BConfiguracionDeCuenta;

    @FXML
    private JFXButton BCambiarDeUsuario;

    @FXML
    void apretoBReporteArticulos(MouseEvent event) {
        runReporteArticulos();
    }

    @FXML
    void apretoBReporteAutores(MouseEvent event) {
        runReporteAutores();
    }

    @FXML
    void apretoBReporteCartas(MouseEvent event) {
        runReporteCartas();
    }

    @FXML
    void apretoBReporteLibros(MouseEvent event) {
        runReporteLibros();
    }

    @FXML
    void apretoBReportePensamientos(MouseEvent event) {
        runReportePensamientos();
    }

    @FXML
    void apretoBReportePensamientosSeleccionados(MouseEvent event) {
        Tema t = getSeleccionado(LVTemas);
        if (t != null) {
            runReportePensamientosDeTema(t);
        } else {
            dialogo_solo_AceptarController.show("No hay seleccionados");
        }

    }

    @FXML
    void apretoBReporteTema(MouseEvent event) {
        runReporteTemas();
    }

    @FXML
    void apretoBReporteSecundario(MouseEvent event) {
        Object seleccionado = objetoTreeTableView.getValorSeleccionado(TVRelacionesPrincipal);
//        System.out.println("seleccionado=" + seleccionado);
        if (seleccionado != null) {
            int indice = getI(TGSecundarios);
            if (RBArticulos.isSelected()) {//(Articulo) seleccionado
                crearReporteDesdeTitulo(indice, ((Articulo) seleccionado).getTitulo());
                return;
            }

            if (RBCartas.isSelected()) {
                crearReporteDesdeTitulo(indice, ((Carta) seleccionado).getTitulo());
                return;
            }
            if (RBLibros.isSelected()) {
                crearReporteDesdeTitulo(indice, ((Libro) seleccionado).getTitulo());
                return;
            }
            if (RBAutores.isSelected()) {
                Autor a = (Autor) seleccionado;
                switch (indice) {
                    case 0://Temas
                        runReporteTemaDeAutor(a);
                        break;
                    case 1://Pensamientos
                        runReportePensamientosDeAutor(a);
                        break;
                    case 2://Libros
                        runReporteLibrosDeAutor(a);
                        break;
                    case 3://Cartas
                        runReporteCartasDeAutor(a);
                        break;
                    case 4://Articulos
                        runReporteArticulosDeAutor(a);
                        break;

                }
                return;
            }
            if (RBPensamientos.isSelected()) {
                try {
                    Pensamiento p = (Pensamiento) seleccionado;
                    switch (indice) {
                        case 0://Libros
                            runReporteLibrosDePensamiento(p);
                            break;
                        case 1://Cartas
                            runReporteCartasDePensamiento(p);
                            break;
                        case 2://Articulos
                            runReporteArticulosDePensamiento(p);
                            break;
                        case 3://Autores
                            runReporteAutoresDePensamiento(p);
                            break;
                    }
                } catch (ClassCastException ex) {
                    ex.printStackTrace();
                    System.out.println("ignorar2");
                }
                return;
            }
            if (RBTemas.isSelected()) {
                Tema t = (Tema) seleccionado;
//                System.out.println("tema="+t);
                switch (indice) {
                    case 0://Pensamientos
                        runReportePensamientosDeTema(t);
                        break;
                    case 1://Libros
                        runReporteLibrosDeTema(t);
                        break;
                    case 2://Cartas
                        runReporteCartasDeTema(t);
                        break;
                    case 3://Articulos
                        runReporteArticulosDeTema(t);
                        break;
                    case 4://Autores
                        runReporteAutoresDeTema(t);
                        break;
                }
                // return;
            }

        } else {
            crearTabla(TVRelacionesSecundarias, new Object[0]);
        }
    }

    @FXML
    void apretoCambiarDeUsuario(MouseEvent event) {
        Platform.runLater(() -> {
            stage_Ventana_Principal.hide();
            stage_Ventana_Login.show();

        });
    }

    @FXML
    void apretoBConfiguracionDeCuenta(MouseEvent event) {
        dialogo_Configuracion_CuentaController.show();
    }

    @FXML
    void apretoReporteCarta(MouseEvent event) {
        runReporteCartas();
    }

    @FXML
    void apretoReporteArticulo(MouseEvent event) {
        runReporteArticulos();
    }

    @FXML
    void apretoReporteAutor(MouseEvent event) {
        runReporteAutores();
    }

    @FXML
    void apretoReporteLibro(MouseEvent event) {
        System.out.println("intenta");
        runReporteLibros();
        System.out.println("sale");
    }

    @FXML
    void apretoReportePensamiento(MouseEvent event) {
        runReportePensamientos();
    }

    @FXML
    void apretoReporteTemas(MouseEvent event) {
        runReporteTemas();
    }

    @FXML
    void apretoBuscarBuscarRelacionesPrincipal(MouseEvent event) {

    }

    @FXML
    void apretoBuscarRelacionesSecundarias(MouseEvent event) {

    }

    @FXML
    void apretoClearBusquedaRelacionesPrincipal(MouseEvent event) {

    }

    @FXML
    void apretoClearBusquedaRelacionesSecundarias(MouseEvent event) {

    }

    @FXML
    void apretoActualizarBD(MouseEvent event) {
        actualizarBD();
        crearTablas();
    }

    @FXML
    void apretoClearBD(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar toda la informacion", EmojiOne.SKULL_CROSSBONES, () -> {
                try {

                    clearBD();
                    actualizarBD();
                    crearTablas();
                } catch (PersistentException ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoAgregarPensamiento(MouseEvent event) {
        dialogo_Agregar_PensamientoController.show();
    }

    @FXML
    void AgregarCarta(MouseEvent event) {
        dialogo_Agregar_CartaController.show();
    }

    @FXML
    void apretoAgregarArticulo(MouseEvent event) {
        dialogo_Agregar_ArticuloController.show();
    }

    @FXML
    void apretoAgregarLibro(MouseEvent event) {
        dialogo_Agregar_LibroController.show();
    }

    @FXML
    void apretoAgregarTemas(MouseEvent event) {
        // System.out.println("se apreto");
        dialogo_Agregar_TemaController.show();
    }

    @FXML
    void apretoCerrar(ActionEvent event) {
//        dialogo_CerrarCotroller.show(Pstack);
        dialogo_CerrarCotroller.show();
    }

    @FXML
    void apretoMinimizar(ActionEvent event) {
        ventana.setIconified(true);
    }

    @FXML
    void apretoAgregarAutor(MouseEvent event) {
        //System.out.println(" se apreto");
        dialogo_Agregar_AutorController.show();
    }

    @FXML
    void apretoBuscarArticulos(MouseEvent event) {
        //    BBuscarArticulos.setContextMenu(new ContextMenu(new MenuItem("Apretame")));
        //BBuscarArticulos.getContextMenu().getItems().add(new MenuItem("Apretame"));
//   VisualFX.showContextMenu(BBuscarArticulos);
//   BBuscarArticulos.getContextMenu().show(BBuscarArticulos, Side.BOTTOM, 0, 0);
    }

    @FXML
    void apretoBuscarAutores(MouseEvent event) {

    }

    @FXML
    void apretoBuscarCartas(MouseEvent event) {

    }

    @FXML
    void apretoBuscarLibros(MouseEvent event) {

    }

    @FXML
    void apretoBuscarPensamientos(MouseEvent event) {

    }

    @FXML
    void apretoBuscarPensamientosSeleccionados(MouseEvent event) {

    }

    @FXML
    void apretoBuscarTemas(MouseEvent event) {

    }

    @FXML
    void apretoClearBusquedaArticulos(MouseEvent event) {
        TBuscarArticulos.setText("");
    }

    @FXML
    void apretoClearBusquedaAutores(MouseEvent event) {
        TBuscarAutores.setText("");
    }

    @FXML
    void apretoClearBusquedaCartas(MouseEvent event) {
        TBuscarCartas.setText("");
    }

    @FXML
    void apretoClearBusquedaLibros(MouseEvent event) {
        TBuscarLibros.setText("");
    }

    @FXML
    void apretoClearBusquedaPensamientos(MouseEvent event) {
        TBuscarPensamientos.setText("");
    }

    @FXML
    void apretoClearBusquedaPensamientosSeleccionados(MouseEvent event) {
        TBuscarPensamientosSeleccionados.setText("");
    }

//    @FXML
//    void apretoClearBusquedaTemas(MouseEvent event) {
//        TBuscarPensamientosSeleccionados.setText("");
//    }
    @FXML
    void apretoClearArticulos(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea todos los articulos", () -> {
                try {
                    eliminarArticuloAll();
                    actualizarArticulos();
                    // Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVArticulos, obArticulos);
                    crearTablaArticulos();
                } catch (PersistentException ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoClearAutores(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar todos los Autores", () -> {
                try {
                    if (eliminarAutorAll().length > 0) {// /n
                        dialogo_solo_AceptarController.show("No se eliminaron algunos porque hay \nTitulos  con un unico Autor");
                    } else {
                        crearTablaAutor();
                    }

                    //Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVAutores, obAutores);
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoClearCartas(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar todas las Cartas", () -> {
                try {
                    eliminarCartaAll();
                    actualizarCartas();
                    //  Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVCartas, obCartas);
                    crearTablaCartas();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoClearLibros(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar todos los Libros", () -> {
                try {
                    eliminarLibroAll();
                    actualizarLibros();
                    //   Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVLibros, obLibros);
                    crearTablaLibros();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoClearPensamientos(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar todos los Pensamientos", () -> {
                try {
                    eliminarPensamientoAll();
                    //  Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVPensamientos, obPensamientos);
                    actualizarPensamiento();
                    crearTablaPensamiento();

                    actualizarPensamientosRelacionados();
                    crearTablaPensamientoSeleccionado();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoClearPensamientosSeleccionados(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar todos los Pensamientos\nsobre este Tema ", () -> {
                try {
                    eliminarPensamientoAll(getSeleccionado(LVTemas));
                    //  Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVPensamientos, obPensamientos);
                    actualizarPensamiento();
                    crearTablaPensamiento();

                    actualizarPensamientosRelacionados();
                    crearTablaPensamientoSeleccionado();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoEditarArticulos(MouseEvent event) {
        int id = objetoTreeTableView.<Articulo>getValorSeleccionado(TVArticulos).getTitulo().getId();
        dialogo_Agregar_ArticuloController.show(id);
    }

    @FXML
    void apretoEditarAutores(MouseEvent event) {
        int id = objetoTreeTableView.<Autor>getValorSeleccionado(TVAutores).getId();
        dialogo_Agregar_AutorController.show(id);
    }

    @FXML
    void apretoEditarCartas(MouseEvent event) {
        int id = objetoTreeTableView.<Carta>getValorSeleccionado(TVCartas).getTitulo().getId();
        dialogo_Agregar_CartaController.show(id);
    }

    @FXML
    void apretoEditarLibros(MouseEvent event) {
        int id = objetoTreeTableView.<Libro>getValorSeleccionado(TVLibros).getTitulo().getId();
        dialogo_Agregar_LibroController.show(id);
    }

    @FXML
    void apretoEditarPensamientos(MouseEvent event) {
        int id = objetoTreeTableView.<Pensamiento>getValorSeleccionado(TVPensamientos).getId();
        dialogo_Agregar_PensamientoController.show(id);
    }

    @FXML
    void apretoEditarPensamientosSeleccionados(MouseEvent event) {
        int id = objetoTreeTableView.<Pensamiento>getValorSeleccionado(TVPensamientosSeleccionados).getId();
        dialogo_Agregar_PensamientoController.show(id);
    }

    @FXML
    void apretoEliminarArticulos(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar este Articulo", () -> {
                try {
                    eliminarTitulo(objetoTreeTableView.<Articulo>getValorSeleccionado(TVArticulos).getTitulo());
                    // Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVArticulos, obArticulos);
                    actualizarArticulos();
                    crearTablaArticulos();
                } catch (PersistentException ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoEliminarAutores(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar este Autor", () -> {
                try {
                    if (eliminarAutor(objetoTreeTableView.<Autor>getValorSeleccionado(TVAutores)).length > 0) {
                        dialogo_solo_AceptarController.show("No se elimino porque hay Titulos donde\n este es el unico Autor");
                    } else {
                        actualizarAutores();
                        crearTablaAutor();
                    }

                    //Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVAutores, obAutores);
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoEliminarCartas(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar esta Carta", () -> {
                try {
                    eliminarTitulo(objetoTreeTableView.<Carta>getValorSeleccionado(TVCartas).getTitulo());
                    //  Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVCartas, obCartas);
                    actualizarCartas();
                    crearTablaCartas();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoEliminarLibros(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar este Libro", () -> {
                try {
                    eliminarTitulo(objetoTreeTableView.<Libro>getValorSeleccionado(TVLibros).getTitulo());
                    //   Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVLibros, obLibros);
                    actualizarLibros();
                    crearTablaLibros();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoEliminarPensamientos(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar este Pensamiento", () -> {
                try {
                    eliminarPensamiento(objetoTreeTableView.<Pensamiento>getValorSeleccionado(TVPensamientos));
                    //  Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVPensamientos, obPensamientos);
                    actualizarPensamiento();
                    crearTablaPensamiento();

                    actualizarPensamientosRelacionados();
                    crearTablaPensamientoSeleccionado();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoEliminarPensamientosSeleccionados(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar este Pensamiento", () -> {
                try {
                    eliminarPensamiento(objetoTreeTableView.<Pensamiento>getValorSeleccionado(TVPensamientosSeleccionados));
                    //  Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVPensamientos, obPensamientos);

                    actualizarPensamientosRelacionados();
                    crearTablaPensamientoSeleccionado();

                    actualizarPensamiento();
                    crearTablaPensamiento();

                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoClearTema(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar todos los Temas", () -> {
                try {
                    eliminarTemaAll();
                    //  Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVPensamientos, obPensamientos);
                    actualizarTemas();
                    actualizarPensamientosRelacionados();
                    crearListaTema();
                    crearTablaPensamientoSeleccionado();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @FXML
    void apretoEditarTema(MouseEvent event) {
        int id = getSeleccionado(LVTemas).getId();
        dialogo_Agregar_TemaController.show(id);
    }

    @FXML
    void apretoCuentas(MouseEvent event) {
        Platform.runLater(() -> {
            stage_Ventana_Principal.hide();
            stage_Ventana_Cuentas.show();

        });
    }

    @FXML
    void apretoEliminarTema(MouseEvent event) {
        try {
            //Autor a = AutorFactory.loadAutorByQuery("Nombre='" + LV.getSelectionModel().getSelectedItem() + "'", null);
            //System.out.println("a=" + a);
            dialogo_Aceptar_CancelarController.show("Desea eliminar este Tema", () -> {
                try {
                    eliminarTema(getSeleccionado(LVTemas));
                    //  Utiles.FX.VisualFX.eliminarDeJFXTreeTable(TVPensamientos, obPensamientos);
                    actualizarTemas();
                    actualizarPensamientosRelacionados();

                    crearListaTema();
                    crearTablaPensamientoSeleccionado();
                } catch (Exception ex) {
                    responerException(ex);
                }
            });
        } catch (Exception ex) {
            responerException(ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Utiles.FX.VisualFX.setOcultarJFXNodesList(NLAgreagar, NLReportes);
        Utiles.FX.VisualFX.setCellFactory(LVTemas, Tema::getNombre);
        iniRBs();

        dialogo_Agregar_TemaController.show();
        System.out.println("a0");
        dialogo_Agregar_TemaController.getVentana().close();
        System.out.println("b0");
        iniBs();
        inicializarObs();
        iniTGs();
        actualizarBD();
        crearTablas();
        iniSeguridad();
        iniContextMenuBusquedaSecundarios();
        iniContextMenuBusquedaPrincipal();
        actualizarRBsBusquedaSecundaria();
        actualizarRBsBusquedaPrincipal();
        VisualFX.showContextMenuOnAction(BBuscarCartas, BBuscarLibros, BBuscarPensamientosSeleccionados, BBuscarRelacionesPrincipal, BBuscarRelacionesSecundarias, BBuscarRelacionesPrincipal);

//        try {
//            crearTablaRelacionSecundaria();
        setTextBusqueda(TBuscarRelacionesSecundarias, VisualFX.getText(TGBusquedaSecundaria));
        setTextBusqueda(TBuscarRelacionesPrincipal, VisualFX.getText(TGBusquedaPrincipal));
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
        VisualFX.setRotateGraphic(90, TabEntidades, TabRelaciones);
        
//        TVArticulos.setRowFactory(v->{
//            TreeTableRow t=new TreeTableRow<>();
//            
//            t.setMinHeight(26);
//            t.setPrefHeight(26);
//            t.setMaxHeight(26);
//        return t;
//        });


//double rotacion=90;
//TabEntidades.getGraphic().setRotate(rotacion);
//TabRelaciones.getGraphic().setRotate(rotacion);

// VisualFX.selecPrimero(TVRelacionesPrincipal);
        //setTextBusqueda(TBuscarRelacionesSecundarias, VisualFX.getText(TGBusquedaSecundaria));
    }

    private void crearReporteDesdeTitulo(int indice, Titulo t) {
        switch (indice) {
            case 0://Temas
                runReporteTemaDeTitulo(t);
                break;
            case 1://Pensamientos
                runReportePensamientoDeTitulo(t);
                break;
            case 2://Autores
                runReporteAutoresDeTitulo(t);
                break;
        }
    }

    private void actualizarEntornoDeUsuario() {
        TENombre.setText(usuarioActual.getNombre());
        Utiles.FX.VisualFX.setVisible(false, new JFXButton[][]{BsAgregar, BsClear, BsEditar, BsEliminar}, BClearBD, BCuentas);
        if (usuarioActual.getProfesor() != null) {
            Utiles.FX.VisualFX.setVisible(true, new JFXButton[][]{BsAgregar, BsClear, BsEditar, BsEliminar}, BClearBD);
            return;
        }
        if (usuarioActual.getAdministrador() != null) {
            Utiles.FX.VisualFX.setVisible(true, new JFXButton[][]{BsAgregar, BsClear, BsEditar, BsEliminar}, BClearBD, BCuentas);
        }
    }

    private void iniContextMenuBusquedaSecundarios() {
        BBuscarRelacionesSecundarias.setContextMenu(new ContextMenu());
    }

    private void iniContextMenuBusquedaPrincipal() {
        BBuscarRelacionesPrincipal.setContextMenu(new ContextMenu());
    }

    private void setRbsBusquedaSecundarios(int lengh) {
//        BBuscarRelacionesSecundarias.getContextMenu().getItems().clear();
//        for (int i = 0; i < lengh; i++) {
////            System.out.println("i="+i);
////            System.out.println("RBsBusquedaSecundarias[i].getText()="+RBsBusquedaSecundarias[i].getText());
//            BBuscarRelacionesSecundarias.getContextMenu().getItems().add(new MenuItem("", RBsBusquedaSecundarias[i]));
//        }
//        VisualFX.selecPrimero(TGBusquedaSecundaria);
        setRbsBusqueda(lengh, BBuscarRelacionesSecundarias, RBsBusquedaSecundarias, TGBusquedaSecundaria);
    }

    private void setRbsBusquedaPrincipal(int lengh) {
        setRbsBusqueda(lengh, BBuscarRelacionesPrincipal, RBsBusquedaPrincipal, TGBusquedaPrincipal);
    }

    private void actualizarRBsBusquedaPrincipal() {
        if (RBTemas.isSelected()) {
            VisualFX.setText(RBsBusquedaPrincipal, NOMBRE, PENSAMIENTO);
            setRbsBusquedaPrincipal(2);
            return;
        }
        if (RBPensamientos.isSelected()) {
            VisualFX.setText(RBsBusquedaPrincipal, getTextoRBPensamiento());
            setRbsBusquedaPrincipal(4);
            return;
        }
        if (RBLibros.isSelected()) {
            VisualFX.setText(RBsBusquedaPrincipal, getTextoRBTitulo(), EDICION);
            setRbsBusquedaPrincipal(5);
            return;
        }
        if (RBCartas.isSelected()) {
            VisualFX.setText(RBsBusquedaPrincipal, getTextoRBTitulo(), DESTINATARIO);
            setRbsBusquedaPrincipal(5);
            return;
        }
        if (RBArticulos.isSelected()) {
            VisualFX.setText(RBsBusquedaPrincipal, getTextoRBTitulo(), PUBLICACION, VOLUMEN);
            setRbsBusquedaPrincipal(6);
            return;
        }
        if (RBAutores.isSelected()) {
            VisualFX.setText(RBsBusquedaPrincipal, getTextoRBAutor());
            setRbsBusquedaPrincipal(4);
            return;
        }
    }

    private void actualizarRBsBusquedaSecundaria() {
        int indice = getI(TGSecundarios);
        if (RBTemas.isSelected()) {
            switch (indice) {
                case 0://Pensamiento
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBPensamiento());
                    setRbsBusquedaSecundarios(4);
                    return;
                case 1://Libro
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBTitulo(), EDICION);
                    setRbsBusquedaSecundarios(5);
                    return;
                case 2://Carta
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBTitulo(), DESTINATARIO);
                    setRbsBusquedaSecundarios(5);
                    return;
                case 3://Articulo
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBTitulo(), PUBLICACION, VOLUMEN);
                    setRbsBusquedaSecundarios(6);
                    return;

                case 4://Autor
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBAutor());
                    setRbsBusquedaSecundarios(4);
                    return;
            }

        }
        if (RBPensamientos.isSelected()) {
            switch (indice) {
                case 0://Libro
                    VisualFX.setText(RBsBusquedaSecundarias, new String[]{UBICACION}, getTextoRBTitulo(), EDICION);
                    setRbsBusquedaSecundarios(6);
                    return;
                case 1://Carta
                    VisualFX.setText(RBsBusquedaSecundarias, new String[]{UBICACION}, getTextoRBTitulo(), DESTINATARIO);
                    setRbsBusquedaSecundarios(6);
                    return;
                case 2://Articulo
                    VisualFX.setText(RBsBusquedaSecundarias, new String[]{UBICACION}, getTextoRBTitulo(), PUBLICACION, VOLUMEN);
                    setRbsBusquedaSecundarios(7);
                    return;

                case 3://Autor
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBAutor());
                    setRbsBusquedaSecundarios(4);
                    return;
            }

        }
        if (RBLibros.isSelected() || RBArticulos.isSelected() || RBCartas.isSelected()) {
            switch (indice) {
                case 0://Tema
                    VisualFX.setText(RBsBusquedaSecundarias, NOMBRE, PENSAMIENTO);
                    setRbsBusquedaSecundarios(2);
                    return;
                case 1://Pensamiento
                    VisualFX.setText(RBsBusquedaSecundarias, new String[]{UBICACION, TEMA}, getTextoRBPensamiento());
                    setRbsBusquedaSecundarios(6);
                    return;
                case 2://Autor
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBAutor());
                    setRbsBusquedaSecundarios(4);
                    return;
            }

        }
        if (RBAutores.isSelected()) {
            switch (indice) {
                case 0://Tema
                    VisualFX.setText(RBsBusquedaSecundarias, NOMBRE, PENSAMIENTO);
                    setRbsBusquedaSecundarios(2);
                    return;
                case 1://Pensamiento
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBPensamiento(1, TEMA));
                    setRbsBusquedaSecundarios(5);
                    return;
                case 2://Libro
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBTitulo(), EDICION);
                    setRbsBusquedaSecundarios(5);
                    return;
                case 3://Carta
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBTitulo(), DESTINATARIO);
                    setRbsBusquedaSecundarios(5);
                    return;
                case 4://Articulo
                    VisualFX.setText(RBsBusquedaSecundarias, getTextoRBTitulo(), PUBLICACION, VOLUMEN);
                    setRbsBusquedaSecundarios(6);
                    return;

            }

        }

    }

    private String getBusquedaSecundaria(Object v) {
        String selecRBSecundaria = VisualFX.getText(TGSecundarios),
                selecRBBusquedaSecundaria = VisualFX.getText(TGBusquedaSecundaria);
        return getBusquedaRelacion(v, selecRBSecundaria, selecRBBusquedaSecundaria);
    }

    private String getBusquedaPrincipal(Object v) {
        return getBusquedaRelacion(v, VisualFX.getText(TGPrincipales), VisualFX.getText(TGBusquedaPrincipal));
    }

    private String getBusquedaRelacion(Object v, String selecRBSecundaria, String selecRBBusquedaSecundaria) {
        Object seleccionado = objetoTreeTableView.getValorSeleccionado(TVRelacionesPrincipal);

        if (selecRBSecundaria.equals(RBPensamientos.getText())) {
            Pensamiento p = (Pensamiento) v;
            switch (selecRBBusquedaSecundaria) {
                case NOMBRE:
                    return p.getNombre();
                case PALABRAS_CLAVE:
                    return p.getPalabrasClave();
                case CONTENIDO:
                    return p.getContenido();
                case TITULOS:
                    return getTitulosString(p);
                case UBICACION:
                    if (seleccionado != null) {
                        if (seleccionado instanceof Libro) {
                            return getUbicacion(((Libro) seleccionado).getTitulo(), p);
                        }
                        if (seleccionado instanceof Articulo) {
                            return getUbicacion(((Articulo) seleccionado).getTitulo(), p);
                        }
                        if (seleccionado instanceof Carta) {
                            return getUbicacion(((Carta) seleccionado).getTitulo(), p);
                        }
                    }
                    return "";
                case TEMA:
                    return p.getTema().getNombre();

            }
        }
        if (selecRBSecundaria.equals(RBTemas.getText())) {
            Tema p = (Tema) v;
            switch (selecRBBusquedaSecundaria) {
                case NOMBRE:
                    return p.getNombre();
                case PENSAMIENTO:
                    return getPensamientosString(p);
            }
        }
        if (selecRBSecundaria.equals(RBAutores.getText())) {
            Autor a = (Autor) v;
            switch (selecRBBusquedaSecundaria) {
                case NOMBRE:
                    return a.getNombre();
                case NACIMIENTO:
                    return getFecha(a.getFecha_Nacimiento());
                case MUERTE:
                    return a.getFecha_Muerte() == null ? "" : getFecha(a.getFecha_Muerte());
                case TITULOS:
                    return getTitulosString(a);
            }
        }
        Titulo t = v instanceof Libro ? ((Libro) v).getTitulo() : (v instanceof Articulo ? ((Articulo) v).getTitulo() : ((Carta) v).getTitulo());
        switch (selecRBBusquedaSecundaria) {
            case NOMBRE:
                return t.getNombre();
            case FECHA:
                return getFecha(t.getFecha());
            case AUTOR:
                return getAutoresString(t);
            case DISPONIBILIDAD:
                return getDisponibilidadString(t);
            case EDICION://libro
                return ((Libro) v).getEdicion() + "";
            case DESTINATARIO://libro
                return ((Carta) v).getDestinatario();
            case PUBLICACION://libro
                return ((Articulo) v).getPublicacion();
            case VOLUMEN://libro
                return ((Articulo) v).getVolumen() + "";
            case UBICACION:
                return seleccionado != null ? getUbicacion(t, ((Pensamiento) seleccionado)) : "";

        }
        return "";
    }

    private String[] getTextoRBPensamiento(int indice, String a) {
        String res[] = new String[]{NOMBRE, PALABRAS_CLAVE, CONTENIDO, TITULOS};
        if (indice != -1) {
            LinkedList<String> l = new LinkedList<String>(Arrays.asList(res));
            l.add(indice, a);
            return l.toArray(res);
        }
        return res;
    }

    private String[] getTextoRBPensamiento() {
        return getTextoRBPensamiento(-1, "");
        //  return new String[]{"Nombre", "Palabras Clave", "Contenido", "Titulos"};
    }

    private String[] getTextoRBTitulo() {
        return new String[]{NOMBRE, FECHA, AUTOR, DISPONIBILIDAD};
    }

    private String[] getTextoRBAutor() {
        return new String[]{NOMBRE, NACIMIENTO, MUERTE, TITULOS};
    }

    private void iniTGs() {
        TGPrincipales = new ToggleGroup();
        TGPrincipales.getToggles().addAll(RBArticulos, RBAutores, RBCartas, RBLibros, RBPensamientos, RBTemas);
        TGSecundarios = new ToggleGroup();
        TGSecundarios.getToggles().addAll(RBsSecundarios);
        TGBusquedaArticulos = new ToggleGroup();
        TGBusquedaArticulos.getToggles().addAll(RBCMArticulosPorAutor, RBCMArticulosPorFecha, RBCMArticulosPorNombre, RBCMArticulosPorPublicacion, RBCMArticulosPorUbicacion, RBCMArticulosPorVolumen);
        TGBusquedaAutores = new ToggleGroup();
        TGBusquedaAutores.getToggles().addAll(RBCMAutoresPorMuerte, RBCMAutoresPorNacimiento, RBCMAutoresPorNombre, RBCMAutoresPorTitulo);
        TGBusquedaCartas = new ToggleGroup();
        TGBusquedaCartas.getToggles().addAll(RBCMCartasPorAutor, RBCMCartasPorDestinatario, RBCMCartasPorFecha, RBCMCartasPorNombre, RBCMCartasPorUbicacion);
        TGBusquedaLibros = new ToggleGroup();
        TGBusquedaLibros.getToggles().addAll(RBCMLibrosPorAutor, RBCMLibrosPorEdicion, RBCMLibrosPorFecha, RBCMLibrosPorNombre, RBCMLibrosPorUbicacion);
        TGBusquedaPensamientos = new ToggleGroup();
        TGBusquedaPensamientos.getToggles().addAll(RBCMPensamientosPorTitulos, RBCMPensamientosPorTitulos, RBCMPensamientosPorContenido, RBCMPensamientosPorNombre, RBCMPensamientosPorPalabrasClave, RBCMPensamientosPorTema);
        TGBusquedaPensamientosSeleccionados = new ToggleGroup();
        TGBusquedaPensamientosSeleccionados.getToggles().addAll(RBCMPensamientosSeleccionadosPorTitulos, RBCMPensamientosSeleccionadosPorTitulos, RBCMPensamientosSeleccionadosPorContenido, RBCMPensamientosSeleccionadosPorNombre, RBCMPensamientosSeleccionadosPorPalabrasClave);
        TGBusquedaSecundaria = new ToggleGroup();
        TGBusquedaSecundaria.getToggles().addAll(RBsBusquedaSecundarias);
        VisualFX.selecPrimero(TGBusquedaSecundaria);
        TGBusquedaPrincipal = new ToggleGroup();
        TGBusquedaPrincipal.getToggles().addAll(RBsBusquedaPrincipal);
        VisualFX.selecPrimero(TGBusquedaPrincipal);
    }

    public void iniRBs() {
        RBsSecundarios = new JFXRadioButton[]{RB1RelacionesSecundarias, RB2RelacionesSecundarias, RB3RelacionesSecundarias, RB4RelacionesSecundarias, RB5RelacionesSecundarias};
        RBsBusquedaSecundarias = new JFXRadioButton[]{new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton()};
        RBsBusquedaPrincipal = new JFXRadioButton[]{new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton()};
    }

    private void iniBs() {
        BsAgregar = new JFXButton[]{BAgregarArticulo, BAgregarCarta, BAgregarLibro, BAgregarPensamiento, BAgregarTemas, BAutor, BCrearArticulos, BCrearCartas, BCrearAutores, BCrearLibros, BCrearPensamientos, BCrearPensamientosSeleccionados, BCrearTema};
        BsClear = new JFXButton[]{BClearArticulos, BClearCartas, BClearAutores, BClearLibros, BClearPensamientos, BClearPensamientosSeleccionados, BClearTema};
        BsEditar = new JFXButton[]{BEditarArticulos, BEditarCartas, BEditarAutores, BEditarLibros, BEditarPensamientos, BEditarPensamientosSeleccionados, BEditarTema};
        BsEliminar = new JFXButton[]{BEliminarArticulos, BEliminarCartas, BEliminarAutores, BEliminarLibros, BEliminarPensamientos, BEliminarPensamientosSeleccionados, BEliminarTema};

    }

    private void iniSeguridad() {
        setPredicate(TVPensamientos, TBuscarPensamientos, v -> getBusquedaDePensamientos((Pensamiento) v), TGBusquedaPensamientos, () -> getTextoEnBusquedaDePensamientos(), BBuscarPensamientos);
        setPredicate(TVAutores, TBuscarAutores, v -> getBusquedaDeAutores((Autor) v), TGBusquedaAutores, () -> getTextoEnBusquedaDeAutores(), BBuscarAutores);
        setPredicate(TVArticulos, TBuscarArticulos, v -> getBusquedaDeArticulos((Articulo) v), TGBusquedaArticulos, () -> getTextoEnBusquedaDeArticulos(), BBuscarArticulos);
//        Utiles.FX.TablasFX.<Pensamiento>setPredicate(TVPensamientos, TBuscarPensamientos, v -> getBusquedaDePensamientos(v));
//        Utiles.FX.TablasFX.<Autor>setPredicate(TVAutores, TBuscarAutores, v -> getBusquedaDeAutores(v));

//        Utiles.FX.TablasFX.<Articulo>setPredicate(TVArticulos, TBuscarArticulos, v -> getBusquedaDeArticulos(v));
        Utiles.FX.TablasFX.<Carta>setPredicate(TVCartas, TBuscarCartas, v -> getBusquedaDeCartas(v));
        Utiles.FX.TablasFX.<Libro>setPredicate(TVLibros, TBuscarLibros, v -> getBusquedaDeLibros(v));
        Utiles.FX.TablasFX.<Pensamiento>setPredicate(TVPensamientosSeleccionados, TBuscarPensamientosSeleccionados, v -> getBusquedaDePensamientosSeleccionados(v));
        Utiles.FX.TablasFX.setPredicate(TVRelacionesSecundarias, TBuscarRelacionesSecundarias, v -> getBusquedaSecundaria(v));
        Utiles.FX.TablasFX.setPredicate(TVRelacionesPrincipal, TBuscarRelacionesPrincipal, v -> getBusquedaPrincipal(v));

//        Utiles.FX.VisualFX.addOnSelected(TGBusquedaArticulos, v -> setTextBusqueda(TBuscarArticulos, getTextoEnBusquedaDeArticulos()));
//        Utiles.FX.VisualFX.addOnSelected(TGBusquedaAutores, v -> setTextBusqueda(TBuscarAutores, getTextoEnBusquedaDeAutores()));
        Utiles.FX.VisualFX.addOnSelected(TGBusquedaCartas, v -> setTextBusqueda(TBuscarCartas, getTextoEnBusquedaDeCartas()));
        Utiles.FX.VisualFX.addOnSelected(TGBusquedaLibros, v -> setTextBusqueda(TBuscarLibros, getTextoEnBusquedaDeLibros()));
//        Utiles.FX.VisualFX.addOnSelected(TGBusquedaPensamientos, v -> setTextBusqueda(TBuscarPensamientos, getTextoEnBusquedaDePensamientos()));
        Utiles.FX.VisualFX.addOnSelected(TGBusquedaPensamientosSeleccionados, v -> setTextBusqueda(TBuscarPensamientosSeleccionados, getTextoEnBusquedaDePensamientosSeleccionados()));
        Utiles.FX.VisualFX.addOnSelected(TGBusquedaSecundaria, v -> setTextBusqueda(TBuscarRelacionesSecundarias, VisualFX.getText(TGBusquedaSecundaria)));
        Utiles.FX.VisualFX.addOnSelected(TGBusquedaPrincipal, v -> setTextBusqueda(TBuscarRelacionesPrincipal, VisualFX.getText(TGBusquedaPrincipal)));
//        Utiles.FX.VisualFX.addOnSelected(TGBusquedaSecundaria, v -> setTextBusqueda(TBuscarRelacionesSecundarias, ((JFXRadioButton) TGBusquedaSecundaria.getSelectedToggle()).getText()));
//        Utiles.FX.VisualFX.addOnSelected(TGBusquedaPrincipal, v -> {
//            setTextBusqueda(TBuscarRelacionesPrincipal, VisualFX.getText(TGBusquedaPrincipal));
//        });

//        setTextBusqueda(TBuscarArticulos, getTextoEnBusquedaDeArticulos());
//        setTextBusqueda(TBuscarAutores, getTextoEnBusquedaDeAutores());
        setTextBusqueda(TBuscarCartas, getTextoEnBusquedaDeCartas());
        setTextBusqueda(TBuscarLibros, getTextoEnBusquedaDeLibros());
//        setTextBusqueda(TBuscarPensamientos, getTextoEnBusquedaDePensamientos());
        setTextBusqueda(TBuscarPensamientosSeleccionados, getTextoEnBusquedaDePensamientosSeleccionados());

        Utiles.FX.VisualFX.relacionarComponentes(TVPensamientos, obPensamientos, BClearPensamientos, BEditarPensamientos, BEliminarPensamientos);
        Utiles.FX.VisualFX.relacionarComponentes(TVArticulos, obArticulos, BClearArticulos, BEditarArticulos, BEliminarArticulos);
        Utiles.FX.VisualFX.relacionarComponentes(TVAutores, obAutores, BClearAutores, BEditarAutores, BEliminarAutores);
        Utiles.FX.VisualFX.relacionarComponentes(TVCartas, obCartas, BClearCartas, BEditarCartas, BEliminarCartas);
        Utiles.FX.VisualFX.relacionarComponentes(TVLibros, obLibros, BClearLibros, BEditarLibros, BEliminarLibros);
        Utiles.FX.VisualFX.relacionarComponentes(TVPensamientosSeleccionados, obPensamientosSeleccionados, BClearPensamientosSeleccionados, BEditarPensamientosSeleccionados, BEliminarPensamientosSeleccionados);
        Utiles.FX.VisualFX.relacionarComponentes(LVTemas, BClearTema, BEditarTema, BEliminarTema);

        Utiles.FX.VisualFX.alSeleccionar(LVTemas, () -> {
            Platform.runLater(() -> {
                try {
//                    System.out.println("crear pens s1");
                    BBuscarPensamientosSeleccionados.setText("");
                    actualizarPensamientosRelacionados();
                    crearTablaPensamientoSeleccionado();
//                    System.out.println("termino pens s2");
                } catch (PersistentException ex) {
                    responerException(ex);
                }
            });
        });
        Utiles.FX.VisualFX.addOnClosed(() -> {
            actualizarBD();
        }, getVentanasAgregar());

        Utiles.FX.VisualFX.addOnSelected(TGPrincipales, v -> {
            Platform.runLater(() -> {
                try {
                    BBuscarRelacionesPrincipal.setText("");
                    BBuscarRelacionesSecundarias.setText("");
                    crearTablaRelacionPrincipal();
                    actualizarRBSecundarios();
                    actualizarRBsBusquedaPrincipal();
                    setTextBusqueda(TBuscarRelacionesPrincipal, VisualFX.getText(TGBusquedaPrincipal));
                    if (getI(TGSecundarios) != 0) {
                        VisualFX.selecPrimero(TGSecundarios);
                    } else {
                        crearTablaRelacionSecundaria();
                        actualizarRBsBusquedaSecundaria();
                        setTextBusqueda(TBuscarRelacionesSecundarias, VisualFX.getText(TGBusquedaSecundaria));
                    }

                    //VisualFX.selecPrimero(TVRelacionesPrincipal);
//                crearTablaRelacionSecundaria();
//                actualizarRBsBusquedaSecundaria();
                } catch (PersistentException ex) {
                    responerException(ex);
                }
            });

        });
        Utiles.FX.VisualFX.addOnSelected(TGSecundarios, v -> {
            Platform.runLater(() -> {
                try {
                    //System.out.println("se apreto");
                    crearTablaRelacionSecundaria();
                    actualizarRBsBusquedaSecundaria();
                    // setTextBusqueda(TBuscarRelacionesSecundarias, VisualFX.getText(TGBusquedaSecundaria));
                } catch (PersistentException ex) {
                    responerException(ex);
                }
            });

        });
        actualizarRBSecundarios();
        Utiles.FX.VisualFX.addOnSelected(TVRelacionesPrincipal, v -> {
            Platform.runLater(() -> {
                try {
                    //System.out.println("talves ");
                    crearTablaRelacionSecundaria();

                } catch (PersistentException ex) {
                    responerException(ex);
                }
            });

        });

    }

    private String getBusquedaDeAutores(Autor a) {
        if (RBCMAutoresPorMuerte.isSelected()) {
            return a.getFecha_Muerte() == null ? "" : getFecha(a.getFecha_Muerte());
        }
        if (RBCMAutoresPorNacimiento.isSelected()) {
            return getFecha(a.getFecha_Nacimiento());
        }
        if (RBCMAutoresPorTitulo.isSelected()) {
            return getTitulosString(a);
        }
        return a.getNombre();
    }

    private String getTextoEnBusquedaDeAutores() {
        if (RBCMAutoresPorMuerte.isSelected()) {
            return "Fecha de Muerte";
        }
        if (RBCMAutoresPorNacimiento.isSelected()) {
            return "Fecha de Nacimiento";
        }
        if (RBCMAutoresPorTitulo.isSelected()) {
            return "Titulos";
        }
        return "Nombre";
    }

    private String getBusquedaDePensamientos(Pensamiento a) {
        if (RBCMPensamientosPorTitulos.isSelected()) {
            return getTitulosString(a);
        }
        if (RBCMPensamientosPorContenido.isSelected()) {
            return a.getContenido();
        }
        if (RBCMPensamientosPorNombre.isSelected()) {
            return a.getNombre();
        }
        if (RBCMPensamientosPorPalabrasClave.isSelected()) {
            return a.getPalabrasClave();
        }
        return a.getTema().getNombre();
    }

    private String getTextoEnBusquedaDePensamientos() {
        if (RBCMPensamientosPorTitulos.isSelected()) {
            return "Titulos";
        }
        if (RBCMPensamientosPorContenido.isSelected()) {
            return "Contenido";
        }
        if (RBCMPensamientosPorNombre.isSelected()) {
            return "Nombre";
        }
        if (RBCMPensamientosPorPalabrasClave.isSelected()) {
            return "Palabras Clave";
        }
        return "Tema";
    }

    private String getTextoEnBusquedaDePensamientosSeleccionados() {
        if (RBCMPensamientosSeleccionadosPorTitulos.isSelected()) {
            return "Titulos";
        }
        if (RBCMPensamientosSeleccionadosPorContenido.isSelected()) {
            return "Contenido";
        }
        if (RBCMPensamientosSeleccionadosPorNombre.isSelected()) {
            return "Nombre";
        }
        return "Palabras Clave";
    }

    private String getBusquedaDePensamientosSeleccionados(Pensamiento a) {
        if (RBCMPensamientosSeleccionadosPorTitulos.isSelected()) {
            return getTitulosString(a);
        }
        if (RBCMPensamientosSeleccionadosPorContenido.isSelected()) {
            return a.getContenido();
        }
        if (RBCMPensamientosSeleccionadosPorNombre.isSelected()) {
            return a.getNombre();
        }
        return a.getPalabrasClave();
    }

    private String getBusquedaDeLibros(Libro a) {
        if (RBCMLibrosPorAutor.isSelected()) {
            return getAutoresString(a.getTitulo());
        }
        if (RBCMLibrosPorFecha.isSelected()) {
            return getFecha(a.getTitulo().getFecha());
        }
        if (RBCMLibrosPorNombre.isSelected()) {
            return a.getTitulo().getNombre() + "";
        }
        if (RBCMLibrosPorEdicion.isSelected()) {
            return a.getEdicion() + "";
        }
        return getDisponibilidadString(a.getTitulo());
    }

    private String getTextoEnBusquedaDeLibros() {
        if (RBCMLibrosPorAutor.isSelected()) {
            return "Autores";
        }
        if (RBCMLibrosPorFecha.isSelected()) {
            return "Fecha";
        }
        if (RBCMLibrosPorNombre.isSelected()) {
            return "Nombre";
        }
        if (RBCMLibrosPorEdicion.isSelected()) {
            return "Edicion";
        }
        return "Disponibilidad";
    }

    private String getTextoEnBusquedaDeArticulos() {
        if (RBCMArticulosPorAutor.isSelected()) {
            return "Autores";
        }
        if (RBCMArticulosPorFecha.isSelected()) {
            return "Fecha";
        }
        if (RBCMArticulosPorNombre.isSelected()) {
            return "Nombre";
        }
        if (RBCMArticulosPorPublicacion.isSelected()) {
            return "Publicacion";
        }
        if (RBCMArticulosPorVolumen.isSelected()) {
            return "Volumen";
        }
        return "Disponibilidad";
    }

    private String getTextoEnBusquedaDeCartas() {
        if (RBCMCartasPorAutor.isSelected()) {
            return "Autores";
        }
        if (RBCMCartasPorFecha.isSelected()) {
            return "Fecha";
        }
        if (RBCMCartasPorNombre.isSelected()) {
            return "Nombre";
        }
        if (RBCMCartasPorDestinatario.isSelected()) {
            return "Destinatario";
        }
        return "Disponibilidad";
    }

    private String getBusquedaDeArticulos(Articulo a) {
        if (RBCMArticulosPorAutor.isSelected()) {
            return getAutoresString(a.getTitulo());
        }
        if (RBCMArticulosPorFecha.isSelected()) {
            return getFecha(a.getTitulo().getFecha());
        }
        if (RBCMArticulosPorNombre.isSelected()) {
            return a.getTitulo().getNombre() + "";
        }
        if (RBCMArticulosPorPublicacion.isSelected()) {
            return a.getPublicacion();
        }
        if (RBCMArticulosPorVolumen.isSelected()) {
            return a.getVolumen() + "";
        }
        return getDisponibilidadString(a.getTitulo());
    }

    private String getBusquedaDeCartas(Carta a) {
        if (RBCMCartasPorAutor.isSelected()) {
            return getAutoresString(a.getTitulo());
        }
        if (RBCMCartasPorFecha.isSelected()) {
            return getFecha(a.getTitulo().getFecha());
        }
        if (RBCMCartasPorNombre.isSelected()) {
            return a.getTitulo().getNombre() + "";
        }
        if (RBCMCartasPorDestinatario.isSelected()) {
            return a.getDestinatario();
        }
        return getDisponibilidadString(a.getTitulo());
    }

    private void inicializarObs() {
        obArticulos = FXCollections.observableArrayList();
        obAutores = FXCollections.observableArrayList();
        obCartas = FXCollections.observableArrayList();
        obLibros = FXCollections.observableArrayList();
        obPensamientos = FXCollections.observableArrayList();
        obTemas = FXCollections.observableArrayList();
//        obTitulos = FXCollections.observableArrayList();
        obPensamientosSeleccionados = FXCollections.observableArrayList();
        temas = FXCollections.observableArrayList();
    }

//    private JFXDialog[] getDialogosAgregar() {
//        return new JFXDialog[]{dialogo_Agregar_ArticuloController.getDialog(),
//            dialogo_Agregar_AutorController.getDialog(),
//            dialogo_Agregar_CartaController.getDialog(),
//            dialogo_Agregar_LibroController.getDialog(),
//            dialogo_Agregar_PensamientoController.getDialog(),
//            dialogo_Agregar_TemaController.getDialog()};
//    }
    private Stage[] getVentanasAgregar() {
        return new Stage[]{dialogo_Agregar_ArticuloController.getVentana(),
            dialogo_Agregar_AutorController.getVentana(),
            dialogo_Agregar_CartaController.getVentana(),
            dialogo_Agregar_LibroController.getVentana(),
            dialogo_Agregar_PensamientoController.getVentana(),
            dialogo_Agregar_TemaController.getVentana()};
    }

    public void crearTablas() {
        Platform.runLater(() -> {

            crearTablaPensamiento();
            crearTablaAutor();
            crearTablaArticulos();
            crearTablaCartas();
            crearTablaLibros();
            crearListaTema();
            crearTablaPensamientoSeleccionado();

            crearTablaRelacionPrincipal();
            try {
                crearTablaRelacionSecundaria();
            } catch (PersistentException ex) {
                responerException(ex);
            }
        });

    }

    public void crearListaTema() {
        LVTemas.setItems(temas);
        Utiles.FX.VisualFX.selecPrimero(LVTemas);
    }

    public void crearTablaPensamientoSeleccionado() {
//        if (haySeleccionado(LVTemas)) {
//            actualizarObs(obPensamientosSeleccionados, getSeleccionado(LVTemas).pensamiento);
//        System.out.println("crear t pens s");
        crearTablaTipoPesamiento(TVPensamientosSeleccionados, obPensamientosSeleccionados);
//        System.out.println("termino t pens s");
//        }
    }

    private void crearTablaTipoPesamiento(JFXTreeTableView<objetoTreeTableView> tv, ObservableList<objetoTreeTableView> ob) {
        crearTabla(tv, ob,
                getPensamientosColumns());
    }

    private JFXTreeTableColumn[] getPensamientosColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.<Pensamiento>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getNombre()),
            TablasFX.<Pensamiento>getTreeTableColumn("Tema", NORMAL, v -> v.getTema().getNombre()),
            TablasFX.<Pensamiento>getTreeTableColumnTextArea("Contenido", LARGO, Pensamiento::getContenido),
            TablasFX.<Pensamiento>getTreeTableColumnList("Claves", NORMAL, v -> {

                return getListaPalabrasClave(v);
            }),
            TablasFX.<Pensamiento, PT>getTreeTableColumnListArreglo("Titulos", ANCHO_NOMBRE, v -> getPensamiento_TituloAll(v), v2 -> {
                //System.out.println("v.getTitulo().getNombre()=" + v.getTitulo().getNombre());
                return v2.getTitulo().getNombre();
            })
//            TablasFX.<Pensamiento, Pensamiento_Titulo>getTreeTableColumnList("Titulos", ANCHO_NOMBRE, v -> v.pensamiento_Titulo.getCollection(), v -> {
//                //System.out.println("v.getTitulo().getNombre()=" + v.getTitulo().getNombre());
//                return v.getTitulo().getNombre();
//            })
        };

    }

    public void crearTablaPensamiento() {
        // System.out.println("crear t pes");
        crearTablaTipoPesamiento(TVPensamientos, obPensamientos);
        // System.out.println("termi t pens");
    }

    private void crearTablaAutor() {
        //  TVAutores.
        crearTablaAutor(TVAutores);
    }

    private void crearTablaAutor(JFXTreeTableView<objetoTreeTableView> TV) {
        crearTabla(TV, obAutores,
                getAutoresColumns());
    }

    private JFXTreeTableColumn[] getAutoresColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.getTreeTableColumn("Nombre", ANCHO_NOMBRE, Autor::getNombre),
            TablasFX.<Autor>getTreeTableColumn("Nacimiento", ANCHO_FECHA, v -> getFecha(v.getFecha_Nacimiento())),
            TablasFX.<Autor>getTreeTableColumn("Muerte", ANCHO_FECHA, v -> getFechaMuerte(v)),
            TablasFX.<Autor, Titulo>getTreeTableColumnList("Titulos", ANCHO_NOMBRE, v -> v.titulo.getCollection(), Titulo::getNombre)
        };

    }

    private void crearTablaLibros() {
        crearTablaLibros(TVLibros);
//        TVLibros.setEditable(false);
//        TablasFX.setColumns(TVLibros, obLibros,
//                TablasFX.<Libro>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getTitulo() != null ? v.getTitulo().getNombre() : ""),
//                TablasFX.<Libro>getTreeTableColumn("Edicion", ANCHO_NOMBRE, v -> v.getEdicion() + ""),
//                TablasFX.<Libro, Autor>getTreeTableColumnList("Autores", ANCHO_NOMBRE, v -> v.getTitulo().autor.getCollection(), v -> v.getNombre()),
//                TablasFX.<Libro>getTreeTableColumn("Biblioteca", NORMAL, v -> disponibleEnBiblioteca((Titulo) v.getTitulo()) ? "si" : "no"),
//                TablasFX.<Libro, Disponibilidad>getTreeTableColumnList("Digital", LARGO, v -> disponibilidaDigital(v.getTitulo()), v -> v.getUbicacion())
//        );

    }

    private void crearTablaLibros(JFXTreeTableView<objetoTreeTableView> TV) {
//        TVLibros.setEditable(false);
//        TablasFX.setColumns(TVLibros, obLibros,
//                TablasFX.<Libro>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getTitulo() != null ? v.getTitulo().getNombre() : ""),
//                TablasFX.<Libro>getTreeTableColumn("Edicion", ANCHO_NOMBRE, v -> v.getEdicion() + ""),
//                TablasFX.<Libro, Autor>getTreeTableColumnList("Autores", ANCHO_NOMBRE, v -> v.getTitulo().autor.getCollection(), v -> v.getNombre()),
//                TablasFX.<Libro>getTreeTableColumn("Biblioteca", NORMAL, v -> disponibleEnBiblioteca((Titulo) v.getTitulo()) ? "si" : "no"),
//                TablasFX.<Libro, Disponibilidad>getTreeTableColumnList("Digital", LARGO, v -> disponibilidaDigital(v.getTitulo()), v -> v.getUbicacion())
//        );
        crearTabla(TV, obLibros,
                getLibrosColumns());
        // setColumnsTitulos(TVLibros, obLibros);
    }

    private JFXTreeTableColumn[] getLibrosColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.<Libro>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getTitulo() != null ? v.getTitulo().getNombre() : ""),
            TablasFX.<Libro>getTreeTableColumn("Fecha", ANCHO_FECHA, v -> getFecha(v.getTitulo().getFecha())),
            TablasFX.<Libro>getTreeTableColumn("Edicion", NORMAL, v -> v.getEdicion() + ""),
            TablasFX.<Libro, Autor>getTreeTableColumnList("Autores", ANCHO_NOMBRE, v -> v.getTitulo().autor.getCollection(), v -> v.getNombre()),
            TablasFX.<Libro>getTreeTableColumn("Biblioteca", NORMAL, v -> disponibleEnBiblioteca((Titulo) v.getTitulo()) ? "si" : "no"),
            TablasFX.<Libro, Disponibilidad>getTreeTableColumnList("Digital", LARGO, v -> disponibilidaDigital(v.getTitulo()), v -> v.getUbicacion()),
            TablasFX.<Libro, PT>getTreeTableColumnListArreglo("Pensamientos", ANCHO_NOMBRE, v -> getPensamiento_TituloAll(v.getTitulo()), v2 -> v2.getPensamiento().getNombre())
        };

    }

    private void crearTablaArticulos() {
        crearTablaArticulos(TVArticulos);
    }

    private void crearTablaArticulos(JFXTreeTableView<objetoTreeTableView> TV) {
        crearTabla(TV, obArticulos, getArticulosColumns());
    }

    private JFXTreeTableColumn[] getArticulosColumns() {
        return new JFXTreeTableColumn[]{TablasFX.<Articulo>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getTitulo() != null ? v.getTitulo().getNombre() : ""),
            TablasFX.<Articulo>getTreeTableColumn("Volumen", NORMAL, Articulo::getPublicacion),
            TablasFX.<Articulo>getTreeTableColumn("Fecha", ANCHO_FECHA, v -> getFecha(v.getTitulo().getFecha())),
            TablasFX.<Articulo>getTreeTableColumn("Publicacion", NORMAL, v -> v.getVolumen() + ""),
            TablasFX.<Articulo, Autor>getTreeTableColumnList("Autores", ANCHO_NOMBRE, v -> v.getTitulo().autor.getCollection(), v -> v.getNombre()),
            TablasFX.<Articulo>getTreeTableColumn("Biblioteca", NORMAL, v -> disponibleEnBiblioteca((Titulo) v.getTitulo()) ? "si" : "no"),
            TablasFX.<Articulo, Disponibilidad>getTreeTableColumnList("Digital", LARGO, v -> disponibilidaDigital(v.getTitulo()), v -> v.getUbicacion()),
            TablasFX.<Articulo, PT>getTreeTableColumnListArreglo("Pensamientos", ANCHO_NOMBRE, v -> getPensamiento_TituloAll(v.getTitulo()), v2 -> v2.getPensamiento().getNombre())
        };
    }

    private void crearTablaCartas() {
        crearTablaCartas(TVCartas);
//        TVLibros.setEditable(false);
//        TablasFX.setColumns(TVCartas, obCartas,
//                TablasFX.<Carta>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getTitulo() != null ? v.getTitulo().getNombre() : ""),
//                TablasFX.<Carta>getTreeTableColumn("Destinatario", ANCHO_NOMBRE, Carta::getDestinatario),
//                TablasFX.<Carta, Autor>getTreeTableColumnList("Autores", ANCHO_NOMBRE, v -> v.getTitulo().autor.getCollection(), v -> v.getNombre()),
//                TablasFX.<Carta>getTreeTableColumn("Biblioteca", NORMAL, v -> disponibleEnBiblioteca((Titulo) v.getTitulo()) ? "si" : "no"),
//                TablasFX.<Carta, Disponibilidad>getTreeTableColumnList("Digital", LARGO, v -> disponibilidaDigital(v.getTitulo()), v -> v.getUbicacion())
//        );

    }

    private void crearTablaCartas(JFXTreeTableView<objetoTreeTableView> TV) {
//        TV.setEditable(false);
//        TablasFX.setColumns(TV, obCartas,
//                TablasFX.<Carta>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getTitulo() != null ? v.getTitulo().getNombre() : ""),
//                TablasFX.<Carta>getTreeTableColumn("Destinatario", ANCHO_NOMBRE, Carta::getDestinatario),
//                TablasFX.<Carta, Autor>getTreeTableColumnList("Autores", ANCHO_NOMBRE, v -> v.getTitulo().autor.getCollection(), v -> v.getNombre()),
//                TablasFX.<Carta>getTreeTableColumn("Biblioteca", NORMAL, v -> disponibleEnBiblioteca((Titulo) v.getTitulo()) ? "si" : "no"),
//                TablasFX.<Carta, Disponibilidad>getTreeTableColumnList("Digital", LARGO, v -> disponibilidaDigital(v.getTitulo()), v -> v.getUbicacion())
//        );
        crearTabla(TV, obCartas,
                getCartasColumns());
    }

    private JFXTreeTableColumn[] getCartasColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.<Carta>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getTitulo() != null ? v.getTitulo().getNombre() : ""),
            TablasFX.<Carta>getTreeTableColumn("Fecha", ANCHO_FECHA, v -> getFecha(v.getTitulo().getFecha())),
            TablasFX.<Carta>getTreeTableColumn("Destinatario", ANCHO_NOMBRE, Carta::getDestinatario),
            TablasFX.<Carta, Autor>getTreeTableColumnList("Autores", ANCHO_NOMBRE, v -> v.getTitulo().autor.getCollection(), Autor::getNombre),
            TablasFX.<Carta>getTreeTableColumn("Biblioteca", NORMAL, v -> disponibleEnBiblioteca((Titulo) v.getTitulo()) ? "si" : "no"),
            TablasFX.<Carta, Disponibilidad>getTreeTableColumnList("Digital", LARGO, v -> disponibilidaDigital(v.getTitulo()), Disponibilidad::getUbicacion),
            TablasFX.<Carta, PT>getTreeTableColumnListArreglo("Pensamientos", ANCHO_NOMBRE, v -> getPensamiento_TituloAll(v.getTitulo()), v2 -> v2.getPensamiento().getNombre())

        };

    }

    private void crearTablaTema(JFXTreeTableView<objetoTreeTableView> TV) {
        crearTabla(TV, obTemas,
                getTemaColumns()
        );
    }

    private JFXTreeTableColumn[] getTemaColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.<Tema>getTreeTableColumn("Nombre", ANCHO_NOMBRE, Tema::getNombre),
            TablasFX.<Tema, Pensamiento>getTreeTableColumnList("Pensamiento", ANCHO_NOMBRE, v -> v.pensamiento.getCollection(), Pensamiento::getNombre)

        };

    }

    private void crearTablaRelacionPrincipal() {
        while (true) {
            if (RBArticulos.isSelected()) {
                crearTablaArticulos(TVRelacionesPrincipal);
                break;
            }
            if (RBAutores.isSelected()) {
                crearTablaAutor(TVRelacionesPrincipal);
                break;
            }
            if (RBCartas.isSelected()) {
                crearTablaCartas(TVRelacionesPrincipal);
                break;
            }
            if (RBLibros.isSelected()) {
                crearTablaLibros(TVRelacionesPrincipal);
                break;
            }
            if (RBPensamientos.isSelected()) {
                crearTablaTipoPesamiento(TVRelacionesPrincipal, obPensamientos);
                break;
            }
            if (RBTemas.isSelected()) {
                crearTablaTema(TVRelacionesPrincipal);
                break;
            }
        }
        VisualFX.selecPrimero(TVRelacionesPrincipal);

    }

//    private void crearTablaSecundariaPensamientoConUbicacion(Titulo t) {
//        crearTabla(TVRelacionesSecundarias, getPensamientos(t), getPensamientosColumns());
//        addColumnaUbicacion(t);
//    }
//
//    private void addColumnaUbicacion(Titulo t) {
//        TablasFX.addColumn(TVRelacionesSecundarias, 0, TablasFX.<Pensamiento>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> getUbicacion(t, v)));
//    }
    private void crearTablaSecundariaDesdeTitulo(int indice, Titulo t) throws PersistentException {
        switch (indice) {
            case 0://Temas
                crearTabla(TVRelacionesSecundarias, getTemas(t), getTemaColumns());
                break;
            case 1://Pensamientos
                crearTabla(TVRelacionesSecundarias, getPensamientos(t), getPensamientosColumns());
                TablasFX.addColumn(TVRelacionesSecundarias, 0, TablasFX.<Pensamiento>getTreeTableColumn("Ubicacion", ANCHO_NOMBRE, v -> getUbicacion(t, v)));
                //crearTablaSecundariaPensamientoConUbicacion(t);
                break;
            case 2://Autores
                crearTabla(TVRelacionesSecundarias, getAutores(t), getAutoresColumns());
                break;
        }
    }

    private void crearTablaRelacionSecundaria() throws PersistentException {
        Object seleccionado = objetoTreeTableView.getValorSeleccionado(TVRelacionesPrincipal);
//        System.out.println("seleccionado=" + seleccionado);
        if (seleccionado != null) {
            int indice = getI(TGSecundarios);
            if (RBArticulos.isSelected()) {//(Articulo) seleccionado
                crearTablaSecundariaDesdeTitulo(indice, ((Articulo) seleccionado).getTitulo());
                return;
            }

            if (RBCartas.isSelected()) {
                crearTablaSecundariaDesdeTitulo(indice, ((Carta) seleccionado).getTitulo());
                return;
            }
            if (RBLibros.isSelected()) {
                crearTablaSecundariaDesdeTitulo(indice, ((Libro) seleccionado).getTitulo());
                return;
            }
            if (RBAutores.isSelected()) {
                Autor a = (Autor) seleccionado;
                switch (indice) {
                    case 0://Temas
                        crearTabla(TVRelacionesSecundarias, getTemas(a), getTemaColumns());
                        break;
                    case 1://Pensamientos
                        crearTabla(TVRelacionesSecundarias, getPensamientos(a), getPensamientosColumns());
                        break;
                    case 2://Libros
                        crearTabla(TVRelacionesSecundarias, getLibros(a), getLibrosColumns());
                        break;
                    case 3://Cartas
                        crearTabla(TVRelacionesSecundarias, getCartas(a), getCartasColumns());
                        break;
                    case 4://Articulos
                        crearTabla(TVRelacionesSecundarias, getArticulos(a), getArticulosColumns());
                        break;

                }
                return;
            }
            if (RBPensamientos.isSelected()) {
                try {
                    Pensamiento p = (Pensamiento) seleccionado;
                    switch (indice) {
                        case 0://Libros
                            crearTabla(TVRelacionesSecundarias, getLibros(p), getLibrosColumns());
                            TablasFX.addColumn(TVRelacionesSecundarias, 0, TablasFX.<Libro>getTreeTableColumn("Ubicacion", ANCHO_NOMBRE, v -> getUbicacion(v.getTitulo(), p)));
                            break;
                        case 1://Cartas
                            crearTabla(TVRelacionesSecundarias, getCartas(p), getCartasColumns());
                            TablasFX.addColumn(TVRelacionesSecundarias, 0, TablasFX.<Carta>getTreeTableColumn("Ubicacion", ANCHO_NOMBRE, v -> getUbicacion(v.getTitulo(), p)));
                            break;
                        case 2://Articulos
                            crearTabla(TVRelacionesSecundarias, getArticulos(p), getArticulosColumns());
                            TablasFX.addColumn(TVRelacionesSecundarias, 0, TablasFX.<Articulo>getTreeTableColumn("Ubicacion", ANCHO_NOMBRE, v -> getUbicacion(v.getTitulo(), p)));
                            break;
                        case 3://Autores
                            crearTabla(TVRelacionesSecundarias, getAutores(p), getAutoresColumns());
                            break;
                    }
                } catch (ClassCastException ex) {
                    ex.printStackTrace();
                    System.out.println("ignorar2");
                }
                return;
            }
            if (RBTemas.isSelected()) {
                Tema t = (Tema) seleccionado;
                switch (indice) {
                    case 0://Pensamientos
                        crearTabla(TVRelacionesSecundarias, t.pensamiento.toArray(), getPensamientosColumns());
                        break;
                    case 1://Libros
                        crearTabla(TVRelacionesSecundarias, getLibros(t), getLibrosColumns());
                        break;
                    case 2://Cartas
                        crearTabla(TVRelacionesSecundarias, getCartas(t), getCartasColumns());
                        break;
                    case 3://Articulos
                        crearTabla(TVRelacionesSecundarias, getArticulos(t), getArticulosColumns());
                        break;
                    case 4://Autores
                        crearTabla(TVRelacionesSecundarias, getAutores(t), getAutoresColumns());
                        break;
                }
                // return;
            }

        } else {
            crearTabla(TVRelacionesSecundarias, new Object[0]);
        }

    }

    private void actualizarRBSecundarios() {
        Utiles.FX.VisualFX.setVisible(false, RB4RelacionesSecundarias, RB5RelacionesSecundarias);
        if (RBArticulos.isSelected() || RBCartas.isSelected() || RBLibros.isSelected()) {
            copiarVisualRelacion(RBTemas, RBPensamientos, RBAutores);
            return;
        }
        if (RBAutores.isSelected()) {
            Utiles.FX.VisualFX.setVisible(true, RB4RelacionesSecundarias, RB5RelacionesSecundarias);
            copiarVisualRelacion(RBTemas, RBPensamientos, RBLibros, RBCartas, RBArticulos);
            return;
        }
        if (RBPensamientos.isSelected()) {
            Utiles.FX.VisualFX.setVisible(true, RB4RelacionesSecundarias);
            copiarVisualRelacion(RBLibros, RBCartas, RBArticulos, RBAutores);
            return;
        }
        if (RBTemas.isSelected()) {
            Utiles.FX.VisualFX.setVisible(true, RB4RelacionesSecundarias, RB5RelacionesSecundarias);
            copiarVisualRelacion(RBPensamientos, RBLibros, RBCartas, RBArticulos, RBAutores);
        }
    }

    private Node getGraphic(JFXRadioButton r) {
        switch (r.getText()) {
            case "Autores":
                return new MaterialDesignIconView(MaterialDesignIcon.LIBRARY);
            case "Pensamientos":
                return new EmojiOneView(EmojiOne.THOUGHT_BALLOON);
            case "Libros":
                return new EmojiOneView(EmojiOne.BLUE_BOOK);
            case "Articulos":
                return new FontAwesomeIconView(FontAwesomeIcon.NEWSPAPER_ALT);
            case "Cartas":
                return new MaterialIconView(MaterialIcon.MAIL);
            case "Temas":
                return new FontAwesomeIconView(FontAwesomeIcon.LIST_ALT);
        }
        return null;
    }

    private void copiarVisualRelacion(JFXRadioButton... R) {
        for (int i = 0; i < R.length; i++) {
            RBsSecundarios[i].setText(R[i].getText());
            RBsSecundarios[i].setGraphic(getGraphic(R[i]));
            //  Utiles.FX.VisualFX.copiarVisualDeAaB(R[i], RBsSecundarios[i]);
        }
    }

    private void actualizarAutores() throws PersistentException {
        actualizarObs(obAutores, AutorFactory.listAutorByQuery(null, null));
    }

    private void actualizarPensamientosRelacionados() throws PersistentException {
        if (haySeleccionado(LVTemas)) {
            probar.actualizarObs(obPensamientosSeleccionados, getSeleccionado(LVTemas).pensamiento);
        } else {
            obPensamientosSeleccionados.clear();
        }
    }

    private void actualizarTemas() throws PersistentException {
        Tema T[] = TemaFactory.listTemaByQuery(null, null);
        actualizarObs(obTemas, T);
        temas.setAll(T);
    }

    private void actualizarPensamiento() throws PersistentException {
        actualizarObs(obPensamientos, PensamientoFactory.listPensamientoByQuery(null, null));
    }

    private void actualizarLibros() throws PersistentException {
        actualizarObs(obLibros, LibroFactory.listLibroByQuery(null, null));
    }

    private void actualizarCartas() throws PersistentException {
        actualizarObs(obCartas, CartaFactory.listCartaByQuery(null, null));
    }

    private void actualizarArticulos() throws PersistentException {
        actualizarObs(obArticulos, ArticuloFactory.listArticuloByQuery(null, null));
    }

    public void actualizarBD() {
        Platform.runLater(() -> {
            try {
                Utiles.FX.VisualFX.activarComponentes(false, BBuscarAutores, BClearBusquedaAutores, TBuscarAutores, TVAutores,
                        BBuscarPensamientos, BClearBusquedaPensamientos, TBuscarPensamientos, TVPensamientos);
                actualizarPensamiento();
                actualizarAutores();
                actualizarCartas();
                actualizarArticulos();
                actualizarLibros();
                actualizarTemas();
                actualizarPensamientosRelacionados();
            } catch (Exception ex) {
                responerException(ex);
            }
            Utiles.FX.VisualFX.activarComponentes(true, BBuscarAutores, BClearBusquedaAutores, TBuscarAutores, TVAutores,
                    BBuscarPensamientos, BClearBusquedaPensamientos, TBuscarPensamientos, TVPensamientos);
            // Utiles.FX.VisualFX.activarComponentes(true, BBuscarPensamientos, BClearBusquedaPensamientos, TBuscarPensamientos, TVPensamientos);

        });
    }

    public void setVentana(Stage ventana) {
        this.ventana = ventana;
        Utiles.FX.VisualFX.addOnShowing(ventana, () -> actualizarEntornoDeUsuario());
    }

    public JFXTabPane getTab() {
        return Tab;
    }

}
