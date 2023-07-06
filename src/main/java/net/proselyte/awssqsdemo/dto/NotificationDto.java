package net.proselyte.awssqsdemo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public record NotificationDto(String id,
                              String subject,
                              String text,
                              String recipientUid,
                              RecipientDto recipient) {
}
