package ch.hevs.sdi.springhellodata;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PhoneBookRestAPI {
    private PhoneBookRepository phoneBookRepository;

    public PhoneBookRestAPI(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    @GetMapping("/phonebook/pbservice")
    public Collection<PhoneBookRecord> getAllPhoneBookRecords() {
        return phoneBookRepository.findAll();
    }

    @GetMapping("/phonebook/pbservice/{name}")
    public PhoneBookRecord getPhoneBookRecordByName(@PathVariable String name) {
        return phoneBookRepository.findById(name).orElseThrow(RecordNotFoundException::new);
    }

    @PostMapping("/phonebook/pbservice")
    public void addPhoneBookRecord(@RequestBody PhoneBookRecord record) {
        phoneBookRepository.insert(record);
    }

    @PutMapping("/phonebook/pbservice/{name}")
    public void modifyPhoneBookRecord(@PathVariable String name, @RequestBody PhoneBookRecord record) {
        PhoneBookRecord existing = phoneBookRepository.findById(name).orElseThrow(RecordNotFoundException::new);
        existing.setPhone(record.getPhone());
        phoneBookRepository.save(existing);
    }

    @DeleteMapping("//phonebook/pbservice/{name}")
    public void deletePhoneBookRecord(@PathVariable String name) {
        phoneBookRepository.deleteById(name);
    }
 }
