package com.edu.certus.alumnos.entity;

/*import javax.persistence.CascadeType;*/
import javax.persistence.Column;
import javax.persistence.Entity;
/*import javax.persistence.FetchType;*/
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;*/
/*import javax.persistence.ManyToOne;*/
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "alumnos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumnos")
	private Long id;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "curso")
	private String curso;
	@Column(name = "estado")
	private Boolean estado;
	
}

