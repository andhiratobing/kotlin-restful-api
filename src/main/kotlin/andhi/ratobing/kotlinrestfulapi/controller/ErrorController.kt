package andhi.ratobing.kotlinrestfulapi.controller

import andhi.ratobing.kotlinrestfulapi.error.NotFoundException
import andhi.ratobing.kotlinrestfulapi.error.UnAuthorizedException
import andhi.ratobing.kotlinrestfulapi.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String>{

        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message!!)
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String>{

        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = "Not Found")
    }

    @ExceptionHandler(value = [UnAuthorizedException::class])
    fun notFound(unAuthorizedException: UnAuthorizedException): WebResponse<String>{

        return WebResponse(
            code = 401,
            status = "UnAuthorized",
            data = "Please put your X-API-Key")
    }
}
