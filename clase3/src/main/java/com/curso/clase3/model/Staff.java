package com.curso.clase3.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="STAFF")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
//@Inheritance( strategy = InheritanceType.JOINED )
//@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@DiscriminatorColumn( name="type" )

public class Staff implements Serializable 
{
   @Id
   @GeneratedValue( strategy = GenerationType.AUTO )
   private Long sid;
   private String sname;
   
   public Staff( Long sid, String sname ) 
   {
      super( );
      this.sid = sid;
      this.sname = sname;
   }
   
   public Staff( ) 
   {
      super( );
   }
   
   public Long getSid( ) 
   {
      return sid;
   }
   
   public void setSid( Long sid ) 
   {
      this.sid = sid;
   }
   
   public String getSname( ) 
   {
      return sname;
   }
   
   public void setSname( String sname ) 
   {
      this.sname = sname;
   }
}
