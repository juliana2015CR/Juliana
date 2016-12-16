package orkut.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import orkut.model.Forum;
import orkut.model.Mensagem;
@Repository
public class MensagemDAOHibernate implements IMensagemDAO {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Mensagem mensagem) {
		manager.persist(mensagem);
		
	}

	@Override
	public void atualizar(Mensagem mensagem) {
		manager.merge(mensagem);
		
	}

	@Override
	public Mensagem recuperar(Long menId) {
		return manager.find(Mensagem.class, menId);
		
	}

	

	@Override
	public Mensagem recuperar(String texto) {
		String hql = "select m from MENSAGEM as m "
				+ "where m.texto =:var_texto";
		Query query = manager.createQuery(hql, Mensagem.class);
		query.setParameter("var_texto", texto);
		List<Mensagem> mensagem = query.getResultList();

		if (mensagem != null && !mensagem.isEmpty()) {
			return mensagem.get(0);
		}

		return null;
	}

	@Override
	public List<Mensagem> listar() {
		String hql = "select m from MENSAGEM as m";

		return manager.createQuery(hql, Mensagem.class).getResultList();

	}

	@Override
	public void apagar(Long menId) {
		Mensagem m = this.recuperar(menId);
		manager.remove(m);
	}

}
