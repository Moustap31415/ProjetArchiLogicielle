package sn.edu.ugb.user.service.mapper;

import org.mapstruct.*;
import sn.edu.ugb.user.domain.ProfilUtilisateur;
import sn.edu.ugb.user.domain.Role;
import sn.edu.ugb.user.service.dto.ProfilUtilisateurDTO;
import sn.edu.ugb.user.service.dto.RoleDTO;

/**
 * Mapper for the entity {@link ProfilUtilisateur} and its DTO {@link ProfilUtilisateurDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProfilUtilisateurMapper extends EntityMapper<ProfilUtilisateurDTO, ProfilUtilisateur> {
    @Mapping(target = "role", source = "role", qualifiedByName = "roleId")
    ProfilUtilisateurDTO toDto(ProfilUtilisateur s);

    @Named("roleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RoleDTO toDtoRoleId(Role role);
}
