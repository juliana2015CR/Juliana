package orkut.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import orkut.model.Comunidade;
import orkut.model.Forum;
import orkut.model.Mensagem;

@Repository

public class ForumDAOHibernate implements IForumDAO{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Forum forum) {
		manager.persist(forum);		
	}

	@Override
	public void atualizar(Forum forum) {
		manager.merge(forum);
	}

	@Override
	public Forum recuperar(Long forId) {
		return manager.find(Forum.class, forId);
		
	}

	@Override
	public Forum recuperarMensagem(Long menId) {
		return manager.find(Forum.class, menId);
		
	}

	@Override
	public Forum recuperar(String titulo) {
		String hql = "select f from FORUM as f "
				+ "where f.titulo =:var_titulo";
		Query query = manager.createQuery(hql, Forum.class);
		query.setParameter("var_titulo", titulo);
		List<Forum> forum = query.getResultList();

		if (forum != null && !forum.isEmpty()) {
			return forum.get(0);
		}

		return null;
	}
	@Override
	public List<Forum> listar() {
		String hql = "select ca from FORUM as ca";

		return manager.createQuery(hql, Forum.class).getResultList();

	}

	@Override
	public List<Mensagem> listarM(Long id) {
		String hql = "select a from MENSAGEM as a where forId = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);
		
		return query.getResultList();

	}
	
	@Override
	public List<Forum> listarF(Long id) {
		String hql = "select a from FORUM as a where comid = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);
		
		return query.getResultList();

	}


	@Override
	public void apagar(Long forId) {
		Forum f = this.recuperar(forId);
		manager.remove(f);
		
	}

}
