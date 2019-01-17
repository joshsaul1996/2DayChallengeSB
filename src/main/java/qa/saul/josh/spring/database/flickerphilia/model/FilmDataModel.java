package qa.saul.josh.spring.database.flickerphilia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "film_list")


public class FilmDataModel implements Serializable {	
	
	@Id
	@Column(name ="FID")
	private Long FID;
	
	
	@NotBlank
	@Column(name ="title")
	private String title;
	
	@NotBlank
	@Column(name ="description")
	private String description;
	
	@NotBlank
	@Column(name ="category")
	private String category;
	
	@NotBlank
	@Column(name ="price")
	private Integer price;
	
	@NotBlank
	@Column(name ="length")
	private Integer length;
	
	@NotBlank
	@Column(name ="rating")
	private String rating;
	
	@NotBlank
	@Column(name ="actors")
	private String actors;

	
	public FilmDataModel(String title,String description,String category,Integer price,Integer length,String rating,String actors) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.length = length;
		this.rating = rating;
		this.actors = actors;
	}
	
	public FilmDataModel (){

	}

	public Long getFID() {
		return FID;
	}

	public void setFID(Long fID) {
		FID = fID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}
	
	

	}