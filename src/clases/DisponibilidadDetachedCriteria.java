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

public class DisponibilidadDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression ubicacion;
	
	public DisponibilidadDetachedCriteria() {
		super(clases.Disponibilidad.class, clases.DisponibilidadCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		ubicacion = new StringExpression("ubicacion", this.getDetachedCriteria());
	}
	
	public DisponibilidadDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.DisponibilidadCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		ubicacion = new StringExpression("ubicacion", this.getDetachedCriteria());
	}
	
	public TituloDetachedCriteria createTituloCriteria() {
		return new TituloDetachedCriteria(createCriteria("titulo"));
	}
	
	public Disponibilidad uniqueDisponibilidad(PersistentSession session) {
		return (Disponibilidad) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Disponibilidad[] listDisponibilidad(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Disponibilidad[]) list.toArray(new Disponibilidad[list.size()]);
	}
}

