/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import Utiles.ClasesUtiles.Interfases.Funcionales.Creador;
import Utiles.ClasesUtiles.Interfases.Funcionales.Realizar;
import Utiles.FX.ConVentana;
import Utiles.FX.JFXDialogs.DialogoJFX;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.emojione.EmojiOne;
import de.jensd.fx.glyphs.emojione.EmojiOneView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dialogo_Aceptar_CancelarController extends ConVentana{

    Realizar R;
//    private Stage ventana;
    @FXML
    private AnchorPane PAnchor;

    @FXML
    private Text Te;

    @FXML
    private JFXButton BCancelar;

    @FXML
    private JFXButton BAceptar;

    @FXML
    private EmojiOneView Icono;

    @FXML
    void apretoAceptar(MouseEvent event) {
        R.realizar();
        close();
//        getDialog().close();

    }

    @FXML
    void apretoCancelar(MouseEvent event) {
        close();
//        getDialog().close();
    }

//    public void iniStage(Parent p) {
//        //this.scene = s;
//        Scene s = new Scene(p);
//        ventana = new Stage();
//        ventana.setScene(s);
//        Utiles.FX.VisualFX.sinBordes(s, ventana);
//    }

    public void show( String mensaje, EmojiOne icono, Realizar r) {
        Icono.setIcon(icono);
        show( mensaje, r);
    }

    public void show( String mensaje, Realizar r) {

        R = r;
        Te.setText(mensaje);
       
        show();
        ///   getDialog().show(sp);
    }

    public void show( Creador<String> c, Realizar r) {

        R = r;
        Te.setText(c.crear());
       
        show();
        ///   getDialog().show(sp);
    }

    public void initialize(URL location, ResourceBundle resources) {
//        ini(PAnchor);
        // ini(getDialog());
         BAceptar.setDefaultButton(true);
    }

//    public static Dialogo_Aceptar_CancelarController cargar() throws MalformedURLException{//Dialogo_Aceptar_Cancelar.fxml
////        System.out.println("existe ="+new File("Utiles/FX/JFXDialogs").exists());
////      File f=new File("Utiles/FX/JFXDialogs/Dialogo_Aceptar_Cancelar.fxml");
//        System.out.println(new File("").getAbsolutePath());
//         File f=new File(new File("").getAbsolutePath()+"/src/Utiles/FX/JFXDialogs/Dialogo_Aceptar_Cancelar.fxml");
//        System.out.println("f.exists()="+f.exists());
//        return new FXMLLoader(f.toURI().toURL()).<Dialogo_Aceptar_CancelarController>getController();
//    }
    public Realizar getR() {
        return R;
    }

    public void setR(Realizar R) {
        this.R = R;
    }

    public AnchorPane getPAnchor() {
        return PAnchor;
    }

    public void setPAnchor(AnchorPane PAnchor) {
        this.PAnchor = PAnchor;
    }

    public Text getTe() {
        return Te;
    }

    public void setTe(Text Te) {
        this.Te = Te;
    }

    public JFXButton getBCancelar() {
        return BCancelar;
    }

    public void setBCancelar(JFXButton BCancelar) {
        this.BCancelar = BCancelar;
    }

    public JFXButton getBAceptar() {
        return BAceptar;
    }

    public void setBAceptar(JFXButton BAceptar) {
        this.BAceptar = BAceptar;
    }

}
