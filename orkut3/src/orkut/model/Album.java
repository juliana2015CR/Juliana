package orkut.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "ALBUM")
public class Album {
	@Id
	@Column(name = "ALB_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long alid;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "album", targetEntity = Fotos.class, fetch = FetchType.EAGER)
	private Collection<Fotos> fotos;

	public Long getAlid() {
		return alid;
	}

	public void setAlid(Long alid) {
		this.alid = alid;
	}

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<Fotos> getFotos() {
		return fotos;
	}

	public void setFotos(Collection<Fotos> fotos) {
		this.fotos = fotos;
	}

}
