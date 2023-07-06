package net.proselyte.awssqsdemo.mapper;

import net.proselyte.awssqsdemo.dto.RecipientDto;
import net.proselyte.awssqsdemo.entity.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientDto map(RecipientEntity entity);

    @InheritInverseConfiguration
    RecipientEntity map(RecipientDto dto);
}
