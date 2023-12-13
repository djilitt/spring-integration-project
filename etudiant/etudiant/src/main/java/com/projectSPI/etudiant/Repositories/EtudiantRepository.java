package com.projectSPI.etudiant.Repositories;

import com.projectSPI.etudiant.Entities.Etudiants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiants, Long> {


}
