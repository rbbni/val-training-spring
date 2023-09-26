package com.example.valtrainingspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1264424881861154963L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String code;

	@NotBlank
	private String name;

	@NotBlank
	private String surname;

	@Column(nullable = false, unique = true)
	private String mail;

	@NotBlank
	private String jobLevel;

	@NotBlank
	private boolean evalutator;

	@NotBlank
	private boolean flagDelete;

	private boolean active;

	@NotBlank
	private String role;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastAccessDate;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date registrationDate;

	private String managerName;

	private String managerSurname;

	private String companySog;

	private String job;

	private String orgUnit;

	private String task;

	private String jobFamilies;

	private String subFamilies;

	private String standardJob;

	private String competenceField;

	private String password;

	@OneToOne(mappedBy = "user")
	private Salt salt;

	@OneToOne(mappedBy = "user")
	private Token token;

	@OneToOne
	@JoinColumn(name = "competence_field_id")
	private CompetenceField competenceFieldId;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Evaluation> evaluations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public boolean isEvalutator() {
		return evalutator;
	}

	public void setEvalutator(boolean evalutator) {
		this.evalutator = evalutator;
	}

	public boolean isFlagDelete() {
		return flagDelete;
	}

	public void setFlagDelete(boolean flagDelete) {
		this.flagDelete = flagDelete;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerSurname() {
		return managerSurname;
	}

	public void setManagerSurname(String managerSurname) {
		this.managerSurname = managerSurname;
	}

	public String getCompanySog() {
		return companySog;
	}

	public void setCompanySog(String companySog) {
		this.companySog = companySog;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getOrgUnit() {
		return orgUnit;
	}

	public void setOrgUnit(String orgUnit) {
		this.orgUnit = orgUnit;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getJobFamilies() {
		return jobFamilies;
	}

	public void setJobFamilies(String jobFamilies) {
		this.jobFamilies = jobFamilies;
	}

	public String getSubFamilies() {
		return subFamilies;
	}

	public void setSubFamilies(String subFamilies) {
		this.subFamilies = subFamilies;
	}

	public String getStandardJob() {
		return standardJob;
	}

	public void setStandardJob(String standardJob) {
		this.standardJob = standardJob;
	}

	public String getCompetenceField() {
		return competenceField;
	}

	public void setCompetenceField(String competenceField) {
		this.competenceField = competenceField;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Salt getSalt() {
		return salt;
	}

	public void setSalt(Salt salt) {
		this.salt = salt;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public CompetenceField getCompetenceFieldId() {
		return competenceFieldId;
	}

	public void setCompetenceFieldId(CompetenceField competenceFieldId) {
		this.competenceFieldId = competenceFieldId;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}