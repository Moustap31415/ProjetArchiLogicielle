package sn.edu.ugb.student.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.student.domain.HistoriqueAcademique;
import sn.edu.ugb.student.service.dto.HistoriqueAcademiqueDTO;

/**
 * Mapper for the entity {@link HistoriqueAcademique} and its DTO {@link HistoriqueAcademiqueDTO}.
 */
@Mapper(componentModel = "spring")
public interface HistoriqueAcademiqueMapper extends EntityMapper<HistoriqueAcademiqueDTO, HistoriqueAcademique> {
    @Mapping(target = "etudiantId", source = "etudiant.id")
    @Mapping(target = "semestre", ignore = true) // Nous gérons semestre séparément via Feign
    HistoriqueAcademiqueDTO toDto(HistoriqueAcademique historiqueAcademique);

    @Mapping(target = "etudiant", ignore = true) // Nous ne mappons pas directement l'étudiant
    @Mapping(target = "semestreId", source = "semestreId")
    HistoriqueAcademique toEntity(HistoriqueAcademiqueDTO historiqueAcademiqueDTO);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "etudiant", ignore = true)
    @Mapping(target = "semestre", ignore = true)
    void partialUpdate(@MappingTarget HistoriqueAcademique entity, HistoriqueAcademiqueDTO dto);
}
