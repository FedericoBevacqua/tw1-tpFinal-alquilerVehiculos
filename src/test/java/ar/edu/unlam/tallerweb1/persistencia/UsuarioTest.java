package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;  //libreria de asserts
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

//Todas las clases de persistencia de usuario
public class UsuarioTest extends SpringTest {
	
	@Test @Transactional @Rollback  //Rollback toda la info al finalizar el test deja la base de datos como estaba antes
	public void guardarUsuarioTest() {
		
		//Inicializar
		Usuario pepe = new Usuario();
		
		//Settear
		pepe.setEmail("pepe@hotmail.com");
		pepe.setPassword("123456");
		
		//Guardar
		Session session = getSession();//ahora tiene valor null pepe en id
		session.save(pepe); //devuelve un serializable el ID con el que lo guarda // A pepe le crea un id y te lo devuelve //Aca tiene valor no null el id
		//Recibo el id del usuario pepe
		Usuario buscado = session.get(Usuario.class, pepe.getId());
		
		//Validar
		assertThat(buscado).isNotNull();  //o es equals to = tal id
		
	}
	@Test @Transactional @Rollback 
	public void updateUsuarioTest() {
		//Inicializar
		Usuario pepe = new Usuario();
		
		//Settear
		pepe.setEmail("pepe@gmail.com");
		pepe.setPassword("123");
		pepe.setRol("Admin");
		Session session = getSession();
		
		//Guardar
		session.save(pepe);
		
		//Ejecutar: update
		pepe.setRol("nulo");
		session.update(pepe);	
		
		//Recibo el email de PEPE
		Usuario buscado = session.get(Usuario.class, pepe.getId()); //o recibo el getEmail
		
		//Validar
		assertThat(buscado.getRol()).isEqualTo(pepe.getRol());
		
		//Comparo que pepe tenga el email2
		//assertThat(buscado).isEqualTo(pepe.getId());
	}
	@Test @Transactional @Rollback 
	public void deleteUsuarioTest() {
		//Inicializar
		Usuario pepe = new Usuario();
		
		//Settear
		pepe.setEmail("pepe@hotmail.com");
		pepe.setPassword("123456");
		
		Session session = getSession();
		
		//Guardar
		session.save(pepe); 
		
		//Ejecutar: borrar
		session.delete(pepe);
		
		//Recibo el id del usuario pepe
		Usuario buscado = session.get(Usuario.class, pepe.getId());
		
		//Validar
		assertThat(buscado).isNull();		
	}	
}