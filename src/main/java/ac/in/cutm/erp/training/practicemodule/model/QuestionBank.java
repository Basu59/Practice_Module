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
@Table(name = "question_bank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionBank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@Column(name = "language")
	private String language;
	
	@Column(name = "number")
	private String number;

	@Column(name = "question")
	private String question;
	
	@Column(name = "hint")
	private String hint;

	@Column(name = "difficulty")
	private String difficulty;

	@Column(name = "answer")
	private String answer;

}
