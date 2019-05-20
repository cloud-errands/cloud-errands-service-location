package xyz.tostring.cloud.errands.service.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.tostring.cloud.errands.common.dto.BaseResult;
import xyz.tostring.cloud.errands.service.location.entity.TableCollegeDO;
import xyz.tostring.cloud.errands.service.location.entity.TableReceiveInfoDO;
import xyz.tostring.cloud.errands.service.location.entity.query.ReceiveInfoQueryVO;
import xyz.tostring.cloud.errands.service.location.serviece.TableCollegeService;
import xyz.tostring.cloud.errands.service.location.serviece.TableReceiveInfoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/receive-info")
public class ReceiveInfoController {
    @Autowired
    private TableReceiveInfoService tableReceiveInfoService;

    @Autowired
    private TableCollegeService tableCollegeService;

    @PostMapping
    public BaseResult create(@RequestBody TableReceiveInfoDO tableReceiveInfoDO) {
        BaseResult baseResult = new BaseResult();
        if (null != tableCollegeService.getById(tableReceiveInfoDO.getCollegeId())) {
            tableReceiveInfoDO = tableReceiveInfoService.createReceiveInfo(tableReceiveInfoDO);
            return baseResult.ok(changeReceiveInfoDOToQueryVO(tableReceiveInfoDO));
        }

        return baseResult.ok();
    }

    @PutMapping
    public BaseResult update(@RequestBody TableReceiveInfoDO tableReceiveInfoDO) {
        BaseResult baseResult = new BaseResult();
        if (null != tableCollegeService.getById(tableReceiveInfoDO.getCollegeId())) {
            tableReceiveInfoDO = tableReceiveInfoService.updateReceiveInfo(tableReceiveInfoDO);
            return baseResult.ok(changeReceiveInfoDOToQueryVO(tableReceiveInfoDO));
        }

        return baseResult.ok();
    }

    @DeleteMapping("{id}")
    public BaseResult delete(@PathVariable Long id) {
        BaseResult baseResult = new BaseResult();
       tableReceiveInfoService.deleteReceiveInfoById(id);
        return baseResult.ok();
    }

    @GetMapping("list/{userOpenId}")
    public BaseResult listByUserOpenId(@PathVariable String userOpenId) {
        BaseResult baseResult = new BaseResult();
        List<TableReceiveInfoDO> tableReceiveInfoDOList = tableReceiveInfoService.listAllByUserOpenId(userOpenId);
        List<ReceiveInfoQueryVO> receiveInfoQueryVOList = tableReceiveInfoDOList.stream().map(this::changeReceiveInfoDOToQueryVO).collect(Collectors.toList());
        return baseResult.ok(receiveInfoQueryVOList);
    }

    @GetMapping("{id}")
    public BaseResult getOne(@PathVariable Long id) {
        BaseResult baseResult = new BaseResult();
        TableReceiveInfoDO tableReceiveInfoDO = tableReceiveInfoService.getById(id);
        return baseResult.ok(changeReceiveInfoDOToQueryVO(tableReceiveInfoDO));
    }

    @PutMapping("as-default")
    public BaseResult setAsDefault(@RequestBody TableReceiveInfoDO tableReceiveInfoDO) {
        BaseResult baseResult = new BaseResult();
        tableReceiveInfoDO = tableReceiveInfoService.setAsDefaultReceiveInfo(tableReceiveInfoDO);
        return baseResult.ok(changeReceiveInfoDOToQueryVO(tableReceiveInfoDO));
    }

    private ReceiveInfoQueryVO changeReceiveInfoDOToQueryVO(TableReceiveInfoDO tableReceiveInfoDO) {
        ReceiveInfoQueryVO receiveInfoQueryVO = new ReceiveInfoQueryVO();
        TableCollegeDO tableCollegeDO = tableCollegeService.getById(tableReceiveInfoDO.getCollegeId());
        receiveInfoQueryVO.setId(tableReceiveInfoDO.getId());
        receiveInfoQueryVO.setUserOpenId(tableReceiveInfoDO.getUserOpenId());
        receiveInfoQueryVO.setCollege(tableCollegeDO);
        receiveInfoQueryVO.setAddressDetail(tableReceiveInfoDO.getAddressDetail());
        receiveInfoQueryVO.setReceiverName(tableReceiveInfoDO.getReceiverName());
        receiveInfoQueryVO.setReceiverMobile(tableReceiveInfoDO.getReceiverMobile());
        receiveInfoQueryVO.setSortWeight(tableReceiveInfoDO.getSortWeight());
        receiveInfoQueryVO.setCreateTime(tableReceiveInfoDO.getCreateTime());
        receiveInfoQueryVO.setUpdateTime(tableReceiveInfoDO.getUpdateTime());
        return receiveInfoQueryVO;
    }
}
