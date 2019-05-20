package xyz.tostring.cloud.errands.service.location.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_college")
public class TableCollegeDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collegeId;
    @Column
    private Double regionId;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String county;
    @Column
    private String collegeName;
    @Column
    private Integer isOpening;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Double getRegionId() {
        return regionId;
    }

    public void setRegionId(Double regionId) {
        this.regionId = regionId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Integer getIsOpening() {
        return isOpening;
    }

    public void setIsOpening(Integer isOpening) {
        this.isOpening = isOpening;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
