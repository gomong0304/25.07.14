package org.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.portfolio.domain.PortfolioVO;

public interface PortfolioMapper {

	@Select("SELECT *FROM tbl_portfolio WHERE bno>0")
	public List<PortfolioVO> getList(); // 추상메서드
	
	//------------------------------------------------------------------------
	
	// 위에 @Select처럼 어노테이션으로 간단한 쿼리문은 가능하나 복잡한 쿼리문은 버그가 생기거나 안돌아감.
	// 그래서 xml를 이용하여 sql문 처리를 진행한다.
	// xml을 이용하려면 src/main/resources/org/mbc/mapper 폴더를 각각 생성하고
	// 인터페이스와 이름이 같은 xml 파일을 생성한다.
	// 이것이 마이바티스 사용법이다.
	
	//------------------------------------------------------------------------
	
	public List<PortfolioVO> getList2();
	// PortfolioMapper.xml을 이용한 쿼리 처리 mapper용 메서드
	// getList2()가 호출이 되면 root-context의 mybatis가 반응하고 xml을 찾아서 db를 다녀옴
	
	//------------------------------------------------------------------------
	
	// C (insert 데이터를 삽입하는 쿼리문)는 2가지 방법이 있다.
	// 1. insert 처리후에 결과 int로 받는 방법
	// 2. pk를 먼저 생성 한 후에 insert가 되는 방법
	
	//------------------------------------------------------------------------
	
	public void insert(PortfolioVO portfolio); // xml에서 쿼리 작성
	// C-1

	
	//------------------------------------------------------------------------
	
	public void insertSelectKey(PortfolioVO portfolio); // xml에서 쿼리 작성
	// C-2
	
	
}
