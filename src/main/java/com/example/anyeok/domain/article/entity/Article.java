package com.example.anyeok.domain.article.entity;

import com.example.anyeok.domain.member.entity.Member;
import com.example.anyeok.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {
    private String subject;
    private String content;
    @ManyToOne
    private Member member;
}
