package net.proselyte.awssqsdemo.rest;

import lombok.RequiredArgsConstructor;
import net.proselyte.awssqsdemo.service.RecipientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipients")
public class RecipientRestControllerV1 {

    private final RecipientService recipientService;

    @GetMapping("/{uid}")
    public Mono<?> findNotificationByUid(@PathVariable String uid) {
        return recipientService.findRecipientWithNotificationsByUid(uid);
    }

}
