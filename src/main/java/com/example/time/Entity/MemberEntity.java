package com.example.time.Entity;


import com.example.time.DTO.MemberDTO;
import lombok.*;
import javax.persistence.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "UserInfo")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @Column(unique = true)//고유한 값만 저장할 수 있음을 나타냄
    String email;

    @Column
    String password;
    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setPassword(memberDTO.getPassword());
        return memberEntity;
    }
}
