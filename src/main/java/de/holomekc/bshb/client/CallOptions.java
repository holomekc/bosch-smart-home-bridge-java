package de.holomekc.bshb.client;

import javax.ws.rs.client.Invocation;

/**
 * @author Christopher Holomek (christopher.holomek@bmw.de)
 * @since 12.01.2020
 */
@FunctionalInterface
public interface CallOptions {
    Invocation.Builder configureInvocation(final Invocation.Builder invocationBuilder);
}
