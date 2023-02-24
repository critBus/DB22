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

public class TituloDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final DateExpression fecha;
	
	public TituloDetachedCriteria() {
		super(clases.Titulo.class, clases.TituloCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
	}
	
	public TituloDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, clases.TituloCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
	}
	
	public AutorDetachedCriteria createAutorCriteria() {
		return new AutorDetachedCriteria(createCriteria("ORM_Autor"));
	}
	
	public LibroDetachedCriteria createLibroCriteria() {
		return new LibroDetachedCriteria(createCriteria("libro"));
	}
	
	public DisponibilidadDetachedCriteria createDisponibilidadCriteria() {
		return new DisponibilidadDetachedCriteria(createCriteria("ORM_Disponibilidad"));
	}
	
	public ArticuloDetachedCriteria createArticuloCriteria() {
		return new ArticuloDetachedCriteria(createCriteria("articulo"));
	}
	
	public CartaDetachedCriteria createCartaCriteria() {
		return new CartaDetachedCriteria(createCriteria("carta"));
	}
	
	public PTDetachedCriteria createPTCriteria() {
		return new PTDetachedCriteria(createCriteria("ORM_PT"));
	}
	
	public Titulo uniqueTitulo(PersistentSession session) {
		return (Titulo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Titulo[] listTitulo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Titulo[]) list.toArray(new Titulo[list.size()]);
	}
}

