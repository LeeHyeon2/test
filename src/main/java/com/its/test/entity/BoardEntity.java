package com.its.test.entity;

import com.its.test.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "board_test_table")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    @Column(name = "boardWriter" , length = 30 , nullable = false)
    private String boardWriter;
    @Column(name = "boardTitle" , length = 50 , nullable = false)
    private String boardTitle;
    @Column(name = "boardContents",length = 500)
    private String boardContents;
    @Column(name = "boardHits")
    @ColumnDefault("0")
    private int boardHits;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime boardCreatedTime;



    public static BoardEntity toEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        return boardEntity;
    }
}
