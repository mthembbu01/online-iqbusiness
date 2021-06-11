package net.iqbusiness.buhle.onlineregistrationapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@ControllerAdvice
public class PersonExceptionController {

	// the date formatter for our date
	final DateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

	@ExceptionHandler(value = { PersonNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> exception(PersonNotFoundException ex, WebRequest request) {
//		1.The payload to handle the exception error details
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND, sdf.format(new Date()),
				HttpStatus.NOT_FOUND.value(), request.getDescription(false));
//		2. Return the Response Entity containing the payload and the exception status
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}

/** An error details class to hold the details of an error */
final class ErrorDetails {
	private final String request;
	private final String message;
	private final HttpStatus httpStatus;
	private final String timestamp;
	private final int status;

	public ErrorDetails(String message, HttpStatus httpStatus, String timestamp, int status, String request) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
		this.status = status;
		this.request = request;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

}
