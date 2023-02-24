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
public class Disponibilidad {
	public Disponibilidad() {
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
			if(getTitulo() != null) {
				getTitulo().disponibilidad.remove(this);
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
			if(getTitulo() != null) {
				getTitulo().disponibilidad.remove(this);
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == clases.ORMConstants.KEY_DISPONIBILIDAD_TITULO) {
			this.titulo = (clases.Titulo) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private clases.Titulo titulo;
	
	private String ubicacion;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setUbicacion(String value) {
		this.ubicacion = value;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	
	public void setTitulo(clases.Titulo value) {
		if (titulo != null) {
			titulo.disponibilidad.remove(this);
		}
		if (value != null) {
			value.disponibilidad.add(this);
		}
	}
	
	public clases.Titulo getTitulo() {
		return titulo;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Titulo(clases.Titulo value) {
		this.titulo = value;
	}
	
	private clases.Titulo getORM_Titulo() {
		return titulo;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
