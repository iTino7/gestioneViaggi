package sabatinoborrelli.progetto.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class Config {
    @Value("${cloudinary.cloud_name}")
    private String name;

    @Value("${cloudinary.api_key}")
    private String apyKey;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = ObjectUtils.asMap(
                "cloud_name", name,
                "api_key", apyKey
        );
        return new Cloudinary(config);
    }
}
