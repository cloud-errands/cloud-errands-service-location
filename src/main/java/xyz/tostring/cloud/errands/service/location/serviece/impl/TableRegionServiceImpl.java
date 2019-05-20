package xyz.tostring.cloud.errands.service.location.serviece.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tostring.cloud.errands.service.location.entity.TableRegionDO;
import xyz.tostring.cloud.errands.service.location.repository.TableRegionRepository;
import xyz.tostring.cloud.errands.service.location.serviece.TableRegionService;

import java.util.List;

@Service
public class TableRegionServiceImpl implements TableRegionService {

    @Autowired
    private TableRegionRepository tableRegionRepository;

    @Override
    public List<TableRegionDO> listAllByParentId(Double parentId) {
        return tableRegionRepository.findAllByParentId(parentId);
    }
}
