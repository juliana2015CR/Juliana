package orkut.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
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
public class FotosController {
	@Autowired
	@Qualifier(value = "fotosDAOHibernate")
	private IFotosDAO fotosDAO;

	@Autowired
	@Qualifier(value = "albumDAOHibernate")
	private IAlbumDAO albumDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/inserirFotosFormulario")
	public String inserirFotosFormulario(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		List<Album> album = albumDAO.listar(u.getUsuId());
		model.addAttribute("album", album);
		return "fotos/inserir_fotos_formulario";
	}

	@RequestMapping("/inserirFotos")
	public String inserirFotos(Fotos fotos,
			@RequestParam(value = "fot", required = false) MultipartFile fot) {

		if (fot != null && !fot.isEmpty()) {
			String path = context.getRealPath("/");
			path += "resources/fot/" + fotos.getLegenda() + ".png";
			AulaFileUtil.saveFile(path, fot);

		}
		Album a = albumDAO.recuperar(fotos.getAlid());
		fotos.setAlbuns(a);

		fotosDAO.inserir(fotos);
		return "redirect:listarAlbuns";
	}

	@RequestMapping("/listarFotos")
	public String listarFotos(Model model, Long alid) {
		List<Fotos> fotos = albumDAO.listarF(alid);
		model.addAttribute("fotos", fotos);
		return "fotos/listar_fotos";
	}

}
