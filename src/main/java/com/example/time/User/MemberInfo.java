package com.example.time.User;


import lombok.*;
import javax.persistence.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "UserInfo")
public class MemberInfo {
    @Column(unique = true)   //고유한 값만 저장할 수 있음을 나타냄
    String name;

    @Id
    @Column(unique = true)
    String email;

    @Column
    String password;
    public MemberInfo(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
