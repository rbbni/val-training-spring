package com.example.valtrainingspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "competence_field")
public class CompetenceField {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category")
	@JsonIgnore
	private Category category;
	private String title;
	private String descr;
	private String ratingScale;

	@OneToOne(mappedBy = "competenceField")
	private Evaluation evaluation;

	@Column(nullable = false)
	private boolean flgDelete;

	public CompetenceField() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getRatingScale() {
		return ratingScale;
	}

	public void setRatingScale(String ratingScale) {
		this.ratingScale = ratingScale;
	}

	public boolean isFlgDelete() {
		return flgDelete;
	}

	public void setFlgDelete(boolean flgDelete) {
		this.flgDelete = flgDelete;
	}
}
