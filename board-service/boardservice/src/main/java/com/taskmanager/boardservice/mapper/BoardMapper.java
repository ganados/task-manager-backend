package com.taskmanager.boardservice.mapper;


import com.taskmanager.boardservice.dto.BoardDetailsDto;
import com.taskmanager.model.Board;
import com.taskmanager.model.BoardDetails;

import java.util.UUID;

public class BoardMapper {

    public static BoardDetailsDto toBoardDetailsDto(Board board) {
        return BoardDetailsDto.builder()
                .boardName(board.getBoardName())
                .ownerId(UUID.fromString(board.getOwnerId()))
                .build();
    }

    public static BoardDetails toBoardDetails(BoardDetailsDto boardDetailsDto) {
        return BoardDetails.builder()
                .boardId(boardDetailsDto.getId().toString())
                .boardName(boardDetailsDto.getBoardName())
                .ownerId(boardDetailsDto.getOwnerId().toString())
                .build();
    }

}
