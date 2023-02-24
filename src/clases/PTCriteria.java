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

public class PTCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression lugar;
	
	public PTCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		lugar = new StringExpression("lugar", this);
	}
	
	public PTCriteria(PersistentSession session) {
		this(session.createCriteria(PT.class));
	}
	
	public PTCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public PensamientoCriteria createPensamientoCriteria() {
		return new PensamientoCriteria(createCriteria("pensamiento"));
	}
	
	public TituloCriteria createTituloCriteria() {
		return new TituloCriteria(createCriteria("titulo"));
	}
	
	public PT uniquePT() {
		return (PT) super.uniqueResult();
	}
	
	public PT[] listPT() {
		java.util.List list = super.list();
		return (PT[]) list.toArray(new PT[list.size()]);
	}
}

