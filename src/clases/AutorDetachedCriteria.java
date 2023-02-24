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

public class AutorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final DateExpression fecha_Nacimiento;
	public final DateExpression fecha_Muerte;
	
	public AutorDetachedCriteria() {
		super(clases.Autor.class, clases.AutorCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		fecha_Nacimiento = new DateExpression("fecha_Nacimiento", this.getDetachedCriteria());
		fecha_Muerte = new DateExpression("fecha_Muerte", this.getDetachedCriteria());
	}
	
	public AutorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.AutorCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		fecha_Nacimiento = new DateExpression("fecha_Nacimiento", this.getDetachedCriteria());
		fecha_Muerte = new DateExpression("fecha_Muerte", this.getDetachedCriteria());
	}
	
	public TituloDetachedCriteria createTituloCriteria() {
		return new TituloDetachedCriteria(createCriteria("ORM_Titulo"));
	}
	
	public Autor uniqueAutor(PersistentSession session) {
		return (Autor) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Autor[] listAutor(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Autor[]) list.toArray(new Autor[list.size()]);
	}
}

