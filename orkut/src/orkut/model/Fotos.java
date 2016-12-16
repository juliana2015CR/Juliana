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

@Entity(name = "FOTOS")
public class Fotos {
	@Id
	@Column(name = "FOT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fotid;

	@Column(name = "LEGENDA")
	private String legenda;

	@Column(name = "ALB_ID", insertable = false, updatable = false, nullable = false)
	private Long alid;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ALB_ID", referencedColumnName = "ALB_ID")
	private Album album;

	@OneToMany(mappedBy = "fotos", targetEntity = Comentarios.class, fetch = FetchType.LAZY)
	private Collection<Comentarios> comentarios;

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Long getFotid() {
		return fotid;
	}

	public void setFotid(Long fotid) {
		this.fotid = fotid;
	}

	public Long getAlid() {
		return alid;
	}

	public void setAlid(Long alid) {
		this.alid = alid;
	}

	public Album getAlbuns() {
		return album;
	}

	public void setAlbuns(Album album) {
		this.album = album;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public Collection<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

}
