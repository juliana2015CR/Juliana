package orkut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import orkut.DAO.IOrkutQuixadaDAO;
import orkut.model.OrkutQuixada;

@Controller
@Transactional
public class OrkutQuixadaController {
	@Autowired
	@Qualifier(value = "orkutquixadaDAOHibernate")
	private IOrkutQuixadaDAO orkutquixadaDAO;

	@RequestMapping("/inserirOrkutQuixadaFormulario")
	// links
	public String inserirOrkutQuixadaFormulario() {
		return "orkutquixada/inserir_orkutquixada_formulario";
	}

	@RequestMapping("/inserirOrkutQuixada")
	public String inserirOrkutQuixada(OrkutQuixada orkutquixada) {
		orkutquixadaDAO.inserir(orkutquixada);
		return "orkutquixada/inserir_ok";
	}

}
