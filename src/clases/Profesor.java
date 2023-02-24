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
public class Profesor {
	public Profesor() {
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
				getUsuario().setProfesor(null);
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
				getUsuario().setProfesor(null);
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
	
	private String especializacion;
	
	private clases.Usuario usuario;
	
	private int usuarioId;
	
	public void setUsuarioId(int value) {
		this.usuarioId = value;
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}
	
	public void setEspecializacion(String value) {
		this.especializacion = value;
	}
	
	public String getEspecializacion() {
		return especializacion;
	}
	
	public void setUsuario(clases.Usuario value) {
		if (this.usuario != value) {
			clases.Usuario lusuario = this.usuario;
			this.usuario = value;
			if (value != null) {
				usuario.setProfesor(this);
			}
			else {
				lusuario.setProfesor(null);
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
