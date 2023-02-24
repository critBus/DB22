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
import org.hibernate.Query;
import java.util.List;

public class ArticuloFactory {
	public static Articulo[] listArticuloByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listArticuloByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Articulo[] listArticuloByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listArticuloByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Articulo[] listArticuloByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Articulo as Articulo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Articulo[]) list.toArray(new Articulo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Articulo[] listArticuloByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Articulo as Articulo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Articulo[]) list.toArray(new Articulo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Articulo loadArticuloByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadArticuloByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Articulo loadArticuloByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadArticuloByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Articulo loadArticuloByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Articulo[] articulos = listArticuloByQuery(session, condition, orderBy);
		if (articulos != null && articulos.length > 0)
			return articulos[0];
		else
			return null;
	}
	
	public static Articulo loadArticuloByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Articulo[] articulos = listArticuloByQuery(session, condition, orderBy, lockMode);
		if (articulos != null && articulos.length > 0)
			return articulos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateArticuloByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iterateArticuloByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArticuloByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iterateArticuloByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArticuloByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Articulo as Articulo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArticuloByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Articulo as Articulo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Articulo createArticulo() {
		return new clases.Articulo();
	}
	
	public static Articulo loadArticuloByCriteria(ArticuloCriteria articuloCriteria) {
		Articulo[] articulos = listArticuloByCriteria(articuloCriteria);
		if(articulos == null || articulos.length == 0) {
			return null;
		}
		return articulos[0];
	}
	
	public static Articulo[] listArticuloByCriteria(ArticuloCriteria articuloCriteria) {
		return articuloCriteria.listArticulo();
	}
}
