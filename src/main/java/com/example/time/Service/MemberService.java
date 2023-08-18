package com.example.time.Service;


import com.example.time.DTO.MemberDTO;
import com.example.time.Entity.MemberEntity;
import com.example.time.Respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByEmail(memberDTO.getEmail());
        if(byMemberEmail.isPresent()){
            MemberEntity  memberEntity = byMemberEmail.get();
            if(memberEntity.getPassword().equals(memberDTO.getPassword())){ //비밀번호 일치, memberDTO.getPassword()이 부분이 로그인시 입력한 비밀번호
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);  //Entity -> DTO로 변환
                return dto;    //DTO 리턴
            }
            else{
                return null;  //비밀번호 불일치
            }
        }
        else{
            return null;  //이메일 없음
        }
    }
    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = toMemberDTOList(memberEntityList);
        return memberDTOList;
    }

    private List<MemberDTO> toMemberDTOList(List<MemberEntity> memberEntityList) {
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity me : memberEntityList){
            memberDTOList.add(MemberDTO.toMemberDTO(me));
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        }
        else{
            return null;
        }

    }
}
