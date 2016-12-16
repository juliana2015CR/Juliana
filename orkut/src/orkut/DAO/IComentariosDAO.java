package orkut.DAO;

import java.util.List;

import orkut.model.Comentarios;

public interface IComentariosDAO {
	public void inserir(Comentarios comentarios);
	
	public Comentarios recuperar(Long comeid);

	public Comentarios recuperar(String texto);
	public List<Comentarios> listar();
	public void apagar(Long comeid);
}
