package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the tb_especialista database table.
 * 
 */
@Data
@Entity
@Table(name="tb_especialista")
@NamedQuery(name="Especialista.findAll", query="SELECT e FROM Especialista e")
public class Especialista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_especialista")
	private int idEspecialista;

	@Column(name="correo_especialista")
	private String correoEspecialista;

	private int dni;

	private String especialidad;

	@Column(name="nom_especialista")
	private String nomEspecialista;

	//bi-directional many-to-one association to Certificacion
	@OneToMany(mappedBy="tbEspecialista")
	private List<Certificacion> tbCertificacions;

	public Especialista() {
	}

	public String toString() {return nomEspecialista;}
	
	public Certificacion addTbCertificacion(Certificacion tbCertificacion) {
		getTbCertificacions().add(tbCertificacion);
		tbCertificacion.setTbEspecialista(this);

		return tbCertificacion;
	}

	public Certificacion removeTbCertificacion(Certificacion tbCertificacion) {
		getTbCertificacions().remove(tbCertificacion);
		tbCertificacion.setTbEspecialista(null);

		return tbCertificacion;
	}

}