package com.ciberfarma.app;

import java.util.List;

import com.ciberfarma.model.Tipo;
import com.ciberfarma.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
	
public class Demo07 {
	public static void main(String[] args) {
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("jpa_sesion02");
		EntityManager em = conexion.createEntityManager();
		
		
		
		//sql ="select * from tb_tipos"
		//jpql  = select from Tipo u"
		List<Tipo> lstTipos = em.createNativeQuery("select * from tb_tipos",Tipo.class).getResultList();
		
		for (Tipo t : lstTipos) {
			System.out.println("Tipo de Usuario: " + t.getDescripcion() );
			System.out.println("-------------------");
			for(Usuario u : t.getLstUsuarios()) {
				System.out.println("Nombre : " + u.getNom_usua());
				System.out.println("Gmail : " + u.getCorreo());
				System.out.println("-------------------");
			}
		}
		
		
		List<Tipo> lstTipo2 = em.createNativeQuery("select from Tipo u").getResultList();
	}
}
