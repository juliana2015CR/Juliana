package orkut.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import orkut.DAO.ICategoriaDAO;
import orkut.DAO.IComunidadeDAO;
import orkut.DAO.IForumDAO;
import orkut.DAO.IUsuarioDAO;
import orkut.form.AmizadeCheckBoxForm;
import orkut.model.Album;
import orkut.model.Amizade;
import orkut.model.Categoria;
import orkut.model.Comunidade;
import orkut.model.Forum;
import orkut.model.Usuario;
import orkut.util.AulaFileUtil;

@Controller
@Transactional
public class ForumController {
	@Autowired
	@Qualifier(value = "forumDAOHibernate")
	private IForumDAO forumDAO;

	@Autowired
	@Qualifier(value = "comunidadeDAOHibernate")
	private IComunidadeDAO comunidadeDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/inserirForumFormulario")
	// links
	public String inserirForumFormulario(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		List<Comunidade> comunidade = u.getComunidades();
		model.addAttribute("comunidade", comunidade);
		return "forum/inserir_forum_formulario";
	}

	@RequestMapping("/inserirForum")
	public String inserirForum(Forum forum, HttpSession session) {

		Comunidade c = comunidadeDAO.recuperar(forum.getComid());
		forum.setComunidade(c);
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		forum.setUsuId(u.getUsuId());
		forum.setLogin(u.getLogin());
		forumDAO.inserir(forum);
		return "redirect:listarMinhasComunidades";

	}

	@RequestMapping("/listarForum")
	public String listarForum(Model model, Long id) {
		List<Forum> forum = comunidadeDAO.listarF(id);
		model.addAttribute("forum", forum);
		return "forum/listar_forum";
	}

	@RequestMapping("/apagarForum")
	public String apagarForum(Long forId) {
		forumDAO.apagar(forId);
		return "redirect:listarMinhasComunidades";

	}

}
