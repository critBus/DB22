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
public class Pensamiento {
	public Pensamiento() {
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
			if(getTema() != null) {
				getTema().pensamiento.remove(this);
			}
			
			clases.PT[] lpTs = pT.toArray();
			for(int i = 0; i < lpTs.length; i++) {
				lpTs[i].setPensamiento(null);
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
			if(getTema() != null) {
				getTema().pensamiento.remove(this);
			}
			
			clases.PT[] lpTs = pT.toArray();
			for(int i = 0; i < lpTs.length; i++) {
				lpTs[i].setPensamiento(null);
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
		if (key == clases.ORMConstants.KEY_PENSAMIENTO_PT) {
			return ORM_pT;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == clases.ORMConstants.KEY_PENSAMIENTO_TEMA) {
			this.tema = (clases.Tema) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private String contenido;
	
	private clases.Tema tema;
	
	private String palabrasClave;
	
	private String nombre;
	
	private java.util.Set ORM_pT = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setContenido(String value) {
		this.contenido = value;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setPalabrasClave(String value) {
		this.palabrasClave = value;
	}
	
	public String getPalabrasClave() {
		return palabrasClave;
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setTema(clases.Tema value) {
		if (tema != null) {
			tema.pensamiento.remove(this);
		}
		if (value != null) {
			value.pensamiento.add(this);
		}
	}
	
	public clases.Tema getTema() {
		return tema;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Tema(clases.Tema value) {
		this.tema = value;
	}
	
	private clases.Tema getORM_Tema() {
		return tema;
	}
	
	private void setORM_pT(java.util.Set value) {
		this.ORM_pT = value;
	}
	
	private java.util.Set getORM_pT() {
		return ORM_pT;
	}
	
	public final clases.PTSetCollection pT = new clases.PTSetCollection(this, _ormAdapter, clases.ORMConstants.KEY_PENSAMIENTO_PT, clases.ORMConstants.KEY_PT_PENSAMIENTO, clases.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
