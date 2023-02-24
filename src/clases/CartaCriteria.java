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

public class CartaCriteria extends AbstractORMCriteria {
	public final StringExpression destinatario;
	
	public CartaCriteria(Criteria criteria) {
		super(criteria);
		destinatario = new StringExpression("destinatario", this);
	}
	
	public CartaCriteria(PersistentSession session) {
		this(session.createCriteria(Carta.class));
	}
	
	public CartaCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public TituloCriteria createTituloCriteria() {
		return new TituloCriteria(createCriteria("titulo"));
	}
	
	public Carta uniqueCarta() {
		return (Carta) super.uniqueResult();
	}
	
	public Carta[] listCarta() {
		java.util.List list = super.list();
		return (Carta[]) list.toArray(new Carta[list.size()]);
	}
}

