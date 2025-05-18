package sn.edu.ugb.curriculum.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.curriculum.domain.Filiere;
import sn.edu.ugb.curriculum.domain.UniteEnseignement;
import sn.edu.ugb.curriculum.service.dto.FiliereDTO;
import sn.edu.ugb.curriculum.service.dto.UniteEnseignementDTO;

/**
 * Mapper for the entity {@link UniteEnseignement} and its DTO {@link UniteEnseignementDTO}.
 */
@Mapper(componentModel = "spring")
public interface UniteEnseignementMapper extends EntityMapper<UniteEnseignementDTO, UniteEnseignement> {
    @Mapping(target = "filiere", source = "filiere", qualifiedByName = "filiereId")
    UniteEnseignementDTO toDto(UniteEnseignement s);

    @Named("filiereId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FiliereDTO toDtoFiliereId(Filiere filiere);
}
