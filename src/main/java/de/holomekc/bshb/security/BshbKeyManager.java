package de.holomekc.bshb.security;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.X509KeyManager;

/**
 * @author Christopher Holomek (christopher.holomek@bmw.de)
 * @since 12.01.2020
 */
public class BshbKeyManager implements X509KeyManager {

    private KeyManager[] keyManagers;

    public BshbKeyManager(final String certificate, final String certificatePrivateKey) {

        try {
            final KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null);

            if (certificate != null && certificatePrivateKey != null) {
                final byte[] certBytes = CertificateUtils
                        .parseDERFromPEM(certificate.getBytes(StandardCharsets.UTF_8), "-----BEGIN CERTIFICATE-----",
                                "-----END CERTIFICATE-----");
                final byte[] keyBytes = CertificateUtils
                        .parseDERFromPEM(certificatePrivateKey.getBytes(StandardCharsets.UTF_8),
                                "-----BEGIN PRIVATE KEY-----", "-----END PRIVATE KEY-----");
                final X509Certificate cert = CertificateUtils.generateCertificateFromDER(certBytes);
                final RSAPrivateKey key = CertificateUtils.generatePrivateKeyFromDER(keyBytes);

                keyStore.setCertificateEntry("cert-bshb", cert);
                keyStore.setKeyEntry("key-bshb", key, "key".toCharArray(), new Certificate[] { cert });
            }

            final KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, "key".toCharArray());

            this.keyManagers = kmf.getKeyManagers();

        } catch (final KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException | InvalidKeySpecException | UnrecoverableKeyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] getClientAliases(final String s, final Principal[] principals) {
        return getKeyManager().getClientAliases(s, principals);
    }

    @Override
    public String chooseClientAlias(final String[] strings, final Principal[] principals, final Socket socket) {
        return getKeyManager().chooseClientAlias(strings, principals, socket);
    }

    @Override
    public String[] getServerAliases(final String s, final Principal[] principals) {
        return getKeyManager().getServerAliases(s, principals);
    }

    @Override
    public String chooseServerAlias(final String s, final Principal[] principals, final Socket socket) {
        return getKeyManager().chooseServerAlias(s, principals, socket);
    }

    @Override
    public X509Certificate[] getCertificateChain(final String s) {
        return getKeyManager().getCertificateChain(s);
    }

    @Override
    public PrivateKey getPrivateKey(final String s) {
        return getKeyManager().getPrivateKey(s);
    }

    private X509KeyManager getKeyManager() {
        for (final KeyManager keyManager : this.keyManagers) {
            if (keyManager instanceof X509KeyManager) {
                return ((X509KeyManager) keyManager);
            }
        }
        throw new IllegalStateException("No key manager found");
    }
}
