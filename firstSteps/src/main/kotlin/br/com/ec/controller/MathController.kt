package br.com.ec.controller

import br.com.ec.converters.NumberConverter
import br.com.ec.exceptions.UnsupportedMathOperationException
import br.com.ec.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    private val math: SimpleMath = SimpleMath()


    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sun(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sun(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(@PathVariable(value = "numberOne") numberOne: String?,
             @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.mult(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.div(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = ["/med/{numberOne}/{numberTwo}"])
    fun med(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sqrt/{number}"])
    fun sqrt(@PathVariable(value = "number") number: String?
    ): Double {
        if(!NumberConverter.isNumeric(number)) {
            throw UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.square(NumberConverter.convertToDouble(number))
    }


}