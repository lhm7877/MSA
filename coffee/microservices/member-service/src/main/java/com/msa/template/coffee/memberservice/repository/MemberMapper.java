package com.msa.template.coffee.memberservice.repository;

import com.msa.template.coffee.api.core.member.dto.MemberDto;
import com.msa.template.coffee.memberservice.model.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    
    MemberDto entityToApi(Member member);
    
}
