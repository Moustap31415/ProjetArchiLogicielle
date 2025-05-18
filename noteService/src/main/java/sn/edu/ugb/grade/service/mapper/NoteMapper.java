package sn.edu.ugb.grade.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.grade.domain.Evaluation;
import sn.edu.ugb.grade.domain.Note;
import sn.edu.ugb.grade.service.dto.EvaluationDTO;
import sn.edu.ugb.grade.service.dto.NoteDTO;

/**
 * Mapper for the entity {@link Note} and its DTO {@link NoteDTO}.
 */
@Mapper(componentModel = "spring")
public interface NoteMapper extends EntityMapper<NoteDTO, Note> {
    @Mapping(target = "evaluation", source = "evaluation", qualifiedByName = "evaluationId")
    NoteDTO toDto(Note s);

    @Named("evaluationId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EvaluationDTO toDtoEvaluationId(Evaluation evaluation);
}
