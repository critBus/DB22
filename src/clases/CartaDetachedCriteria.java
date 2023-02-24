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

public class CartaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression destinatario;
	
	public CartaDetachedCriteria() {
		super(clases.Carta.class, clases.CartaCriteria.class);
		destinatario = new StringExpression("destinatario", this.getDetachedCriteria());
	}
	
	public CartaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.CartaCriteria.class);
		destinatario = new StringExpression("destinatario", this.getDetachedCriteria());
	}
	
	public TituloDetachedCriteria createTituloCriteria() {
		return new TituloDetachedCriteria(createCriteria("titulo"));
	}
	
	public Carta uniqueCarta(PersistentSession session) {
		return (Carta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Carta[] listCarta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Carta[]) list.toArray(new Carta[list.size()]);
	}
}

