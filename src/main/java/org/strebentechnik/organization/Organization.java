package org.strebentechnik.organization;

import java.sql.Timestamp;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@RegisterForReflection
@Data
public class Organization{
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