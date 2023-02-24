/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

/**
 *
 * @author Rene
 */
public enum Permisos {
    LEER_INFORAMACION("Leer inforamacion"),
    MODIFICAR_INFORAMACION("Modificar inforamacion"),
    AGREGAR_INFORAMACION("Agregar inforamacion"),
    LEER_CUENTAS("Leer Cuentas"),
    MODIFICAR_CUENTAS("Modificar Cuentas"),
    AGREGAR_CUENTAS("Agregar Cuentas");

    private final String permiso;
    private static final String SEPARADOR=",";
    private Permisos(String permiso) {
        this.permiso = permiso;
    }

//    public static final String LEER_INFORAMACION="Leer inforamacion",
//            MODIFICAR_INFORAMACION="Modificar inforamacion",
//            AGREGAR_INFORAMACION="Agregar inforamacion",
//            LEER_CUENTAS="Leer Cuentas",
//            MODIFICAR_CUENTAS="Modificar Cuentas",
//            AGREGAR_CUENTAS="Agregar Cuentas";
    public String getPermiso() {
        return permiso;
    }

    public static String getPermisosEstudiante() {
        return getPermisos(LEER_INFORAMACION);
    }

    public static String getPermisosProfesor() {
        return getPermisos(LEER_INFORAMACION, MODIFICAR_INFORAMACION, AGREGAR_INFORAMACION);
    }

    public static String getPermisosAdministrador() {
        return getPermisos(LEER_INFORAMACION, MODIFICAR_INFORAMACION, AGREGAR_INFORAMACION,
                LEER_CUENTAS, MODIFICAR_CUENTAS, AGREGAR_CUENTAS);
    }

    private static String getPermisos(Permisos... P) {
        String per = "";
        for (int i = 0; i < P.length; i++) {
            per += P[i].permiso + (i != P.length - 1 ? SEPARADOR : "");
        }
        return per;
    }

    public static String[] getPermisos(String per) {
        return per.split(SEPARADOR);
    }
}
