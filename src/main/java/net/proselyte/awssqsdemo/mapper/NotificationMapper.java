package net.proselyte.awssqsdemo.mapper;

import net.proselyte.awssqsdemo.dto.NotificationDto;
import net.proselyte.awssqsdemo.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto map(NotificationEntity entity);

    @InheritInverseConfiguration
    NotificationEntity map(NotificationDto dto);
}
