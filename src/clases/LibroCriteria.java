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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class LibroCriteria extends AbstractORMCriteria {
	public final IntegerExpression edicion;
	
	public LibroCriteria(Criteria criteria) {
		super(criteria);
		edicion = new IntegerExpression("edicion", this);
	}
	
	public LibroCriteria(PersistentSession session) {
		this(session.createCriteria(Libro.class));
	}
	
	public LibroCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public TituloCriteria createTituloCriteria() {
		return new TituloCriteria(createCriteria("titulo"));
	}
	
	public Libro uniqueLibro() {
		return (Libro) super.uniqueResult();
	}
	
	public Libro[] listLibro() {
		java.util.List list = super.list();
		return (Libro[]) list.toArray(new Libro[list.size()]);
	}
}

