package orkut.DAO;

import java.util.List;

import orkut.model.Forum;
import orkut.model.Mensagem;

public interface IForumDAO {
	public void inserir(Forum forum);
	public void atualizar(Forum forum);
	public Forum recuperar(Long forId);
	public Forum recuperarMensagem(Long menId);

	public Forum recuperar(String titulo);
	public void apagar(Long forId);
	public List<Forum> listarF(Long id);
	public List<Forum> listar();
	List<Mensagem> listarM(Long id);
}
