package com.its.test.controller;


import com.its.test.dto.BoardDTO;
import com.its.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        Long id = testService.save(boardDTO);
        return "/testtesttesttesttesttest";
    }


    //
    //
    //test test
    @GetMapping("/board")
    public String findAll(Model model){
        List<BoardDTO> boardDTOS = testService.findAll();
        model.addAttribute("boardDTOS", boardDTOS);
        return "/findAll";
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable Long id , Model model){
        BoardDTO boardDTO = testService.findById(id);
        model.addAttribute("boardDTO",boardDTO);
        return "/detail";
    }
}
