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

public class ArticuloCriteria extends AbstractORMCriteria {
	public final IntegerExpression volumen;
	public final StringExpression publicacion;
	
	public ArticuloCriteria(Criteria criteria) {
		super(criteria);
		volumen = new IntegerExpression("volumen", this);
		publicacion = new StringExpression("publicacion", this);
	}
	
	public ArticuloCriteria(PersistentSession session) {
		this(session.createCriteria(Articulo.class));
	}
	
	public ArticuloCriteria() throws PersistentException {
		this(clases.DB22PersistentManager.instance().getSession());
	}
	
	public TituloCriteria createTituloCriteria() {
		return new TituloCriteria(createCriteria("titulo"));
	}
	
	public Articulo uniqueArticulo() {
		return (Articulo) super.uniqueResult();
	}
	
	public Articulo[] listArticulo() {
		java.util.List list = super.list();
		return (Articulo[]) list.toArray(new Articulo[list.size()]);
	}
}

