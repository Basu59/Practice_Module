package ac.in.cutm.erp.training.practicemodule.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pro_det")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "uid")
	private String uid;

	@Column(name = "edu")
	private String edu;

	@Column(name = "aboutme")
	private String aboutme;

	@Column(name = "yrgra")
	private String yrgra;
		
	@Column(name = "mobileno")
	private String mobileno;


}
