package com.example.qaboard.board.dto;

import com.example.qaboard.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public class BoardDto {

    @Data
    public static class Preview{
        private Integer boardNumber;
        private LocalDateTime boardWriteDate;
        private String boardTitle;
        private String boardWriter;
        private Boolean boardAnswerEnabled;
    }

    @Data
    public static class Write{

        private String boardTitle;
        private String boardContent;
        private Integer boardWriter;
        private MultipartFile boardAttachedFile;

        public Board toEntity(String boardAttachedFile) {

            return Board.builder().boardWriteDate(LocalDateTime.now()).boardTitle(boardTitle).boardContent(boardContent).
                    boardWriter(boardWriter).boardAttachedFile(boardAttachedFile).build();

        }
    }

    @Data
    public static class Answer{
        private Integer boardNumber;
        private LocalDateTime boardAnswerDate;
        private String boardAnswerContent;
    }

    @Data
    @AllArgsConstructor
    public static class PreviewPage {
        private Integer pageNo;
        private Integer prev;
        private Integer start;
        private Integer end;
        private Integer next;
        private List<Preview> preview;
    }

    @Data
    public static class Read {

        private Integer boardNumber;
        private LocalDateTime boardWriteDate;
        private String boardTitle;
        private String boardContent;
        private Integer boardWriter;
        private String memberNickname;
        private String boardAttachedFile;
        private String boardAnswerContent;
        private LocalDateTime boardAnswerDate;
        private Boolean boardAnswerEnabled;
        private Boolean boardEnabled;
    }

    @Data
    public static class Update{
        private Integer boardNumber;
        private String boardTitle;
        private String boardContent;
    }

}
