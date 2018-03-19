package p2.backend.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import p2.backend.Beans.Employee;
import p2.backend.Service.EmployeeService;
import p2.backend.security.SecurityConstants;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import p2.backend.Repository.EmployeeRepository;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {
	private EmployeeService employeeService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private Logger log;

	@Autowired
	public UserController(EmployeeService employeeService ,
						  BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.employeeService = employeeService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody Employee user) {
		System.out.println(user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		employeeService.saveEmployee(user);

	}

	@PostMapping("/signin")
	public String signIn(@RequestBody Employee user) {
		//System.out.println(user.toString());
		return signinDAO(user);
	}

	public String signinDAO(Employee user){
		Employee emp = employeeService.byUsername(user.getUsername());
		if(bCryptPasswordEncoder.matches(user.getPassword(),emp.getPassword())){
			try {
				String role = "manager";
				Algorithm algorithmHS = Algorithm.HMAC512(SecurityConstants.SECRET);
				String token = JWT.create()
						.withAudience(role) //"Audience" is the means by which users are organized into groups
						.withIssuer("Zootropolis") //Should be the name of the site or service.
						.withSubject(emp.getUsername()) //Subject is the user, typically by name or ID. Here, it is name.
						.withExpiresAt(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
						.sign(algorithmHS);
				return token;

			} catch (UnsupportedEncodingException e)
			{
				log.error(e.getMessage());
			}

		}
		return "No token";
	}

}
