package MemberDao;

import MemberDto.MemberDto;

import java.util.List;

public interface MemberDao {

    List<MemberDto> allMember();
    MemberDto getMember(MemberDto dto);

}
