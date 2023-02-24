/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ProgressIndicator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Ventana_CargandoController implements Initializable{

    @FXML
    private Text Te;

    @FXML
    private ProgressIndicator Pro;

      @FXML
    private AnchorPane PAnchor;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     //  Pro.set
//        ProgressIndicator p1 = new ProgressIndicator();
//        p1.setPrefSize(50, 50);
        Pro.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
//       AnchorPane.setLeftAnchor(p1, 50d);
//       AnchorPane.setTopAnchor(p1, 10d);
//       PAnchor.getChildren().add(p1);
    }

}
