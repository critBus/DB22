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

public class AutorFactory {
	public static Autor loadAutorByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadAutorByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor getAutorByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return getAutorByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor loadAutorByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadAutorByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor getAutorByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return getAutorByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor loadAutorByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Autor) session.load(clases.Autor.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor getAutorByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Autor) session.get(clases.Autor.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor loadAutorByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Autor) session.load(clases.Autor.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor getAutorByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Autor) session.get(clases.Autor.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor[] listAutorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listAutorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor[] listAutorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listAutorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor[] listAutorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Autor as Autor");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Autor[]) list.toArray(new Autor[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor[] listAutorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Autor as Autor");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Autor[]) list.toArray(new Autor[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor loadAutorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadAutorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor loadAutorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadAutorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Autor loadAutorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Autor[] autors = listAutorByQuery(session, condition, orderBy);
		if (autors != null && autors.length > 0)
			return autors[0];
		else
			return null;
	}
	
	public static Autor loadAutorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Autor[] autors = listAutorByQuery(session, condition, orderBy, lockMode);
		if (autors != null && autors.length > 0)
			return autors[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAutorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iterateAutorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAutorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iterateAutorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAutorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Autor as Autor");
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
	
	public static java.util.Iterator iterateAutorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Autor as Autor");
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
	
	public static Autor createAutor() {
		return new clases.Autor();
	}
	
	public static Autor loadAutorByCriteria(AutorCriteria autorCriteria) {
		Autor[] autors = listAutorByCriteria(autorCriteria);
		if(autors == null || autors.length == 0) {
			return null;
		}
		return autors[0];
	}
	
	public static Autor[] listAutorByCriteria(AutorCriteria autorCriteria) {
		return autorCriteria.listAutor();
	}
}
