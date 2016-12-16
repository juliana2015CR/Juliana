package orkut.controller;

import java.util.ArrayList;
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

import orkut.form.AmizadeCheckBoxForm;
import orkut.model.Amizade;
import orkut.util.AulaFileUtil;
import orkut.DAO.IAmizadeDAO;
import orkut.DAO.IUsuarioDAO;
import orkut.DAO.UsuarioDAOHibernate;
import orkut.model.Usuario;

@Controller
@Transactional
public class UsuarioController {

	@Autowired
	@Qualifier(value = "amizadeDAOHibernate")
	private IAmizadeDAO amizadeDAO;

	@Autowired
	@Qualifier(value = "usuarioDAOHibernate")
	private IUsuarioDAO usuarioDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario() {
		return "usuarios/inserir_usuario_formulario";
	}

	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usuario,
			@RequestParam(value = "image", required = false) MultipartFile image) {

		if (image != null && !image.isEmpty()) {
			String path = context.getRealPath("/");
			path += "resources/images/" + usuario.getLogin() + ".png";
			AulaFileUtil.saveFile(path, image);

		}

		// confirmar senha
		String t1 = usuario.getSenha();
		String t2 = usuario.getConfsenha();
		if (t1.equals(t2)) {
			usuario.setSenha(DigestUtils.md5Hex(usuario.getSenha()));
			usuario.setConfsenha(DigestUtils.md5Hex(usuario.getConfsenha()));

			usuarioDAO.inserir(usuario);
			return "redirect:loginFormulario";
		}
		return "redirect:inserirUsuarioFormulario";

	}

	// listar
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model) {
		List<Usuario> usuarios = usuarioDAO.listar();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/listar_usuario";
	}

	@RequestMapping("/listarEu")
	public String listarEu(HttpSession session, Model model) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		usuarios.add(u);

		model.addAttribute("usuarios", usuarios);
		return "usuarios/listar_eu";
	}

	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long usuId) {
		usuarioDAO.apagar(usuId);
		return "redirect:/";

	}

	// alterar
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long usuId, Model model) {
		Usuario u = usuarioDAO.recuperar(usuId);
		model.addAttribute("usuario", u);
		return "usuarios/alterar_usuario_formulario";

	}

	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario u,
			@RequestParam(value = "image", required = false) MultipartFile image) {

		if (image != null && !image.isEmpty()) {
			String path = context.getRealPath("/");
			path += "resources/images/" + u.getLogin() + ".png";
			AulaFileUtil.saveFile(path, image);

		}

		// confirmar senha
		String t1 = u.getSenha();
		String t2 = u.getConfsenha();
		if (t1.equals(t2)) {
			u.setSenha(DigestUtils.md5Hex(u.getSenha()));
			u.setConfsenha(DigestUtils.md5Hex(u.getConfsenha()));

			usuarioDAO.atualizar(u);
			return "redirect:listarEu";
		}
		return "redirect:alterarUsuarioFormulario";

	}

	@RequestMapping("/inserirAmizadeFormulario")
	public String inserirAmizadeFormulario(HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
		List<Usuario> potenciaisAmigos = usuarioDAO.listar();
		potenciaisAmigos.remove(usuario);

		AmizadeCheckBoxForm acf = new AmizadeCheckBoxForm();
		List<Amizade> minhasAmizades = this.amizadeDAO
				.listarAmizadesDeId(usuario.getUsuId());
		if (minhasAmizades != null && minhasAmizades.size() > 0) {

			for (Amizade amizade : minhasAmizades) {
				Long amigoId = amizade.getUsuarioAlvo().getUsuId();
				Usuario amigoTemp = new Usuario();
				amigoTemp.setUsuId(amigoId);
				potenciaisAmigos.remove(amigoTemp);

			}
		}

		model.addAttribute("usuario", usuario);
		model.addAttribute("potenciais_amigos", potenciaisAmigos);
		model.addAttribute("amizade", acf);
		return "usuarios/inserir_amizade_formulario";

	}

	@RequestMapping("/inserirAmizade")
	public String inserirAmizade(HttpSession session,
			AmizadeCheckBoxForm amizades) {
		Usuario amigoFonte = (Usuario) session.getAttribute("usuario_logado");
		for (Long usuId : amizades.getAmigos()) {

			Usuario amigoAlvo = usuarioDAO.recuperar(usuId);
			Amizade amizade = new Amizade();
			amizade.setUsuarioFonte(amigoFonte);
			amizade.setUsuarioAlvo(amigoAlvo);

			amizadeDAO.inserir(amizade);
		}
		return "redirect:listarAmigos";
	}

	@RequestMapping("/verPerfil")
	public String verPerfil(Model model, Long id) {
		Usuario u = usuarioDAO.recuperar(id);
		model.addAttribute("perfil", u);
		return "usuarios/perfil_usuario";
	}
	
	@RequestMapping("/Menu")
	public String Menu() {
		
		return "menu";
	}
}
