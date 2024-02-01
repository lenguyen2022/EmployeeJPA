package ca.lenguyen.employeejpa.databases;

import ca.lenguyen.employeejpa.beans.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
