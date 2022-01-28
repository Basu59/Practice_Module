package ac.in.cutm.erp.training.practicemodule.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac.in.cutm.erp.training.practicemodule.model.QuestionBank;



@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long>{

}
