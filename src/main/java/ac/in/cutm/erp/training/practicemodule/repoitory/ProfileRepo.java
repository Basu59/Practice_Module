package ac.in.cutm.erp.training.practicemodule.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac.in.cutm.erp.training.practicemodule.model.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {

}