package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

public interface SkillRepository<S> extends JpaRepository<Skill,Long> {
	/*@Query("select * from Employee where skills= :skillName")
	public List<Employee> getEmployeeBySkill(@Param("skillName") String skillName );
*/
	public Skill getSkillByName(String name);
}
