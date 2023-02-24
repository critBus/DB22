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

public class DisponibilidadCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression ubicacion;
	
	public DisponibilidadCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		ubicacion = new StringExpression("ubicacion", this);
	}
	
	public DisponibilidadCriteria(PersistentSession session) {
		this(session.createCriteria(Disponibilidad.class));
	}
	
	public DisponibilidadCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public TituloCriteria createTituloCriteria() {
		return new TituloCriteria(createCriteria("titulo"));
	}
	
	public Disponibilidad uniqueDisponibilidad() {
		return (Disponibilidad) super.uniqueResult();
	}
	
	public Disponibilidad[] listDisponibilidad() {
		java.util.List list = super.list();
		return (Disponibilidad[]) list.toArray(new Disponibilidad[list.size()]);
	}
}

