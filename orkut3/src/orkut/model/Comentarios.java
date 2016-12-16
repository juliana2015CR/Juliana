package orkut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "COMENTARIOS")
public class Comentarios {
	@Id
	@Column(name = "COME_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comeid;

	@Column(name = "TEXTO")
	private String texto;

	@Column(name = "FOT_ID", insertable = false, updatable = false, nullable = false)
	private Long fotid;

	@Column(name = "USU_ID")
	private Long usuId;

	@Column(name = "LOGIN")
	private String login;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FOT_ID", referencedColumnName = "FOT_ID")
	private Fotos fotos;

	public Long getComeid() {
		return comeid;
	}

	public void setComeid(Long comeid) {
		this.comeid = comeid;
	}

	public Long getFotid() {
		return fotid;
	}

	public void setFotid(Long fotid) {
		this.fotid = fotid;
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getFotId() {
		return fotid;
	}

	public void setFotId(Long fotid) {
		this.fotid = fotid;
	}

	public Fotos getFotos() {
		return fotos;
	}

	public void setFotos(Fotos fotos) {
		this.fotos = fotos;
	}

}
