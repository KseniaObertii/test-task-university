package com.botscrew.testtaskuniversity.specification;

import com.botscrew.testtaskuniversity.model.Lector;
import org.springframework.data.jpa.domain.Specification;

public class LectorSpecification {
    public static Specification<Lector> likeName(String lectorName) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + lectorName + "%"));
    }

    public static Specification<Lector> likeSurname(String lectorSurname) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("surname"), "%" + lectorSurname + "%"));
    }
}
