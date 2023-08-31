package com.example.qaboard.board.dao;

import com.example.qaboard.board.dto.BoardDto;
import com.example.qaboard.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    public Integer write(Board board);

    public void delete(Integer boardNumber);
    public List<BoardDto.Preview> preview(Integer start, Integer limit);
    public Integer count();

    public BoardDto.Read read(Integer boardNumber);

    public Integer update(String boardTitle, String boardContent, Integer boardNumber);
}
