package ch.hevs.sdi.springhellodata

import org.springframework.web.bind.annotation.*

@RestController
class PhoneBookRestAPI(private val phoneBookRepository: PhoneBookRepository) {
    @GetMapping("/phonebook/pbservice")
    fun getAllPhoneBookRecords() = phoneBookRepository.findAll()

    @GetMapping("/phonebook/pbservice/{name}")
    fun getPhoneBookRecordByName(@PathVariable name: String): PhoneBookRecord = phoneBookRepository.findById(name).orElse(null) ?: throw RecordNotFoundException()

    @PostMapping("/phonebook/pbservice")
    fun addPhoneBookRecord(@RequestBody record: PhoneBookRecord) = phoneBookRepository.insert(record)

    @PutMapping("/phonebook/pbservice/{name}")
    fun modifyPhoneBookRecord(@PathVariable name: String, @RequestBody record: PhoneBookRecord) {
        val existing = phoneBookRepository.findById(name).orElse(null) ?: throw RecordNotFoundException()
        existing.phone = record.phone
        phoneBookRepository.save(existing)
    }

    @DeleteMapping("//phonebook/pbservice/{name}")
    fun deletePhoneBookRecord(@PathVariable name: String) = phoneBookRepository.deleteById(name)
}
