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

import ac.in.cutm.erp.training.practicemodule.model.Profile;
import ac.in.cutm.erp.training.practicemodule.repoitory.ProfileRepo;
import ac.in.cutm.erp.training.practicemodule.resourcenotfound.ResourceNotFoundException;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/practice")
public class ProfileController {
	@Autowired
	private ProfileRepo profileRepository;
	
	@GetMapping("/addpro")
	public List<Profile> getAllDetails(){
		return profileRepository.findAll();
		
		}
	// create employee rest api
	@PostMapping("/addpro")
	public Profile createDetails( @RequestBody  Profile profile) {
		return profileRepository.save(profile);
		}
	@GetMapping("/addpro/{id}")
	public ResponseEntity<Profile>getDetailsById(@PathVariable Long id) {
		Profile profile = profileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		return ResponseEntity.ok(profile);
	}
	// update rest api
	@PutMapping("/addpro/{id}")
	public ResponseEntity<Profile> updateDetails(@PathVariable Long id, @RequestBody Profile details){
		Profile profile= profileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
		
		profile.setName(details.getName());
		profile.setEdu(details.getEdu());
		profile.setYrgra(details.getYrgra());
		profile.setUid(details.getUid());
		profile.setAboutme(details.getAboutme());
		profile.setMobileno(details.getMobileno());
		Profile updateDetails = profileRepository.save(profile);
		return ResponseEntity.ok(updateDetails);
	
		
	}
	// Delete rest api
	@DeleteMapping("/addpro/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDetails(@PathVariable Long id){
		Profile busDetails= profileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		
		profileRepository.delete(busDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
	
