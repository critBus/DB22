/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.FX.TablasFX;
import static Utiles.FX.TablasFX.crearTabla;
import Utiles.FX.objetoTreeTableView;
import clases.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.orm.PersistentException;
import static visual.probar.*;
import static Utiles.FX.VisualFX.actualizarObs;
import static Utiles.FX.VisualFX.getI;
import Utiles.FX.VisualFX;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.scene.layout.StackPane;
import static Utiles.FX.VisualFX.setRbsBusqueda;
import static Utiles.FX.VisualFX.setTextBusqueda;
import static Utiles.FX.VisualFX.setPredicate;
import static Utiles.FX.VisualFX.getSeleccionado;
import com.jfoenix.controls.JFXNodesList;
import java.util.function.Consumer;
//import static Utiles.FX.VisualFX.setRbsBusqueda;

public class Ventana_CuentasController implements Initializable {
    
    private ObservableList<objetoTreeTableView> obUsuarios, obEstudiantes, obProfesores, obAdministrador;
    private ToggleGroup TG, TGBusqueda;
    private Stage ventana;
    private JFXRadioButton RBs[], RBsBusqueda[];
    private Administrador administradorActual;
    @FXML
    private StackPane Pstack;
    
    @FXML
    private JFXTreeTableView<objetoTreeTableView> TV;
    
    @FXML
    private JFXTextField TBuscar;
    
    @FXML
    private JFXButton BClearBusqueda;
    
    @FXML
    private JFXButton BBuscar;
    
    @FXML
    private JFXButton BEditar;
    
    @FXML
    private JFXButton BEliminar;
    
    @FXML
    private JFXButton BClear;
    
    @FXML
    private JFXButton BCrear;
    
    @FXML
    private JFXRadioButton RBTodas;
    
    @FXML
    private JFXRadioButton RBProfesores;
    
    @FXML
    private JFXRadioButton RBEstudiantes;
    
    @FXML
    private JFXRadioButton RBAdministrador;
    
    @FXML
    private JFXButton BCerrar;
    
    @FXML
    private JFXButton BMinimizar;
    
    @FXML
    private JFXButton BHome;
    
    @FXML
    private JFXButton BClearBD;
    
    @FXML
    private JFXButton BActualizarBD;
    
    @FXML
    private JFXButton BConfiguracionDeCuenta;
    
    @FXML
    private JFXNodesList NLAgregar;
    
    @FXML
    private JFXButton BCrearNL;
    
    @FXML
    private JFXButton BCrearEstudiante;
    
    @FXML
    private JFXButton BCrearProfesor;
    
    @FXML
    private JFXButton BCrearAdministrador;

    @FXML
    void apretoBCrearAdministrador(MouseEvent event) {
         dialogo_Agregar_AdministradorController.show();
    }
    
    @FXML
    void apretoBCrearEstudiante(MouseEvent event) {
          dialogo_Agregar_EstudianteController.show();
    }
    
    @FXML
    void apretoBCrearNL(MouseEvent event) {
        
    }
    
    @FXML
    void apretoBCrearProfesor(MouseEvent event) {
            dialogo_Agregar_ProfesorController.show();
    }

    @FXML
    void apretoBConfiguracionDeCuenta(MouseEvent event) {
        dialogo_Configuracion_CuentaController.show();
    }
    
    @FXML
    void apretoActualizarBD(MouseEvent event) {
        actualizarBD();
        crearTablas();
    }
    
    @FXML
    void apretoAgregar(MouseEvent event) {
        if (RBEstudiantes.isSelected()) {
            dialogo_Agregar_EstudianteController.show();
            return;
        }
        if (RBAdministrador.isSelected()) {
            dialogo_Agregar_AdministradorController.show();
            return;
        }
        dialogo_Agregar_ProfesorController.show();
    }
    
    @FXML
    void apretoBuscar(MouseEvent event) {
        
    }
    
    @FXML
    void apretoCerrar(ActionEvent event) {
        dialogo_CerrarCotroller.show();
    }
    
    @FXML
    void apretoClear(MouseEvent event) {//"Desea eliminar todos los Temas"
        try {
            
            dialogo_Aceptar_CancelarController.show(
                    () -> RBTodas.isSelected() ? DESEA_ELIMINAR_TODAS_LAS + "cuentas" : (RBAdministrador.isSelected() ? DESEA_ELIMINAR_TODOS_LOS + "administradores" : (RBEstudiantes.isSelected() ? DESEA_ELIMINAR_TODOS_LOS + "estudiantes" : (DESEA_ELIMINAR_TODOS_LOS + "profesores"))),
                    () -> {
                        try {
                            clearUsuarios();
                            actualizarBD();
                            crearTablas();
                        } catch (Exception ex) {
                            responerException(ex);
                        }
                    });
        } catch (Exception ex) {
            responerException(ex);
        }
    }
    
    @FXML
    void apretoClearBD(MouseEvent event) {
        try {
            
            dialogo_Aceptar_CancelarController.show(DESEA_ELIMINAR_TODAS_LAS + "cuentas",
                    () -> {
                        try {
                            eliminarUsuarioAll(administradorActual);
                            dialogo_solo_AceptarController.show("No se elimino al Administrador actual");
                            actualizarBD();
                            crearTablas();
                        } catch (Exception ex) {
                            responerException(ex);
                        }
                    });
        } catch (Exception ex) {
            responerException(ex);
        }
    }
    
    @FXML
    void apretoClearBusqueda(MouseEvent event) {
        TBuscar.setText("");
    }
    
    @FXML
    void apretoEditar(MouseEvent event) {
        int id = -1;
        if (RBTodas.isSelected()) {
            Usuario u = objetoTreeTableView.<Usuario>getValorSeleccionado(TV);
            id = u.getId();
            if (u.getEstudiante() != null) {
                dialogo_Agregar_EstudianteController.show(id);
                return;
            }
            if (u.getAdministrador() != null) {
                dialogo_Agregar_AdministradorController.show(id);
                return;
            }
            dialogo_Agregar_ProfesorController.show(id);
            return;
        }
        if (RBEstudiantes.isSelected()) {
            id = objetoTreeTableView.<Estudiante>getValorSeleccionado(TV).getUsuarioId();
            dialogo_Agregar_EstudianteController.show(id);
            return;
        }
        if (RBAdministrador.isSelected()) {
            id = objetoTreeTableView.<Administrador>getValorSeleccionado(TV).getUsuarioId();
            dialogo_Agregar_AdministradorController.show(id);
            return;
        }
        id = objetoTreeTableView.<Profesor>getValorSeleccionado(TV).getUsuarioId();
        dialogo_Agregar_ProfesorController.show(id);
    }
    
    @FXML
    void apretoEliminar(MouseEvent event) {
        try {
            
            dialogo_Aceptar_CancelarController.show(
                    () -> RBTodas.isSelected() ? DESEA_ELIMINAR_ESTE + "usuario" : (RBAdministrador.isSelected() ? DESEA_ELIMINAR_ESTE + "administrador" : (RBEstudiantes.isSelected() ? DESEA_ELIMINAR_ESTE + "estudiante" : (DESEA_ELIMINAR_TODOS_LOS + "profesor"))),
                    () -> {
                        try {
                            eliminarUsuarioSeleccionado();
                            actualizarBD();
                            crearTablas();
                        } catch (Exception ex) {
                            responerException(ex);
                        }
                    });
        } catch (Exception ex) {
            responerException(ex);
        }
        
    }
    
    @FXML
    void apretoHome(MouseEvent event) {
        Platform.runLater(() -> {
            stage_Ventana_Cuentas.hide();
            ventana_PrincipalController.actualizarBD();
            stage_Ventana_Principal.show();
        });
    }
    
    @FXML
    void apretoMinimizar(ActionEvent event) {
        ventana.setIconified(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniRBs();
        inicializarObs();
        iniTGs();
        actualizarBD();
        crearTablas();
        iniSeguridad();
        Utiles.FX.VisualFX.addOnClosed(() -> {
            actualizarBD();
        }, getVentanasAgregar());
        VisualFX.addOnSelected(TG, v -> crearTablas());
    }
    
    private void setRbsBusqueda(int lengh) {
        VisualFX.setRbsBusqueda(lengh, BBuscar, RBsBusqueda, TGBusqueda);
        VisualFX.selecPrimero(TGBusqueda);
    }
    
    private String getBusqueda(Object v) {
        Object seleccionado = objetoTreeTableView.getValorSeleccionado(TV);
        String selecRBBusquedaSecundaria = VisualFX.getText(TGBusqueda);
        Usuario u = v instanceof Estudiante ? ((Estudiante) v).getUsuario() : (v instanceof Profesor ? ((Profesor) v).getUsuario() : (v instanceof Administrador ? ((Administrador) v).getUsuario() : ((Usuario) v)));
//        if (RBTodas.isSelected()) {
//            System.out.println("selecRBBusquedaSecundaria="+selecRBBusquedaSecundaria);
        switch (selecRBBusquedaSecundaria) {
            case NOMBRE:
                return u.getNombre();
            case CUENTA:
//                    System.out.println("u.getNombreDeCuenta()="+u.getNombreDeCuenta());
                return u.getNombreDeCuenta();
            case PERMISOS:
                return u.getPermisos();
            case CARGO:
                return ((Administrador) v).getCargo();
            case ESPECIALIZACION:
                return ((Profesor) v).getEspecializacion();
            case IDENTIFICADOR:
                return ((Estudiante) v).getIdentificador() + "";
            case CURSO:
                return ((Estudiante) v).getCurso() + "";
            case CARRERA:
                return ((Estudiante) v).getCarrera();
        }
//        }

        return "";
    }
    
    private void actualizarRBsBusqueda() {
        if (RBTodas.isSelected()) {
            VisualFX.setText(RBsBusqueda, getTextoRBUsuario());
            setRbsBusqueda(3);
            return;
        }
        if (RBAdministrador.isSelected()) {
            VisualFX.setText(RBsBusqueda, getTextoRBUsuario(), CARGO);
            setRbsBusqueda(4);
            return;
        }
        if (RBProfesores.isSelected()) {
            VisualFX.setText(RBsBusqueda, getTextoRBUsuario(), ESPECIALIZACION);
            setRbsBusqueda(4);
            return;
        }
        VisualFX.setText(RBsBusqueda, getTextoRBUsuario(), CURSO, CARRERA, IDENTIFICADOR);
        setRbsBusqueda(6);
    }
    
    private String[] getTextoRBUsuario() {
        return new String[]{NOMBRE, CUENTA, PERMISOS};
    }
    
    public void iniRBs() {
        RBs = new JFXRadioButton[]{RBAdministrador, RBEstudiantes, RBProfesores, RBTodas};
        RBsBusqueda = new JFXRadioButton[]{new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton(), new JFXRadioButton()};
    }
    
    private void eliminarUsuarioSeleccionado() throws PersistentException {
        if (RBTodas.isSelected()) {
            Usuario u = objetoTreeTableView.<Usuario>getValorSeleccionado(TV);
            if (u.getAdministrador() != null && u.getId() == administradorActual.getUsuarioId()) {
                dialogo_solo_AceptarController.show("No se puede elimino al Administrador\nactual");
            } else {
                eliminarUsuario(u);
            }
            return;
        }
        if (RBAdministrador.isSelected()) {
            Usuario u = objetoTreeTableView.<Administrador>getValorSeleccionado(TV).getUsuario();
            if (u.getId() == administradorActual.getUsuarioId()) {
                dialogo_solo_AceptarController.show("No se puede elimino al Administrador\nactual");
            } else {
                eliminarUsuario(u);
            }
            return;
        }
        if (RBEstudiantes.isSelected()) {
            eliminarUsuario(objetoTreeTableView.<Estudiante>getValorSeleccionado(TV).getUsuario());
            return;
        }
        eliminarUsuario(objetoTreeTableView.<Profesor>getValorSeleccionado(TV).getUsuario());
    }
    
    private void clearUsuarios() throws PersistentException {
        if (RBTodas.isSelected()) {
            eliminarUsuarioAll(administradorActual);
            dialogo_solo_AceptarController.show("No se elimino al Administrador actual");
            return;
        }
        if (RBAdministrador.isSelected()) {
            eliminarAdministradorAll(administradorActual);
            dialogo_solo_AceptarController.show("No se elimino al Administrador actual");
            return;
        }
        if (RBEstudiantes.isSelected()) {
            eliminarEstudianteAll();
            return;
        }
        eliminarProfesorAll();
    }

//    private JFXDialog[] getDialogosAgregar() {
////return new JFXDialog[]{dialogo_Agregar_EstudianteController.getDialog(), dialogo_Agregar_ProfesorController.getDialog()};
//        return new JFXDialog[]{dialogo_Agregar_EstudianteController.getDialog(), dialogo_Agregar_AdministradorController.getDialog(), dialogo_Agregar_ProfesorController.getDialog()};
//    }
    private Stage[] getVentanasAgregar() {
        return new Stage[]{dialogo_Agregar_EstudianteController.getVentana(), dialogo_Agregar_AdministradorController.getVentana(), dialogo_Agregar_ProfesorController.getVentana()};
    }

    private void iniSeguridad() {
//        System.out.println("TBuscar=" + TBuscar);
        setPredicate(TV, TBuscar, TGBusqueda, BBuscar, v -> getBusqueda(v), TG, () -> actualizarRBsBusqueda());
        //Utiles.FX.TablasFX.setPredicate(TV, TBuscar, v -> v instanceof Usuario ? ((Usuario) v).getNombre() : (v instanceof Estudiante ? ((Estudiante) v).getUsuario().getNombre() : (v instanceof Profesor ? ((Profesor) v).getUsuario().getNombre() : ((Administrador) v).getUsuario().getNombre())));
        Utiles.FX.VisualFX.relacionarComponentes(TV, new ObservableList[]{obAdministrador, obEstudiantes, obProfesores, obUsuarios}, () -> RBTodas.isSelected() ? obUsuarios : (RBAdministrador.isSelected() ? obAdministrador : (RBProfesores.isSelected() ? obProfesores : (obEstudiantes))), BClear, BEditar, BEliminar);
        Consumer c = v -> {
            boolean selTodas = RBTodas.isSelected();
            NLAgregar.setVisible(selTodas);
            BCrear.setVisible(!selTodas);
        };
        VisualFX.addOnSelected(TG, c);
        c.accept(null);
      //  NLAgregar.setRotate(180);
       Utiles.FX.VisualFX.setOcultarJFXNodesList(NLAgregar);
    }
    
    private void crearTablaUsuarios(JFXTreeTableView<objetoTreeTableView> TV) {
        crearTabla(TV, obUsuarios, getUsuariosColumns());
    }
    
    private void crearTablaEstudiante(JFXTreeTableView<objetoTreeTableView> TV) {
        crearTabla(TV, obEstudiantes, getEstudianteColumns());
    }
    
    private void crearTablaAdministrador(JFXTreeTableView<objetoTreeTableView> TV) {
        crearTabla(TV, obAdministrador, getAdministradorColumns());
    }
    
    private void crearTablaProfesor(JFXTreeTableView<objetoTreeTableView> TV) {
        crearTabla(TV, obProfesores, getProfesorColumns());
    }
    
    private JFXTreeTableColumn[] getUsuariosColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.<Usuario>getTreeTableColumn("Nombre", ANCHO_NOMBRE, Usuario::getNombre),
            TablasFX.<Usuario>getTreeTableColumn("Cuenta", ANCHO_MEDIO, Usuario::getNombreDeCuenta),
            TablasFX.<Usuario>getTreeTableColumn("Tipo", NORMAL, v -> getTipoDeUsuario(v)),
            TablasFX.<Usuario>getTreeTableColumnList("Permisos", ANCHO_NOMBRE, v -> getListaPermisos(v))
        
        };
    }
    
    private JFXTreeTableColumn[] getEstudianteColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.<Estudiante>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getUsuario().getNombre()),
            TablasFX.<Estudiante>getTreeTableColumn("Cuenta", ANCHO_MEDIO, v -> v.getUsuario().getNombreDeCuenta()),
            TablasFX.<Estudiante>getTreeTableColumnList("Permisos", ANCHO_NOMBRE, v -> getListaPermisos(v.getUsuario())),
            TablasFX.<Estudiante>getTreeTableColumn("Carrera", ANCHO_MEDIO, Estudiante::getCarrera),
            TablasFX.<Estudiante>getTreeTableColumn("Curso", NORMAL, v -> v.getCurso() + ""),
            TablasFX.<Estudiante>getTreeTableColumn("Identificador", NORMAL, v -> v.getIdentificador() + "")
        };
    }
    
    private JFXTreeTableColumn[] getProfesorColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.<Profesor>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getUsuario().getNombre()),
            TablasFX.<Profesor>getTreeTableColumn("Cuenta", ANCHO_MEDIO, v -> v.getUsuario().getNombreDeCuenta()),
            TablasFX.<Profesor>getTreeTableColumnList("Permisos", ANCHO_NOMBRE, v -> getListaPermisos(v.getUsuario())),
            TablasFX.<Profesor>getTreeTableColumn("Especializacion", ANCHO_MEDIO, Profesor::getEspecializacion)};
    }
    
    private JFXTreeTableColumn[] getAdministradorColumns() {
        return new JFXTreeTableColumn[]{
            TablasFX.<Administrador>getTreeTableColumn("Nombre", ANCHO_NOMBRE, v -> v.getUsuario().getNombre()),
            TablasFX.<Administrador>getTreeTableColumn("Cuenta", ANCHO_MEDIO, v -> v.getUsuario().getNombreDeCuenta()),
            TablasFX.<Administrador>getTreeTableColumnList("Permisos", ANCHO_NOMBRE, v -> getListaPermisos(v.getUsuario())),
            TablasFX.<Administrador>getTreeTableColumn("Cargo", ANCHO_MEDIO, Administrador::getCargo)};
    }
    
    private void crearTablaPrincipal() {
        while (true) {
            if (RBTodas.isSelected()) {
                crearTablaUsuarios(TV);
                break;
            }
            if (RBAdministrador.isSelected()) {
                crearTablaAdministrador(TV);
                break;
            }
            if (RBEstudiantes.isSelected()) {
                crearTablaEstudiante(TV);
                break;
            }
            if (RBProfesores.isSelected()) {
                crearTablaProfesor(TV);
                break;
            }
            
        }
        VisualFX.selecPrimero(TV);
        
    }
    
    public void crearTablas() {
        Platform.runLater(() -> {
            crearTablaPrincipal();
        });
        
    }
    
    private void actualizarAdministrador() throws PersistentException {
        actualizarObs(obAdministrador, getAdministradorAll());
    }
    
    private void actualizarUsuarios() throws PersistentException {
        actualizarObs(obUsuarios, getUsuarioAll());
    }
    
    private void actualizarEstudiantes() throws PersistentException {
        actualizarObs(obEstudiantes, getEstudianteAll());
    }
    
    private void actualizarProfesores() throws PersistentException {
        actualizarObs(obProfesores, getProfesorAll());
    }
    
    private void actualizarBD() {
        Platform.runLater(() -> {
            try {
                Utiles.FX.VisualFX.activarComponentes(false, BBuscar, BClearBusqueda, TBuscar, TV);
                actualizarAdministrador();
                actualizarEstudiantes();
                actualizarProfesores();
                actualizarUsuarios();
            } catch (Exception ex) {
                responerException(ex);
            }
            Utiles.FX.VisualFX.activarComponentes(true, BBuscar, BClearBusqueda, TBuscar, TV);
        });
    }
    
    private void iniTGs() {
        TG = new ToggleGroup();
        TG.getToggles().addAll(RBs);
        TGBusqueda = new ToggleGroup();
        TGBusqueda.getToggles().addAll(RBsBusqueda);
        VisualFX.selecPrimero(TGBusqueda);
    }
    
    private void inicializarObs() {
        obAdministrador = FXCollections.observableArrayList();
        obUsuarios = FXCollections.observableArrayList();
        obEstudiantes = FXCollections.observableArrayList();
        obProfesores = FXCollections.observableArrayList();
    }
    
    public Administrador getAdministradorActual() {
        return administradorActual;
    }
    
    public void setAdministradorActual(Administrador administradorActual) {
        this.administradorActual = administradorActual;
    }
    
    public Stage getVentana() {
        return ventana;
    }
    
    public void setVentana(Stage ventana) {
        this.ventana = ventana;
    }
    
}
