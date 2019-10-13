package com.radoslaw.dauksza.travelers.event.songkick;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SongkickConfig {
    @Value("${songkick.api.endpoint}")
    private String songkickEndPoint;
    @Value("${songkick.api.key}")
    private String songkickApiKey;
}
