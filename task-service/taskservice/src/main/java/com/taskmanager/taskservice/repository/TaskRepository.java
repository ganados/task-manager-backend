package com.taskmanager.taskservice.repository;

import com.taskmanager.taskservice.dto.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskDto, UUID> {

    Optional<TaskDto> findByTitle(String title);
    Optional<List<TaskDto>> findAllByAssigneeId(UUID assigneeId);
    Optional<List<TaskDto>> findAllByBoardId(UUID boardId);
}
