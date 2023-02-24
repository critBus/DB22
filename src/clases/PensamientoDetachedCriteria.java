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

public class PensamientoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression contenido;
	public final StringExpression palabrasClave;
	public final StringExpression nombre;
	
	public PensamientoDetachedCriteria() {
		super(clases.Pensamiento.class, clases.PensamientoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		palabrasClave = new StringExpression("palabrasClave", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
	}
	
	public PensamientoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.PensamientoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		palabrasClave = new StringExpression("palabrasClave", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
	}
	
	public TemaDetachedCriteria createTemaCriteria() {
		return new TemaDetachedCriteria(createCriteria("tema"));
	}
	
	public PTDetachedCriteria createPTCriteria() {
		return new PTDetachedCriteria(createCriteria("ORM_PT"));
	}
	
	public Pensamiento uniquePensamiento(PersistentSession session) {
		return (Pensamiento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pensamiento[] listPensamiento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pensamiento[]) list.toArray(new Pensamiento[list.size()]);
	}
}

