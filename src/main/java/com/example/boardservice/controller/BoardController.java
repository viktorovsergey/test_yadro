package com.example.boardservice.controller;

import com.example.boardservice.entity.Board;
import com.example.boardservice.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/boards")
public class BoardController {


    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // Регистрация новой платы
    @PostMapping
    public ResponseEntity<Board> registerBoard(@RequestBody Board board) {
        Board registeredBoard = boardService.registerBoard(board);
        return ResponseEntity.ok(registeredBoard);
    }

    // Перемещение платы по шагам
    @PatchMapping("/{boardId}/move")
    public ResponseEntity<UUID> moveBoard(@PathVariable UUID boardId, @RequestParam String nextStep) {
        UUID updatedBoard = boardService.moveBoard(boardId, nextStep);
        return ResponseEntity.ok(updatedBoard);
    }
}
