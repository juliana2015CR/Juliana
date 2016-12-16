package orkut.controller;

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

import orkut.util.AulaFileUtil;
import orkut.DAO.IAlbumDAO;
import orkut.DAO.IFotosDAO;
import orkut.DAO.IUsuarioDAO;
import orkut.DAO.UsuarioDAOHibernate;
import orkut.model.Album;
import orkut.model.Comunidade;
import orkut.model.Fotos;
import orkut.model.Usuario;

@Controller
@Transactional
public class AlbumController {
	@Autowired
	@Qualifier(value = "albumDAOHibernate")
	private IAlbumDAO albumDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/inserirAlbunsFormulario")
	public String inserirAlbunsFormulario() {
		return "fotos/inserir_albuns_formulario";
	}

	@RequestMapping("/inserirAlbuns")
	public String inserirAlbuns(HttpSession session, Album album,
			@RequestParam(value = "fot", required = false) MultipartFile fot) {

		if (fot != null && !fot.isEmpty()) {
			String path = context.getRealPath("/");
			path += "resources/fot/" + album.getNome() + ".png";
			AulaFileUtil.saveFile(path, fot);

		}

		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		album.setUsuario(u);
		albumDAO.inserir(album);
		return "redirect:listarAlbuns";

	}

	@RequestMapping("/listarAlbuns")
	public String listarAlbuns(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		List<Album> album = albumDAO.listar(u.getUsuId());
		model.addAttribute("album", album);
		return "fotos/listar_albuns";
	}

	@RequestMapping("/listarAlbunsPerfil")
	public String listarAlbuns(Model model, Long id) {
		List<Album> album = albumDAO.listar(id);
		model.addAttribute("album", album);
		return "fotos/listar_albuns_perfil";
	}
	@RequestMapping("/listarAlbunsPessoas")
	public String listarAlbunsPessoas(Model model, HttpSession session) {
		Collection<Album> album = albumDAO.listarT();
		model.addAttribute("album", album);
		return "fotos/listar_albuns_pessoas";
	}
	/*
	 * @RequestMapping("/apagarAlbum") public String apagarAlbum(Long alid){
	 * albumDAO.apagar(alid); return "redirect:listarAlbuns";
	 * 
	 * }
	 */
}
