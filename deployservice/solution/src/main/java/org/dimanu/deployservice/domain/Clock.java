package org.dimanu.deployservice.domain;

import java.time.LocalDateTime;

public interface Clock {

    public LocalDateTime now();
}
