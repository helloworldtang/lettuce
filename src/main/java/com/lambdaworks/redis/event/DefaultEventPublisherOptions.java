package com.lambdaworks.redis.event;

import java.util.concurrent.TimeUnit;

import com.lambdaworks.redis.internal.LettuceAssert;
import com.lambdaworks.redis.metrics.CommandLatencyCollectorOptions;

/**
 * The default implementation of {@link CommandLatencyCollectorOptions}.
 *
 * @author Mark Paluch
 */
public class DefaultEventPublisherOptions implements EventPublisherOptions {

    public static final long DEFAULT_EMIT_INTERVAL = 10;
    public static final TimeUnit DEFAULT_EMIT_INTERVAL_UNIT = TimeUnit.MINUTES;

    private static final DefaultEventPublisherOptions DISABLED = new Builder().eventEmitInterval(0, TimeUnit.SECONDS).build();

    private final long eventEmitInterval;
    private final TimeUnit eventEmitIntervalUnit;

    private DefaultEventPublisherOptions(Builder builder) {
        this.eventEmitInterval = builder.eventEmitInterval;
        this.eventEmitIntervalUnit = builder.eventEmitIntervalUnit;
    }

    /**
     * Returns a new {@link DefaultEventPublisherOptions.Builder} to construct {@link DefaultEventPublisherOptions}.
     *
     * @return a new {@link DefaultEventPublisherOptions.Builder} to construct {@link DefaultEventPublisherOptions}.
     */
    public static Builder builder(){
        return new Builder();
    }

    /**
     * Builder for {@link DefaultEventPublisherOptions}.
     */
    public static class Builder {

        private long eventEmitInterval = DEFAULT_EMIT_INTERVAL;
        private TimeUnit eventEmitIntervalUnit = DEFAULT_EMIT_INTERVAL_UNIT;

        private Builder() {
        }

        /**
         * Sets the emit interval and the interval unit. Event emission will be disabled if the {@code eventEmitInterval} is set
         * to 0}. Defaults to 10} {@link TimeUnit#MINUTES}. See {@link DefaultEventPublisherOptions#DEFAULT_EMIT_INTERVAL}
         * {@link DefaultEventPublisherOptions#DEFAULT_EMIT_INTERVAL_UNIT}.
         *
         * @param eventEmitInterval the event interval, must be greater or equal to 0}
         * @param eventEmitIntervalUnit the {@link TimeUnit} for the interval, must not be null
         * @return this
         */
        public Builder eventEmitInterval(long eventEmitInterval, TimeUnit eventEmitIntervalUnit) {
            LettuceAssert.isTrue(eventEmitInterval >= 0, "EventEmitInterval must be greater or equal to 0");
            LettuceAssert.notNull(eventEmitIntervalUnit, "EventEmitIntervalUnit must not be null");

            this.eventEmitInterval = eventEmitInterval;
            this.eventEmitIntervalUnit = eventEmitIntervalUnit;
            return this;
        }

        /**
         *
         * @return a new instance of {@link DefaultEventPublisherOptions}.
         */
        public DefaultEventPublisherOptions build() {
            return new DefaultEventPublisherOptions(this);
        }
    }

    @Override
    public long eventEmitInterval() {
        return eventEmitInterval;
    }

    @Override
    public TimeUnit eventEmitIntervalUnit() {
        return eventEmitIntervalUnit;
    }

    /**
     * Create a new {@link DefaultEventPublisherOptions} using default settings.
     * 
     * @return a new instance of a default {@link DefaultEventPublisherOptions} instance
     */
    public static DefaultEventPublisherOptions create() {
        return new Builder().build();
    }

    /**
     * Create a disabled {@link DefaultEventPublisherOptions} using default settings.
     * 
     * @return a new instance of a default {@link DefaultEventPublisherOptions} instance with disabled event emission
     */
    public static DefaultEventPublisherOptions disabled() {
        return DISABLED;
    }
}
