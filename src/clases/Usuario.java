/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package clases;

import org.orm.*;
public class Usuario {
	public Usuario() {
	}
	
	public boolean save() throws PersistentException {
		try {
			clases.DB22PersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			clases.DB22PersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			clases.DB22PersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			clases.DB22PersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			if(getAdministrador() != null) {
				getAdministrador().setUsuario(null);
			}
			
			if(getProfesor() != null) {
				getProfesor().setUsuario(null);
			}
			
			if(getEstudiante() != null) {
				getEstudiante().setUsuario(null);
			}
			
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			if(getAdministrador() != null) {
				getAdministrador().setUsuario(null);
			}
			
			if(getProfesor() != null) {
				getProfesor().setUsuario(null);
			}
			
			if(getEstudiante() != null) {
				getEstudiante().setUsuario(null);
			}
			
			try {
				session.delete(this);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private int id;
	
	private String nombreDeCuenta;
	
	private String contrasena;
	
	private String nombre;
	
	private String permisos;
	
	private clases.Administrador administrador;
	
	private clases.Profesor profesor;
	
	private clases.Estudiante estudiante;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNombreDeCuenta(String value) {
		this.nombreDeCuenta = value;
	}
	
	public String getNombreDeCuenta() {
		return nombreDeCuenta;
	}
	
	public void setContrasena(String value) {
		this.contrasena = value;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setPermisos(String value) {
		this.permisos = value;
	}
	
	public String getPermisos() {
		return permisos;
	}
	
	public void setAdministrador(clases.Administrador value) {
		if (this.administrador != value) {
			clases.Administrador ladministrador = this.administrador;
			this.administrador = value;
			if (value != null) {
				administrador.setUsuario(this);
			}
			else {
				ladministrador.setUsuario(null);
			}
		}
	}
	
	public clases.Administrador getAdministrador() {
		return administrador;
	}
	
	public void setProfesor(clases.Profesor value) {
		if (this.profesor != value) {
			clases.Profesor lprofesor = this.profesor;
			this.profesor = value;
			if (value != null) {
				profesor.setUsuario(this);
			}
			else {
				lprofesor.setUsuario(null);
			}
		}
	}
	
	public clases.Profesor getProfesor() {
		return profesor;
	}
	
	public void setEstudiante(clases.Estudiante value) {
		if (this.estudiante != value) {
			clases.Estudiante lestudiante = this.estudiante;
			this.estudiante = value;
			if (value != null) {
				estudiante.setUsuario(this);
			}
			else {
				lestudiante.setUsuario(null);
			}
		}
	}
	
	public clases.Estudiante getEstudiante() {
		return estudiante;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
