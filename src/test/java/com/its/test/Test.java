package com.its.test;

import com.its.test.dto.BoardDTO;
import com.its.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
public class Test {
    @Autowired
    private TestService testService;

    public BoardDTO testDTO(){
        BoardDTO boardDTO =
                new BoardDTO("title","writer","contents");
        return boardDTO;
    }

    @org.junit.jupiter.api.Test
    @Transactional
    @Rollback(value = true)
    public void saveTest(){
        BoardDTO boardDTO =
                new BoardDTO("title","writer","contents");
        Long saveId = testService.save(boardDTO);
        BoardDTO findResult = testService.findById(saveId);

        assertThat(boardDTO.getBoardWriter()).isEqualTo(findResult.getBoardWriter());
    }
}
