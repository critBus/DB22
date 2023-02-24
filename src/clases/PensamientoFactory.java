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

public class PensamientoFactory {
	public static Pensamiento loadPensamientoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadPensamientoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento getPensamientoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return getPensamientoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento loadPensamientoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadPensamientoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento getPensamientoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return getPensamientoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento loadPensamientoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Pensamiento) session.load(clases.Pensamiento.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento getPensamientoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Pensamiento) session.get(clases.Pensamiento.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento loadPensamientoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pensamiento) session.load(clases.Pensamiento.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento getPensamientoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pensamiento) session.get(clases.Pensamiento.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento[] listPensamientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listPensamientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento[] listPensamientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listPensamientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento[] listPensamientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Pensamiento as Pensamiento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Pensamiento[]) list.toArray(new Pensamiento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento[] listPensamientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Pensamiento as Pensamiento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Pensamiento[]) list.toArray(new Pensamiento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento loadPensamientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadPensamientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento loadPensamientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadPensamientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pensamiento loadPensamientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Pensamiento[] pensamientos = listPensamientoByQuery(session, condition, orderBy);
		if (pensamientos != null && pensamientos.length > 0)
			return pensamientos[0];
		else
			return null;
	}
	
	public static Pensamiento loadPensamientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Pensamiento[] pensamientos = listPensamientoByQuery(session, condition, orderBy, lockMode);
		if (pensamientos != null && pensamientos.length > 0)
			return pensamientos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePensamientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iteratePensamientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePensamientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iteratePensamientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePensamientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Pensamiento as Pensamiento");
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
	
	public static java.util.Iterator iteratePensamientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Pensamiento as Pensamiento");
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
	
	public static Pensamiento createPensamiento() {
		return new clases.Pensamiento();
	}
	
	public static Pensamiento loadPensamientoByCriteria(PensamientoCriteria pensamientoCriteria) {
		Pensamiento[] pensamientos = listPensamientoByCriteria(pensamientoCriteria);
		if(pensamientos == null || pensamientos.length == 0) {
			return null;
		}
		return pensamientos[0];
	}
	
	public static Pensamiento[] listPensamientoByCriteria(PensamientoCriteria pensamientoCriteria) {
		return pensamientoCriteria.listPensamiento();
	}
}
