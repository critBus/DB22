/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.FX.Validadores.Validador;
import Utiles.FX.objetoTreeTableView;
import clases.Tema;
import clases.TemaFactory;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.effects.JFXDepthManager;
import de.jensd.fx.glyphs.emojione.EmojiOne;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.orm.PersistentException;

import clases.*;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.stage.StageStyle;
import org.orm.util.ORMSet;

/**
 *
 * @author Rene
 */
public class probar extends Application {

    public static final String EN_LA_BIBLIOTECA = "En la biblioteca", TEXT_FIEL_CLASE_CSS = "JFXtextFielTextoBlanco",
            REQUISITOS_CONTRASEÑA = "Minimo 8 caracteres", USUARIO_INCORRECTO = "Cuenta o Contraseña incorrecta",
            BUSCAR_POR = "Buscar Por";
    public static final String DESEA_ELIMINAR = "Desea eliminar ", TODOS_LOS = "todos los ", TODAS_LAS = "todas las ",
            DESEA_ELIMINAR_TODOS_LOS = DESEA_ELIMINAR + TODOS_LOS, DESEA_ELIMINAR_TODAS_LAS = DESEA_ELIMINAR + TODAS_LAS,
            DESEA_ELIMINAR_ESTE = DESEA_ELIMINAR + "este ";
    public static final String NOMBRE = "Nombre", FECHA = "Fecha", AUTOR = "Autor", DISPONIBILIDAD = "Disponibilidad",
            NACIMIENTO = "Nacimiento", MUERTE = "Muerte", TITULOS = "Titulos", PALABRAS_CLAVE = "Palabras Clave", CONTENIDO = "Contenido",
            EDICION = "Edicion", PUBLICACION = "Publicacion", VOLUMEN = "Volumen", DESTINATARIO = "Destinatario",
            UBICACION = "Ubicacion", PENSAMIENTO = "Pensamiento", TEMA = "Tema", CUENTA = "Cuenta", PERMISOS = "Permisos", CARGO = "Cargo", ESPECIALIZACION = "Especializacion", CURSO = "Curso", CARRERA = "Carrera", IDENTIFICADOR = "Identificador";

    public static final int ANCHO_NOMBRE = 350, ANCHO_FECHA = 100, NORMAL = 100, LARGO = 400, ANCHO_MEDIO = 200;
    public static int prueba = 0;
    public static Dialogo_CerrarCotroller dialogo_CerrarCotroller;
//    public static Dialogo_SobrescribirCotroller dialogo_SobrescribirCotroller;
    public static Dialogo_Agregar_TemaController2 dialogo_Agregar_TemaController;
    public static Dialogo_Agregar_AutorController dialogo_Agregar_AutorController;
    public static Dialogo_Agregar_LibroController dialogo_Agregar_LibroController;
    public static Dialogo_Agregar_ArticuloController dialogo_Agregar_ArticuloController;
    public static Dialogo_Agregar_CartaController dialogo_Agregar_CartaController;
    public static Dialogo_Agregar_PensamientoController dialogo_Agregar_PensamientoController;
    public static Dialogo_Agregar_EstudianteController dialogo_Agregar_EstudianteController;
    public static Dialogo_Agregar_AdministradorController dialogo_Agregar_AdministradorController;
    public static Dialogo_Agregar_ProfesorController dialogo_Agregar_ProfesorController;
    public static Dialogo_Aceptar_CancelarController dialogo_Aceptar_CancelarController;
    public static Dialogo_solo_AceptarController dialogo_solo_AceptarController;
    public static Dialogo_Configuracion_CuentaController dialogo_Configuracion_CuentaController;
    public static Ventana_PrincipalController ventana_PrincipalController;
//    public static Ventana_CargandoController ventana_CargandoController;
    public static Ventana_CuentasController ventana_CuentasController;
    public static Stage stage_Ventana_Principal;
    public static Stage stage_Ventana_Login;
    public static Stage stage_Cargando;
    public static Stage stage_Ventana_Cuentas;

    public static Usuario usuarioActual;
//    public static JFXDialog dialog;

    @Override
    public void start(Stage stage) throws Exception {
        int asd = 0;
        System.out.println("aa");
        stage_Ventana_Login = stage;
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent p = fx.load();
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx2 = new FXMLLoader(getClass().getResource("Dialogo_Cerrar.fxml"));
        Parent p2 = fx2.load();
        dialogo_CerrarCotroller = fx2.<Dialogo_CerrarCotroller>getController();
        dialogo_CerrarCotroller.iniStage(p2);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx3 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Tema.fxml"));
        Parent p3 = fx3.load();
        dialogo_Agregar_TemaController = fx3.<Dialogo_Agregar_TemaController2>getController();
        dialogo_Agregar_TemaController.iniStage(p3);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx4 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Autor.fxml"));
        Parent p4 = fx4.load();
        dialogo_Agregar_AutorController = fx4.<Dialogo_Agregar_AutorController>getController();
        dialogo_Agregar_AutorController.iniStage(p4);
        System.out.println((char) ('a' + asd++));
//        FXMLLoader fx5 = new FXMLLoader(getClass().getResource("Dialogo_Sobrescribir.fxml"));
//        Parent p5 = fx5.load();
//        dialogo_SobrescribirCotroller = fx5.<Dialogo_SobrescribirCotroller>getController();
//        System.out.println((char) ('a' + asd++));

        FXMLLoader fx7 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Libro.fxml"));
        Parent p7 = fx7.load();
        dialogo_Agregar_LibroController = fx7.<Dialogo_Agregar_LibroController>getController();
        dialogo_Agregar_LibroController.iniStage(p7);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx8 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Articulo.fxml"));
        Parent p8 = fx8.load();
        dialogo_Agregar_ArticuloController = fx8.<Dialogo_Agregar_ArticuloController>getController();
        dialogo_Agregar_ArticuloController.iniStage(p8);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx9 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Carta.fxml"));
        Parent p9 = fx9.load();
        dialogo_Agregar_CartaController = fx9.<Dialogo_Agregar_CartaController>getController();
        dialogo_Agregar_CartaController.iniStage(p9);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx10 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Pensamiento.fxml"));
        Parent p10 = fx10.load();
        dialogo_Agregar_PensamientoController = fx10.<Dialogo_Agregar_PensamientoController>getController();
        dialogo_Agregar_PensamientoController.iniStage(p10);
        System.out.println((char) ('a' + asd++));

        FXMLLoader fx6 = new FXMLLoader(getClass().getResource("Ventana_Principal.fxml"));
        Parent p6 = fx6.load();
        stage_Ventana_Principal = new Stage(StageStyle.TRANSPARENT);
        Scene s2 = new Scene(p6);
//                         Scene s=new Scene(new JFXRippler(p));
        stage_Ventana_Principal.setScene(s2);
        Utiles.FX.VisualFX.sinBordes(s2, stage_Ventana_Principal);
        ventana_PrincipalController = fx6.<Ventana_PrincipalController>getController();
        ventana_PrincipalController.setVentana(stage_Ventana_Principal);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx11 = new FXMLLoader(getClass().getResource("Dialogo_Aceptar_Cancelar.fxml"));
        Parent p11 = fx11.load();
        dialogo_Aceptar_CancelarController = fx11.<Dialogo_Aceptar_CancelarController>getController();
        dialogo_Aceptar_CancelarController.iniStage(p11);
        System.out.println((char) ('a' + asd++));
//        FXMLLoader fx12 = new FXMLLoader(getClass().getResource("Ventana_Cargando.fxml"));
//        Parent p12 = fx12.load();
//        ventana_CargandoController = fx12.<Ventana_CargandoController>getController();
//        stage_Cargando = new Stage(StageStyle.TRANSPARENT);
//        Scene s3 = new Scene(p12);
//        stage_Cargando.setScene(s3);
//        Utiles.FX.VisualFX.trans(s3, stage_Cargando);
//        System.out.println((char) ('a' + asd++));
        FXMLLoader fx13 = new FXMLLoader(getClass().getResource("Dialogo_solo_Aceptar.fxml"));
        Parent p13 = fx13.load();
        dialogo_solo_AceptarController = fx13.<Dialogo_solo_AceptarController>getController();
        dialogo_solo_AceptarController.iniStage(p13);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx14 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Estudiante.fxml"));
        Parent p14 = fx14.load();
        dialogo_Agregar_EstudianteController = fx14.<Dialogo_Agregar_EstudianteController>getController();
        dialogo_Agregar_EstudianteController.iniStage(p14);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx16 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Administrador.fxml"));
        Parent p16 = fx16.load();
        dialogo_Agregar_AdministradorController = fx16.<Dialogo_Agregar_AdministradorController>getController();
        dialogo_Agregar_AdministradorController.iniStage(p16);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx17 = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Profesor.fxml"));
        Parent p17 = fx17.load();
        dialogo_Agregar_ProfesorController = fx17.<Dialogo_Agregar_ProfesorController>getController();
        dialogo_Agregar_ProfesorController.iniStage(p17);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx18 = new FXMLLoader(getClass().getResource("Dialogo_Configuracion_Cuenta.fxml"));
        Parent p18 = fx18.load();
        dialogo_Configuracion_CuentaController = fx18.<Dialogo_Configuracion_CuentaController>getController();
        dialogo_Configuracion_CuentaController.iniStage(p18);
        System.out.println((char) ('a' + asd++));
        FXMLLoader fx15 = new FXMLLoader(getClass().getResource("Ventana_Cuentas.fxml"));
        Parent p15 = fx15.load();
        stage_Ventana_Cuentas = new Stage(StageStyle.TRANSPARENT);
        Scene s4 = new Scene(p15);
        stage_Ventana_Cuentas.setScene(s4);
        Utiles.FX.VisualFX.sinBordes(s4, stage_Ventana_Cuentas);
        ventana_CuentasController = fx15.<Ventana_CuentasController>getController();
        ventana_CuentasController.setVentana(stage_Ventana_Cuentas);
        System.out.println((char) ('a' + asd++));

        if (getAdministradorAll().length == 0) {
//            Stage st = new Stage();

            FXMLLoader fxAdministrador = new FXMLLoader(getClass().getResource("Dialogo_Agregar_Administrador.fxml"));
            Parent pAdministrador = fxAdministrador.load();
            Dialogo_Agregar_AdministradorController controlador = fxAdministrador.<Dialogo_Agregar_AdministradorController>getController();
            controlador.iniStage(pAdministrador);
//            controlador.getVentana().setOnCloseRequest(v -> System.exit(0));

//            controlador.ini();
            Utiles.FX.VisualFX.addOnAction(controlador.getBAtras(), v -> System.exit(0));
//            Utiles.FX.VisualFX.addOnAction(controlador.getBAceptar(), v -> controlador.close());
//            controlador.getBAtras().setVisible(false);
//            Scene s = new Scene(pAdministrador);
//            st.setTitle("Crear Administrador");
//            st.setResizable(false);
//            st.setScene(s);
//            st.showAndWait();

        }

        Scene s = new Scene(p);
        Utiles.FX.VisualFX.sinBordes(s, stage);
        stage.setScene(s);
        stage.show();

//        stage.setOnShowing(value);
//        stage.isShowing()
//        FXMLLoader fx14 = new FXMLLoader(getClass().getResource("uno.fxml"));
//        Parent p14 = fx14.load();
//         Scene s5 = new Scene(p14);
//         Stage ss=new Stage();
//         ss.setScene(s5);
//         ss.show();
        //JFXTextArea
//        dialog = new JFXDialog();
//        dialog.setTransitionType(JFXDialog.DialogTransition.LEFT);
//        JFXDepthManager.setDepth(dialog, 6);
    }

    public static void main(String[] args) {
//        try {
        launch(args);
//            // Tema[] T = TemaFactory.listTemaByQuery(null, null);
////            Autor a=AutorFactory.createAutor();
////            a.setNombre("abc");
////            a.setApellidos("ccd");
////            a.save();
//           // Autor A[]=AutorFactory.listAutorByQuery(null, null);
//        } catch (PersistentException ex) {
//            Logger.getLogger(probar.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static void actualizarObs(final ObservableList<objetoTreeTableView> ob, ORMSet orm) {
        ob.clear();
        orm.getCollection().iterator().forEachRemaining(v -> ob.add(new objetoTreeTableView(v)));
    }

    public static void clearBD() throws PersistentException {
        System.out.println("comenzo e eliminar todos los Titulos");
        eliminarTituloAll();
        System.out.println("elimino todos los titulos");
        System.out.println("comenzo e eliminar todos los Autores");
        eliminarAutorAll();
        System.out.println("elimino todos los Autores");
        System.out.println("comenzo e eliminar todos los temas");
        eliminarTemaAll();
        System.out.println("elimino todos los temas");
    }

    public static Tema getTema(String nombre) {
        try {
            return TemaFactory.loadTemaByQuery(" nombre='" + nombre + "'" , null);
        } catch (PersistentException ex) {
            responerException(ex);
            return null;
        }
    }

    public static String getPensamientosString(Tema t) {
        Pensamiento[] P = getPensamientos(t);
        String res = "";
        for (int i = 0; i < P.length; i++) {
            res += "\n" + P[i].getNombre();
        }
        return res;
    }

    public static Pensamiento[] getPensamientos(Tema t) {
        return t.pensamiento.toArray();
    }

    public static String getAutoresString(Titulo p) {
        Autor A[] = getAutores(p);
        String res = "";
        for (int i = 0; i < A.length; i++) {
            res += "\n" + A[i].getNombre();
        }
        return res;
    }

    public static String getDisponibilidadString(Titulo p) {
        Disponibilidad A[] = getDisponibilidad(p);
        String res = "";
        for (int i = 0; i < A.length; i++) {
            res += "\n" + A[i].getUbicacion();
        }
        return res;
    }

    public static Disponibilidad[] getDisponibilidad(Titulo t) {
        return t.disponibilidad.toArray();
    }

    public static Titulo[] getTitulos(Autor a) {
        return a.titulo.toArray();
    }

    public static String getTitulosString(Autor a) {
        Titulo T[] = getTitulos(a);
        String res = "";
        for (int i = 0; i < T.length; i++) {
            res += "\n" + T[i].getNombre();
        }
        return res;
    }

    public static String getTitulosString(Titulo p) {
//        PT pt[] = getPensamiento_TituloAll(p);
//        String res = "";
//        for (int i = 0; i < pt.length; i++) {
//            res += "\n" + pt[i].getTitulo().getNombre();
//        }
        return getTitulosString(getPensamiento_TituloAll(p));
    }

    public static String getTitulosString(Pensamiento p) {
//        PT pt[] = getPensamiento_TituloAll(p);
//        String res = "";
//        for (int i = 0; i < pt.length; i++) {
//            res += "\n" + pt[i].getTitulo().getNombre();
//        }
        return getTitulosString(getPensamiento_TituloAll(p));
    }

    public static String getTitulosString(PT pt[]) {
        String res = "";
        for (int i = 0; i < pt.length; i++) {
            res += "\n" + pt[i].getTitulo().getNombre();
        }
        return res;
    }

    public static Predicate esValidaDireccionWeb(JFXTextField t, Predicate p) {
        return v -> {
            if (!p.test(v)) {
//                System.out.println("falso uno");
                return false;
            }
            if (!Utiles.MetodosUtiles.MetodosUtiles.esDireccionWeb(t.getText())) {
//                System.out.println("false dos");
                ((Validador) v).setMessage("Direccion Incorrecta");
                return false;
            }
//            System.out.println("true");
            return true;
        };
    }

    public static boolean contraseñaValida(JFXPasswordField p) {
        return p.getText().trim().length() >= 8;
    }

    public static void eliminarEstudianteAll() throws PersistentException {
        Estudiante A[] = getEstudianteAll();
        for (int i = 0; i < A.length; i++) {
            eliminarUsuario(A[i].getUsuario());
        }
    }

    public static void eliminarProfesorAll() throws PersistentException {
        Profesor A[] = getProfesorAll();
        for (int i = 0; i < A.length; i++) {
            eliminarUsuario(A[i].getUsuario());
        }
    }

    public static void eliminarAdministradorAll(Administrador a) throws PersistentException {
        Administrador A[] = getAdministradorAll();
        for (int i = 0; i < A.length; i++) {
            if (A[i].getUsuarioId() != a.getUsuarioId()) {
                eliminarUsuario(A[i].getUsuario());
            }
        }
    }

    public static void eliminarUsuario(Usuario a) throws PersistentException {
        try {
            eliminarSubbclaseDeUsuario(a);
            System.out.println("elimino subclase usuario");
            //a.deleteAndDissociate();
            //System.out.println("lo logro");
        } catch (org.hibernate.StaleStateException ex) {
            System.out.println("ignorar ");
//            responerException(ex);
        } catch (Exception ex) {

            Utiles.MetodosUtiles.MetodosUtiles.cls();
            System.out.println("ex=" + ex.getClass().getSimpleName());
            System.out.println("ignorar 5");
//            responerException(ex);
        }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
    }

    public static void eliminarUsuarioAll(Administrador a) throws PersistentException {
        eliminarAdministradorAll(a);
        eliminarProfesorAll();
        eliminarEstudianteAll();
    }

    private static void eliminarSubbclaseDeUsuario(Usuario a) throws PersistentException {
        if (a.getAdministrador() != null) {
            a.getAdministrador().deleteAndDissociate();
            return;
        }
        if (a.getEstudiante() != null) {
            a.getEstudiante().deleteAndDissociate();
            return;
        }
        a.getProfesor().deleteAndDissociate();
    }

    public static Estudiante getEstudiante(int id) {
        try {
            return EstudianteFactory.loadEstudianteByQuery(" usuarioid='" + id + "'", null);
        } catch (PersistentException ex) {
            responerException(ex);
            return null;
        }

    }

    public static Usuario getUsuario(String nombreCuenta, String contraseña) {
        try {
            return UsuarioFactory.loadUsuarioByQuery(" nombredecuenta='" + nombreCuenta + "' AND contrasena='" + contraseña + "'", null);
        } catch (PersistentException ex) {
            responerException(ex);
            return null;
        }
    }

    public static Usuario getUsuario(int id) {
        try {
            return UsuarioFactory.loadUsuarioByQuery(" id='" + id + "'", null);
        } catch (PersistentException ex) {
            responerException(ex);
            return null;
        }

    }

    public static Profesor getProfesor(int id) {
        try {
            return ProfesorFactory.loadProfesorByQuery(" usuarioid='" + id + "'", null);
        } catch (PersistentException ex) {
            responerException(ex);
            return null;
        }

    }

    public static Administrador getAdministrador(int id) {
        try {
            return AdministradorFactory.loadAdministradorByQuery(" usuarioid='" + id + "'", null);
        } catch (PersistentException ex) {
            responerException(ex);
            return null;
        }

    }

    public static Autor getAutor(String nombre) {
        try {
            return AutorFactory.loadAutorByQuery(" nombre='" + nombre + "'", null);
        } catch (PersistentException ex) {
            responerException(ex);
            return null;
        }

    }

    public static Titulo getTitulo(String nombre) {
        try {
            return TituloFactory.loadTituloByQuery(" nombre='" + nombre + "'", null);
        } catch (PersistentException ex) {
            responerException(ex);
            return null;
        }

    }

    public static Estudiante createEstudiante() {
        return EstudianteFactory.createEstudiante();
    }

    public static String getTipoDeUsuario(Usuario u) {
        return u.getAdministrador() != null ? "Administrador" : (u.getEstudiante() != null ? "Estudiante" : "Profesor");
    }

    public static Usuario createUsuario(int idActual, Object subclase, JFXTextField TNombre, JFXTextField TCuenta, JFXPasswordField TP) {
        Usuario u = idActual == -1 || (u = getUsuario(idActual)) == null ? createUsuario() : u;
        u.setNombre(TNombre.getText().trim());
        u.setContrasena(TP.getText().trim());
        u.setNombreDeCuenta(TCuenta.getText().trim());
        if (subclase instanceof Estudiante) {
            u.setEstudiante((Estudiante) subclase);
            u.setPermisos(Permisos.getPermisosEstudiante());
            saveUsuario(u);
            ((Estudiante) subclase).setUsuario(u);
            return u;
        }
        if (subclase instanceof Administrador) {
            u.setAdministrador((Administrador) subclase);
            u.setPermisos(Permisos.getPermisosAdministrador());
            saveUsuario(u);
            ((Administrador) subclase).setUsuario(u);
            return u;
        }
        u.setProfesor((Profesor) subclase);
        u.setPermisos(Permisos.getPermisosProfesor());
        saveUsuario(u);
        ((Profesor) subclase).setUsuario(u);
        return u;
    }

    private static void saveUsuario(Usuario u) {
        try {
            u.save();
        } catch (Exception ex) {
            System.out.println("ignorar cuatro");
            ex.printStackTrace();
        }
    }

    public static Usuario createUsuario() {
        return UsuarioFactory.createUsuario();
    }

    public static Administrador createAdministrador() {
        return AdministradorFactory.createAdministrador();
    }

    public static Profesor createProfesor() {
        return ProfesorFactory.createProfesor();
    }

    public static Usuario[] getUsuarioAll() {
        try {
            return UsuarioFactory.listUsuarioByQuery(null, null);
        } catch (PersistentException ex) {
            responerException(ex);
        }
        return null;
    }

    public static Administrador[] getAdministradorAll() {
        try {
            return AdministradorFactory.listAdministradorByQuery(null, null);
        } catch (PersistentException ex) {
            responerException(ex);
        }
        return null;
    }

    public static Profesor[] getProfesorAll() {
        try {
            return ProfesorFactory.listProfesorByQuery(null, null);
        } catch (PersistentException ex) {
            responerException(ex);
        }
        return null;
    }

    public static Estudiante[] getEstudianteAll() {
        try {
            return EstudianteFactory.listEstudianteByQuery(null, null);
        } catch (PersistentException ex) {
            responerException(ex);
        }
        return null;
    }

    public static Pensamiento[] getPensamientoAll() {
        try {
            return PensamientoFactory.listPensamientoByQuery(null, null);
        } catch (PersistentException ex) {
            responerException(ex);
        }
        return null;
    }

    public static String getFecha(Date d) {
        return Utiles.MetodosUtiles.Tempus.getTaim(d, '-');
    }

    public static String getFechaMuerte(Autor d) {
        return d.getFecha_Muerte() != null ? Utiles.MetodosUtiles.Tempus.getTaim(d.getFecha_Muerte(), '-') : "---";
    }

    public static void responerException(Exception ex) {
        Utiles.FX.VisualFX.responerException(ex, new String[]{"Problemas con la Base de Datos"}, PersistentException.class);
    }

    public static JFXListView<String> getListaPalabrasClave(Pensamiento p) {
        JFXListView<String> L = new JFXListView();
        //  System.out.println("p.getContenido().trim()="+p.getContenido().trim());
        StringTokenizer t = Utiles.MetodosUtiles.Archivo.getTokenizer(p.getContenido().trim());

        while (t.hasMoreTokens()) {
            L.getItems().add(t.nextToken());
        }
        return L;
    }

    public static JFXListView<String> getListaPermisos(Usuario p) {
        JFXListView<String> L = new JFXListView();
        L.getItems().addAll(Permisos.getPermisos(p.getPermisos()));
        return L;
    }

    public static String getPalabrasClave(String a) {
        String respuesta = "";
        StringTokenizer t = Utiles.MetodosUtiles.Archivo.getTokenizer(a);
        while (t.hasMoreTokens()) {
            String token = t.nextToken();
            if (token.length() > 3) {
                respuesta += token + " ";
            }
        }
        return respuesta;
    }

    public static Set disponibilidaDigital(Titulo t) {
        final HashSet H = new HashSet();
        t.disponibilidad.getCollection().forEach(v -> {
            if (!((Disponibilidad) v).getUbicacion().equals(EN_LA_BIBLIOTECA)) {
                H.add(v);
            }
        });
//        Iterator I=t.disponibilidad.getIterator();
//        while(I.hasNext()){
//        
//        }

        return H;
    }

    public static boolean disponibleEnBiblioteca(Titulo v) {
        if (v.disponibilidad.isEmpty()) {
            //System.out.println("vacia");
            return false;
        }
        Disponibilidad next = (Disponibilidad) v.disponibilidad.getIterator().next();
        //System.out.println("next=" + next.getUbicacion());
        if (next.getUbicacion().equals(EN_LA_BIBLIOTECA)) {
            //   System.out.println("si");
            return true;
        }
        // System.out.println("no");
        return false;
        // v.disponibilidad.isEmpty() || !v.disponibilidad.getIterator().next().equals(EN_LA_BIBLIOTECA);
    }

    public static String getTipoDeTitulo(Titulo t) {
        return t.getArticulo() != null ? "Articulo" : (t.getCarta() != null ? "Carta" : "Libro");
    }

//    public static void eliminarAutor_TituloAll(Titulo a) {
//    try {
//            Iterator I = a.autor.getIterator();
//            Au P[]=new Pensamiento_Titulo[p.pensamiento_Titulo.size()];
//          int in=0;
//            while (I.hasNext()) {
//                Pensamiento_Titulo Pt = (Pensamiento_Titulo) I.next();
////                Pt.getTitulo().pensamiento_Titulo.remove(Pt);
////                I.remove();
////                Pt.deleteAndDissociate();
//                P[in++]=Pt;
//            }
//            for (int i = 0; i < P.length; i++) {
//                P[i].deleteAndDissociate();
//            }
////            Titulo T[] = TituloFactory.listTituloByQuery(null, null);
////            for (int i = 0; i < T.length; i++) {
////                T[i].pensamiento.remove(p);
////               // aaaaaaaaaaa
////            }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
//    }
//    public static void clearBD() throws PersistentException {
//        System.out.println("comenzo e eliminar todos los Titulos");
//        eliminarTituloAll();
//        System.out.println("elimino todos los titulos");
//        System.out.println("comenzo e eliminar todos los Autores");
//        eliminarAutorAll();
//        System.out.println("elimino todos los Autores");
//        System.out.println("comenzo e eliminar todos los temas");
//        eliminarTemaAll();
//        System.out.println("elimino todos los temas");
//    }
//   public static boolean esLibro(Titulo t){
//   
//   }
    public static Articulo[] getArticulos(Tema a) {
        final HashSet<Articulo> ob = new HashSet<>();
        a.pensamiento.getCollection().forEach(v -> {
            try {
                ob.addAll(Arrays.asList(getArticulos((Pensamiento) v)));
            } catch (PersistentException ex) {
                responerException(ex);
            }
        });
        return ob.toArray(new Articulo[0]);
    }

    public static Articulo[] getArticulos(Pensamiento a) throws PersistentException {
        PT P[] = getPensamiento_TituloAll(a);
//        Pensamiento_Titulo P[] = Pensamiento_TituloFactory.listPensamiento_TituloByQuery("pensamientoid= '" + a.getId() + "'", null);

        LinkedList<Articulo> ar = new LinkedList();
//        Articulo[] L = new Articulo[P.length];
        for (int i = 0; i < P.length; i++) {
            if (P[i].getTitulo().getArticulo() != null) {
                //  L[i] = P[i].getTitulo().getArticulo();
                ar.add(P[i].getTitulo().getArticulo());
            }

        }
        // System.out.println("P=" + P.length);
        return ar.toArray(new Articulo[0]);

//        final ObservableList<Articulo> ob = FXCollections.observableArrayList();
//        a.pensamiento_Titulo.getCollection().forEach(v -> {
//            Titulo t = ((Pensamiento_Titulo) v).getTitulo();
//            if (t.getArticulo() != null) {
//                ob.add(t.getArticulo());
//            }
//        });
//        return ob.toArray(new Articulo[0]);
    }

    public static Articulo[] getArticulos(Autor a) {
        final ObservableList<Articulo> ob = FXCollections.observableArrayList();
        a.titulo.getCollection().forEach(v -> {
            Titulo t = (Titulo) v;
            if (t.getArticulo() != null) {
                ob.add(t.getArticulo());
            }
        });
        return ob.toArray(new Articulo[0]);
    }

    public static Carta[] getCartas(Tema a) {
        final HashSet<Carta> ob = new HashSet<>();
        a.pensamiento.getCollection().forEach(v -> {
            try {
                ob.addAll(Arrays.asList(getCartas((Pensamiento) v)));
            } catch (PersistentException ex) {
                responerException(ex);
            }
        });
        return ob.toArray(new Carta[0]);
    }

    public static Carta[] getCartas(Pensamiento a) throws PersistentException {
//        Pensamiento_Titulo P[] = Pensamiento_TituloFactory.listPensamiento_TituloByQuery("pensamientoid= '" + a.getId() + "'", null);
        PT P[] = getPensamiento_TituloAll(a);
        LinkedList<Carta> ar = new LinkedList();
        //Carta[] L = new Carta[P.length];
        for (int i = 0; i < P.length; i++) {
            if (P[i].getTitulo().getCarta() != null) {
//                L[i] = P[i].getTitulo().getCarta();
                ar.add(P[i].getTitulo().getCarta());
            }

        }
        // System.out.println("P=" + P.length);
        return ar.toArray(new Carta[0]);

//        final ObservableList<Carta> ob = FXCollections.observableArrayList();
//        a.pensamiento_Titulo.getCollection().forEach(v -> {
//            Titulo t = ((Pensamiento_Titulo) v).getTitulo();
//            if (t.getCarta() != null) {
//                ob.add(t.getCarta());
//            }
//        });
//        return ob.toArray(new Carta[0]);
    }

    public static Carta[] getCartas(Autor a) {
        final ObservableList<Carta> ob = FXCollections.observableArrayList();
        a.titulo.getCollection().forEach(v -> {
            Titulo t = (Titulo) v;
            if (t.getCarta() != null) {
                ob.add(t.getCarta());
            }
        });
        return ob.toArray(new Carta[0]);
    }

    public static Libro[] getLibros(Autor a) {
//        final ObservableList<Libro> ob = FXCollections.observableArrayList();
        LinkedList<Libro> ob = new LinkedList<>();
        // Titulo
        a.titulo.getCollection().forEach(v -> {
            Titulo t = (Titulo) v;
            if (t.getLibro() != null) {
                ob.add(t.getLibro());
            }
        });
//        System.out.println("ob1=" + ob.size());
        return ob.toArray(new Libro[0]);
    }

    public static Libro[] getLibros(Tema a) {
        final HashSet<Libro> ob = new HashSet<>();
        a.pensamiento.getCollection().forEach(v -> {
            try {
                ob.addAll(Arrays.asList(getLibros((Pensamiento) v)));
            } catch (PersistentException ex) {
                responerException(ex);
            }
        });
//        System.out.println("ob2=" + ob.size());
        return ob.toArray(new Libro[0]);
    }

    public static Libro[] getLibros(Pensamiento a) throws PersistentException {
        // final ObservableList<Libro> ob = FXCollections.observableArrayList();
        //System.out.println("comenzo");
//        Pensamiento_Titulo P[] = Pensamiento_TituloFactory.listPensamiento_TituloByQuery("pensamientoid= '" + a.getId() + "'", null);
        PT P[] = getPensamiento_TituloAll(a);
        LinkedList<Libro> ar = new LinkedList();
        //Libro[] L = new Libro[P.length];
        for (int i = 0; i < P.length; i++) {
            if (P[i].getTitulo().getLibro() != null) {
                //  L[i] = P[i].getTitulo().getLibro();
                ar.add(P[i].getTitulo().getLibro());
            }

        }
        // System.out.println("P=" + P.length);
        return ar.toArray(new Libro[0]);

//        LinkedList<Libro> ob = new LinkedList<>();
//        Pensamiento_Titulo P[] = a.pensamiento_Titulo.toArray();
//        System.out.println("P=" + P.length);
//        for (int i = 0; i < P.length; i++) {
//            Titulo t = ((Pensamiento_Titulo) P[i]).getTitulo();
//            if (t.getLibro() != null) {
//                // System.out.println("add");
//                ob.add(t.getLibro());
//            }
//        }
//        a.pensamiento_Titulo.getCollection().forEach(v -> {
//            Titulo t = ((Pensamiento_Titulo) v).getTitulo();
//            if (t.getLibro() != null) {
//                System.out.println("add");
//                ob.add(t.getLibro());
//            }
//        });
//        System.out.println("ob3=" + ob.size());
//        return ob.toArray(new Libro[0]);
    }

    public static Autor[] getAutores(Tema a) {
        final HashSet<Autor> ob = new HashSet<>();
        a.pensamiento.getCollection().forEach(v -> {
            ob.addAll(Arrays.asList(getAutores((Pensamiento) v)));
        });
        return ob.toArray(new Autor[0]);
    }

    public static Autor[] getAutores(Pensamiento p) {
        final HashSet<Autor> ob = new HashSet<>();
        PT P[] = getPensamiento_TituloAll(p);
        for (int i = 0; i < P.length; i++) {
            ob.addAll(Arrays.asList(getAutores(P[i].getTitulo())));
        }
//        p.pensamiento_Titulo.getCollection().forEach(v -> {
//            ob.addAll(Arrays.asList(getAutores(((Pensamiento_Titulo) v).getTitulo())));
//        });
        return ob.toArray(new Autor[0]);
    }

    public static Autor[] getAutores(Titulo t) {
//        try {
//            Autor A[]=AutorFactory.listAutorByQuery("", null);
//            
//        } catch (PersistentException ex) {
//           return null;
//        }
        final HashSet<Autor> ob = new HashSet<>();
        // final ObservableList<Autor> ob = FXCollections.observableArrayList();
        t.autor.getCollection().forEach(v -> {
            ob.add(((Autor) v));
        });
        return ob.toArray(new Autor[0]);
    }

    public static Tema[] getTemas(Autor a) {
        final HashSet<Tema> ob = new HashSet<>();
        a.titulo.getCollection().forEach(v -> {
            try {
                ob.addAll(Arrays.asList(getTemas(((Titulo) v))));
            } catch (PersistentException ex) {
                responerException(ex);
            }
        });
        return ob.toArray(new Tema[0]);
    }

    public static Tema[] getTemas(Titulo t) throws PersistentException {
//        Pensamiento_Titulo P[] = Pensamiento_TituloFactory.listPensamiento_TituloByQuery("tituloid= '" + t.getId() + "'", null);
        PT P[] = getPensamiento_TituloAll(t);
        final HashSet<Tema> ob = new HashSet<>();
        for (int i = 0; i < P.length; i++) {
            ob.add(P[i].getPensamiento().getTema());
        }
        // System.out.println("P=" + P.length);
        return ob.toArray(new Tema[0]);

//        final ObservableList<Tema> ob = FXCollections.observableArrayList();
//        t.pensamiento_Titulo.getCollection().forEach(v -> {
//            ob.add(((Pensamiento_Titulo) v).getPensamiento().getTema());
//        });
//        return ob.toArray(new Tema[0]);
    }

//    public static Tema[] getTemas(Articulo a) {
//        final ObservableList<Tema> ob = FXCollections.observableArrayList();
//        a.getTitulo().pensamiento_Titulo.getCollection().forEach(v -> {
//            ob.add(((Pensamiento_Titulo) v).getPensamiento().getTema());
//        });
//        return ob.toArray(new Tema[0]);
//    }
//    public static Pensamiento[] getPensamientos(Articulo a) {
//        final ObservableList<Pensamiento> ob = FXCollections.observableArrayList();
//        a.getTitulo().pensamiento_Titulo.getCollection().forEach(v -> {
//            ob.add(((Pensamiento_Titulo) v).getPensamiento());
//        });
//        return ob.toArray(new Pensamiento[0]);
//    }
    public static Pensamiento[] getPensamientos(Autor a) {
        final HashSet<Pensamiento> ob = new HashSet<>();
        a.titulo.getCollection().forEach(v -> {
            try {
                ob.addAll(Arrays.asList(getPensamientos(((Titulo) v))));
            } catch (PersistentException ex) {
                responerException(ex);
            }
        });
        return ob.toArray(new Pensamiento[0]);
    }

    public static Pensamiento[] getPensamientos(Titulo t) throws PersistentException {
//        Pensamiento_Titulo P[] = Pensamiento_TituloFactory.listPensamiento_TituloByQuery("tituloid= '" + t.getId() + "'", null);
        PT P[] = getPensamiento_TituloAll(t);
        Pensamiento[] L = new Pensamiento[P.length];
        for (int i = 0; i < P.length; i++) {
            //if (P[i].getTitulo().getLibro() != null) {
            L[i] = P[i].getPensamiento();
            // }

        }
        return L;
//        final ObservableList<Pensamiento> ob = FXCollections.observableArrayList();
//        t.pensamiento_Titulo.getCollection().forEach(v -> {
//            ob.add(((Pensamiento_Titulo) v).getPensamiento());
//        });
//        return ob.toArray(new Pensamiento[0]);
    }
//    public static String getUbicacion(Articulo a, Pensamiento p) throws PersistentException {
//        return getUbicacion(a.getTitulo(), p);
//    }

    public static String getUbicacion(Titulo t, Pensamiento p) {
        try {
            // System.out.println(" p=" + p + " t=" + t);
            // PT pt=PTFactory.loadPTByQuery("pensamientoid='" + p.getId() + "' AND  tituloid='" + p.getId() + "'", null);
            PT PTs[] = PTFactory.listPTByQuery("pensamientoid='" + p.getId() + "'", null);
            PT pt = null;
            for (int i = 0; i < PTs.length; i++) {
                if (PTs[i].getTitulo().getId() == t.getId()) {
                    pt = PTs[i];
                    break;
                }
            }
            // System.out.println("pt=" + pt);
            return pt != null ? pt.getLugar() : "---";

            // return Pensamiento_TituloFactory.loadPensamiento_TituloByORMID(p, t).getLugar();
        } catch (PersistentException ex) {
            System.out.println("error de sintaxis");
            responerException(ex);
            return "---";
        }
    }

    public static void eliminarArticuloAll() throws PersistentException {
        Articulo A[] = ArticuloFactory.listArticuloByQuery(null, null);
        for (int i = 0; i < A.length; i++) {
            eliminarTitulo(A[i].getTitulo());
        }
    }

    public static void eliminarCartaAll() throws PersistentException {
        Carta A[] = CartaFactory.listCartaByQuery(null, null);
        for (int i = 0; i < A.length; i++) {
            eliminarTitulo(A[i].getTitulo());
        }
    }

    public static void eliminarLibroAll() throws PersistentException {
        Libro A[] = LibroFactory.listLibroByQuery(null, null);
        for (int i = 0; i < A.length; i++) {
            eliminarTitulo(A[i].getTitulo());
        }
    }

    public static void eliminarDisponibilidadAll(Titulo a) throws PersistentException {
//        try {
        Disponibilidad D[] = DisponibilidadFactory.listDisponibilidadByQuery(" tituloid='" + a.getId() + "'", null);
        for (int i = 0; i < D.length; i++) {
            D[i].deleteAndDissociate();
        }

//            Iterator I = a.disponibilidad.getIterator();
//            Disponibilidad P[] = new Disponibilidad[a.disponibilidad.size()];
//            int in = 0;
//            while (I.hasNext()) {
//                Disponibilidad Pt = (Disponibilidad) I.next();
////                Pt.getTitulo().pensamiento_Titulo.remove(Pt);
////                I.remove();
////                Pt.deleteAndDissociate();
//                P[in++] = Pt;
//            }
//            for (int i = 0; i < P.length; i++) {
//
//                P[i].deleteAndDissociate();
//            }
////            Titulo T[] = TituloFactory.listTituloByQuery(null, null);
////            for (int i = 0; i < T.length; i++) {
////                T[i].pensamiento.remove(p);
////               // aaaaaaaaaaa
////            }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
    }

    public static void eliminarTituloAll() throws PersistentException {
//        Titulo[] T=TituloFactory.listTituloByQuery(null, null);
//        
//        for (int i = 0; i < T.length; i++) {
//            eliminarTitulo(T[i]);
//        }

        eliminarLibroAll();
        eliminarCartaAll();
        eliminarArticuloAll();

    }

    public static void eliminarTitulo(Titulo a) throws PersistentException {
        System.out.println("comenzo a eliminar Titulo");
        eliminarPensamiento_TituloAll(a);
        System.out.println("elimino Pensamiento Titulo");
        eliminarDisponibilidadAll(a);
        System.out.println("elimino Disponibilidad");
        eliminarTituloAutorAll(a);
        System.out.println("elimino Autor Titulo");

        // eli
        try {
            eliminarSubbclaseDeTitulo(a);
            System.out.println("elimino subclase");
//            a.disponibilidad.clear();
//            a.pensamiento_Titulo.clear();
            // a.deleteAndDissociate();
            System.out.println("lo logro");
        } catch (org.hibernate.StaleStateException ex) {
            System.out.println("ignorar ");
//            responerException(ex);
        } catch (Exception ex) {

            Utiles.MetodosUtiles.MetodosUtiles.cls();
            System.out.println("ex=" + ex.getClass().getSimpleName());
            System.out.println("ignorar 2");
//            responerException(ex);
        }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
    }

    private static void eliminarSubbclaseDeTitulo(Titulo a) throws PersistentException {
        if (a.getArticulo() != null) {
            a.getArticulo().deleteAndDissociate();
            return;
        }
        if (a.getLibro() != null) {
            a.getLibro().deleteAndDissociate();
            return;
        }
        a.getCarta().deleteAndDissociate();
    }

    public static void eliminarTemaAll() throws PersistentException {
        //   try {
        Tema T[] = TemaFactory.listTemaByQuery(null, null);
        for (int i = 0; i < T.length; i++) {
            eliminarTema(T[i]);
        }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }

    }

    public static void eliminarPensamientoAll() throws PersistentException {
        Pensamiento P[] = PensamientoFactory.listPensamientoByQuery(null, null);
        for (int i = 0; i < P.length; i++) {
            eliminarPensamiento(P[i]);
        }
    }

    public static void eliminarPensamientoAll(Tema t) throws PersistentException {
        Pensamiento P[] = PensamientoFactory.listPensamientoByQuery(" temaid='" + t.getId() + "'", null);
        for (int i = 0; i < P.length; i++) {
            eliminarPensamiento(P[i]);
        }
    }

    public static void eliminarTema(Tema t) throws PersistentException {
        System.out.println("comenzo a eliminar Tema");
        eliminarPensamientoAll(t);
        System.out.println("elimino Pensamiento Tema");
        t.deleteAndDissociate();
        System.out.println("elimino Tema");

    }

    public static void eliminarPensamiento(Pensamiento p) throws PersistentException {
//        try {
        System.out.println("comenso a eliminar Pensamiento");
        eliminarPensamiento_TituloAll(p);
        System.out.println("elimino pensamiento_Titulo");
        //  eliminarPensamiento_PalabrasClave(p);
        p.deleteAndDissociate();
        System.out.println("elimino pensamiento");
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
    }

    public static PT[] getPensamiento_TituloAll(Pensamiento p) {
        try {
            return PTFactory.listPTByQuery(" pensamientoid= '" + p.getId() + "'", null);
            // return Pensamiento_TituloFactory.listPensamiento_TituloByQuery(" pensamientoid= '" + p.getId() + "'", null);
        } catch (PersistentException ex) {
            return null;
        }

    }

    public static PT[] getPensamiento_TituloAll(Titulo p) {
        try {
            return PTFactory.listPTByQuery(" tituloid= '" + p.getId() + "'", null);
            // return Pensamiento_TituloFactory.listPensamiento_TituloByQuery(" tituloid= '" + p.getId() + "'", null);
        } catch (PersistentException ex) {
            return null;
        }

    }

    public static void eliminarPensamiento_TituloAll(Pensamiento p) throws PersistentException {
        p.refresh();
        PT Pe[] = getPensamiento_TituloAll(p);
        // Pensamiento_Titulo Pe[] = Pensamiento_TituloFactory.listPensamiento_TituloByQuery(" pensamientoid= '" + p.getId() + "'", null);
//        System.out.println("p.getTema()=" + p.getTema());
        for (int i = 0; i < Pe.length; i++) {
//            Pe[i].setLugar(null);
//            try {
            Pe[i].refresh();
            Pe[i].deleteAndDissociate();
//            } catch (Exception ex) {
//                System.out.println("Pe[i]="+Pe[i]);
////                p.pensamiento_Titulo.remove(Pe[i]);
////                Pe[i].setPensamiento(null);
////                Pe[i].setTitulo(null);
////                //p.save();
////               // Pe[i].save();
////              //  Pe[i].deleteAndDissociate();
//            }
            System.out.println("elimino Pensamiento_Titulo");
        }
    }

    public static PT createPensamiento_Titulo() {
        return PTFactory.createPT();
    }

    public static void eliminarPensamiento_TituloAll(Titulo p) throws PersistentException {
        PT Pe[] = getPensamiento_TituloAll(p);
//  Pensamiento_Titulo Pe[] = Pensamiento_TituloFactory.listPensamiento_TituloByQuery(" tituloid= '" + p.getId() + "'", null);
        for (int i = 0; i < Pe.length; i++) {
            Pe[i].setLugar(null);
            Pe[i].deleteAndDissociate();
        }

    }
//    public static void eliminarPensamiento_TituloAll(Titulo t) {
//        try {
//            Iterator I = t.pensamiento_Titulo.getIterator();
//           while (I.hasNext()) {
//                Pensamiento_Titulo Pt = (Pensamiento_Titulo) I.next();
////                Pt.getTitulo().pensamiento_Titulo.remove(Pt);
////                I.remove();
//                Pt.deleteAndDissociate();
//            }
////            Titulo T[] = TituloFactory.listTituloByQuery(null, null);
////            for (int i = 0; i < T.length; i++) {
////                T[i].pensamiento.remove(p);
////               // aaaaaaaaaaa
////            }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
//        
//    }

    public static Autor[] eliminarAutorAll() throws PersistentException {
        final LinkedList<Autor> deTitulosConUnSoloAutor = new LinkedList();
//        try {
        Autor A[] = AutorFactory.listAutorByQuery(null, null);
        for (int i = 0; i < A.length; i++) {
            if (eliminarAutor(A[i]).length > 0) {
                deTitulosConUnSoloAutor.add(A[i]);
            }

        }
        return deTitulosConUnSoloAutor.toArray(new Autor[0]);
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }

    }

    public static void eliminarTituloAutorAll(Titulo t) {

//        Ti
        Autor A[] = t.autor.toArray();

        for (int i = 0; i < A.length; i++) {
            A[i].titulo.remove(t);
        }

        //t.autor.getCollection().forEach(v -> ((Autor) v).titulo.remove(t));
        t.autor.clear();
    }

    public static void eliminarTituloAutorAll(final Autor t) {
        t.titulo.getCollection().forEach(v -> ((Titulo) v).autor.remove(t));
        t.titulo.clear();
    }
//    public static Titulo[] getTitulosRelacionados(Autor a){
//   
//    } 

    public static Titulo[] eliminarAutor(Autor a) throws PersistentException {
        final LinkedList<Titulo> titulosConUnSoloAutor = new LinkedList();
        a.titulo.getCollection().forEach(v -> {
            Titulo t = (Titulo) v;
            if (t.autor.size() == 1) {
                titulosConUnSoloAutor.add(t);
            }
        });
        if (titulosConUnSoloAutor.isEmpty()) {
            System.out.println("comenso a liminar autor");
            eliminarTituloAutorAll(a);
            System.out.println("elimino Titulo Autor");
            a.deleteAndDissociate();
            System.out.println("elimino autor");
        }
        return titulosConUnSoloAutor.toArray(new Titulo[0]);
//        Aut
//        try {
//            
//            
////            Titulo T[] = TituloFactory.listTituloByQuery(null, null);
////            for (int i = 0; i < T.length; i++) {
////                if (T[i].autor.contains(a)) {
////                    T[i].autor.remove(a);
////                }
////            }
//            a.deleteAndDissociate();
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
    }
//    public static boolean existeAutor(String nombre){
//    
//    }

    public static Disponibilidad crearDisponibilidadFisica(Titulo T) throws PersistentException {
        return crearDisponibilidad(T, EN_LA_BIBLIOTECA);
    }

    public static Disponibilidad crearDisponibilidad(Titulo T, String ubicacion) throws PersistentException {
        Disponibilidad D = DisponibilidadFactory.createDisponibilidad();
        D.setUbicacion(ubicacion);
        D.setTitulo(T);
        D.save();
        T.disponibilidad.add(D);
        return D;
    }
//    public static void eliminarPensamiento_PalabrasClave(Pensamiento p) {
//        try {
//            Pensamiento_PalabrasClave C[] = Pensamiento_PalabrasClaveFactory.listPensamiento_PalabrasClaveByQuery(null, null);
//            for (int i = 0; i < C.length; i++) {
//                if (C[i].getPensamiento().getId() == p.getId()) {
//                    C[i].getPalabrasClave().deleteAndDissociate();
//                    C[i].deleteAndDissociate();
//                }
//            }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
//        
//    }

//    public static void eliminarPalabrasClave(Pensamiento p) {
//        try {
//            Pensamiento_PalabrasClave C[] = Pensamiento_PalabrasClaveFactory.listPensamiento_PalabrasClaveByQuery(null, null);
//            for (int i = 0; i < C.length; i++) {
//                if (C[i].getPensamiento().getId() == p.getId()) {
//                    C[i].deleteAndDissociate();
//                }
//            }
//        } catch (PersistentException ex) {
//            responerException(ex);
//        }
//
//    }
}
