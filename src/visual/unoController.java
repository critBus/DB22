/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import clases.*;
import static visual.probar.*;
import Utiles.FX.*;
import static Utiles.FX.VisualFX.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.collections.FXCollections;
import javafx.scene.AccessibleRole;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

public class unoController implements Initializable {
    
    @FXML
    private TableView<Pensamiento> tabla;
    
    @FXML
    private JFXTextField tex;
    
    @FXML
    private JFXPasswordField PF;
    
    @FXML
    private JFXButton BU;
    
    @FXML
    void escribe(KeyEvent event) {
//        if(!Utiles.MetodosUtiles.MetodosUtiles.esCharNumero(event.getCharacter().charAt(0))){
//        event.consume();
//        }
//        char a=event.getCharacter().charAt(0);
//        System.out.println("a="+(int)a);
//        
//if(!(a>='0'&&a<='9')){event.consume();}
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // PF.setAccessibleRole(AccessibleRole.TEXT_FIELD);
        
//                 tex.setAccessibleRole(AccessibleRole.PASSWORD_FIELD);
//        tex.setTextFormatter(PF.getTextFormatter());
//        StringConverter<String> es=new StringConverter<String>() {
//            @Override
//            public String toString(String object) {
//                System.out.println("object="+object);
//               // PF.commitValue();
//                return object==null?"":object;
//            }
//
//            @Override
//            public String fromString(String string) {
//                System.out.println("string="+string);
//               // PF.commitValue();
//                return string;
//            }
//        };
//        System.out.println("es="+es);
//        TextFormatter<String> t=new TextFormatter<String>(es);
//        System.out.println("t="+t);
//        System.out.println("PF="+PF);
//        PF.setTextFormatter(t);
//        PF.setOnKeyTyped(v -> {
//            //System.out.println("escribe");
//            System.out.println(PF.getAccessibleText());
////            System.out.println("PF.getTextFormatter()=" + PF.getTextFormatter());
////            System.out.println("PF.getTextFormatter().getValueConverter()=" + PF.getTextFormatter().getValueConverter());
////            System.out.println("tos=" + PF.getTextFormatter().getValueConverter().fromString(PF.getText()));
////            PF.commitValue();
//        });
        //PF.appendText("algo");
        //
//PF.setContextMenu(new ContextMenu(new MenuItem("Primero")));
//PF.snapToPixelProperty().setValue(false);
//PF.getContextMenu().getItems().add(new MenuItem("Primero"));
//System.out.println("");
//PF.setAccessibleText("Hola");
    }
    
}
