package com.example.boardservice.service;

import com.example.boardservice.entity.Board;
import com.example.boardservice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BoardService {


    private  final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // Регистрация новой платы
    public Board registerBoard(Board board) {
        board.setCurrentStep("Регистрация");
        return boardRepository.save(board);
    }

    // Перемещение платы по шагам
    public Board moveBoard(UUID boardId, String nextStep) {
        Board board =  boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Плата не найдена"));

        // Простая проверка допустимости перехода
        if (!isValidTransition(board.getCurrentStep(), nextStep)) {
            throw new RuntimeException("Недопустимый переход шага");
        }

        board.setCurrentStep(nextStep);
        return boardRepository.save(board);
    }


    private boolean isValidTransition(String currentStep, String nextStep) {
        // Пример простой логики переходов
        switch (currentStep) {
            case "Регистрация":
                return nextStep.equals("Установка компонентов");
            case "Установка компонентов":
                return nextStep.equals("Контроль качества");
            case "Контроль качества":
                return nextStep.equals("Ремонт") || nextStep.equals("Упаковывание");
            case "Ремонт":
                return nextStep.equals("Контроль качества");
            case "Упаковывание":
                return false; // Процесс завершён
            default:
                throw new RuntimeException("Неизвестный шаг");
        }
    }
}