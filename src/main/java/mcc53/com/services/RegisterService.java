package mcc53.com.services;

import mcc53.com.models.Department;
import mcc53.com.models.Employee;
import mcc53.com.models.RegisterRequest;
import mcc53.com.models.User;
import mcc53.com.repositories.EmployeeRepository;
import mcc53.com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private EmployeeRepository employeeRepository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(EmployeeRepository employeeRepository,
                           UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterRequest saveRegister(RegisterRequest registerRequest){
        Employee employee = new Employee();
        employee.setFirstName(registerRequest.getFirstName());
        employee.setLastName(registerRequest.getLastName());
        employee.setEmail(registerRequest.getEmail());
        employee.setAddress(registerRequest.getAddress());
        employee.setDepartment(new Department(registerRequest.getDepartment()));

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        user.setPassword(encodedPassword);
        user.setEmployee(employeeRepository.save(employee));
        userRepository.save(user);

        return registerRequest;
    }

}
