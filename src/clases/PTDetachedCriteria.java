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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PTDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression lugar;
	
	public PTDetachedCriteria() {
		super(clases.PT.class, clases.PTCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		lugar = new StringExpression("lugar", this.getDetachedCriteria());
	}
	
	public PTDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.PTCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		lugar = new StringExpression("lugar", this.getDetachedCriteria());
	}
	
	public PensamientoDetachedCriteria createPensamientoCriteria() {
		return new PensamientoDetachedCriteria(createCriteria("pensamiento"));
	}
	
	public TituloDetachedCriteria createTituloCriteria() {
		return new TituloDetachedCriteria(createCriteria("titulo"));
	}
	
	public PT uniquePT(PersistentSession session) {
		return (PT) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PT[] listPT(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PT[]) list.toArray(new PT[list.size()]);
	}
}

