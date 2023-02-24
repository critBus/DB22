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

public class CartaFactory {
	public static Carta[] listCartaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listCartaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carta[] listCartaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return listCartaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carta[] listCartaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Carta as Carta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Carta[]) list.toArray(new Carta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carta[] listCartaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Carta as Carta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Carta[]) list.toArray(new Carta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carta loadCartaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadCartaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carta loadCartaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return loadCartaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carta loadCartaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Carta[] cartas = listCartaByQuery(session, condition, orderBy);
		if (cartas != null && cartas.length > 0)
			return cartas[0];
		else
			return null;
	}
	
	public static Carta loadCartaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Carta[] cartas = listCartaByQuery(session, condition, orderBy, lockMode);
		if (cartas != null && cartas.length > 0)
			return cartas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCartaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iterateCartaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCartaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = clases.DB22PersistentManager.instance().getSession();
			return iterateCartaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCartaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Carta as Carta");
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
	
	public static java.util.Iterator iterateCartaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From clases.Carta as Carta");
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
	
	public static Carta createCarta() {
		return new clases.Carta();
	}
	
	public static Carta loadCartaByCriteria(CartaCriteria cartaCriteria) {
		Carta[] cartas = listCartaByCriteria(cartaCriteria);
		if(cartas == null || cartas.length == 0) {
			return null;
		}
		return cartas[0];
	}
	
	public static Carta[] listCartaByCriteria(CartaCriteria cartaCriteria) {
		return cartaCriteria.listCarta();
	}
}
