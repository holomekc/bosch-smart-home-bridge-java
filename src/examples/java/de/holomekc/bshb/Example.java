package de.holomekc.bshb;

import de.holomekc.bshb.client.typed.TypedBshcClient;
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

        final TypedBshcClient typedClient = new TypedBshcClient(boschSmartHomeBridge.getBshcClient());

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

                // If you want more control then use this
                // return boschSmartHomeBridge.getBshcClient().getRooms()

                // Or used typed version
                return typedClient.getRooms();
            }).blockingForEach(getRoomsResponse -> {
                System.out.println("GetRooms:");
                //final List<Room> rooms = getRoomsResponse.readList(Room.class);
                System.out.println(getRoomsResponse.getData().get(0).getId());

                //System.out.println(getRoomsResponse.getResponse().readEntity(JsonNode.class));

                //typedClient.getInformation().subscribe(info -> {
                //    System.out.println(info.getData());
                //});
                //
                //boschSmartHomeBridge.getBshcClient().getDevices().subscribe(info -> {
                //    System.out.println(info.getResponse().readEntity(String.class));
                //});
                //
                //boschSmartHomeBridge.getBshcClient().setAlarmState(false).subscribe(info -> {
                //    System.out.println(info.getResponse().readEntity(String.class));
                //});
                //
                //boschSmartHomeBridge.getBshcClient().subscribe().subscribe(subscriptionId -> {
                //    System.out.println(subscriptionId);
                //
                //    boschSmartHomeBridge.getBshcClient().longPolling(subscriptionId, 30000).subscribe(response -> {
                //        System.out.println(response);
                //    });
                //});

                typedClient.getDevicesServices().subscribe(info -> {
                    System.out.println(info.getData());
                });

            });
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
