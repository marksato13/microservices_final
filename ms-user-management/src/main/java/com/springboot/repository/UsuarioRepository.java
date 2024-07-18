package com.springboot.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value = "select p.id_persona,p.nombre,p.apellido, rl.nombre_rol\r\n"
			+ "from persona p join usuario us on p.id_persona = us.persona_id\r\n"
			+ "join usuario_rol ur on us.id_usuario = ur.id_usuario\r\n"
			+ "join rol rl on rl.id_rol = ur.id_rol\r\n"
			+ "where us.nombre_user= ? and us.contraseña = ?", nativeQuery = true)
	List<Map<String, Object>> getInitSesion(String user, String pass);
	
	@Query(value = "select op.nombre\r\n"
			+ "from\r\n"
			+ "persona p join usuario us on p.id_persona = us.persona_id\r\n"
			+ "join usuario_rol ur on us.id_usuario = ur.id_usuario\r\n"
			+ "join rol rl on rl.id_rol = ur.id_rol\r\n"
			+ "join rol_opciones ro on rl.id_rol = ro.id_rol\r\n"
			+ "join opciones op on ro.id_opciones = op.id_opciones\r\n"
			+ "where p.id_persona = ?", nativeQuery = true)
	List<Map<String, Object>> getModules(int id);
	
}