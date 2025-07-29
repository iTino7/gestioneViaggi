package sabatinoborrelli.progetto.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import sabatinoborrelli.progetto.entities.Employee;
import sabatinoborrelli.progetto.exceptions.UnauthorizedException;
import sabatinoborrelli.progetto.services.EmployeeService;

import java.io.IOException;
import java.util.UUID;

@Component
public class JwFilter extends OncePerRequestFilter {


    @Autowired
    private JwTools jwTools;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer "))
            throw new UnauthorizedException("Inserire il token nel formato corretto!");

        String accessToken = authHeader.replace("Bearer ", "");

        jwTools.verifyToken(accessToken);

        String user = jwTools.extractIdFromToken(accessToken);
        Employee currentEmployee = this.employeeService.findById(UUID.fromString(user));
        Authentication authentication = new UsernamePasswordAuthenticationToken(currentEmployee, null, currentEmployee.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);


        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return new AntPathMatcher().match("/auth/**", request.getServletPath());
    }
}
