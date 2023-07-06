package net.proselyte.awssqsdemo.poller;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.awssqsdemo.dto.NotificationDto;
import net.proselyte.awssqsdemo.entity.NotificationEntity;
import net.proselyte.awssqsdemo.mapper.NotificationMapper;
import net.proselyte.awssqsdemo.repository.NotificationRepository;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationsSQSPoller {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessage(@Payload NotificationDto message) {
        log.info("received notification: {}", message);
        NotificationEntity entity = notificationMapper.map(message);
        notificationRepository.save(entity).subscribe();
    }
}
