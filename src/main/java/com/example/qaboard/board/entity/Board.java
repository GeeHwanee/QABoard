package com.example.qaboard.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;

@Builder
@Getter
public class Board {

    private Integer boardNumber;
    private LocalDateTime boardWriteDate;
    private String boardTitle;
    private String boardContent;
    private Integer boardWriter;
    private String boardAttachedFile;
    private String boardAnswerContent;
    private LocalDateTime boardAnswerDate;
    private Boolean boardAnswerEnabled;
    private Boolean boardEnabled;
}
