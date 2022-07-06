package com.its.test.repository;

import com.its.test.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
