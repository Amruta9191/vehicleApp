package com.care.turbo.vehicleapp.remote.model.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
 class WheelerResponse {

    @JsonProperty("MyArray")
    var wheelerlist: List<String>? = null
}
