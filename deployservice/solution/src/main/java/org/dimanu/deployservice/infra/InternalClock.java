package org.dimanu.deployservice.infra;

import org.dimanu.deployservice.domain.Clock;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InternalClock implements Clock {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
