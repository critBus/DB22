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
public class Autor {
	public Autor() {
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
			clases.Titulo[] lTitulos = titulo.toArray();
			for(int i = 0; i < lTitulos.length; i++) {
				lTitulos[i].autor.remove(this);
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
			clases.Titulo[] lTitulos = titulo.toArray();
			for(int i = 0; i < lTitulos.length; i++) {
				lTitulos[i].autor.remove(this);
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
	
	private java.util.Set this_getSet (int key) {
		if (key == clases.ORMConstants.KEY_AUTOR_TITULO) {
			return ORM_titulo;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String nombre;
	
	private java.util.Date fecha_Nacimiento;
	
	private java.util.Date fecha_Muerte;
	
	private java.util.Set ORM_titulo = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setFecha_Nacimiento(java.util.Date value) {
		this.fecha_Nacimiento = value;
	}
	
	public java.util.Date getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}
	
	public void setFecha_Muerte(java.util.Date value) {
		this.fecha_Muerte = value;
	}
	
	public java.util.Date getFecha_Muerte() {
		return fecha_Muerte;
	}
	
	private void setORM_Titulo(java.util.Set value) {
		this.ORM_titulo = value;
	}
	
	private java.util.Set getORM_Titulo() {
		return ORM_titulo;
	}
	
	public final clases.TituloSetCollection titulo = new clases.TituloSetCollection(this, _ormAdapter, clases.ORMConstants.KEY_AUTOR_TITULO, clases.ORMConstants.KEY_TITULO_AUTOR, clases.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getNombre());
	}
	
}
