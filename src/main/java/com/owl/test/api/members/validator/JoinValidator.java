package com.owl.test.api.members.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.owl.test.api.members.dto.RequestJoin;
import com.owl.test.commons.validators.MobileValidator;
import com.owl.test.commons.validators.PasswordValidator;
import com.owl.test.repositories.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator, PasswordValidator, MobileValidator {

	private final MemberRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RequestJoin.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestJoin form = (RequestJoin) target;
		/**
		 * 1. 아이디 중복 여부 체크 2. 비밀번호 복잡성 체크 3. 비밀번호 및 비밀번호 확인 일치 여부 4. 휴대전화번호 형식 체크
		 */

		String email = form.email();
		String password = form.password();
		String confirmPassword = form.confirmPassword();
		String mobile = form.mobile();

		if (email != null && !email.isBlank() && repository.exists(email)) {
			errors.rejectValue("email", "Duplicate");
		}

		if (password != null && !password.isBlank()
				&& (!alphaCheck(password, false) || !numberCheck(password) || !specialCharsCheck(password))) {
			errors.rejectValue("password", "Complexity");
		}

		if (password != null && !password.isBlank() && confirmPassword != null && !confirmPassword.isBlank()
				&& !password.equals(confirmPassword)) {
			errors.rejectValue("confirmPassword", "Mismatch");
		}

		if (mobile != null && !mobile.isBlank() && !mobileNumCheck(mobile)) {
			errors.rejectValue("mobile", "Mobile");
		}
	}

}
