package org.portfolio.service;

import java.util.List;

import org.portfolio.domain.PortfolioVO;


public interface PortfolioService {
	
	public void register(PortfolioVO portfolio); //조장이 만든 메서드명 (시그니처)
	// 게시판 등록용 메서드
	
	public PortfolioVO get(Long bno);
	// 게시글 자세히 보기 (번호를 넣으면 객체가 나와야한다.)
	
	public boolean modify(PortfolioVO portfolio);
	// 게시글 수정하기 (객체가 들어가서 수정이 됐는지 T/F 값으로 출력)
	
	public boolean remove(Long bno);
	// 게시글 삭제하기 (번호가 들어가서 삭제 됐는지 T/F 값으로 출력)
	
	public List<PortfolioVO> getList();
	// 이 메서드가 호출되면 리스트타입으로 BoardVO객체들이 넘어온다.
	// List : 동적리스트 / <> 제네릭 : 강제로 객체 타입을 정함.
	
}
