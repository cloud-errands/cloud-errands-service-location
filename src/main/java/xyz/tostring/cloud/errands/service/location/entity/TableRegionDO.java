package xyz.tostring.cloud.errands.service.location.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_region")
public class TableRegionDO {
    @Id
    private Double regionId;
    @Column
    private String regionCode;
    @Column
    private String regionName;
    @Column
    private Double parentId;
    @Column
    private Double regionLevel;
    @Column
    private Double regionOrder;
    @Column
    private String regionNameEn;
    @Column
    private String regionShortnameEn;

    public Double getRegionId() {
        return regionId;
    }

    public void setRegionId(Double regionId) {
        this.regionId = regionId;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Double getParentId() {
        return parentId;
    }

    public void setParentId(Double parentId) {
        this.parentId = parentId;
    }

    public Double getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Double regionLevel) {
        this.regionLevel = regionLevel;
    }

    public Double getRegionOrder() {
        return regionOrder;
    }

    public void setRegionOrder(Double regionOrder) {
        this.regionOrder = regionOrder;
    }

    public String getRegionNameEn() {
        return regionNameEn;
    }

    public void setRegionNameEn(String regionNameEn) {
        this.regionNameEn = regionNameEn;
    }

    public String getRegionShortnameEn() {
        return regionShortnameEn;
    }

    public void setRegionShortnameEn(String regionShortnameEn) {
        this.regionShortnameEn = regionShortnameEn;
    }

    @Override
    public String toString() {
        return "TableRegionDO{" +
                "regionId=" + regionId +
                ", regionCode='" + regionCode + '\'' +
                ", regionName='" + regionName + '\'' +
                ", parentId=" + parentId +
                ", regionLevel=" + regionLevel +
                ", regionOrder=" + regionOrder +
                ", regionNameEn='" + regionNameEn + '\'' +
                ", regionShortnameEn='" + regionShortnameEn + '\'' +
                '}';
    }
}
