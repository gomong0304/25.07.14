package org.portfolio.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.portfolio.domain.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class PortfolioMapperTests { // board에서 사용하는 DB 테스트용
	
	//-----------------------------------------------------------------------------------
	
	@Setter(onMethod_ =@Autowired)
	private PortfolioMapper mapper; // 인터페이스로 만든 객체를 세터로 연결
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testGetList() {
		
		mapper.getList().forEach(portfolio -> log.info(portfolio));
	}
	
	//-----------------------------------------------------------------------------------
	
	@Test
	public void testGetListXML() {
		
		mapper.getList2().forEach(portfolio -> log.info(portfolio));
	}

	//-----------------------------------------------------------------------------------
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testInsert() {
		
		PortfolioVO portfolio=new PortfolioVO();
		portfolio.setTitle("제목추가1");
		portfolio.setContent("내용추가1");
		portfolio.setWriter("작성자추가1");
		
		mapper.insert(portfolio);
		
		log.info(portfolio);
		}

	//-----------------------------------------------------------------------------------
	
	@Test
	public void testInsertSelectKey() {
		
		PortfolioVO portfolio=new PortfolioVO();
		portfolio.setTitle("제목추가2");
		portfolio.setContent("내용추가2");
		portfolio.setWriter("작성자추가2");
		
		mapper.insertSelectKey(portfolio);
		
		log.info(portfolio);
		log.info("내가 만든 게시물의 번호는 : " + portfolio.getBno());
	}
}
