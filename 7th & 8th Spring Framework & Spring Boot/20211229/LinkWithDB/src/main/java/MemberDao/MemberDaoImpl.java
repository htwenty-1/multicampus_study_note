package MemberDao;

import MemberDto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired       // 객체 자동 생성 ===> SqlSession sqlSession = new Sql;
    SqlSession sqlSession;

    String nameSpace = "Member.";

    @Override
    public List<MemberDto> allMember() {
        List<MemberDto> list = sqlSession.selectList(nameSpace + "Member.allMember");
        return list;
    }

    @Override
    public MemberDto getMember(MemberDto dto) {
        MemberDto mem = sqlSession.selectOne(nameSpace + "getMember", dto);
        return mem;
    }

}
