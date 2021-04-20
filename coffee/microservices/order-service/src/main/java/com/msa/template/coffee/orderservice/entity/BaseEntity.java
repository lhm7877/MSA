package com.msa.template.coffee.orderservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
//XXX 이후민 : BaseEntity는 모든 entity가 다 상속받아야할 것 같은 이름인데 그렇지는 않네요 상속받지 않은건 생성/수정일자가 안필요한가요?
//XXX 이후민 : id도 추가하는건 어떻게 생각하세요?
//XXX 이후민 : entity와 repository를 persistence 패키지 안에 넣는건 어때요?
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
