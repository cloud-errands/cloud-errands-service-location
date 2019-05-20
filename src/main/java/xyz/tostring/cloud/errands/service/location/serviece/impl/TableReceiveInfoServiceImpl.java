package xyz.tostring.cloud.errands.service.location.serviece.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tostring.cloud.errands.common.service.util.SnowflakeIdWorker;
import xyz.tostring.cloud.errands.service.location.entity.TableReceiveInfoDO;
import xyz.tostring.cloud.errands.service.location.repository.TableReceiveInfoRepository;
import xyz.tostring.cloud.errands.service.location.serviece.TableReceiveInfoService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TableReceiveInfoServiceImpl implements TableReceiveInfoService {
    public static final int DEFAULT_WEIGHT = 0;
    public static final int WEIGHT_STEP = 5;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Autowired
    private TableReceiveInfoRepository tableReceiveInfoRepository;

    @Override
    public TableReceiveInfoDO createReceiveInfo(TableReceiveInfoDO tableReceiveInfoDO) {
        Date date = new Date();
        tableReceiveInfoDO.setId(snowflakeIdWorker.nextId());
        tableReceiveInfoDO.setSortWeight(DEFAULT_WEIGHT);
        tableReceiveInfoDO.setCreateTime(date);
        tableReceiveInfoDO.setUpdateTime(date);
        tableReceiveInfoRepository.save(tableReceiveInfoDO);
        return tableReceiveInfoDO;
    }

    @Override
    public TableReceiveInfoDO updateReceiveInfo(TableReceiveInfoDO tableReceiveInfoDO) {
        Date date = new Date();
        tableReceiveInfoDO.setUpdateTime(date);
        tableReceiveInfoRepository.save(tableReceiveInfoDO);
        return tableReceiveInfoDO;
    }

    @Override
    public TableReceiveInfoDO setAsDefaultReceiveInfo(TableReceiveInfoDO tableReceiveInfoDO) {
        List<TableReceiveInfoDO> tableReceiveInfoDOList = listAllByUserOpenId(tableReceiveInfoDO.getUserOpenId());
        tableReceiveInfoDO = tableReceiveInfoRepository.getOne(tableReceiveInfoDO.getId());
        if (tableReceiveInfoDOList != null) {
            int currentMaxWeight = tableReceiveInfoDOList.get(0).getSortWeight();
            tableReceiveInfoDO.setSortWeight(currentMaxWeight + WEIGHT_STEP);
            updateReceiveInfo(tableReceiveInfoDO);
            return tableReceiveInfoDO;
        } else {
            tableReceiveInfoDO.setSortWeight(tableReceiveInfoDO.getSortWeight() + WEIGHT_STEP);
            updateReceiveInfo(tableReceiveInfoDO);
            return tableReceiveInfoDO;
        }
    }

    @Override
    public void deleteReceiveInfoById(Long id) {
        Optional<TableReceiveInfoDO> byId = tableReceiveInfoRepository.findById(id);
        if (byId.isPresent()) {
            TableReceiveInfoDO tableReceiveInfoDO = byId.get();
            tableReceiveInfoRepository.delete(tableReceiveInfoDO);
        }
    }

    @Override
    public List<TableReceiveInfoDO> listAll() {
        return tableReceiveInfoRepository.findAll();
    }

    @Override
    public List<TableReceiveInfoDO> listAllByUserOpenId(String userOpenId) {
        return tableReceiveInfoRepository.findAllByUserOpenIdOrderBySortWeightDescUpdateTimeDesc(userOpenId);
    }

    @Override
    public TableReceiveInfoDO getById(Long id) {
        return tableReceiveInfoRepository.findById(id).orElse(null);
    }
}
