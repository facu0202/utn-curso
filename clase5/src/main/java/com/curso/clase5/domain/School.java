package com.curso.clase5.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	private String cname;
	

	public School( String cname, Set teacherSet) {
		super();
		this.cname = cname;
		if (teacherSet==null)
		this.teacherSet = new HashSet<>();
	}

	@ManyToMany(targetEntity = Teacher.class)
	private Set teacherSet;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getTeacherSet() {
		return teacherSet;
	}
	

	@Override
	public String toString() {
		return "School [cid=" + cid + ", cname=" + cname + ", teacherSet=" + teacherSet + "]";
	}

	public void setTeacherSet(Set teacherSet) {
		this.teacherSet = teacherSet;
	}
	
	

}
