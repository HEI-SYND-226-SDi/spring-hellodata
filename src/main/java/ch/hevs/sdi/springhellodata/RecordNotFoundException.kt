package ch.hevs.sdi.springhellodata

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class RecordNotFoundException: RuntimeException("Phone book record not found.")
