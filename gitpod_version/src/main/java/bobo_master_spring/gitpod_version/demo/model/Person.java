package bobo_master_spring.gitpod_version.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public record Person(@JsonProperty("id") UUID id, @JsonProperty("name") @NonNull @NotBlank String name) {}
