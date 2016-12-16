package orkut.DAO;

import java.util.List;

import orkut.model.Comunidade;
import orkut.model.Forum;


public interface IComunidadeDAO {
	public void inserir(Comunidade comunidade);
	public void atualizar(Comunidade comunidade);
	public Comunidade recuperar(Long comid);
	public Comunidade recuperarCategoria(Long catid);

	public Comunidade recuperar(String nome);
	public List<Comunidade> listar();
	public void apagar(Long comid);
	List<Forum> listarF(Long id);
}
