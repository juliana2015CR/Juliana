package orkut.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import orkut.model.Comentarios;

@Repository
public class ComentariosDAOHibernate implements IComentariosDAO {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Comentarios comentarios) {
		manager.persist(comentarios);
		
	}

	@Override
	public Comentarios recuperar(Long comeid) {
		return manager.find(Comentarios.class, comeid);
		
	}

	@Override
	public Comentarios recuperar(String texto) {
		String hql = "select c from COMENTARIOS as c "
				+ "where c.texto =:var_texto";
		Query query = manager.createQuery(hql, Comentarios.class);
		query.setParameter("var_texto", texto);
		List<Comentarios> comentarios = query.getResultList();

		if (comentarios != null && !comentarios.isEmpty()) {
			return comentarios.get(0);
		}

		return null;
	}

	@Override
	public List<Comentarios> listar() {
		String hql = "select c from COMENTARIOS as c";

		return manager.createQuery(hql, Comentarios.class).getResultList();

	}

	@Override
	public void apagar(Long comeid) {
		Comentarios c = this.recuperar(comeid);
		manager.remove(c);
	}

}
