package com.portfolio.backEndArgProg.Repository;

import com.portfolio.backEndArgProg.Entity.Exp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpRepository extends JpaRepository<Exp, Integer> {
    public Optional<Exp> findByName(String name);
    public boolean existsByName(String name);
}
