package orkut.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import orkut.DAO.IComentariosDAO;
import orkut.DAO.IFotosDAO;
import orkut.model.Comentarios;
import orkut.model.Forum;
import orkut.model.Fotos;
import orkut.model.Mensagem;
import orkut.model.Usuario;

@Controller
@Transactional
public class ComentariosController {
	@Autowired
	@Qualifier(value = "comentariosDAOHibernate")
	private IComentariosDAO comentariosDAO;

	// não esquecer das anotações
	@Autowired
	@Qualifier(value = "fotosDAOHibernate")
	private IFotosDAO fotosDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(HttpSession session, Long id) {
		Fotos foto = fotosDAO.recuperar(id);
		session.setAttribute("foto", foto);
		return "comentarios/inserir_comentario_formulario";
	}

	@RequestMapping("/inserirComentario")
	public String inserirComentario(Comentarios comentarios, HttpSession session) {
		Fotos f = (Fotos) session.getAttribute("foto");
		comentarios.setFotos(f);
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		comentarios.setUsuId(u.getUsuId());
		comentarios.setLogin(u.getLogin());
		comentariosDAO.inserir(comentarios);
		return "redirect:listarAlbuns";
	}

	@RequestMapping("/listarComentarios")
	public String listarComentarios(Model model, Long id) {
		List<Comentarios> comentarios = fotosDAO.listarC(id);
		model.addAttribute("comentarios", comentarios);
		return "comentarios/listar_comentarios";
	}

}
