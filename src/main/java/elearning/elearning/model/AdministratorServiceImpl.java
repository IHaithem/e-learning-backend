package elearning.elearning.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator getAdministratorById(Long administratorId) {
        return administratorRepository.findById(administratorId).orElse(null);
    }

    @Override
    public Administrator addAdministrator(Administrator administrator) {
         return administratorRepository.save(administrator);
    }

    @Override
    public Administrator updateAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public void deleteAdministrator(Long administratorId) {
        administratorRepository.deleteById(administratorId);
    }

    @Override
    public List<Administrator> findByFirstNameOrLastName(String searchwith) {
       return administratorRepository.findByFirstNameOrLastName(searchwith, searchwith);
    }


}
