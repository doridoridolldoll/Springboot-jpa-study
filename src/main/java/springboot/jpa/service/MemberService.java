package springboot.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.jpa.dto.MemberDto;
import springboot.jpa.entity.Member;
import springboot.jpa.repository.MemberRepository;

import java.util.List;

public interface MemberService {

    Long join(Member member);

    void validateDuplicateMember(Member member);
    List<Member> findMembers();
    Member findOne(Long memberId);


    default MemberDto entityToDto(Member member) {
        MemberDto dto = MemberDto.builder()
                .name(member.getName())
                .address(member.getAddress())
                .orders(member.getOrders())
                .build();
        return dto;
    }

    default Member dtoToEntity(MemberDto dto) {
        Member entity = Member.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .orders(dto.getOrders())
                .build();
        return entity;
    }
}
