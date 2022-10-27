package com.example.concour.filter;



import com.example.concour.service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.concour.service.facade.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAutorisationFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String autorization = httpServletRequest.getHeader(JwtConstant.AUTORIZATION);
        String token = null;
        String usernameFromToken = null;
        if (autorization != null && autorization.startsWith(JwtConstant.BEARER)) {
            token = autorization.substring(JwtConstant.BEARER.length());
            usernameFromToken = jwtUtil.getUsernameFromToken(token);
        }
        if (usernameFromToken != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userService.loadUserByUsername(usernameFromToken);
            if (jwtUtil.validateToken(token, userDetails)) {
                jwtUtil.registerAuthenticationTokenInContext(userDetails, httpServletRequest);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

}
// verifier l autoriation
// extret le token se basant sur l'autorisation
//Extrer le user name en se basant sur le token via methode getusernamefromtoken
//si ca marche telecharger usr en sebant sur l username
// il va essyer de valider le token
// enregistrer l user