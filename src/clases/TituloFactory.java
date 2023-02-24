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

public class TituloFactory {
	public static Titulo loadTituloByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadTituloByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo getTituloByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return getTituloByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo loadTituloByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadTituloByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo getTituloByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return getTituloByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo loadTituloByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Titulo) session.load(clases.Titulo.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo getTituloByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Titulo) session.get(clases.Titulo.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo loadTituloByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Titulo) session.load(clases.Titulo.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo getTituloByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Titulo) session.get(clases.Titulo.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo[] listTituloByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listTituloByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo[] listTituloByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listTituloByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo[] listTituloByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Titulo as Titulo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Titulo[]) list.toArray(new Titulo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo[] listTituloByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Titulo as Titulo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Titulo[]) list.toArray(new Titulo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo loadTituloByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadTituloByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo loadTituloByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadTituloByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Titulo loadTituloByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Titulo[] titulos = listTituloByQuery(session, condition, orderBy);
		if (titulos != null && titulos.length > 0)
			return titulos[0];
		else
			return null;
	}
	
	public static Titulo loadTituloByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Titulo[] titulos = listTituloByQuery(session, condition, orderBy, lockMode);
		if (titulos != null && titulos.length > 0)
			return titulos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTituloByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iterateTituloByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTituloByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iterateTituloByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTituloByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Titulo as Titulo");
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
	
	public static java.util.Iterator iterateTituloByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Titulo as Titulo");
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
	
	public static Titulo createTitulo() {
		return new clases.Titulo();
	}
	
	public static Titulo loadTituloByCriteria(TituloCriteria tituloCriteria) {
		Titulo[] titulos = listTituloByCriteria(tituloCriteria);
		if(titulos == null || titulos.length == 0) {
			return null;
		}
		return titulos[0];
	}
	
	public static Titulo[] listTituloByCriteria(TituloCriteria tituloCriteria) {
		return tituloCriteria.listTitulo();
	}
}
