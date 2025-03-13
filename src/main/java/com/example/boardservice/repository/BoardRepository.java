package com.example.boardservice.repository;

import com.example.boardservice.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class BoardRepository {
    public Board save(Board board) {
    }

    public Optional<Object> findById(UUID boardId) {

        return null;
    }
}
