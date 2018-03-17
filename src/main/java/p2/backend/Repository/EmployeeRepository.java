package p2.backend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p2.backend.Beans.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findByUsernameAndPassword(String username, String password);
}
