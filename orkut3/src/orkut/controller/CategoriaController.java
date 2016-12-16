package orkut.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import orkut.DAO.ICategoriaDAO;
import orkut.model.Categoria;

@Controller
@Transactional
public class CategoriaController {

	@Autowired
	@Qualifier(value = "categoriaDAOHibernate")
	private ICategoriaDAO categoriaDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/listarCategorias")
	public String listarCategorias(Model model) {
		List<Categoria> categoria = categoriaDAO.listar();
		model.addAttribute("categorias", categoria);
		return "categorias/listar_categorias";
	}

}
