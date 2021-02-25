package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.vo.BoardVO;
import edu.bit.ex.vo.Criteria;

public interface BoardService {
	public List<BoardVO> getList(Criteria cri);

	public BoardVO content(int getbId);

	public int totalCount(Criteria cri);

	public void write(BoardVO boardVO);

	public void modify(BoardVO boardVO);

	public void delete(int getbId);

	public BoardVO replyView(int getbId);

	public void reply(BoardVO boardVO);
}
