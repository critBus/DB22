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

public class AutorCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final DateExpression fecha_Nacimiento;
	public final DateExpression fecha_Muerte;
	
	public AutorCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nombre = new StringExpression("nombre", this);
		fecha_Nacimiento = new DateExpression("fecha_Nacimiento", this);
		fecha_Muerte = new DateExpression("fecha_Muerte", this);
	}
	
	public AutorCriteria(PersistentSession session) {
		this(session.createCriteria(Autor.class));
	}
	
	public AutorCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public TituloCriteria createTituloCriteria() {
		return new TituloCriteria(createCriteria("ORM_Titulo"));
	}
	
	public Autor uniqueAutor() {
		return (Autor) super.uniqueResult();
	}
	
	public Autor[] listAutor() {
		java.util.List list = super.list();
		return (Autor[]) list.toArray(new Autor[list.size()]);
	}
}

