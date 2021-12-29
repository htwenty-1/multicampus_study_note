package Service;

import MemberDao.MemberDao;
import MemberDto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements MemberServiceImpl {

    @Autowired
    public MemberDao dao;

//    @Autowired
//    public MemberService(MemberDao dao) {
//        this.dao = dao;
//    }

    @Override
    public List<MemberDto> allMember() {
        return dao.allMember();
    }

    @Override
    public MemberDto getMember(MemberDto dto) {
        return dao.getMember(dto);
    }

}
