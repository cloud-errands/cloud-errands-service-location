package xyz.tostring.cloud.errands.service.location.serviece;

import xyz.tostring.cloud.errands.service.location.entity.TableRegionDO;

import java.util.List;

public interface TableRegionService {
    List<TableRegionDO> listAllByParentId(Double parentId);
    TableRegionDO listAllByRegionCode(String regionCode);
}
