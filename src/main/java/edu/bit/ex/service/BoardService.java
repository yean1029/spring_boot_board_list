package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.vo.BoardVO;
import edu.bit.ex.vo.Criteria;

public interface BoardService {
	public List<BoardVO> getList(Criteria cri);

	public BoardVO content(int getbId);

	public int totalCount(Criteria cri);
}
