package xyz.tostring.cloud.errands.service.location.serviece;

import xyz.tostring.cloud.errands.service.location.entity.TableReceiveInfoDO;

import java.util.List;

public interface TableReceiveInfoService {
    TableReceiveInfoDO createReceiveInfo(TableReceiveInfoDO tableReceiveInfoDO);
    TableReceiveInfoDO updateReceiveInfo(TableReceiveInfoDO tableReceiveInfoDO);
    TableReceiveInfoDO setAsDefaultReceiveInfo(TableReceiveInfoDO tableReceiveInfoDO);
    void deleteReceiveInfoById(Long id);
    List<TableReceiveInfoDO> listAll();
    List<TableReceiveInfoDO> listAllByUserOpenId(String userOpenId);
    TableReceiveInfoDO getById(Long id);
}
