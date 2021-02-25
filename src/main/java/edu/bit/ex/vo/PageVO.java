package edu.bit.ex.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageVO {
	private Criteria cri;
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realPage = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realPage<=this.endPage) {
			this.endPage = realPage;
		}		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realPage;	
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page)
				.queryParam("amount", cri.getAmount())
				.build();
		
				return uriComponentsBuilder.toUriString();
	}

}

