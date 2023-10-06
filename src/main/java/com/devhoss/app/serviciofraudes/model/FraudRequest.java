package com.devhoss.app.serviciofraudes.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public record FraudRequest(
        @JsonProperty("id_type") String idType,
        @JsonProperty("id_value") String idValue) {
}
