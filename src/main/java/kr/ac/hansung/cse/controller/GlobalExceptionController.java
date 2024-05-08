package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.exception.OfferNotFoundException;
import kr.ac.hansung.cse.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice // 전역 Exception Handler
public class GlobalExceptionController {

    // Exception Stack trace를 보여주는 것은 보안상 적절하지 않다
    @ExceptionHandler(OfferNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOfferNotFoundException(HttpServletRequest req, OfferNotFoundException ex) {

        String requestUri = req.getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setRequestUri(requestUri);
        errorResponse.setErrorCode("offer.notfound.exception");
        errorResponse.setErrorMsg("Offer with id " + ex.getOfferId() + "not found");

        // Handler를 Body에 담아 전달
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
