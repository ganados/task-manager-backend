package com.taskmanager.boardservice.service;

import com.taskmanager.boardservice.client.TaskServiceClient;
import com.taskmanager.boardservice.client.UserServiceClient;
import com.taskmanager.boardservice.dto.BoardDetailsDto;
import com.taskmanager.boardservice.mapper.BoardMapper;
import com.taskmanager.boardservice.repository.BoardRepository;
import com.taskmanager.model.BoardDetails;
import com.taskmanager.model.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final TaskServiceClient taskServiceClient;
    private final UserServiceClient userServiceClient;

    public UUID createBoard(BoardDetailsDto boardDetailsDto) {
        BoardDetailsDto savedBoard = boardRepository.save(boardDetailsDto);
        return savedBoard.getId();
    }

    public BoardDetails getBoardDetails(UUID boardId) {
        BoardDetailsDto boardDetailsDto = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        return prepareBoardDetails(boardId.toString(), boardDetailsDto);
    }

    public void addBoardMembers(UUID boardId, List<String> memberIds) {
        BoardDetailsDto boardDetailsDto = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        addBoardMembers(boardDetailsDto, memberIds);
        boardRepository.save(boardDetailsDto);
    }

    public List<UserDetails> getBoardMembers(UUID boardId) {
        BoardDetailsDto boardDetailsDto = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        return userServiceClient.getUsersDetails(boardDetailsDto.getMemberIds().stream().map(UUID::toString).toList());
    }

    public void deleteMember(UUID boardId, UUID memberId) {
        BoardDetailsDto boardDetailsDto = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        boardDetailsDto.getMemberIds().remove(memberId);
        boardRepository.save(boardDetailsDto);
    }

    private BoardDetails prepareBoardDetails(String boardId, BoardDetailsDto boardDetailsDto) {
        BoardDetails boardDetails = BoardMapper.toBoardDetails(boardDetailsDto);
        boardDetails.setTasks(taskServiceClient.getBoardTasks(boardId));
        boardDetails.setBoardMembers(userServiceClient
                .getUsersDetails(boardDetailsDto.getMemberIds().stream().map(UUID::toString).toList()));
        return boardDetails;
    }

    private void addBoardMembers(BoardDetailsDto boardDetailsDto, List<String> memberIds) {
        Set<UUID> members = new HashSet<>(boardDetailsDto.getMemberIds());
        members.addAll(memberIds.stream().map(UUID::fromString).toList());
        boardDetailsDto.setMemberIds(new ArrayList<>(members));
    }

}
