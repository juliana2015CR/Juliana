package orkut.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import orkut.model.Album;
import orkut.model.Fotos;
import orkut.model.Mensagem;

@Repository
public class AlbumDAOHibernate implements IAlbumDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Album album) {
		manager.persist(album);
	}
	
	@Override
	public void apagar(Long alid) {
		Album a = this.recuperar(alid);
		manager.remove(a);
		
	}

	@Override
	public Album recuperar(Long alid) {
		return manager.find(Album.class, alid);
	}

	@Override
	public List<Album> listar(Long id) {
		String hql = "select a from ALBUM as a where usuId = :var";
		Query query = manager.createQuery(hql);
		query.setParameter("var", id);
		return query.getResultList();
		
	}
	
	@Override
	public List<Album> listarT() {
		String hql = "select a from ALBUM as a";
		return manager.createQuery(hql, Album.class).getResultList();

		
	}
	@Override
	public List<Fotos> listarF(Long alid) {
		String hql = "select a from FOTOS as a where alid = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", alid);
		
		return query.getResultList();

	}

	@Override
	public Album recuperar(String nome) {
		String hql = "select f from ALBUM as f "
				+ "where u.nome =:var_nome";
		Query query = manager.createQuery(hql, Album.class);
		query.setParameter("var_nome", nome);
		List<Album> album = query.getResultList();

		if (album != null && !album.isEmpty()) {
			return album.get(0);
		}

		return null;
	}
	}
