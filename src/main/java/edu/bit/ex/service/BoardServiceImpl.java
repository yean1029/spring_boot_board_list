package edu.bit.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.vo.BoardVO;
import edu.bit.ex.vo.Criteria;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList(Criteria cri){
		log.info("list");
		return mapper.getList(cri);
	}

	@Override
	public int totalCount(Criteria cri) {
		log.info("count");	
		return mapper.totalCount(cri);
	}
	
	@Override
	public BoardVO content(int getbId) {
		log.info("content");
		mapper.hit(getbId);
		return mapper.content(getbId);
	}
}
