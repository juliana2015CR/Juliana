package orkut.DAO;

import java.util.List;

import orkut.model.Mensagem;

public interface IMensagemDAO {
	public void inserir(Mensagem mensagem);
	public void atualizar(Mensagem mensagem);
	public Mensagem recuperar(Long menId);

	public Mensagem recuperar(String texto);
	public List<Mensagem> listar();
	public void apagar(Long menId);
}
