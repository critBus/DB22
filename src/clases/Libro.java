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
public class Libro {
	public Libro() {
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
			clases.Titulo titulo = getTitulo();
			if(getTitulo() != null) {
				getTitulo().setLibro(null);
			}
			setTitulo(titulo);
			
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			clases.Titulo titulo = getTitulo();
			if(getTitulo() != null) {
				getTitulo().setLibro(null);
			}
			setTitulo(titulo);
			
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
	
	private Integer edicion;
	
	private clases.Titulo titulo;
	
	private int tituloId;
	
	public void setTituloId(int value) {
		this.tituloId = value;
	}
	
	public int getTituloId() {
		return tituloId;
	}
	
	public void setEdicion(int value) {
		setEdicion(new Integer(value));
	}
	
	public void setEdicion(Integer value) {
		this.edicion = value;
	}
	
	public Integer getEdicion() {
		return edicion;
	}
	
	public void setTitulo(clases.Titulo value) {
		if (this.titulo != value) {
			clases.Titulo ltitulo = this.titulo;
			this.titulo = value;
			if (value != null) {
				titulo.setLibro(this);
			}
			else {
				ltitulo.setLibro(null);
			}
		}
	}
	
	public clases.Titulo getTitulo() {
		return titulo;
	}
	
	public clases.Titulo getORMID() {
		return getTitulo();
	}
	
	public String toString() {
		return String.valueOf(((getTitulo() == null) ? "" : String.valueOf(getTitulo().getORMID())));
	}
	
}
