package com.botscrew.testtaskuniversity.dao;

import com.botscrew.testtaskuniversity.model.Lector;
import com.botscrew.testtaskuniversity.specification.LectorSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorDao extends JpaRepository<Lector, Long>, JpaSpecificationExecutor<Lector> {

    //done
    default List<Lector> findLectorsByNameOrSurnameContaining(String nameOrSurnamePart) {
        Specification<Lector> specs = Specification.where(LectorSpecification.likeName(nameOrSurnamePart))
                .or(LectorSpecification.likeSurname(nameOrSurnamePart));
        return findAll(specs);
    }
}
