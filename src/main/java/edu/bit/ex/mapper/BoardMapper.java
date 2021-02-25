package edu.bit.ex.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import edu.bit.ex.vo.BoardVO;
import edu.bit.ex.vo.Criteria;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getList(Criteria cri);

	public BoardVO content(int getbId);

	public int totalCount(Criteria cri);

	public void hit(int getbId);

	public void write(BoardVO boardVO);

	public void modify(BoardVO boardVO);

	public void delete(int getbId);
	
	
}
