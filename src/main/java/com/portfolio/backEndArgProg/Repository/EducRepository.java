/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backEndArgProg.Repository;

import com.portfolio.backEndArgProg.Entity.Educ;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducRepository extends JpaRepository<Educ, Integer>{
    public Optional<Educ> findByName(String name);
    public boolean existsByName(String name);
}
