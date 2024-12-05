package com.reactivebeg.api.Repository.DB2Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reactivebeg.api.Entity.DB2Entity.Film;

@Repository
public interface FilmRepo extends JpaRepository<Film, Integer> {

}
