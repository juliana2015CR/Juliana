package orkut.DAO;

import java.util.List;

import orkut.model.Album;
import orkut.model.Forum;
import orkut.model.Fotos;

public interface IAlbumDAO {
	public void inserir(Album album);
	public Album recuperar(Long alid);
	public List<Album> listar(Long id);
	public Album recuperar(String nome);
	public List<Fotos> listarF(Long alid);
	public void apagar(Long alid);
	List<Album> listarT();
}
