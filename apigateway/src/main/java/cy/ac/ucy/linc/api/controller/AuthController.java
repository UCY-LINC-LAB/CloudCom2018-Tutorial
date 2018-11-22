package cy.ac.ucy.linc.api.controller;

import cy.ac.ucy.linc.api.payload.JWTAuthenticationResponse;
import cy.ac.ucy.linc.api.payload.LoginPayload;
import cy.ac.ucy.linc.api.security.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginPayload loginPayload){

        logger.info("Username -->  "+loginPayload.getUsername()+"  , Password --> "+loginPayload.getPassword());

        //Throws DisabledException, LockedException, BadCredentialsException
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginPayload.getUsername(),
                        loginPayload.getPassword()
                )
        );


        // In case of bad credentials BadCredentialsException is thrown

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(loginPayload.getUsername());

        return ResponseEntity.ok(new JWTAuthenticationResponse(jwt));

    }

    // No signup method is implemented.

}
