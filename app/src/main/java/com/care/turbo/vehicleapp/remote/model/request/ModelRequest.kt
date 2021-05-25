package com.care.turbo.vehicleapp.remote.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    "class",
     "make")
class ModelRequest {
    @JsonProperty("class")
    var type: String? = null

    @JsonProperty("make")
    var make: String? = null
}

