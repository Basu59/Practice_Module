package ac.in.cutm.erp.training.practicemodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name = "question_bank",uniqueConstraints = {@UniqueConstraint(columnNames = {"number"})})
@Table(name = "question_bank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionBank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Size(min = 2, message = "Language Should not be empty")
	@Column(name = "language")
	private String language;

	@NotBlank
	@Size(min = 2, message = "please enter question")
	@Column(name = "question")
	private String question;

	@NotBlank
	@Size(min = 2, message = "please give hint for question")
	@Column(name = "hint")
	private String hint;

	@NotBlank
	@Size(min = 2, message = "please select a difficulty level")
	@Column(name = "difficulty")
	private String difficulty;

	@NotBlank
	@Size(min = 2, message = "Question should have its answer")
	@Column(name = "answer")
	private String answer;

}
