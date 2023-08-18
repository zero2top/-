package com.example.time.DTO;


import com.example.time.Entity.MemberEntity;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String email;
    private String name;
    private String password;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
       MemberDTO memberDTO = new MemberDTO();
       memberDTO.setId(memberEntity.getId());
       memberDTO.setEmail(memberEntity.getEmail());
       memberDTO.setName(memberEntity.getName());
       memberDTO.setPassword(memberEntity.getPassword());
       return memberDTO;
    }
}


