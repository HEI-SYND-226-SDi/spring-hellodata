package ch.hevs.sdi.springhellodata

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneBookRepository: MongoRepository<PhoneBookRecord, String>
