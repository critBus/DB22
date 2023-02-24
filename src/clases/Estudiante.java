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
public class Estudiante {
	public Estudiante() {
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
			clases.Usuario usuario = getUsuario();
			if(getUsuario() != null) {
				getUsuario().setEstudiante(null);
			}
			setUsuario(usuario);
			
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			clases.Usuario usuario = getUsuario();
			if(getUsuario() != null) {
				getUsuario().setEstudiante(null);
			}
			setUsuario(usuario);
			
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
	
	private Integer curso;
	
	private String carrera;
	
	private Integer identificador;
	
	private clases.Usuario usuario;
	
	private int usuarioId;
	
	public void setUsuarioId(int value) {
		this.usuarioId = value;
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}
	
	public void setCurso(int value) {
		setCurso(new Integer(value));
	}
	
	public void setCurso(Integer value) {
		this.curso = value;
	}
	
	public Integer getCurso() {
		return curso;
	}
	
	public void setCarrera(String value) {
		this.carrera = value;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	public void setIdentificador(int value) {
		setIdentificador(new Integer(value));
	}
	
	public void setIdentificador(Integer value) {
		this.identificador = value;
	}
	
	public Integer getIdentificador() {
		return identificador;
	}
	
	public void setUsuario(clases.Usuario value) {
		if (this.usuario != value) {
			clases.Usuario lusuario = this.usuario;
			this.usuario = value;
			if (value != null) {
				usuario.setEstudiante(this);
			}
			else {
				lusuario.setEstudiante(null);
			}
		}
	}
	
	public clases.Usuario getUsuario() {
		return usuario;
	}
	
	public clases.Usuario getORMID() {
		return getUsuario();
	}
	
	public String toString() {
		return String.valueOf(((getUsuario() == null) ? "" : String.valueOf(getUsuario().getORMID())));
	}
	
}
