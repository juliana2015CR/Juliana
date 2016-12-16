package orkut.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import orkut.model.OrkutQuixada;
import orkut.model.Usuario;

@Repository
public class OrkutQuixadaDAOHibernate implements IOrkutQuixadaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(OrkutQuixada orkutquixada) {
		// TODO Auto-generated method stub
		manager.persist(orkutquixada);
	}

	@Override
	public OrkutQuixada recuperar(Long orkid) {
		return manager.find(OrkutQuixada.class, orkid);

	}
	
	
	@Override
	public OrkutQuixada recuperar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrkutQuixada> listar() {
		String hql = "select o from ORKUT_QUIXADA as o";

		return manager.createQuery(hql, OrkutQuixada.class).getResultList();

	
	}

}
