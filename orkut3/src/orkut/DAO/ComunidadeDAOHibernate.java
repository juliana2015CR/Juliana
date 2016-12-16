package orkut.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import orkut.controller.ComunidadeController;
import orkut.model.Categoria;
import orkut.model.Comunidade;
import orkut.model.Forum;
import orkut.model.OrkutQuixada;
import orkut.model.Usuario;

@Repository
public class ComunidadeDAOHibernate implements IComunidadeDAO {

	@Autowired
	@Qualifier(value="categoriaDAOHibernate")
	private ICategoriaDAO categoriaDAO;
	
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Comunidade comunidade) {
		OrkutQuixada o = new OrkutQuixada();
		o.setOrkid(1L);
		comunidade.setOrkutquixada(o);
		
		manager.persist(comunidade);
	}
	
	@Override
	public void atualizar(Comunidade comunidade) {
		OrkutQuixada o = new OrkutQuixada();
		o.setOrkid(1L);
		comunidade.setOrkutquixada(o);
	
		
		manager.merge(comunidade);

	}
	
	

	@Override
	public Comunidade recuperar(Long comid) {
		return manager.find(Comunidade.class, comid);

	}
	@Override
	public Comunidade recuperarCategoria(Long catid) {
		return manager.find(Comunidade.class, catid);

	}
	
	@Override
	public Comunidade recuperar(String nome) {
		String hql = "select c from COMUNIDADE as c "
				+ "where c.nome =:var_nome";
		Query query = manager.createQuery(hql, Comunidade.class);
		query.setParameter("var_nome", nome);
		List<Comunidade> comunidade = query.getResultList();

		if (comunidade != null && !comunidade.isEmpty()) {
			return comunidade.get(0);
		}

		return null;
	}

	
	@Override
	public List<Comunidade> listar() {
		String hql = "select c from COMUNIDADE as c";

		return manager.createQuery(hql, Comunidade.class).getResultList();
	}

	
	
	@Override
	public void apagar(Long comid) {
		Comunidade c = this.recuperar(comid);
		manager.remove(c);

	}

	
	@Override
	public List<Forum> listarF(Long id) {
		String hql = "select a from FORUM as a where comid = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);
		
		return query.getResultList();

	}
	

	

}
