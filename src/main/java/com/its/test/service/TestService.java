package com.its.test.service;

import com.its.test.dto.BoardDTO;
import com.its.test.entity.BoardEntity;
import com.its.test.repository.BoardRepository;
import com.its.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final MemberRepository memberRepository;


    public Long save(BoardDTO boardDTO) {
        return boardRepository.save(BoardEntity.toEntity(boardDTO)).getId();
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (BoardEntity boardEntity : boardEntities){
            boardDTOS.add(BoardDTO.toDTO(boardEntity));
        }
        return boardDTOS;
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        return BoardDTO.toDTO(boardEntity.get());
    }
}
