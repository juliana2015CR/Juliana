package orkut.controller;

import java.util.ArrayList;
import java.util.Collection;
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
import orkut.DAO.IUsuarioDAO;
import orkut.form.AmizadeCheckBoxForm;
import orkut.model.Album;
import orkut.model.Amizade;
import orkut.model.Categoria;
import orkut.model.Comunidade;
import orkut.model.Fotos;
import orkut.model.Usuario;
import orkut.util.AulaFileUtil;

@Controller
@Transactional
public class ComunidadeController {

	@Autowired
	@Qualifier(value = "comunidadeDAOHibernate")
	private IComunidadeDAO comunidadeDAO;

	@Autowired
	@Qualifier(value = "categoriaDAOHibernate")
	private ICategoriaDAO categoriaDAO;

	@Autowired
	@Qualifier(value = "usuarioDAOHibernate")
	private IUsuarioDAO usuarioDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/inserirComunidadeFormulario")
	// links
	public String inserirComunidadeFormulario(Model model) {
		List<Categoria> categoria = categoriaDAO.listar();
		model.addAttribute("categoria", categoria);

		return "comunidades/inserir_comunidade_formulario";
	}

	@RequestMapping("/inserirComunidade")
	public String inserirComunidade(HttpSession session, Comunidade comunidade,
			@RequestParam(value = "image", required = false) MultipartFile image) {

		// USUARIO_COMUNIDADES
		List<Usuario> users = new ArrayList<Usuario>();
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		users.add(u);

		if (image != null && !image.isEmpty()) {
			String path = context.getRealPath("/");
			path += "resources/images/" + comunidade.getNome() + ".png";
			AulaFileUtil.saveFile(path, image);

		}
		Categoria c = categoriaDAO.recuperar(comunidade.getCatId());
		comunidade.setCategoria(c);

		// USUARIO_COMUNIDADES

		comunidade.setUsuarios(users);
		comunidadeDAO.inserir(comunidade);

		return "redirect:listarMinhasComunidades";

	}

	@RequestMapping("/adicionarComunidadeFormulario")
	public String adicionarComunidadeFormulario(Model model) {
		List<Comunidade> comunidade = comunidadeDAO.listar();
		model.addAttribute("comunidade", comunidade);
		return "comunidades/adicionar_comunidade_formulario";
	}

	@RequestMapping("/adicionarComunidade")
	public String adicionarComunidade(HttpSession session, Comunidade comunidade) {
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		Comunidade cT = comunidadeDAO.recuperar(comunidade.getComid());
		cT.getUsuarios().add(u);

		comunidadeDAO.atualizar(cT);

		return "redirect:listarMinhasComunidades";

	}

	@RequestMapping("/listarComunidade")
	public String listarComunidade(Model model) {
		List<Comunidade> comunidades = comunidadeDAO.listar();
		model.addAttribute("comunidades", comunidades);
		return "comunidades/listar_comunidade";
	}

	@RequestMapping("/listarMinhasComunidades")
	public String listarMinhasComunidades(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		List<Comunidade> comu = u.getComunidades();
		model.addAttribute("comu", comu);
		return "comunidades/listar_minhas_comunidades";
	}
	
	@RequestMapping("/listarParticipantesC")
	public String listarParticipantesC(HttpSession session, Long id) {
		Comunidade comunidade = comunidadeDAO.recuperar(id);
		session.setAttribute("comunidade", comunidade);
		return "comunidades/listar_participantes";
	}
	@RequestMapping("/listarParticipantes")
	public String listarParticipantes(Model model, HttpSession session) {
		Comunidade c = (Comunidade) session.getAttribute("comunidade");
		List<Usuario> usu = c.getUsuarios();
		model.addAttribute("usu", usu);
		return "comunidades/listarParticipantes";
	}
	

	/*
	 * @RequestMapping("/apagarComunidade") public String apagarComunidade(Long
	 * comid){ comunidadeDAO.apagar(comid); return "redirect:listarComunidade";
	 * 
	 * }
	 */

	@RequestMapping("/alterarComunidadeFormulario")
	public String alterarComunidadeFormulario(Long comid, Model model) {
		Comunidade comunidade = comunidadeDAO.recuperar(comid);
		model.addAttribute("comunidade", comunidade);
		return "comunidades/alterar_comunidade_formulario";

	}

	@RequestMapping("/alterarComunidade")
	public String alterarComunidade(Comunidade c, Model model,
			@RequestParam(value = "image", required = false) MultipartFile image) {

		if (image != null && !image.isEmpty()) {
			String path = context.getRealPath("/");
			path += "resources/images/" + c.getNome() + ".png";
			AulaFileUtil.saveFile(path, image);

		}
		Categoria ca = categoriaDAO.recuperar(c.getCatId());
		c.setCategoria(ca);

		comunidadeDAO.atualizar(c);
		return "redirect:listarMinhasComunidades";

	}

}
