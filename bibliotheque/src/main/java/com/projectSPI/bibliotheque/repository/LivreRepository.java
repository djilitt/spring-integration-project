package com.projectSPI.bibliotheque.repository;

import com.projectSPI.bibliotheque.entity.Livre;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByTitleContaining(String title);

}
