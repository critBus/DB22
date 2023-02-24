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
public class Titulo {
	public Titulo() {
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
			clases.Autor[] lAutors = autor.toArray();
			for(int i = 0; i < lAutors.length; i++) {
				lAutors[i].titulo.remove(this);
			}
			if(getLibro() != null) {
				getLibro().setTitulo(null);
			}
			
			clases.Disponibilidad[] lDisponibilidads = disponibilidad.toArray();
			for(int i = 0; i < lDisponibilidads.length; i++) {
				lDisponibilidads[i].setTitulo(null);
			}
			if(getArticulo() != null) {
				getArticulo().setTitulo(null);
			}
			
			if(getCarta() != null) {
				getCarta().setTitulo(null);
			}
			
			clases.PT[] lpTs = pT.toArray();
			for(int i = 0; i < lpTs.length; i++) {
				lpTs[i].setTitulo(null);
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
			clases.Autor[] lAutors = autor.toArray();
			for(int i = 0; i < lAutors.length; i++) {
				lAutors[i].titulo.remove(this);
			}
			if(getLibro() != null) {
				getLibro().setTitulo(null);
			}
			
			clases.Disponibilidad[] lDisponibilidads = disponibilidad.toArray();
			for(int i = 0; i < lDisponibilidads.length; i++) {
				lDisponibilidads[i].setTitulo(null);
			}
			if(getArticulo() != null) {
				getArticulo().setTitulo(null);
			}
			
			if(getCarta() != null) {
				getCarta().setTitulo(null);
			}
			
			clases.PT[] lpTs = pT.toArray();
			for(int i = 0; i < lpTs.length; i++) {
				lpTs[i].setTitulo(null);
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
		if (key == clases.ORMConstants.KEY_TITULO_AUTOR) {
			return ORM_autor;
		}
		else if (key == clases.ORMConstants.KEY_TITULO_DISPONIBILIDAD) {
			return ORM_disponibilidad;
		}
		else if (key == clases.ORMConstants.KEY_TITULO_PT) {
			return ORM_pT;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == clases.ORMConstants.KEY_TITULO_LIBRO) {
			this.libro = (clases.Libro) owner;
		}
		
		else if (key == clases.ORMConstants.KEY_TITULO_ARTICULO) {
			this.articulo = (clases.Articulo) owner;
		}
		
		else if (key == clases.ORMConstants.KEY_TITULO_CARTA) {
			this.carta = (clases.Carta) owner;
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
	
	private String nombre;
	
	private java.util.Date fecha;
	
	private java.util.Set ORM_autor = new java.util.HashSet();
	
	private clases.Libro libro;
	
	private java.util.Set ORM_disponibilidad = new java.util.HashSet();
	
	private clases.Articulo articulo;
	
	private clases.Carta carta;
	
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
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setFecha(java.util.Date value) {
		this.fecha = value;
	}
	
	public java.util.Date getFecha() {
		return fecha;
	}
	
	private void setORM_Autor(java.util.Set value) {
		this.ORM_autor = value;
	}
	
	private java.util.Set getORM_Autor() {
		return ORM_autor;
	}
	
	public final clases.AutorSetCollection autor = new clases.AutorSetCollection(this, _ormAdapter, clases.ORMConstants.KEY_TITULO_AUTOR, clases.ORMConstants.KEY_AUTOR_TITULO, clases.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setLibro(clases.Libro value) {
		if (this.libro != value) {
			clases.Libro llibro = this.libro;
			this.libro = value;
			if (value != null) {
				libro.setTitulo(this);
			}
			else {
				llibro.setTitulo(null);
			}
		}
	}
	
	public clases.Libro getLibro() {
		return libro;
	}
	
	private void setORM_Disponibilidad(java.util.Set value) {
		this.ORM_disponibilidad = value;
	}
	
	private java.util.Set getORM_Disponibilidad() {
		return ORM_disponibilidad;
	}
	
	public final clases.DisponibilidadSetCollection disponibilidad = new clases.DisponibilidadSetCollection(this, _ormAdapter, clases.ORMConstants.KEY_TITULO_DISPONIBILIDAD, clases.ORMConstants.KEY_DISPONIBILIDAD_TITULO, clases.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setArticulo(clases.Articulo value) {
		if (this.articulo != value) {
			clases.Articulo larticulo = this.articulo;
			this.articulo = value;
			if (value != null) {
				articulo.setTitulo(this);
			}
			else {
				larticulo.setTitulo(null);
			}
		}
	}
	
	public clases.Articulo getArticulo() {
		return articulo;
	}
	
	public void setCarta(clases.Carta value) {
		if (this.carta != value) {
			clases.Carta lcarta = this.carta;
			this.carta = value;
			if (value != null) {
				carta.setTitulo(this);
			}
			else {
				lcarta.setTitulo(null);
			}
		}
	}
	
	public clases.Carta getCarta() {
		return carta;
	}
	
	private void setORM_pT(java.util.Set value) {
		this.ORM_pT = value;
	}
	
	private java.util.Set getORM_pT() {
		return ORM_pT;
	}
	
	public final clases.PTSetCollection pT = new clases.PTSetCollection(this, _ormAdapter, clases.ORMConstants.KEY_TITULO_PT, clases.ORMConstants.KEY_PT_TITULO, clases.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getNombre());
	}
	
}
