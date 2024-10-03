package com.example.lab6.repository;

import com.example.lab6.entity.Artistas;
import com.example.lab6.entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistasRepository extends JpaRepository<Artistas, Integer> {
}
