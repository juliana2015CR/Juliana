package orkut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MENSAGEM")
public class Mensagem {
	@Id
	@Column(name = "MEN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long menId;

	@Column(name = "TEXTO")
	private String texto;

	@Column(name = "FOR_ID", insertable = false, updatable = false, nullable = false)
	private Long forId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FOR_ID", referencedColumnName = "FOR_ID")
	private Forum forum;

	@Column(name = "USU_ID")
	private Long usuId;

	@Column(name = "LOGIN")
	private String login;

	public Long getMenId() {
		return menId;
	}

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

	public void setMenId(Long menId) {
		this.menId = menId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getForId() {
		return forId;
	}

	public void setForId(Long forId) {
		this.forId = forId;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

}
