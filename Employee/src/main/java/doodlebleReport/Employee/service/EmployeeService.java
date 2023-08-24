package doodlebleReport.Employee.service;

import doodlebleReport.Employee.Model.EmployeeModel;
import doodlebleReport.Employee.entity.Employees;
import doodlebleReport.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired(required = true)
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Employees> employee = employeeRepository.findByName(username);

        return employee.map(EmployeeModel::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));


    }

    public ResponseEntity<String> addUser(Employees employee) {

        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);

        return new ResponseEntity<>(
                "User Added",
                HttpStatus.BAD_REQUEST);
    }


    public String getUser(int id) {
      Employees employee= employeeRepository.findById(id).orElse(null);
      return employee.getName();

    }
}
