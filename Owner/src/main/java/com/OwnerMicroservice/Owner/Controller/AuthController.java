package com.OwnerMicroservice.Owner.Controller;



import com.OwnerMicroservice.Owner.Entity.User;
import com.OwnerMicroservice.Owner.Repository.UserRepository;
import com.OwnerMicroservice.Owner.payload.request.LoginRequest;
import com.OwnerMicroservice.Owner.payload.request.SignupRequest;
import com.OwnerMicroservice.Owner.payload.response.JwtResponse;
import com.OwnerMicroservice.Owner.payload.response.MessageResponse;
import com.OwnerMicroservice.Owner.security.jwt.JwtUtils;
import com.OwnerMicroservice.Owner.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/Owner/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(
			@Validated @RequestBody LoginRequest loginRequest) {


		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(),
												 userDetails.getUsername(),
												 userDetails.getEmail()
												 ));
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Ownersignup is already taken!"));
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new Receptionist's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("Owner added successfully!"));
	}



}