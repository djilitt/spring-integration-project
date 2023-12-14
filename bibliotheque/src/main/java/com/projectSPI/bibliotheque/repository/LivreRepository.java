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

    @Override
    default void flush() {

    }

    @Override
    default <S extends Livre> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    default <S extends Livre> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    default void deleteAllInBatch(Iterable<Livre> entities) {

    }

    @Override
    default void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    default void deleteAllInBatch() {

    }

    @Override
    default Livre getOne(Long aLong) {
        return null;
    }

    @Override
    default Livre getById(Long aLong) {
        return null;
    }

    @Override
    default Livre getReferenceById(Long aLong) {
        return null;
    }

    @Override
    default <S extends Livre> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends Livre> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    default <S extends Livre> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    default <S extends Livre> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Livre> long count(Example<S> example) {
        return 0;
    }

    @Override
    default <S extends Livre> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    default <S extends Livre, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    default <S extends Livre> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Livre> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Livre> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default List<Livre> findAll() {
        return null;
    }

    @Override
    default List<Livre> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Livre entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Livre> entities) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default List<Livre> findAll(Sort sort) {
        return null;
    }

    @Override
    default Page<Livre> findAll(Pageable pageable) {
        return null;
    }
}
