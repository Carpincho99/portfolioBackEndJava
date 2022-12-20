package com.portfolio.backEndArgProg.Repository;

import com.portfolio.backEndArgProg.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    public boolean existsById(int id);
}
