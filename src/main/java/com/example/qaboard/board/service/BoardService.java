package com.example.qaboard.board.service;

import com.example.qaboard.board.dao.BoardDao;
import com.example.qaboard.board.dto.BoardDto;
import com.example.qaboard.board.entity.Board;
import com.example.qaboard.global.util.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;
    private final Integer BLOCKSIZE=5;
    private final Integer PAGESIZE=3;

    public Boolean write(BoardDto.Write dto) {

        String boardAttachedFileName = "N";
        MultipartFile mf = dto.getBoardAttachedFile();
        if(mf!=null && !mf.isEmpty()) {
            String path = System.getProperty("user.dir")+"/./src/main/resources/file/";
            File file = new File(path, mf.getOriginalFilename());
            try {
                mf.transferTo(file);
                boardAttachedFileName = path+mf.getOriginalFilename();
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        Board board = dto.toEntity(boardAttachedFileName);
        return boardDao.write(board)>=1;
    }

    public void delete(Integer boardNumber, Integer boardWriter, Integer memberNumber) {
        if(boardWriter.equals(memberNumber)){
            boardDao.delete(boardNumber);
        }

    }

        public BoardDto.PreviewPage preview(Integer pageNumber) {
            Integer countOfPreview = boardDao.count();
            Pagination page = new Pagination(BLOCKSIZE,PAGESIZE,pageNumber,countOfPreview);
            List<BoardDto.Preview> preview =  boardDao.preview( page.getStartRowNum(),page.getPageSize());
            return new BoardDto.PreviewPage(pageNumber, page.getPrevPage(), page.getStartPage(), page.getEndPage(), page.getNextPage(), preview);
        }

    public BoardDto.Read read(Integer boardNumber) {
        return boardDao.read(boardNumber);
    }

    public Boolean update(String boardTitle, String boardContent, Integer boardNumber) {
       return boardDao.update(boardTitle, boardContent, boardNumber)>=1;
    }
}

