package org.portfolio.service;

import java.util.List;

import org.portfolio.domain.PortfolioVO;
import org.portfolio.mapper.PortfolioMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service				// 이 클래스는 서비스 계층임을 명시한다.
@AllArgsConstructor		// 생성자 자동 주입 (new PortfolioServiceImpl(mapper)의 생성자)
@Log4j2					// 로깅 처리용
public class PortfolioServiceImpl implements PortfolioService {
	
	private PortfolioMapper mapper; // db 쿼리용 객체(CRUD)

	@Override // (C-1)
	public void register(PortfolioVO portfolio) {
		// 객체가 넘어오면 메퍼를 이용해서 DB에 등록하겠다.
		
		log.info("PortfolioController.register 메서드 실행...........");
		
		mapper.insertSelectKey(portfolio);
		log.info("정상등록 후 리스트 출력테스트........");
		mapper.getList2();
	}
	
	//-------------------------------------------------------------------------

	@Override
	public PortfolioVO get(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(PortfolioVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PortfolioVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
