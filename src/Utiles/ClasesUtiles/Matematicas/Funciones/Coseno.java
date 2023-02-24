/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles.ClasesUtiles.Matematicas.Funciones;

import Utiles.ClasesUtiles.Matematicas.*;
import static Utiles.MetodosUtiles.MetodosUtiles.bicondicional;

/**
 *
 * @author Rene
 */
public class Coseno extends Funcion{
     public Coseno(Coseno f) {
        this(f.getParametro1().copia(), f.esPositivo());
    }

    public Coseno( double parametro1) {
        this(new Numero(parametro1), true);
    }
     public Coseno( double parametro1, boolean positivo) {
        this(new Numero(parametro1), true);
    }

    public Coseno(Operando parametro1) {
        this(parametro1, true);
    }
    
    public Coseno(Operando parametro1, boolean positivo) {
         inicializarConstructorUnParamtro(TipoDeEnvoltura.COSENO,parametro1, positivo);

    }

    
     @Override
    public Coseno[] crearArreglo(int leng) {
        return new Coseno[leng];
    }

    @Override
    public Coseno[][] crearArreglo(int filas, int columnas) {
        return new Coseno[filas][columnas];
    }

    @Override
    public Coseno[][][] crearArreglo(int filas, int columnas, int cantidad) {
         return new Coseno[filas][columnas][cantidad];
    }

    @Override
    public Operando inicializarDerivada(char v) {
        return (derivado=new Multiplicacion(bicondicional(positivo, false),new Seno(getParametro1().copia()) ,getParametro1().inicializarDerivada(v))); //To change body of generated methods, choose Tools | Templates.
    }
    
}
