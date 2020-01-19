package de.holomekc.bshb.model.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import de.holomekc.bshb.model.BshcType;
import de.holomekc.bshb.model.service.air.AirQualityLevelState;
import de.holomekc.bshb.model.service.controller.ArmDisarmPushNotificationState;
import de.holomekc.bshb.model.service.controller.RemoteAccessState;
import de.holomekc.bshb.model.service.controller.RemotePushNotificationState;
import de.holomekc.bshb.model.service.controller.SoftwareUpdateState;
import de.holomekc.bshb.model.service.general.CommunicationQualityState;
import de.holomekc.bshb.model.service.general.LinkingState;
import de.holomekc.bshb.model.service.heating.ChildLockState;
import de.holomekc.bshb.model.service.heating.ClimateControlState;
import de.holomekc.bshb.model.service.heating.TemperatureOffsetState;
import de.holomekc.bshb.model.service.heating.ValveTappetState;
import de.holomekc.bshb.model.service.hue.HueBridgeConnectorState;
import de.holomekc.bshb.model.service.hue.HueBridgeSearcherState;
import de.holomekc.bshb.model.service.power.PowerMeterState;
import de.holomekc.bshb.model.service.power.PowerSwitchState;
import de.holomekc.bshb.model.service.presence.PresenceSimulationConfigurationState;
import de.holomekc.bshb.model.service.presence.PresenceSimulationSchedulingState;
import de.holomekc.bshb.model.service.shuttercontact.ShutterContactState;
import de.holomekc.bshb.model.service.smoke.SmokeDetectionControlState;
import de.holomekc.bshb.model.service.smoke.SmokeDetectorCheckState;
import de.holomekc.bshb.model.service.smoke.SmokeSensitivityState;
import de.holomekc.bshb.model.service.surveillance.IntrusionDetectionControlState;
import de.holomekc.bshb.model.service.surveillance.SurveillanceAlarmState;
import de.holomekc.bshb.model.service.temperature.TemperatureLevelConfigurationState;
import de.holomekc.bshb.model.service.temperature.TemperatureLevelState;
import de.holomekc.bshb.model.service.twinguard.TwinguardNightlyPromiseState;
import de.holomekc.bshb.model.service.ventilation.VentilationDelayState;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "@type", defaultImpl = SimpleState.class)
@JsonSubTypes({ // wrap
        @Type(value = SurveillanceAlarmState.class, name = "surveillanceAlarmState"),
        @Type(value = IntrusionDetectionControlState.class, name = "intrusionDetectionControlState"),
        @Type(value = SoftwareUpdateState.class, name = "softwareUpdateState"),
        @Type(value = RemoteAccessState.class, name = "remoteAccessState"),
        @Type(value = RemotePushNotificationState.class, name = "remotePushNotificationState"),
        @Type(value = ArmDisarmPushNotificationState.class, name = "armDisarmPushNotificationState"),
        @Type(value = ShutterContactState.class, name = "shutterContactState"),
        @Type(value = TemperatureLevelConfigurationState.class, name = "temperatureLevelConfigurationState"),
        @Type(value = ClimateControlState.class, name = "climateControlState"),
        @Type(value = TemperatureLevelState.class, name = "temperatureLevelState"),
        @Type(value = ValveTappetState.class, name = "valveTappetState"),
        @Type(value = ChildLockState.class, name = "childLockState"),
        @Type(value = TemperatureOffsetState.class, name = "temperatureOffsetState"),
        @Type(value = LinkingState.class, name = "linkingState"),
        @Type(value = VentilationDelayState.class, name = "ventilationDelayState"),
        @Type(value = PowerMeterState.class, name = "powerMeterState"),
        @Type(value = PowerSwitchState.class, name = "powerSwitchState"),
        @Type(value = SmokeSensitivityState.class, name = "smokeSensitivityState"),
        @Type(value = TwinguardNightlyPromiseState.class, name = "twinguardNightlyPromiseState"),
        @Type(value = CommunicationQualityState.class, name = "communicationQualityState"),
        @Type(value = SmokeDetectorCheckState.class, name = "smokeDetectorCheckState"),
        @Type(value = AirQualityLevelState.class, name = "airQualityLevelState"),
        @Type(value = PresenceSimulationSchedulingState.class, name = "presenceSimulationSchedulingState"),
        @Type(value = PresenceSimulationConfigurationState.class, name = "presenceSimulationConfigurationState"),
        @Type(value = HueBridgeSearcherState.class, name = "hueBridgeSearcherState"),
        @Type(value = HueBridgeConnectorState.class, name = "hueBridgeConnectorState"),
        @Type(value = SmokeDetectionControlState.class, name = "smokeDetectionControlState"),
        // wrap
})
public abstract class State extends BshcType {

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).toString();
    }
}

