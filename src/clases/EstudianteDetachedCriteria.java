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

public class EstudianteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression curso;
	public final StringExpression carrera;
	public final IntegerExpression identificador;
	
	public EstudianteDetachedCriteria() {
		super(clases.Estudiante.class, clases.EstudianteCriteria.class);
		curso = new IntegerExpression("curso", this.getDetachedCriteria());
		carrera = new StringExpression("carrera", this.getDetachedCriteria());
		identificador = new IntegerExpression("identificador", this.getDetachedCriteria());
	}
	
	public EstudianteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.EstudianteCriteria.class);
		curso = new IntegerExpression("curso", this.getDetachedCriteria());
		carrera = new StringExpression("carrera", this.getDetachedCriteria());
		identificador = new IntegerExpression("identificador", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createUsuarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario"));
	}
	
	public Estudiante uniqueEstudiante(PersistentSession session) {
		return (Estudiante) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Estudiante[] listEstudiante(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Estudiante[]) list.toArray(new Estudiante[list.size()]);
	}
}

