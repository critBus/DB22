/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jlopezr
 */
public class Reporte {

    private Connection c = null;

    public Reporte() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB22", "postgres", "postgres");
            c.setAutoCommit(false);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void runreporte(String reporte) {
        try {
            //  JOptionPane.showMessageDialog(null, System.getProperty("user.dir"));

            String master = System.getProperty("user.dir") + "\\src\\reportes\\" + reporte;
            if (!new File(master).exists()) {
                master = new File(System.getProperty("user.dir")).getParent() + "\\src\\reportes\\" + reporte;
                //JOptionPane.showMessageDialog(null, master);
            }

            //InputStream jasper = this.getClass().getResourceAsStream(master);
            if (master == null) {
                //JOptionPane.showConfirmDialog(null, "No se encuentra el master", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                 Utiles.FX.VisualFX.showAlertaError("No se encuentra el master");
            }
            JasperReport masterReport = null;
            try {
                // System.out.println("existe "+new File(master).exists());
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e) {
                JOptionPane.showConfirmDialog(null, "Error cargando el master" + master, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            Map parametro = new HashMap();
            JasperPrint jasperprint = JasperFillManager.fillReport(masterReport, parametro, c);
            JasperViewer jasperviewer = new JasperViewer(jasperprint, false);
            jasperviewer.setVisible(true);
            c.close();
        } catch (Exception j) {
            j.printStackTrace();
            System.out.println("Mensaje error" + j.getMessage());
        }
    }
public void runReporteConParametro(String reporte,int id) {
        try {
            //  JOptionPane.showMessageDialog(null, System.getProperty("user.dir"));

            String master = System.getProperty("user.dir") + "\\src\\reportes\\" + reporte;
            if (!new File(master).exists()) {
                master = new File(System.getProperty("user.dir")).getParent() + "\\src\\reportes\\" + reporte;
                //JOptionPane.showMessageDialog(null, master);
            }

            //InputStream jasper = this.getClass().getResourceAsStream(master);
            if (master == null) {
               // JOptionPane.showConfirmDialog(null, "No se encuentra el master", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
              Utiles.FX.VisualFX.showAlertaError("No se encuentra el master");
            }
            JasperReport masterReport = null;
            try {
                // System.out.println("existe "+new File(master).exists());
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e) {
                JOptionPane.showConfirmDialog(null, "Error cargando el master" + master, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            Map parametro = new HashMap();
            parametro.put("ID", id);
            JasperPrint jasperprint = JasperFillManager.fillReport(masterReport, parametro, c);
            JasperViewer jasperviewer = new JasperViewer(jasperprint, false);
            jasperviewer.setVisible(true);
            c.close();
        } catch (Exception j) {
            j.printStackTrace();
            System.out.println("Mensaje error" + j.getMessage());
        }
    }

    public void runreportePath(String reporte) {
        try {
            String master = System.getProperty("user.dir") + "\\src\\reportes\\" + reporte;

            //InputStream jasper = this.getClass().getResourceAsStream(master);
            if (master == null) {
                JOptionPane.showConfirmDialog(null, "No se encuentra el master", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e) {
                JOptionPane.showConfirmDialog(null, "Error cargando el master" + master, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            Map parametro = new HashMap();
            parametro.put("path", System.getProperty("user.dir") + "\\src\\reportes\\");
            JasperPrint jasperprint = JasperFillManager.fillReport(masterReport, parametro, c);
            JasperViewer jasperviewer = new JasperViewer(jasperprint, false);
            jasperviewer.setVisible(true);
            c.close();
        } catch (Exception j) {
            System.out.println("Mensaje error" + j.getMessage());
        }
    }

    public void runreporteGuia_Inspeccion(String reporte, String decreto) {
        try {
            String master = System.getProperty("user.dir") + "\\src\\reportes\\" + reporte;
            //InputStream jasper = this.getClass().getResourceAsStream(master);
            if (master == null) {
                JOptionPane.showConfirmDialog(null, "No se encuentra el master", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e) {
                JOptionPane.showConfirmDialog(null, "Error cargando el master" + master, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            Map parametro = new HashMap();
            parametro.put("decreto", decreto);
            parametro.put("path", System.getProperty("user.dir") + "\\src\\reportes\\");
            JasperPrint jasperprint = JasperFillManager.fillReport(masterReport, parametro, c);
            JasperViewer jasperviewer = new JasperViewer(jasperprint, false);
            jasperviewer.setVisible(true);
            c.close();
        } catch (Exception j) {
            System.out.println("Mensaje error" + j.getMessage());
        }
    }

    public void runreporteActa_Inspeccion(String reporte, String delegacion, int codigo) {
        try {
            String master = System.getProperty("user.dir") + "\\src\\reportes\\" + reporte;
            //InputStream jasper = this.getClass().getResourceAsStream(master);
            if (master == null) {
                JOptionPane.showConfirmDialog(null, "No se encuentra el master", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e) {
                JOptionPane.showConfirmDialog(null, "Error cargando el master" + master, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            Map parametro = new HashMap();
            parametro.put("delegacion", delegacion);
            parametro.put("codigo", codigo);
            parametro.put("path", System.getProperty("user.dir") + "\\src\\reportes\\");
            JasperPrint jasperprint = JasperFillManager.fillReport(masterReport, parametro, c);
            JasperViewer jasperviewer = new JasperViewer(jasperprint, false);
            jasperviewer.setVisible(true);
            c.close();
        } catch (Exception j) {
            System.out.println("Mensaje error" + j.getMessage());
        }
    }

}
