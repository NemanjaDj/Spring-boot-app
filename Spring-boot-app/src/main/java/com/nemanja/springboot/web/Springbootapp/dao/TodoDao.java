package com.nemanja.springboot.web.Springbootapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nemanja.springboot.web.Springbootapp.model.Todo;
import com.nemanja.springboot.web.Springbootapp.model.User;

public interface TodoDao extends JpaRepository<Todo, Integer>{
	
	List<Todo> findByUser(User user);
	
	Todo findById(int id);
	
	/* Whenever you are trying to modify a record in db, you have to mark it 
	 * @Transactional as well as @Modifying, which instruct Spring that it can modify existing records.
	The repository method must be void or the exception keeps getting thrown.
	*/
	@Transactional
	@Modifying
	@Query("DELETE FROM Todo t WHERE t.id=:id")
	void removeTodo(@Param("id")int id);

}
