package com.taskmanager.boardservice.controller;

import com.taskmanager.boardservice.mapper.BoardMapper;
import com.taskmanager.boardservice.service.BoardService;
import com.taskmanager.model.Board;
import com.taskmanager.model.BoardDetails;
import com.taskmanager.model.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/boards")
@AllArgsConstructor
public class BoardController {

    public final BoardService boardService;

    @PostMapping
    public ResponseEntity<String> createBoard(@RequestBody Board board) {
        return ResponseEntity.ok(boardService.createBoard(BoardMapper.toBoardDetailsDto(board)).toString());
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDetails> getBoardTasks(@PathVariable String boardId) {
        BoardDetails boardDetails = boardService.getBoardDetails(UUID.fromString(boardId));
        return ResponseEntity.ok(boardDetails);
    }

    @PostMapping("/{boardId}/members")
    public ResponseEntity<String> addBoardMembers(@PathVariable String boardId, @RequestBody List<String> memberIds) {
        boardService.addBoardMembers(UUID.fromString(boardId), memberIds);
        return ResponseEntity.ok(boardId);
    }

    @GetMapping("/{boardId}/members")
    public ResponseEntity<List<UserDetails>> getBoardMembers(@PathVariable String boardId) {
        return ResponseEntity.ok(boardService.getBoardMembers(UUID.fromString(boardId)));
    }

    @DeleteMapping("/{boardId}/members/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable String boardId, @PathVariable String memberId) {
        boardService.deleteMember(UUID.fromString(boardId), UUID.fromString(memberId));
        return ResponseEntity.ok(memberId);
    }

}
