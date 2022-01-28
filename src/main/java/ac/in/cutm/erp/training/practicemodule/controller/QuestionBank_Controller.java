package ac.in.cutm.erp.training.practicemodule.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.in.cutm.erp.training.practicemodule.model.QuestionBank;
import ac.in.cutm.erp.training.practicemodule.repoitory.QuestionBankRepository;
import ac.in.cutm.erp.training.practicemodule.resourcenotfound.ResourceNotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/traning")
public class QuestionBank_Controller {
	@Autowired
	private QuestionBankRepository questionrepository;

	@GetMapping("/quesbank")
	
	public List<QuestionBank> getAllQuestions(){
		return questionrepository.findAll();
	}

	// create a rest api
	@PostMapping("/addques")
	public QuestionBank createQue(@RequestBody QuestionBank qn) {
		return questionrepository.save(qn);
	}

	@GetMapping("/addques/{id}")
	public ResponseEntity<QuestionBank> getquesById(Long id) {
		QuestionBank qn = questionrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id doesnot exist with id:" + id));
		return ResponseEntity.ok(qn);
	}

	// upadating

	@PutMapping("/addques/{id}")
	public ResponseEntity<QuestionBank> updateQuestion(@PathVariable Long id, @RequestBody QuestionBank quesndetails) {
		QuestionBank qn = questionrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));

		qn.setQuestion(quesndetails.getQuestion());
		
		qn.setNumber(quesndetails.getNumber());
		qn.setHint(quesndetails.getHint());
		qn.setAnswer(quesndetails.getAnswer());
        qn.setLanguage(quesndetails.getLanguage());
        qn.setDifficulty(quesndetails.getDifficulty());
		QuestionBank updatedquestion = questionrepository.save(qn);
		return ResponseEntity.ok(updatedquestion);

	}

	// Delete
	@DeleteMapping("/addques/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteQuestion(@PathVariable Long id) {
		QuestionBank qn = questionrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));

		questionrepository.delete(qn);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
