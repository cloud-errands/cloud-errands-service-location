package xyz.tostring.cloud.errands.service.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.tostring.cloud.errands.common.dto.BaseResult;
import xyz.tostring.cloud.errands.service.location.entity.TableRegionDO;
import xyz.tostring.cloud.errands.service.location.serviece.TableRegionService;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private TableRegionService tableRegionService;

    @GetMapping("next/{parentId}")
    private BaseResult nextCityList(@PathVariable Double parentId) {
        BaseResult baseResult = new BaseResult();
        List<TableRegionDO> tableRegionDOList = tableRegionService.listAllByParentId(parentId);
        return baseResult.ok(tableRegionDOList);
    }
}
