package sn.edu.ugb.grade.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.grade.domain.Evaluation;
import sn.edu.ugb.grade.domain.SessionExamen;
import sn.edu.ugb.grade.service.dto.EvaluationDTO;
import sn.edu.ugb.grade.service.dto.SessionExamenDTO;

/**
 * Mapper for the entity {@link Evaluation} and its DTO {@link EvaluationDTO}.
 */
@Mapper(componentModel = "spring")
public interface EvaluationMapper extends EntityMapper<EvaluationDTO, Evaluation> {
    @Mapping(target = "session", source = "session", qualifiedByName = "sessionExamenId")
    EvaluationDTO toDto(Evaluation s);

    @Named("sessionExamenId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SessionExamenDTO toDtoSessionExamenId(SessionExamen sessionExamen);
}
