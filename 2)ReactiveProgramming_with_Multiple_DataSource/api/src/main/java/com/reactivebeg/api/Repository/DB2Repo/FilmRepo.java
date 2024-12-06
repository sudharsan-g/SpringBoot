package com.reactivebeg.api.Repository.DB2Repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.reactivebeg.api.Entity.DB2Entity.Film;

@Repository
public interface FilmRepo extends R2dbcRepository<Film, Integer> {

}
