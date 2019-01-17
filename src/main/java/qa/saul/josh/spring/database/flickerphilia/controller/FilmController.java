package qa.saul.josh.spring.database.flickerphilia.controller;

import java.util.List;

import javax.validation.Valid;

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

import qa.saul.josh.spring.database.flickerphilia.exception.ResourceNotFoundException;
import qa.saul.josh.spring.database.flickerphilia.model.FilmDataModel;
import qa.saul.josh.spring.database.flickerphilia.repository.FilmRepository;


@RestController
@RequestMapping("/api")
public class FilmController {
	
	@Autowired
	FilmRepository Repository;
	
	
	//Method to create a film
	@PostMapping("/film")
	public FilmDataModel createFilm(@Valid @RequestBody FilmDataModel mSDM) {
		return Repository.save(mSDM);
	}
	
	
	//Method to get a film
	@CrossOrigin
	@GetMapping("film/{FID}")
	public FilmDataModel getFilmbyID(@PathVariable(value = "FID")Long FID) {
		return Repository.findById(FID).orElseThrow(()->new ResourceNotFoundException("FilmDataModel", "FID",FID));
	}
	
	
	// Method get film by title
	@CrossOrigin
	@GetMapping("title/{title}")
	public List<FilmDataModel> getFilmByTitle(@PathVariable(value = "title")String title) {
		return Repository.findByTitle(title);
		}
		
	// Method get film by category
	@CrossOrigin
	@GetMapping("category/{category}")
	public List<FilmDataModel> getFilmByCategory(@PathVariable(value = "category")String category) {
		return Repository.findByCategory(category);
	}
	
	@CrossOrigin
	@GetMapping("rating/{rating}")
	public List<FilmDataModel> getFilmByRating(@PathVariable(value = "rating")String rating) {
		return Repository.findByRating(rating);
	}
	
	
	// Method get films by rating
	@CrossOrigin
	@GetMapping("actors/{actors}")
	public List<FilmDataModel> getFilmByActors(@PathVariable(value = "actors")String actors) {
		return Repository.findByActors(actors);
	}
		
	//Method to get all films
	@CrossOrigin
	@GetMapping("/film")
	public List<FilmDataModel> getAllFilms(){
		return Repository.findAll();
	}
	
	
	//Method to update a film
	@PutMapping("/film/{FID}")
	public FilmDataModel updateFilm(@PathVariable(value = "FID") Long FID,
			@Valid @RequestBody FilmDataModel filmDetails) {
		FilmDataModel mSDM = Repository.findById(FID).orElseThrow(()-> new ResourceNotFoundException("Film","FID",FID));
		
		mSDM.setTitle(filmDetails.getTitle());
		mSDM.setDescription(filmDetails.getDescription());
		mSDM.setCategory(filmDetails.getCategory());
		mSDM.setPrice(filmDetails.getPrice());
		mSDM.setLength(filmDetails.getLength());
		mSDM.setRating(filmDetails.getRating());
		mSDM.setActors(filmDetails.getActors());
		
		FilmDataModel updateData = Repository.save(mSDM);
		return updateData;
		
	}
	
	
	//Method to remove a film
	@DeleteMapping("/film/{FID}")
	public ResponseEntity<?> deleteFilm(@PathVariable(value = "FID") Long FID){
		FilmDataModel mSDM = Repository.findById(FID).orElseThrow(()->new ResourceNotFoundException("Film","FID",FID));
		
		
		Repository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	
	//Method to remove all films from the database
	@DeleteMapping("/film")
	public ResponseEntity<?> deleteAllFilms(){
		Repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}

