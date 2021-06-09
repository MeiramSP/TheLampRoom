package kz.saparov.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.saparov.room.entity.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
