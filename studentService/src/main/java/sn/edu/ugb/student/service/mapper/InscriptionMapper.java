package sn.edu.ugb.student.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.student.domain.Inscription;
import sn.edu.ugb.student.service.dto.InscriptionDTO;

/**
 * Mapper for the entity {@link Inscription} and its DTO {@link InscriptionDTO}.
 */
@Mapper(componentModel = "spring")
public interface InscriptionMapper extends EntityMapper<InscriptionDTO, Inscription> {

    @Mapping(target = "etudiantId", source = "etudiant.id")
    @Mapping(target = "filiere", ignore = true)
    @Mapping(target = "semestre", ignore = true)
    InscriptionDTO toDto(Inscription inscription);

    @Mapping(target = "etudiant", ignore = true)
    @Mapping(target = "filiereId", source = "filiereId")
    @Mapping(target = "semestreId", source = "semestreId")
    Inscription toEntity(InscriptionDTO inscriptionDTO);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "etudiant", ignore = true)
    @Mapping(target = "filiere", ignore = true)
    @Mapping(target = "semestre", ignore = true)
    void partialUpdate(@MappingTarget Inscription entity, InscriptionDTO dto);
}
