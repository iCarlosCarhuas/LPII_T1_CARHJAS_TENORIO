package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_especialista database table.
 * 
 */
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

	public int getIdEspecialista() {
		return this.idEspecialista;
	}

	public void setIdEspecialista(int idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public String getCorreoEspecialista() {
		return this.correoEspecialista;
	}

	public void setCorreoEspecialista(String correoEspecialista) {
		this.correoEspecialista = correoEspecialista;
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNomEspecialista() {
		return this.nomEspecialista;
	}

	public void setNomEspecialista(String nomEspecialista) {
		this.nomEspecialista = nomEspecialista;
	}

	public List<Certificacion> getTbCertificacions() {
		return this.tbCertificacions;
	}

	public void setTbCertificacions(List<Certificacion> tbCertificacions) {
		this.tbCertificacions = tbCertificacions;
	}

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