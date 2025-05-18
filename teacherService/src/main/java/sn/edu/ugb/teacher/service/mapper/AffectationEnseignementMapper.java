package sn.edu.ugb.teacher.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.teacher.domain.AffectationEnseignement;
import sn.edu.ugb.teacher.domain.Enseignant;
import sn.edu.ugb.teacher.service.dto.AffectationEnseignementDTO;
import sn.edu.ugb.teacher.service.dto.EnseignantDTO;

/**
 * Mapper for the entity {@link AffectationEnseignement} and its DTO {@link AffectationEnseignementDTO}.
 */
@Mapper(componentModel = "spring")
public interface AffectationEnseignementMapper extends EntityMapper<AffectationEnseignementDTO, AffectationEnseignement> {
    @Mapping(target = "enseignant", source = "enseignant", qualifiedByName = "enseignantId")
    AffectationEnseignementDTO toDto(AffectationEnseignement s);

    @Named("enseignantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EnseignantDTO toDtoEnseignantId(Enseignant enseignant);
}
