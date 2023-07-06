package net.proselyte.awssqsdemo.service;

import lombok.RequiredArgsConstructor;
import net.proselyte.awssqsdemo.dto.RecipientDto;
import net.proselyte.awssqsdemo.entity.NotificationEntity;
import net.proselyte.awssqsdemo.entity.RecipientEntity;
import net.proselyte.awssqsdemo.mapper.RecipientMapper;
import net.proselyte.awssqsdemo.repository.NotificationRepository;
import net.proselyte.awssqsdemo.repository.RecipientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDto> findRecipientWithNotificationsByUid(String uid) {
        return Mono.zip(recipientRepository.findById(uid),
                notificationRepository.findAllByRecipientUid(uid).collectList())
                .map(tuples -> {
                    RecipientEntity recipient = tuples.getT1();
                    List<NotificationEntity> notifications = tuples.getT2();
                    recipient.setNotifications(notifications);
                    return recipientMapper.map(recipient);
                });
    }
}
