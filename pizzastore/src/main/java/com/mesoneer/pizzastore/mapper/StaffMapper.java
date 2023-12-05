package com.mesoneer.pizzastore.mapper;

import com.mesoneer.pizzastore.entity.Staff;
import com.mesoneer.pizzastore.openapi.model.StaffResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    StaffResponseDto toDto(Staff entity);
}
