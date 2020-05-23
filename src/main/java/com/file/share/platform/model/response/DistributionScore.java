package com.file.share.platform.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DistributionScore {

    @JsonProperty("score")
    private Integer allScore;


    private Integer num;
}
