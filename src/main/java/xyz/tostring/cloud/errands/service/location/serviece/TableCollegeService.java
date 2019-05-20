package xyz.tostring.cloud.errands.service.location.serviece;

import xyz.tostring.cloud.errands.service.location.entity.TableCollegeDO;

import java.util.List;

public interface TableCollegeService {
    List<TableCollegeDO> listAllByRegionId(Double regionId);
    void createCollege(TableCollegeDO tableCollegeDO);
    void updateCollege(TableCollegeDO tableCollegeDO);
    void closeCollege(Integer collegeId);
    void openCollege(Integer collegeId);
    List<TableCollegeDO> listAllByRegionIdClosing(Double regionId);
    List<TableCollegeDO> listAllByRegionIdOpening(Double regionId);
    TableCollegeDO getById(int id);

}
