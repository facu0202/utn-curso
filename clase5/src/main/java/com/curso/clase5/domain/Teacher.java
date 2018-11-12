package com.curso.clase5.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher 
{
   @Id
   @GeneratedValue( strategy = GenerationType.AUTO )
   private Long tid;
   private String tname;
   private String subject;

   @ManyToMany(targetEntity=School.class)
   private Set schoolSet;

   public Teacher() 
   {
      super();
   }
   
   public Teacher(Long tid, String tname, String subject, Set clasSet) 
   {
      super();
      this.tid = tid;
      this.tname = tname;
      this.subject = subject;
      this.schoolSet = clasSet;
   }
   
   public Long getTid() 
   {
      return tid;
   }
   
   public void setTid(Long tid) 
   {
      this.tid = tid;
   }
   
   public String getTname() 
   {
      return tname;
   }
   
   public void setTname(String tname) 
   {
      this.tname = tname;
   }
   
   public String getSubject() 
   {
      return subject;
   }
   
   public void setSubject(String subject) 
   {
      this.subject = subject;
   }
   
   public Set getClasSet() 
   {
      return schoolSet;
   }
   
   public void setClasSet(Set clasSet) 
   {
      this.schoolSet = clasSet;
   }

@Override
public String toString() {
	return "Teacher [tid=" + tid + ", tname=" + tname + ", subject=" + subject + "]";
}
   
   
}
