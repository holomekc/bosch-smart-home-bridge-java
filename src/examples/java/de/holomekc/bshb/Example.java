package de.holomekc.bshb;

import com.fasterxml.jackson.databind.JsonNode;

import de.holomekc.bshb.security.CertificateDefinition;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class Example {

    public static String extractArg(final String arg) {
        return arg.substring(arg.indexOf("=") + 1);
    }

    public static void main(final String[] args) {

        final String host = extractArg(args[0]);
        final String identifier = extractArg(args[1]);
        final String password = extractArg(args[2]);
        final String clientCert = "-----BEGIN CERTIFICATE-----\n" + extractArg(args[3]) + "\n-----END CERTIFICATE-----";
        final String clientPrivateKey =
                "-----BEGIN PRIVATE KEY-----\n" + extractArg(args[4]) + "\n-----BEGIN PRIVATE KEY-----";
        final CertificateDefinition certificate = new CertificateDefinition(clientCert, clientPrivateKey);

        //identifier = BshbUtils.generateIdentifier();
        //certificate = BshbUtils.generateClientCertificate();

        final BoschSmartHomeBridge boschSmartHomeBridge =
                BoschSmartHomeBridgeBuilder.builder().withHost(host).withClientCert(certificate.getCert())
                        .withClientPrivateKey(certificate.getPrivateKey()).build();

        try {

            boschSmartHomeBridge.pairIfNeeded("bshb", identifier, password).switchMap(pairingResponse -> {
                System.out.println("Pairing result:");
                if (pairingResponse.getResponse() != null) {
                    System.out.println("Pairing successful");
                    System.out.println(pairingResponse.getResponse().getStatus());
                    System.out.println(pairingResponse.getResponse().readEntity(String.class));
                } else {
                    System.out.println("Already paired");
                }

                return boschSmartHomeBridge.getBshcClient().getRooms();
            }).blockingForEach(getRoomsResponse -> {
                System.out.println("GetRooms:");
                final JsonNode jsonNode = getRoomsResponse.getResponse().readEntity(JsonNode.class);
                System.out.println(jsonNode.get(0).get("id"));
                //System.out.println(getRoomsResponse.getResponse().readEntity(JsonNode.class));
            });
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
