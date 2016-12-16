package orkut.DAO;

import java.util.List;

import orkut.model.Comentarios;
import orkut.model.Fotos;

public interface IFotosDAO {
	public void inserir(Fotos fotos);
	
	public Fotos recuperar(Long fotid);
	public Fotos recuperarComentario(Long comeid);

	public Fotos recuperar(String legenda);
	public void apagar(Long fotid);
	public List<Fotos> listarF(Long id);
	public List<Fotos> listar();
	public List<Comentarios> listarC(Long id);
}
