package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Dojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface DojoRepository extends ListCrudRepository<Dojo, Long> {
    @Query(
            "SELECT dj FROM Dojo dj WHERE " +
            "(:name IS NULL OR :name = '' OR dj.name LIKE CONCAT(:name, '%')) AND " +
            "(:state IS NULL OR :state = '' OR dj.state LIKE CONCAT(:state, '%')) AND " +
            "(:city IS NULL OR :city = '' OR dj.city LIKE CONCAT(:city, '%')) AND " +
            "(:street IS NULL OR :street = '' OR dj.street LIKE CONCAT(:street, '%'))"
    )
    Page<Dojo> findAllBy(
            @Param("name") String name,
            @Param("state") String state,
            @Param("city") String city,
            @Param("township") String township,
            @Param("street") String street,
            Pageable pageable
    );
}