package com.taobao.api;

public class TaobaoApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorMessage;

	private String subErrorCode;

	private String subErrorMessage;

    public TaobaoApiException(){
    }

	public TaobaoApiException(String errorCode, String errorMessage) {
		this(errorCode, errorMessage, null, null);
	}

    public TaobaoApiException(Throwable cause) {
        super(cause);
    }

    public TaobaoApiException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
		super(buildMessage(errorCode, errorMessage, subErrorCode, subErrorMessage));
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.subErrorCode = subErrorCode;
		this.subErrorMessage = subErrorMessage;
	}

	private static String buildMessage(String errorCode, String errorMessage, String subErrorCode,
			String subErrorMessage) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Code: ").append(errorCode);
		if (subErrorCode != null) {
			strBuilder.append("/");
			strBuilder.append(subErrorCode);
		}

		strBuilder.append(", Message: ");
		strBuilder.append(errorMessage);
		if (subErrorMessage != null) {
			strBuilder.append("/");
			strBuilder.append(subErrorMessage);
		}
		return strBuilder.toString();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getSubErrorCode() {
		return subErrorCode;
	}

	public String getSubErrorMessage() {
		return subErrorMessage;
	}
}
