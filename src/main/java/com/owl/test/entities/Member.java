package com.owl.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.owl.test.commons.constants.MemberType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {

	@Id
	@GeneratedValue
	private Long seq;

	@Column(length = 60, unique = true, nullable = false)
	private String email;

	@Column(length = 65, nullable = false)
	private String password;

	@Column(length = 30, nullable = false)
	private String name;

	private String mobile;

	@Enumerated(EnumType.STRING)
	@Column(length = 30, nullable = false)
	private MemberType type = MemberType.USER;

}
