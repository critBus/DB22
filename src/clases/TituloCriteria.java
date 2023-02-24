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

public class TituloCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final DateExpression fecha;
	
	public TituloCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nombre = new StringExpression("nombre", this);
		fecha = new DateExpression("fecha", this);
	}
	
	public TituloCriteria(PersistentSession session) {
		this(session.createCriteria(Titulo.class));
	}
	
	public TituloCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public AutorCriteria createAutorCriteria() {
		return new AutorCriteria(createCriteria("ORM_Autor"));
	}
	
	public LibroCriteria createLibroCriteria() {
		return new LibroCriteria(createCriteria("libro"));
	}
	
	public DisponibilidadCriteria createDisponibilidadCriteria() {
		return new DisponibilidadCriteria(createCriteria("ORM_Disponibilidad"));
	}
	
	public ArticuloCriteria createArticuloCriteria() {
		return new ArticuloCriteria(createCriteria("articulo"));
	}
	
	public CartaCriteria createCartaCriteria() {
		return new CartaCriteria(createCriteria("carta"));
	}
	
	public PTCriteria createPTCriteria() {
		return new PTCriteria(createCriteria("ORM_PT"));
	}
	
	public Titulo uniqueTitulo() {
		return (Titulo) super.uniqueResult();
	}
	
	public Titulo[] listTitulo() {
		java.util.List list = super.list();
		return (Titulo[]) list.toArray(new Titulo[list.size()]);
	}
}

