package org.strebentechnik.organization;

import java.util.List;
import org.strebentechnik.organization.util.QuarkusMappingConfig;

import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface OrganizationTransformer{

    Organization toResource(OrganizationEntity organizationEntity);

    List<Organization> map(List<OrganizationEntity> employeeEntityList);

    OrganizationEntity toEntity(Organization employee);

}