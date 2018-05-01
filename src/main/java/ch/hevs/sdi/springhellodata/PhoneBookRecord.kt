package ch.hevs.sdi.springhellodata

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "PhoneBook")
data class PhoneBookRecord(@Id var name: String, var phone: String?)
