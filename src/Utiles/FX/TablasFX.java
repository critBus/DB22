/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles.FX;

import Utiles.ClasesUtiles.Interfases.Funcionales.Creador;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

/**
 * Version 0.1
 *
 * @author Rene
 */
public abstract class TablasFX {

    public static void crearTabla(JFXTreeTableView<objetoTreeTableView> TV, Object ob[], JFXTreeTableColumn<objetoTreeTableView, ?>... T) {
        TV.setEditable(false);
        setColumns(TV, ob, T);
    }

    public static void crearTabla(JFXTreeTableView<objetoTreeTableView> TV, ObservableList<objetoTreeTableView> ob, JFXTreeTableColumn<objetoTreeTableView, ?>... T) {
        TV.setEditable(false);
        TablasFX.setColumns(TV, ob, T);
    }

    public static void crearTabla(JFXTreeTableView<objetoTreeTableView> TV, ObservableList<objetoTreeTableView> ob, JFXTreeTableColumn<objetoTreeTableView, ?>[] principales, JFXTreeTableColumn<objetoTreeTableView, ?>... T) {
        TV.setEditable(false);
        setColumns(TV, ob, principales);
        addColumns(TV, T);
    }

    public static void setWidth(TableColumn t, double w) {
        if (w > 0) {
            t.setMinWidth(w);
           
            //  t.getC
        }
    }

    public static void setWidth(JFXTreeTableColumn t, double w) {
        if (w > 0) {
            t.setMinWidth(w);
            t.setPrefWidth(w);

            //t.setC
        }
    }

    public static <E> JFXTreeTableColumn<E, Boolean> getTreeTableColumnCheckBox(String nombre, double w, final ObservableList<SimpleBooleanProperty> ob) {
        JFXTreeTableColumn<E, Boolean> columnaSeleccionar = new JFXTreeTableColumn<>(nombre);

        columnaSeleccionar.setCellFactory(v -> {
            final CheckBoxTreeTableCell tc = new CheckBoxTreeTableCell<>();
            tc.setAlignment(Pos.CENTER);
            // VisualFX.addOnMousePressed(tc, v2 -> System.out.println("mira rrrrrrrrrr"));
            return tc;
        });
        if (ob != null) {
            columnaSeleccionar.setCellValueFactory(v -> {
                SimpleBooleanProperty b = new SimpleBooleanProperty(false);
                // b.addListener(null);
                ob.add(b);
                System.out.println("seleccionados ob.size()=" + ob.size());
                return b;
            });
        }

        setWidth(columnaSeleccionar, w);
        columnaSeleccionar.setEditable(true);

        return columnaSeleccionar;
    }

    public static <E> TableColumn<E, Boolean> getTableColumnCheckBox(String nombre, double w, final ObservableList<SimpleBooleanProperty> ob) {
        TableColumn<E, Boolean> columnaSeleccionar = new TableColumn<>(nombre);

        columnaSeleccionar.setCellFactory(v -> {
            final CheckBoxTableCell tc = new CheckBoxTableCell<>();
            // VisualFX.addOnMousePressed(tc, v2 -> System.out.println("mira rrrrrrrrrr"));
            return tc;
        });
        if (ob != null) {
            columnaSeleccionar.setCellValueFactory(v -> {
                SimpleBooleanProperty b = new SimpleBooleanProperty(false);
                // b.addListener(null);
                ob.add(b);
                return b;
            });
        }

        setWidth(columnaSeleccionar, w);
        columnaSeleccionar.setEditable(true);
        return columnaSeleccionar;
    }
//public static boolean asd=true;
    public static <E> JFXTreeTableColumn<objetoTreeTableView, String> getTreeTableColumn(String nombre, double w, Callback<E, String> c) {
        JFXTreeTableColumn<objetoTreeTableView, String> columnaNombre = new JFXTreeTableColumn<>(nombre);

        columnaNombre.setCellFactory(v -> {
            TextFieldTreeTableCell TF = new TextFieldTreeTableCell<>();
//            if(asd){
//            System.out.println("TF.getPadding()="+TF.getPadding());
//            asd=false;
//            }
//            
//            TF.setPadding(Insets.EMPTY);
//            TF.setPrefHeight(26);
//             TF.setMaxHeight(26);
//              TF.setMinHeight(26);
            TF.setAlignment(Pos.CENTER);
            return TF;
        });

        columnaNombre.setCellValueFactory(v -> {
            //  System.out.println("comen a=" + a);
            ReadOnlyObjectWrapper read = null;
            try {
                read = new ReadOnlyObjectWrapper<>(v.getValue().getValue().getValor() != null ? c.call((E) v.getValue().getValue().getValor()) : "");
            } catch (Exception ex) {
                //  System.out.println("fue a="+a);
                // ex.printStackTrace();
                throw ex;
            }
//            System.out.println("termi a=" + a);
            return read;
        });

        setWidth(columnaNombre, w);
        columnaNombre.setEditable(false);
        return columnaNombre;
    }

//    public static <E> JFXTreeTableColumn<E, String> getTreeTableColumn(String nombre, double w, Callback<E, String> c) {
//        JFXTreeTableColumn<E, String> columnaNombre = new JFXTreeTableColumn<>(nombre);
//
//        columnaNombre.setCellFactory(v -> {
//            TextFieldTreeTableCell TF = new TextFieldTreeTableCell<>();
//            TF.setAlignment(Pos.CENTER);
//            return TF;
//        });
//        columnaNombre.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(c.call(v.getValue().getValue())));
//        setWidth(columnaNombre, w);
//        columnaNombre.setEditable(false);
//        return columnaNombre;
//    }
    public static <E> TableColumn<E, String> getTableColumn(String nombre, double w, Callback<E, String> c) {
        TableColumn<E, String> columnaNombre = new TableColumn<>(nombre);

        columnaNombre.setCellFactory(v -> {
            TextFieldTableCell TF = new TextFieldTableCell<>();
            TF.setAlignment(Pos.CENTER);
            return TF;
        });
        columnaNombre.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(c.call(v.getValue())));
        setWidth(columnaNombre, w);
        columnaNombre.setEditable(false);
        return columnaNombre;
    }

//    public static <E> TableColumn<E, ListView<String>> getTableColumnList(String nombre,Creador<ListView<String>> c) {
//        TableColumn<E, ListView<String>> columnaSeleccionar = new TableColumn<>("Seleccionar");
//        columnaSeleccionar.setCellFactory(v -> new Utiles.FX.Table.TableCellLista<>());
//        columnaSeleccionar.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(c.crear()));
//        return columnaSeleccionar;
//    }
//    public static <E, P> TableColumn<E, ListView<String>> getTableColumnList(String nombre, Iterable<P> iterable, final Callback<P, String> c) {
//        TableColumn<E, ListView<String>> columnaSeleccionar = new TableColumn<>("Seleccionar");
//        columnaSeleccionar.setCellFactory(v -> new Utiles.FX.Table.TableCellLista<>());
//        ListView<String> item = new ListView<>();
//        iterable.forEach(v -> item.getItems().add(c.call(v)));
//        columnaSeleccionar.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(item));
//        return columnaSeleccionar;
//    }
    public static <E> JFXTreeTableColumn<objetoTreeTableView, JFXTextArea> getTreeTableColumnTextArea(String nombre, double w, final Callback<E, String> c) {
        JFXTreeTableColumn<objetoTreeTableView, JFXTextArea> columnaSeleccionar = new JFXTreeTableColumn<>(nombre);

        columnaSeleccionar.setCellFactory(v -> new Utiles.FX.Celdas.TreeTableCellTExtArea());

        columnaSeleccionar.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(new JFXTextArea(c.call((E) v.getValue().getValue().getValor()))));

        setWidth(columnaSeleccionar, w);

        columnaSeleccionar.setEditable(false);

        return columnaSeleccionar;
    }

    public static <E> JFXTreeTableColumn<objetoTreeTableView, JFXListView<String>> getTreeTableColumnList(String nombre, double w, Callback<E, JFXListView<String>> c) {
        JFXTreeTableColumn<objetoTreeTableView, JFXListView<String>> columnaSeleccionar = new JFXTreeTableColumn<>(nombre);

        columnaSeleccionar.setCellFactory(v -> new Utiles.FX.Celdas.TreeTableCellLista<>());

        columnaSeleccionar.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(c.call((E) v.getValue().getValue().getValor())));

        setWidth(columnaSeleccionar, w);

        columnaSeleccionar.setEditable(false);

        return columnaSeleccionar;
    }

    //crearListaLlena(iterable, c, (E)v.getValue().getValue().getValor())
    public static <E, P> JFXTreeTableColumn<objetoTreeTableView, JFXListView<String>> getTreeTableColumnListArreglo(String nombre, double w, Callback<E, P[]> iterable, final Callback<P, String> c) {
        //return getTreeTableColumnList(nombre, w, crearListaLlena(iterable, c, (E)v.getValue().getValue().getValor()));
        JFXTreeTableColumn<objetoTreeTableView, JFXListView<String>> columnaSeleccionar = new JFXTreeTableColumn<>(nombre);

        columnaSeleccionar.setCellFactory(v -> new Utiles.FX.Celdas.TreeTableCellLista<>());

        columnaSeleccionar.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(crearListaLlenaJFXArreglo(iterable, c, (E) v.getValue().getValue().getValor())));

        setWidth(columnaSeleccionar, w);

        columnaSeleccionar.setEditable(false);

        return columnaSeleccionar;
    }

    public static <E, P> JFXTreeTableColumn<objetoTreeTableView, JFXListView<String>> getTreeTableColumnList(String nombre, double w, Callback<E, Iterable<P>> iterable, final Callback<P, String> c) {
        //return getTreeTableColumnList(nombre, w, crearListaLlena(iterable, c, (E)v.getValue().getValue().getValor()));
        JFXTreeTableColumn<objetoTreeTableView, JFXListView<String>> columnaSeleccionar = new JFXTreeTableColumn<>(nombre);

        columnaSeleccionar.setCellFactory(v -> new Utiles.FX.Celdas.TreeTableCellLista<>());

        columnaSeleccionar.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(crearListaLlenaJFX(iterable, c, (E) v.getValue().getValue().getValor())));

        setWidth(columnaSeleccionar, w);

        columnaSeleccionar.setEditable(false);

        return columnaSeleccionar;
    }

    public static <E, P> TableColumn<E, ListView<String>> getTableColumnList(String nombre, double w, Callback<E, Iterable<P>> iterable, final Callback<P, String> c) {
        TableColumn<E, ListView<String>> columnaSeleccionar = new TableColumn<>(nombre);
        columnaSeleccionar.setCellFactory(v -> new Utiles.FX.Celdas.TableCellLista<>());
//        ListView<String> item = new ListView<>();
//        iterable.forEach(v -> item.getItems().add(c.call(v)));
        columnaSeleccionar.setCellValueFactory(v -> new ReadOnlyObjectWrapper<>(crearListaLlena(iterable, c, v.getValue())));
        setWidth(columnaSeleccionar, w);
        columnaSeleccionar.setEditable(false);
        return columnaSeleccionar;
    }

    private static <E, P> JFXListView<String> crearListaLlenaJFX(Callback<E, Iterable<P>> iterable, final Callback<P, String> c, E e) {
        JFXListView<String> item = new JFXListView<>();
        iterable.call(e).forEach(v -> item.getItems().add(c.call(v)));
//        System.out.println("aaaaaaaa");
//        for (int i = 0; i < item.getItems().size(); i++) {
//            System.out.println("item.getItems().get(i)="+item.getItems().get(i));
//        }
//        System.out.println("bbbbbbbbb");
        return item;
    }

    private static <E, P> JFXListView<String> crearListaLlenaJFXArreglo(Callback<E, P[]> iterable, final Callback<P, String> c, E e) {
        JFXListView<String> item = new JFXListView<>();
        P[] A = iterable.call(e);
        for (int i = 0; i < A.length; i++) {
            item.getItems().add(c.call(A[i]));
        }
//        iterable.call(e).forEach(v -> item.getItems().add(c.call(v)));
//       
        return item;
    }

    private static <E, P> ListView<String> crearListaLlena(Callback<E, Iterable<P>> iterable, final Callback<P, String> c, E e) {
        ListView<String> item = new ListView<>();
        iterable.call(e).forEach(v -> item.getItems().add(c.call(v)));
        return item;
    }

    public static <E> void setColumns(TableView<E> TV, TableColumn<E, ?>... T) {
        TV.getColumns().clear();
        TV.getColumns().addAll(T);

    }

    public static void setColumns(JFXTreeTableView<objetoTreeTableView> TV, Object ob[], JFXTreeTableColumn<objetoTreeTableView, ?>... T) {
        setColumns(TV, objetoTreeTableView.getOb(ob), T);
    }

    public static void setColumns(JFXTreeTableView<objetoTreeTableView> TV, ObservableList<objetoTreeTableView> ob, JFXTreeTableColumn<objetoTreeTableView, ?>... T) {

        RecursiveTreeItem<objetoTreeTableView> ti = new RecursiveTreeItem<objetoTreeTableView>(ob, RecursiveTreeObject::getChildren);

        TV.getColumns().clear();
        TV.getColumns().addAll(T);
        TV.setRoot(ti);
        TV.setShowRoot(false);
// StackPane 
    }

    public static void addColumns(JFXTreeTableView<objetoTreeTableView> TV, JFXTreeTableColumn<objetoTreeTableView, ?>... T) {
        TV.getColumns().addAll(T);
    }

    public static void addColumn(JFXTreeTableView<objetoTreeTableView> TV, int indice, JFXTreeTableColumn<objetoTreeTableView, ?> T) {
        TV.getColumns().add(indice, T);
    }

    public static <E> void setPredicate(JFXTreeTableView<objetoTreeTableView> TV, TextInputControl T, Callback<E, String> c) {
        T.textProperty().addListener(v -> {
            if (!T.getText().isEmpty()) {
                TV.setPredicate(v2 -> c.call(v2.getValue().<E>getValor()).toLowerCase().contains(T.getText().trim().toLowerCase()));
                //TV.setPredicate(v2->v2.getValue().<E>getValor().getNombre().contains(TBuscar.getText().trim()));
            } else {
                TV.setPredicate(null);
            }
        });
    }

}
