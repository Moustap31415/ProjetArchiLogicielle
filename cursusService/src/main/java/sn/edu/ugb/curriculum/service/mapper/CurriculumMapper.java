package sn.edu.ugb.curriculum.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.curriculum.domain.Curriculum;
import sn.edu.ugb.curriculum.domain.Filiere;
import sn.edu.ugb.curriculum.domain.Semestre;
import sn.edu.ugb.curriculum.domain.UniteEnseignement;
import sn.edu.ugb.curriculum.service.dto.CurriculumDTO;
import sn.edu.ugb.curriculum.service.dto.FiliereDTO;
import sn.edu.ugb.curriculum.service.dto.SemestreDTO;
import sn.edu.ugb.curriculum.service.dto.UniteEnseignementDTO;

/**
 * Mapper for the entity {@link Curriculum} and its DTO {@link CurriculumDTO}.
 */
@Mapper(componentModel = "spring")
public interface CurriculumMapper extends EntityMapper<CurriculumDTO, Curriculum> {
    @Mapping(target = "filiere", source = "filiere", qualifiedByName = "filiereId")
    @Mapping(target = "unite", source = "unite", qualifiedByName = "uniteEnseignementId")
    @Mapping(target = "semestre", source = "semestre", qualifiedByName = "semestreId")
    CurriculumDTO toDto(Curriculum s);

    @Named("filiereId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FiliereDTO toDtoFiliereId(Filiere filiere);

    @Named("uniteEnseignementId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UniteEnseignementDTO toDtoUniteEnseignementId(UniteEnseignement uniteEnseignement);

    @Named("semestreId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SemestreDTO toDtoSemestreId(Semestre semestre);
}
