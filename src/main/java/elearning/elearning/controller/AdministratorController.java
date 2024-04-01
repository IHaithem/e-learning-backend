package elearning.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import elearning.elearning.model.Administrator;
import elearning.elearning.model.AdministratorService;

import java.util.List;

@RestController
@RequestMapping("/administrator")
@CrossOrigin("http://localhost:3000")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        List<Administrator> administrators = administratorService.getAllAdministrators();

        // Log or print the administrators
        administrators.forEach(administrator -> {
            System.out.println("Administrator ID: " + administrator.getId());
            System.out.println("Username: " + administrator.getUsername());
            // Add more fields as needed
        });

        return ResponseEntity.ok(administrators);
    }

    @GetMapping("/{administratorId}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long administratorId) {
        return ResponseEntity.ok(administratorService.getAdministratorById(administratorId));
    }

    @GetMapping("/search/{searchwith}")
    public ResponseEntity<List<Administrator>> getAdministratorByName(@PathVariable String searchwith) {
        return ResponseEntity.ok(administratorService.findByFirstNameOrLastName(searchwith));
    }

    @PostMapping
    public ResponseEntity<Administrator> addAdministrator(@RequestBody Administrator administrator) {
        String w=administrator.getPassword();
        administrator.setPassword(passwordEncoder.encode(w));
        return ResponseEntity.ok(administratorService.addAdministrator(administrator));
    }

    @DeleteMapping("/{administratorId}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long administratorId) {
        administratorService.deleteAdministrator(administratorId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{administratorId}")
    public ResponseEntity<Administrator> updateAdministrator(@RequestBody Administrator administrator,
                                                              @PathVariable Long administratorId) {
        administrator.setId(administratorId);

        return ResponseEntity.ok(administratorService.updateAdministrator(administrator));
    }
}
