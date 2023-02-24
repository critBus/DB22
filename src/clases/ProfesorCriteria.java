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

public class ProfesorCriteria extends AbstractORMCriteria {
	public final StringExpression especializacion;
	
	public ProfesorCriteria(Criteria criteria) {
		super(criteria);
		especializacion = new StringExpression("especializacion", this);
	}
	
	public ProfesorCriteria(PersistentSession session) {
		this(session.createCriteria(Profesor.class));
	}
	
	public ProfesorCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createUsuarioCriteria() {
		return new UsuarioCriteria(createCriteria("usuario"));
	}
	
	public Profesor uniqueProfesor() {
		return (Profesor) super.uniqueResult();
	}
	
	public Profesor[] listProfesor() {
		java.util.List list = super.list();
		return (Profesor[]) list.toArray(new Profesor[list.size()]);
	}
}

