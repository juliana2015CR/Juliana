package orkut.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Repository;

import orkut.model.OrkutQuixada;
import orkut.model.Usuario;

@Repository
public class UsuarioDAOHibernate implements IUsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Usuario usuario) {
		OrkutQuixada o = new OrkutQuixada();
		o.setOrkid(1L);
		usuario.setOrkutquixada(o);
		manager.persist(usuario);

	}
	
	
	
	@Override
	public void atualizar(Usuario usuario) {
		OrkutQuixada o = new OrkutQuixada();
		o.setOrkid(1L);
		usuario.setOrkutquixada(o);
		manager.merge(usuario);

	}

	@Override
	public Usuario recuperar(Long usuId) {
		return manager.find(Usuario.class, usuId);

	}

	@Override
	public Usuario recuperar(String login) {
		String hql = "select u from USUARIO as u "
				+ "where u.login =:var_login";
		Query query = manager.createQuery(hql, Usuario.class);
		query.setParameter("var_login", login);
		List<Usuario> usuarios = query.getResultList();

		if (usuarios != null && !usuarios.isEmpty()) {
			return usuarios.get(0);
		}

		return null;
	}

	@Override
	public List<Usuario> listar() {
		String hql = "select u from USUARIO as u";

		return manager.createQuery(hql, Usuario.class).getResultList();

	}

	public List<Usuario> listarComunidade() {
		String hql = "select c from USUARIO_COMUNIDADES as c";

		return manager.createQuery(hql, Usuario.class).getResultList();

	}

	@Override
	public void apagar(Long usuId) {
		Usuario u = this.recuperar(usuId);
		manager.remove(u);

	}
}
