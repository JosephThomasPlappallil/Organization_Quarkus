package org.strebentechnik.organization;
import java.sql.Timestamp;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name="organization")
public class OrganizationEntity extends PanacheEntity {
    
	public Long id;
    public String code;
	public String parentId;
    public String parentCode;
    public String name;
    public String shortName;
    public String taxIdentifier;
    public String details;
    public String createdBy;
    public String updatedBy;
    public Timestamp createdAt;
    public Timestamp updatedAt;

}
