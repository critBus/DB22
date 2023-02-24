/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles.FX;

import Utiles.ClasesUtiles.Interfases.Funcionales.Realizar;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Rene
 */
public abstract class ConVentana {

    private Stage ventana;

    public void iniStage(Parent p) {
        //this.scene = s;
        Scene s = new Scene(p);
        ventana = new Stage();
        ventana.setScene(s);
        ventana.initModality(Modality.APPLICATION_MODAL);

        Utiles.FX.VisualFX.sinBordes(s, ventana);
    }

    public Stage getVentana() {
        return ventana;
    }

    public void setVentana(Stage ventana) {
        this.ventana = ventana;
    }

    public void close() {
        ventana.close();
    }

    public void show() {
        ventana.showAndWait();
        //dialog.setStyle("-fx-background-radius: 40; -fx-border-radius: 40; -fx-background-color: red; -fx-border-width: 5; -fx-border-color: orange;");
        //  dialog.show(sp);
    }

    public void addOnClosed(Realizar r) {
        VisualFX.addOnClosed(ventana, r);
    }

    public boolean isShowing() {
        return ventana.isShowing();
    }
    public void minimizar() {
        ventana.setIconified(true);
    }
}
