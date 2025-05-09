package com.taskmanager.boardservice.repository;

import com.taskmanager.boardservice.dto.BoardDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<BoardDetailsDto, UUID> {

}
