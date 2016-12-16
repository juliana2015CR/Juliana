package orkut.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "FORUM")
public class Forum {
	@Id
	@Column(name = "FOR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long forId;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "COM_ID", insertable = false, updatable = false, nullable = false)
	private Long comid;

	@ManyToOne(optional = false)
	@JoinColumn(name = "COM_ID", referencedColumnName = "COM_ID")
	private Comunidade comunidade;

	@OneToMany(mappedBy = "forum", targetEntity = Mensagem.class, fetch = FetchType.EAGER)
	private Collection<Mensagem> mensagem;

	@Column(name = "USU_ID")
	private Long usuId;

	@Column(name = "LOGIN")
	private String login;

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Mensagem> getMensagem() {
		return mensagem;
	}

	public void setMensagem(Collection<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}

	public Long getForId() {
		return forId;
	}

	public void setForId(Long forId) {
		this.forId = forId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

}
