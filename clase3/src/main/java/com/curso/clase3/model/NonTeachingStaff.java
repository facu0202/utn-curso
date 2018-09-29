package com.curso.clase3.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "NS" )
//@PrimaryKeyJoinColumn(referencedColumnName="sid")
public class NonTeachingStaff extends Staff 
{
   private String areaexpertise;

   public NonTeachingStaff( Long sid, String sname, String areaexpertise ) 
   {
      super( sid, sname );
      this.areaexpertise = areaexpertise;
   }

   public NonTeachingStaff( ) 
   {
      super( );
   }

   public String getAreaexpertise( ) 
   {
      return areaexpertise;
   }

   public void setAreaexpertise( String areaexpertise )
   {
      this.areaexpertise = areaexpertise;
   }
}
