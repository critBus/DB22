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

public class ProfesorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression especializacion;
	
	public ProfesorDetachedCriteria() {
		super(clases.Profesor.class, clases.ProfesorCriteria.class);
		especializacion = new StringExpression("especializacion", this.getDetachedCriteria());
	}
	
	public ProfesorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.ProfesorCriteria.class);
		especializacion = new StringExpression("especializacion", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createUsuarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario"));
	}
	
	public Profesor uniqueProfesor(PersistentSession session) {
		return (Profesor) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Profesor[] listProfesor(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Profesor[]) list.toArray(new Profesor[list.size()]);
	}
}

