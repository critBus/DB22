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

public class ArticuloDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression volumen;
	public final StringExpression publicacion;
	
	public ArticuloDetachedCriteria() {
		super(clases.Articulo.class, clases.ArticuloCriteria.class);
		volumen = new IntegerExpression("volumen", this.getDetachedCriteria());
		publicacion = new StringExpression("publicacion", this.getDetachedCriteria());
	}
	
	public ArticuloDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.ArticuloCriteria.class);
		volumen = new IntegerExpression("volumen", this.getDetachedCriteria());
		publicacion = new StringExpression("publicacion", this.getDetachedCriteria());
	}
	
	public TituloDetachedCriteria createTituloCriteria() {
		return new TituloDetachedCriteria(createCriteria("titulo"));
	}
	
	public Articulo uniqueArticulo(PersistentSession session) {
		return (Articulo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Articulo[] listArticulo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Articulo[]) list.toArray(new Articulo[list.size()]);
	}
}

