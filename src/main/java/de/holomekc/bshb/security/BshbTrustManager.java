package de.holomekc.bshb.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import de.holomekc.bshb.BshbUtils;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class BshbTrustManager implements X509TrustManager {

    private TrustManager[] trustManagers;

    public BshbTrustManager() {
        final byte[] certBytes = CertificateUtils
                .parseDERFromPEM(BshbUtils.getBoschSmartHomeControllerRootCa().getBytes(StandardCharsets.UTF_8),
                        "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----");

        try {
            final X509Certificate cert = CertificateUtils.generateCertificateFromDER(certBytes);

            final KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null);
            keyStore.setCertificateEntry("cert-bshc", cert);

            final TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            this.trustManagers = tmf.getTrustManagers();

        } catch (final KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkClientTrusted(final X509Certificate[] x509Certificates, final String s)
            throws CertificateException {
        getTrustManager().checkClientTrusted(x509Certificates, s);
    }

    @Override
    public void checkServerTrusted(final X509Certificate[] x509Certificates, final String s)
            throws CertificateException {
        getTrustManager().checkServerTrusted(x509Certificates, s);
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return getTrustManager().getAcceptedIssuers();
    }

    private X509TrustManager getTrustManager() {
        for (final TrustManager keyManager : this.trustManagers) {
            if (keyManager instanceof X509TrustManager) {
                return ((X509TrustManager) keyManager);
            }
        }
        throw new IllegalStateException("No trust manager found");
    }
}
