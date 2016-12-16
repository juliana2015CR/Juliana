package orkut.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import orkut.model.Comentarios;

import orkut.model.Fotos;


@Repository
public class FotosDAOHibernate implements IFotosDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Fotos fotos) {
		manager.persist(fotos);
	}

	@Override
	public Fotos recuperar(Long fotid) {
		return manager.find(Fotos.class, fotid);
	}

	@Override
	public List<Fotos> listar() {
		String hql = "select f from FOTOS as f";
		return manager.createQuery(hql, Fotos.class).getResultList();
		
	}
	@Override
	public Fotos recuperar(String legenda) {
		String hql = "select f from FOTOS as f "
				+ "where u.legenda =:var_legenda";
		Query query = manager.createQuery(hql, Fotos.class);
		query.setParameter("var_legenda", legenda);
		List<Fotos> fotos = query.getResultList();

		if (fotos != null && !fotos.isEmpty()) {
			return fotos.get(0);
		}

		return null;
	}
	
	@Override
	public List<Comentarios> listarC(Long id) {
		String hql = "select a from COMENTARIOS as a where fotid = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);
		
		return query.getResultList();

	}

	@Override
	public Fotos recuperarComentario(Long comeid) {
		return manager.find(Fotos.class, comeid);
	}

	@Override
	public void apagar(Long fotid) {
		Fotos f = this.recuperar(fotid);
		manager.remove(f);
		
	}

	@Override
	public List<Fotos> listarF(Long id) {
		String hql = "select a from FOTOS as a where alid = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);
		
		return query.getResultList();
	}

}
