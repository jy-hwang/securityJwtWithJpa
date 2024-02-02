package com.owl.test.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.owl.test.entities.Member;
import com.owl.test.entities.QMember;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member>{

	Optional<Member> findByEmail(String email);
	
	default boolean exists(String email) {
		return exists(QMember.member.email.eq(email));
	}

}
