package br.com.ec.exceptions

import java.lang.RuntimeException

class UnsupportedMathOperationException(exception: String?) : RuntimeException(exception)