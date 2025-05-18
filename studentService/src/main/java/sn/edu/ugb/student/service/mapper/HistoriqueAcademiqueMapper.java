package sn.edu.ugb.student.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.student.domain.Etudiant;
import sn.edu.ugb.student.domain.HistoriqueAcademique;
import sn.edu.ugb.student.service.dto.EtudiantDTO;
import sn.edu.ugb.student.service.dto.HistoriqueAcademiqueDTO;

/**
 * Mapper for the entity {@link HistoriqueAcademique} and its DTO {@link HistoriqueAcademiqueDTO}.
 */
@Mapper(componentModel = "spring")
public interface HistoriqueAcademiqueMapper extends EntityMapper<HistoriqueAcademiqueDTO, HistoriqueAcademique> {
    @Mapping(target = "etudiant", source = "etudiant", qualifiedByName = "etudiantId")
    HistoriqueAcademiqueDTO toDto(HistoriqueAcademique s);

    @Named("etudiantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EtudiantDTO toDtoEtudiantId(Etudiant etudiant);
}
