package orkut.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import orkut.DAO.IAlbumDAO;
import orkut.DAO.IAmizadeDAO;
import orkut.DAO.IUsuarioDAO;
import orkut.model.Album;
import orkut.model.Amizade;
import orkut.model.Usuario;
import orkut.DAO.UsuarioDAOHibernate;

@Controller
@Transactional
public class AmizadeController {

	@Autowired
	@Qualifier(value = "amizadeDAOHibernate")
	private IAmizadeDAO amizadeDAO;

	@Autowired
	@Qualifier(value = "usuarioDAOHibernate")
	private IUsuarioDAO usuarioDAO;

	@Autowired
	@Qualifier(value = "albumDAOHibernate")
	private IAlbumDAO albumDAO;
	
	@Autowired
	private ServletContext context;

	
	@RequestMapping("/listarAmigos")
	public String listarAmigos(HttpSession session, Model model) {
		Usuario u = (Usuario) session.getAttribute("usuario_logado");

		List<Amizade> amigos = this.amizadeDAO.listarAmizadesDeId(u.getUsuId());
		List<Usuario> usuarios = new ArrayList<Usuario>();

		for (Amizade a : amigos) {
			Long amigoId = a.getUsuarioAlvo().getUsuId();
			Usuario usuario = usuarioDAO.recuperar(amigoId);
			usuarios.add(usuario);
		}

		model.addAttribute("amizades", usuarios);
		return "usuarios/listar_amigos";
	}
	

}