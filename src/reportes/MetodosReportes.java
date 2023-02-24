/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import clases.*;

/**
 *
 * @author Rene
 */
public class MetodosReportes {

    // private final static Reporte R = new Reporte();
    public static void runReporteTemas() {
        new Reporte().runreporte("report29.jasper");//1
    }

    public static void runReporteAutores() {
        new Reporte().runreporte("report24.jasper");//2
    }

    public static void runReporteCartas() {
        new Reporte().runreporte("report28.jasper");//3
    }

    public static void runReporteArticulos() {
        new Reporte().runreporte("report27.jasper");//4
    }

    public static void runReporteLibros() {
        new Reporte().runreporte("report26.jasper");//5
    }

    public static void runReportePensamientos() {
        new Reporte().runreporte("report25.jasper");//6
    }

    public static void runReportePensamientosDeTema(Tema t) {//7 30
        new Reporte().runReporteConParametro("report30.jasper", t.getId());
    }

    public static void runReporteLibrosDeTema(Tema t) {//8
        new Reporte().runReporteConParametro("report31.jasper", t.getId());
    }

    public static void runReporteArticulosDeTema(Tema t) {//9
        new Reporte().runReporteConParametro("report32.jasper", t.getId());
    }

    public static void runReporteCartasDeTema(Tema t) {//10
        new Reporte().runReporteConParametro("report33.jasper", t.getId());
    }

    public static void runReporteAutoresDeTema(Tema t) {//11
        new Reporte().runReporteConParametro("report34.jasper", t.getId());
    }

    public static void runReporteLibrosDePensamiento(Pensamiento t) {//12
        new Reporte().runReporteConParametro("report35.jasper", t.getId());
    }

    public static void runReporteCartasDePensamiento(Pensamiento t) {//13
        new Reporte().runReporteConParametro("report36.jasper", t.getId());
    }

    public static void runReporteArticulosDePensamiento(Pensamiento t) {//14
        new Reporte().runReporteConParametro("report37.jasper", t.getId());
    }
    public static void runReporteAutoresDePensamiento(Pensamiento t) {//15
        new Reporte().runReporteConParametro("report38.jasper", t.getId());
    }
    public static void runReporteTemaDeTitulo(Titulo t) {//16
        new Reporte().runReporteConParametro("report39.jasper", t.getId());
    }
     public static void runReportePensamientoDeTitulo(Titulo t) {//17
        new Reporte().runReporteConParametro("report40.jasper", t.getId());
    }
     public static void runReporteAutoresDeTitulo(Titulo t) {//18
        new Reporte().runReporteConParametro("report41.jasper", t.getId());
    }
     public static void runReporteTemaDeAutor(Autor t) {//19
        new Reporte().runReporteConParametro("report42.jasper", t.getId());
    }
     public static void runReportePensamientosDeAutor(Autor t) {//20
        new Reporte().runReporteConParametro("report43.jasper", t.getId());
    }
     public static void runReporteLibrosDeAutor(Autor t) {//21
        new Reporte().runReporteConParametro("report44.jasper", t.getId());
    }
      public static void runReporteCartasDeAutor(Autor t) {//22
        new Reporte().runReporteConParametro("report45.jasper", t.getId());
    }
       public static void runReporteArticulosDeAutor(Autor t) {//23
        new Reporte().runReporteConParametro("report46.jasper", t.getId());
    }
}
