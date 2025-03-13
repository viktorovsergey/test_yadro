package com.example.boardservice.controller;

import com.example.boardservice.entity.Board;
import com.example.boardservice.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // Регистрация новой платы
    @PostMapping
    public ResponseEntity<Board> registerBoard(@RequestBody Board board) {
        Board registeredBoard = boardService.registerBoard(board);
        return ResponseEntity.ok(registeredBoard);
    }

    // Перемещение платы по шагам
    @PatchMapping("/{boardId}/move")
    public ResponseEntity<Board> moveBoard(@PathVariable UUID boardId, @RequestParam String nextStep) {
        Board updatedBoard = boardService.moveBoard(boardId, nextStep);
        return ResponseEntity.ok(updatedBoard);
    }
}
