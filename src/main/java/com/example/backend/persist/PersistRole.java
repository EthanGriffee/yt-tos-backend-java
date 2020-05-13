package com.example.backend.persist;  
  
import com.example.backend.models.Role;
import com.example.backend.models.Role.Type;

import javax.persistence.*;  
public class PersistRole {  
      

    //from https://www.javatpoint.com/jpa-inserting-an-entity
    public static void main(String args[])  
    {  
          
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("Student_details");  
        EntityManager em=emf.createEntityManager();  
          
        em.getTransaction().begin();  
          
        Role jailor = new Role("Jailor", Type.JAILOR);      
        Role sheriff = new Role("Sheriff", Type.TOWN_INVESTIGATIVE); 

        em.persist(jailor);  
        em.persist(sheriff);        
  
        em.getTransaction().commit();  
          
        emf.close();  
        em.close();  
    }  
}  