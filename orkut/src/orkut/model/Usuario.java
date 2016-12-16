package orkut.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import orkut.model.Amizade;
import orkut.model.Usuario;

@Entity(name = "USUARIO")
public class Usuario {
	@Id
	@Column(name = "USU_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long usuId;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "SOBRENOME")
	private String sobrenome;

	@Column(name = "IDADE")
	private int idade;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "SENHA")
	private String senha;

	@Column(name = "CONF_SENHA")
	private String confsenha;

	@Column(name = "ORK_ID", insertable = false, updatable = false, nullable = false)
	private Long orkId;

	// um usuario pode ter vários albuns
	/* ONE-TO.MANY */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", targetEntity = Album.class, fetch = FetchType.EAGER)
	private Collection<Album> album;

	/* many-to-one */
	@ManyToOne(optional = false)
	@JoinColumn(name = "ORK_ID", referencedColumnName = "ORK_ID")
	private OrkutQuixada orkutquixada;

	/* many-to-many */
	@ManyToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)
	private List<Comunidade> comunidades;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFonte")
	private List<Amizade> amizades = new ArrayList<Amizade>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuId == null) ? 0 : usuId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuId == null) {
			if (other.usuId != null)
				return false;
		} else if (!usuId.equals(other.usuId))
			return false;
		return true;
	}

	public List<Amizade> getAmizades() {
		return amizades;
	}

	public void setAmizades(List<Amizade> amizades) {
		this.amizades = amizades;
	}

	public OrkutQuixada getOrkutquixada() {
		return orkutquixada;
	}

	public String getConfsenha() {
		return confsenha;
	}

	public void setConfsenha(String confsenha) {
		this.confsenha = confsenha;
	}

	public Collection<Album> getAlbum() {
		return album;
	}

	public void setAlbum(Collection<Album> album) {
		this.album = album;
	}

	public void setOrkutquixada(OrkutQuixada orkutquixada) {
		this.orkutquixada = orkutquixada;
	}

	public Collection<Album> getAlbuns() {
		return album;
	}

	public void setAlbuns(Collection<Album> album) {
		this.album = album;
	}

	public List<Comunidade> getComunidades() {
		return comunidades;
	}

	public void setComunidades(List<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public Long getOrkId() {
		return orkId;
	}

	public void setOrkId(Long orkId) {
		this.orkId = orkId;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// public Collection<Fotos> getFotos() {
	// return fotos;
	// }

	// public void setFotos(Collection<Fotos> fotos) {
	// this.fotos = fotos;
	// }

}