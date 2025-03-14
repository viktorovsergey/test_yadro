package com.example.boardservice.service;

import com.example.boardservice.entity.Board;
import com.example.boardservice.repository.BoardRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class BoardService {


    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Optional<Board> findBoardById(UUID boardId) {
        return boardRepository.findById(boardId);
    }

    public Board registerBoard(Board board) {
   return board;
    }

    public UUID moveBoard(UUID boardId, String nextStep) {
        return boardId;
    }
}