package by.overone.restaurant.utils;

public interface IMappingUtils<DTO, ENT> {
    DTO mapToDto(ENT entity);

    public ENT mapToEntity(DTO dto);
}
