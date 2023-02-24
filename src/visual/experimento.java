/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import static Utiles.MetodosUtiles.Tempus.getDate;
import static visual.probar.*;
import clases.*;
import java.util.Date;
import org.orm.PersistentException;

/**
 *
 * @author Rene
 */
public class experimento {

    public static void main(String[] args) throws PersistentException {
//        crear();
//        System.out.println("se creo");
//        clearBD();
//        eliminarPensamientoAll();
//        System.out.println("se elimino");
    }

    public static void crear() throws PersistentException {
        Tema t = TemaFactory.createTema();
        t.setNombre("Tema uno");
        t.save();

        Autor a = AutorFactory.createAutor();
        a.setFecha_Nacimiento(new Date());
        a.setFecha_Muerte(new Date());
        a.setNombre("Autor uno");

        Titulo T = TituloFactory.createTitulo();
        T.setNombre("Libro uno");
        T.setFecha(new Date());
        T.autor.add(a);
        T.save();
        Disponibilidad D = DisponibilidadFactory.createDisponibilidad();
        D.setUbicacion("Ubicacion uno");
        D.setTitulo(T);
        D.save();
        T.disponibilidad.add(D);
        Libro l = LibroFactory.createLibro();
        l.setTitulo(T);
        l.setEdicion(2);
        l.save();
        T.setLibro(l);

        
        Pensamiento P=PensamientoFactory.createPensamiento();
        P.setContenido("Contenido uno");
        P.setNombre("Nombre uno");
        P.setPalabrasClave("Palbra clave");
        P.setTema(t);
        P.save();
        
        PT Pt=createPensamiento_Titulo();
        Pt.setLugar("Lugar uno");
        Pt.setPensamiento(P);
        Pt.setTitulo(T);
        Pt.save();
    }
}
