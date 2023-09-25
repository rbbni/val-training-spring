package model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String fieldName;

	@Column(nullable = false)
	private boolean flagDelete;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CompetenceField> CompetenceFields;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public boolean isFlagDelete() {
		return flagDelete;
	}

	public void setFlagDelete(boolean flagDelete) {
		this.flagDelete = flagDelete;
	}

	public List<CompetenceField> getCompetenceFields() {
		return CompetenceFields;
	}

	public void setCompetenceFields(List<CompetenceField> competenceFields) {
		CompetenceFields = competenceFields;
	}

}
