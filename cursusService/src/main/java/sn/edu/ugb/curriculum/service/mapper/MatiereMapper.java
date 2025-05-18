package sn.edu.ugb.curriculum.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.curriculum.domain.Matiere;
import sn.edu.ugb.curriculum.domain.UniteEnseignement;
import sn.edu.ugb.curriculum.service.dto.MatiereDTO;
import sn.edu.ugb.curriculum.service.dto.UniteEnseignementDTO;

/**
 * Mapper for the entity {@link Matiere} and its DTO {@link MatiereDTO}.
 */
@Mapper(componentModel = "spring")
public interface MatiereMapper extends EntityMapper<MatiereDTO, Matiere> {
    @Mapping(target = "unite", source = "unite", qualifiedByName = "uniteEnseignementId")
    MatiereDTO toDto(Matiere s);

    @Named("uniteEnseignementId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UniteEnseignementDTO toDtoUniteEnseignementId(UniteEnseignement uniteEnseignement);
}
