package orkut.DAO;

import java.util.List;

import orkut.model.Comunidade;
import orkut.model.Usuario;


public interface IUsuarioDAO {
	public void inserir(Usuario usuario);
	public void atualizar(Usuario usuario);
	public Usuario recuperar(Long usuid);
	public Usuario recuperar(String login);
	public List<Usuario> listar();
	public void apagar(Long id);
	public List<Usuario> listarComunidade();

}
