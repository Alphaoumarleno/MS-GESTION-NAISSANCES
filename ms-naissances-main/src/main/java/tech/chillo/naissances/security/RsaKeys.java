package tech.chillo.naissances.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@ConfigurationProperties(prefix = "rsa")
public class RsaKeys {

    private Resource privateKey;
    private Resource publicKey;

    public RSAPrivateKey privateKey() throws Exception {
        return KeyUtils.loadPrivateKey(privateKey);
    }

    public RSAPublicKey publicKey() throws Exception {
        return KeyUtils.loadPublicKey(publicKey);
    }

    public void setPrivateKey(Resource privateKey) {
        this.privateKey = privateKey;
    }

    public void setPublicKey(Resource publicKey) {
        this.publicKey = publicKey;
    }
}
