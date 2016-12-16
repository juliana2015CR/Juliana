package orkut.DAO;

import java.util.List;

import orkut.model.Amizade;
import orkut.model.Usuario;

public interface IAmizadeDAO {
	public void inserir(Amizade amizade);
	public List<Amizade> listarAmizadesDeId(Long id);
	public boolean existeAmizade(Amizade amizade);
	public List<Amizade> listarAmigos();
	void apagar(Long id);
	Amizade recuperar(Long id);
}
