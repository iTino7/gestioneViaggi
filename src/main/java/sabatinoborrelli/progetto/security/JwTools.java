package sabatinoborrelli.progetto.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sabatinoborrelli.progetto.entities.Employee;
import sabatinoborrelli.progetto.exceptions.UnauthorizedException;

import java.util.Date;

@Component
public class JwTools {
    @Value("${jwt.secret}")
    private String secret;

    public String createToken(Employee employee) {
        Date currentDate = new Date(System.currentTimeMillis());

        return Jwts.builder()
                .issuedAt(currentDate)
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .subject(String.valueOf(employee.getId()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    public void verifyToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build().parse(token);
        } catch (Exception ex) {
            throw new UnauthorizedException("Problemi con il token");
        }
    }
}
