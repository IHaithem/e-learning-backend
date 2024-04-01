package elearning.elearning.model;

import java.util.List;

public interface AdministratorService {
    List<Administrator> getAllAdministrators();
    Administrator getAdministratorById(Long administratorId);
    Administrator addAdministrator(Administrator administrator);
    Administrator updateAdministrator(Administrator updatedAdministrator);
    void deleteAdministrator(Long administratorId);
    List<Administrator> findByFirstNameOrLastName(String searchwith);

}
