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

import orkut.DAO.IComunidadeDAO;
import orkut.DAO.IForumDAO;
import orkut.DAO.IMensagemDAO;
import orkut.model.Album;
import orkut.model.Comunidade;
import orkut.model.Forum;
import orkut.model.Fotos;
import orkut.model.Mensagem;
import orkut.model.Usuario;

@Controller
@Transactional
public class MensagemController {

	@Autowired
	@Qualifier(value = "forumDAOHibernate")
	private IForumDAO forumDAO;

	@Autowired
	@Qualifier(value = "mensagemDAOHibernate")
	private IMensagemDAO mensagemDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/inserirMensagemFormulario")
	// links
	public String inserirMensagemFormulario(Model model, HttpSession session,
			Long id) {

		Forum forum = forumDAO.recuperar(id);
		session.setAttribute("forum", forum);
		return "mensagem/inserir_mensagem_formulario";
	}

	@RequestMapping("/inserirMensagem")
	public String inserirMensagem(HttpSession session, Mensagem mensagem) {

		Forum f = (Forum) session.getAttribute("forum");
		mensagem.setForum(f);
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		mensagem.setUsuId(u.getUsuId());
		mensagem.setLogin(u.getLogin());

		mensagemDAO.inserir(mensagem);

		return "redirect:listarMinhasComunidades";

	}

	@RequestMapping("/listarMensagem")
	public String listarMensagem(Model model, Long id) {
		List<Mensagem> mensagem = forumDAO.listarM(id);
		model.addAttribute("mensagem", mensagem);
		return "mensagem/listar_mensagem";
	}

	@RequestMapping("/apagarMensagem")
	public String apagarMensagem(Long menId) {
		mensagemDAO.apagar(menId);
		return "redirect:listarMinhasComunidades";

	}

}
