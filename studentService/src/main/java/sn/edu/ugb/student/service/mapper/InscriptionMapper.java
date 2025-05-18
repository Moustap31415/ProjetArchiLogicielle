package sn.edu.ugb.student.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.student.domain.Etudiant;
import sn.edu.ugb.student.domain.Inscription;
import sn.edu.ugb.student.service.dto.EtudiantDTO;
import sn.edu.ugb.student.service.dto.InscriptionDTO;

/**
 * Mapper for the entity {@link Inscription} and its DTO {@link InscriptionDTO}.
 */
@Mapper(componentModel = "spring")
public interface InscriptionMapper extends EntityMapper<InscriptionDTO, Inscription> {
    @Mapping(target = "etudiant", source = "etudiant", qualifiedByName = "etudiantId")
    InscriptionDTO toDto(Inscription s);

    @Named("etudiantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EtudiantDTO toDtoEtudiantId(Etudiant etudiant);
}
