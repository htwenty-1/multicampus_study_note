package Service;

import MemberDto.MemberDto;

import java.util.List;


public interface MemberServiceImpl {

    List<MemberDto> allMember();

    MemberDto getMember(MemberDto dto);

}
