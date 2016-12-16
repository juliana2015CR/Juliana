package orkut.DAO;

import java.util.List;

import orkut.model.OrkutQuixada;

public interface IOrkutQuixadaDAO {

	public void inserir(OrkutQuixada orkutquixada);
	public OrkutQuixada recuperar(Long orkid);
	public OrkutQuixada recuperar(String nome);
	public List<OrkutQuixada> listar();
}
