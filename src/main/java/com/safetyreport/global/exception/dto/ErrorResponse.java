package com.safetyreport.global.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.safetyreport.global.exception.code.ErrorCode;

import jakarta.validation.ConstraintViolation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
	int status,
	String message,
	List<ValidationError> errors
) {
	// 에러 응답 (유효성 검사 없음, ErrorCode 메시지만 표시)
	public static ErrorResponse of(ErrorCode errorCode) {
		return new ErrorResponse(
			errorCode.getHttpStatus().value(),
			errorCode.getMessage(),
			null
		);
	}

	// 에러 응답 (유효성 검사 포함)
	public static ErrorResponse of(ErrorCode errorCode, BindingResult bindingResult) {
		return new ErrorResponse(
			errorCode.getHttpStatus().value(),
			errorCode.getMessage(),
			ValidationError.of(bindingResult)
		);
	}

	// 에러 응답 (ConstraintViolation 포함)
	public static ErrorResponse of(ErrorCode errorCode, Set<ConstraintViolation<?>> violations) {
		return new ErrorResponse(
			errorCode.getHttpStatus().value(),
			errorCode.getMessage(),
			ValidationError.of(violations)
		);
	}

	// 에러 응답 (추가 세부 정보 포함)
	public static ErrorResponse of(ErrorCode errorCode, Object detail) {
		return new ErrorResponse(
			errorCode.getHttpStatus().value(),
			errorCode.getMessage() + (detail != null ? ": " + detail : ""),
			null
		);
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public record ValidationError(
		String path,
		String field,
		String message
	) {
		// ConstraintViolation -> ValidationError 변환
		public static List<ValidationError> of(Set<ConstraintViolation<?>> violations) {
			return violations == null ? List.of() : violations.stream()
				.map(violation -> new ValidationError(
					violation.getPropertyPath().toString(),
					null,
					violation.getMessage()
				))
				.toList();
		}

		// FieldError -> ValidationError 변환
		public static List<ValidationError> of(BindingResult bindingResult) {
			return bindingResult.getFieldErrors().stream()
				.map(error -> new ValidationError(
					null,
					error.getField(),
					error.getDefaultMessage()
				))
				.toList();
		}
	}
}
