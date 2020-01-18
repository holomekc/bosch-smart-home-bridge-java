package de.holomekc.bshb.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.HttpMethod;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;

import de.holomekc.bshb.CertificateStorage;
import de.holomekc.bshb.model.longpolling.LpPoll;
import de.holomekc.bshb.model.longpolling.LpSubscribe;
import io.reactivex.Observable;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class BshcClient extends AbstractBshcClient {

    private static final String PATH_PREFIX = "/smarthome/";

    public BshcClient(final String host, final CertificateStorage certificateStorage) {
        super(host, certificateStorage);
    }

    /**
     * Get information about BSHC
     *
     * @return bshb response object
     */
    public Observable<BshbResponse> getInformation() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "information", null);
    }

    /**
     * Get information about BSHC
     *
     * @return bshb response object
     */
    public Observable<BshbResponse> getPublicInformation() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "public/information", null);
    }

    /**
     * Get all rooms stored
     *
     * @return bshb response object
     */
    public Observable<BshbResponse> getRooms() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "rooms", null);
    }

    public Observable<BshbResponse> getDevices() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "devices", null);
    }

    public Observable<BshbResponse> getDevice(final String id) {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "devices/" + id, null);
    }

    public Observable<BshbResponse> getDevicesServices() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "services/", null);
    }

    public Observable<BshbResponse> getDeviceServices(final String deviceId) {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "devices/" + deviceId + "/services/", null);
    }

    public Observable<BshbResponse> getDeviceServices(final String deviceId, final String serviceId) {
        return this
                .simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "devices/" + deviceId + "/services/" + serviceId,
                        null);
    }

    public Observable<List<String>> getDeviceServiceIds(final String deviceId) {
        if (StringUtils.isNotBlank(deviceId)) {
            return this.getDeviceServices(deviceId).map(res -> {
                final JsonNode services = res.readEntity(JsonNode.class);

                final List<String> result = new ArrayList<>();
                services.forEach(service -> {
                    result.add(service.get("id").asText());
                });

                return result;
            });
        } else {
            return Observable.just(new ArrayList<>());
        }
    }

    public Observable<BshbResponse> getSupportedDeviceTypes() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "configuration/supportedDeviceTypes", null);
    }

    public Observable<BshbResponse> getScenarios() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "scenarios", null);
    }

    public Observable<BshbResponse> triggerScenario(final String scenarioId) {
        return this
                .simpleCall(COMMON_PORT, HttpMethod.POST, PATH_PREFIX + "scenarios/" + scenarioId + "triggers", null);
    }

    public Observable<BshbResponse> getAlarmState() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET,
                PATH_PREFIX + "devices/intrusionDetectionSystem/services/IntrusionDetectionControl/state", null);
    }

    public Observable<BshbResponse> setAlarmState(final boolean armed) {
        final String value;
        if (armed) {
            value = "SYSTEM_ARMED";
        } else {
            value = "SYSTEM_DISARMED";
        }
        final String data = "{\"@type\": \"intrusionDetectionControlState\",\"value\": \"" + value + "\"}";
        return this.putState("devices/intrusionDetectionSystem/services/IntrusionDetectionControl", data);
    }

    public Observable<BshbResponse> getPresenceSimulation() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET,
                PATH_PREFIX + "devices/presenceSimulationService/services/PresenceSimulationConfiguration/state", null);
    }

    public Observable<BshbResponse> setPresenceSimulation(final boolean enabled) {
        final String data = "{\"@type\": \"presenceSimulationConfigurationState\",\"enabled\": " + enabled + "}";
        return this.putState("devices/presenceSimulationService/services/PresenceSimulationConfiguration", data);
    }

    public Observable<BshbResponse> putState(final String path, final Object data) {
        return this.simpleCall(COMMON_PORT, HttpMethod.PUT, PATH_PREFIX + path + "/state", data);
    }

    public Observable<BshbResponse> getClients() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "clients", null);
    }

    public Observable<BshbResponse> getMessages() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "messages", null);
    }

    public Observable<BshbResponse> deleteMessages(final List<String> ids) {
        return this.simpleCall(COMMON_PORT, HttpMethod.POST, PATH_PREFIX + "messages/batchDelete", ids);
    }

    public Observable<BshbResponse> getMessage(final String id) {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "messages/" + id, null);
    }

    public Observable<BshbResponse> deleteMessage(final String id) {
        return this.simpleCall(COMMON_PORT, HttpMethod.DELETE, PATH_PREFIX + "messages/" + id, null);
    }

    public Observable<String> subscribe() {
        return this.simpleCall(COMMON_PORT, HttpMethod.POST, "/remote/json-rpc", new LpSubscribe())
                .map(bshbResponse -> {
                    final JsonNode response = bshbResponse.readEntity(JsonNode.class);
                    return response.get("result").asText();
                });
    }

    public Observable<BshbResponse> longPolling(final String subscriptionId, int timeout) {
        if (timeout < 0) {
            timeout = 30000;
        }
        return this.simpleCall(COMMON_PORT, HttpMethod.POST, "/remote/json-rpc", new LpPoll(subscriptionId, timeout));
    }

    public Observable<String> unsubscribe() {
        return this.simpleCall(COMMON_PORT, HttpMethod.POST, "/remote/json-rpc", new LpSubscribe())
                .map(bshbResponse -> {
                    final JsonNode response = bshbResponse.readEntity(JsonNode.class);
                    return response.get("result").asText();
                });
    }

    public <T> Observable<BshbResponse> call(final int port, final String method, final String path, final T data) {
        return this.call(port, method, path, data, options -> options);
    }

    public <T> Observable<BshbResponse> call(final int port, final String method, final String path, final T data,
            final CallOptions options) {
        return this.simpleCall(port, method, path, data, options);
    }

}
