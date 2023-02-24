/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles.FX;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import static Utiles.FX.VisualFX.getI;
import javafx.scene.control.TreeTableView;

/**
 *
 * @author Rene
 */
public class objetoTreeTableView extends RecursiveTreeObject<objetoTreeTableView> {

    Object valor;

    public objetoTreeTableView(Object valor) {
        this.valor = valor;
    }

    public <E> E getValor() {
        return (E) valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public static <E> E getValorSeleccionado( TreeTableView<objetoTreeTableView> TV) {
   
        return TV.getSelectionModel().getSelectedItem()==null?null: TV.getSelectionModel().getSelectedItem().getValue().<E>getValor();
        //  int indice = getI(TV);
       // System.out.println("TV.getSelectionModel().getSelectedItem()="+TV.getSelectionModel().getSelectedItem());
       // System.out.println("indice="+indice);
        //return indice == -1 ? null : valores.get(indice).<E>getValor();
    }

    public static <E> E getValorDe(ObservableList<objetoTreeTableView> valores, ObservableList<objetoTreeTableView> dondeBuscar, Object aBuscar) {
        int indice = getIndex(dondeBuscar, aBuscar);
        return indice == -1 ? null : valores.get(indice).<E>getValor();
    }

    public static int getIndex(ObservableList<objetoTreeTableView> ob, Object o) {
        for (int i = 0; i < ob.size(); i++) {
            if (ob.get(i).getValor().equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public static ObservableList<objetoTreeTableView> getOb(Object... V) {
        ObservableList<objetoTreeTableView> O = FXCollections.observableArrayList();
        for (int i = 0; i < V.length; i++) {
            O.add(new objetoTreeTableView(V[i]));
        }
        return O;
    }

    public static ObservableList<TreeItem<objetoTreeTableView>> getObTreeItem(Object... V) {
        ObservableList<TreeItem<objetoTreeTableView>> O = FXCollections.observableArrayList();
        for (int i = 0; i < V.length; i++) {
            O.add(new TreeItem<objetoTreeTableView>(new objetoTreeTableView(V[i])));
        }
        return O;
    }
}
