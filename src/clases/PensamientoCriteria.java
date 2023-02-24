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

public class PensamientoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression contenido;
	public final StringExpression palabrasClave;
	public final StringExpression nombre;
	
	public PensamientoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		contenido = new StringExpression("contenido", this);
		palabrasClave = new StringExpression("palabrasClave", this);
		nombre = new StringExpression("nombre", this);
	}
	
	public PensamientoCriteria(PersistentSession session) {
		this(session.createCriteria(Pensamiento.class));
	}
	
	public PensamientoCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public TemaCriteria createTemaCriteria() {
		return new TemaCriteria(createCriteria("tema"));
	}
	
	public PTCriteria createPTCriteria() {
		return new PTCriteria(createCriteria("ORM_PT"));
	}
	
	public Pensamiento uniquePensamiento() {
		return (Pensamiento) super.uniqueResult();
	}
	
	public Pensamiento[] listPensamiento() {
		java.util.List list = super.list();
		return (Pensamiento[]) list.toArray(new Pensamiento[list.size()]);
	}
}

