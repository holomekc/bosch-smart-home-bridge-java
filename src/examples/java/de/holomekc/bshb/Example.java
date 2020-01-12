package de.holomekc.bshb;

/**
 * @author Christopher Holomek (christopher.holomek@bmw.de)
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
        final BoschSmartHomeBridge boschSmartHomeBridge =
                BoschSmartHomeBridgeBuilder.builder().withHost(host).withClientCert(clientCert)
                        .withClientPrivateKey(clientPrivateKey).build();

        boschSmartHomeBridge.pairIfNeeded("bshb", identifier, password).doOnError(err -> {
            System.out.println("Test Result error: ");
            err.printStackTrace();
        }).switchMap(pairingResponse -> {
            System.out.println("Pairing result:");
            if (pairingResponse.getResponse() != null) {
                System.out.println("Pairing successful");
                System.out.println(pairingResponse.getResponse().getStatus());
                System.out.println(pairingResponse.getResponse().readEntity(String.class));
            } else {
                System.out.println("Already paired");
            }

            return boschSmartHomeBridge.getBshcClient().getRooms();
        }).subscribe(getRoomsResponse -> {
            System.out.println("GetRooms:");
            System.out.println(getRoomsResponse.getResponse().readEntity(String.class));
        });
    }
}
