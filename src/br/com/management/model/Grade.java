package br.com.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Grade implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GradeKey id;

	@ManyToOne
	@MapsId("studentId")
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id")
	private Course course;

	@Column
	private Double firstGrade;

	@Column
	private Double secondGrade;

	@Column
	private Integer currentPeriod;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Double getFirstGrade() {
		return firstGrade;
	}

	public void setFirstGrade(Double firstGrade) {
		this.firstGrade = firstGrade;
	}

	public Double getSecondGrade() {
		return secondGrade;
	}

	public void setSecondGrade(Double secondGrade) {
		this.secondGrade = secondGrade;
	}

	public Integer getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(Integer currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	public GradeKey getId() {
		return id;
	}

}
