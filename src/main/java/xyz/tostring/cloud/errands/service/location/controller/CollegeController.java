package xyz.tostring.cloud.errands.service.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.tostring.cloud.errands.common.dto.BaseResult;
import xyz.tostring.cloud.errands.service.location.entity.TableCollegeDO;
import xyz.tostring.cloud.errands.service.location.serviece.TableCollegeService;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private TableCollegeService tableCollegeService;

    @PostMapping
    public BaseResult openNewCollege(TableCollegeDO tableCollegeDO) {
        BaseResult baseResult = new BaseResult();
        tableCollegeService.createCollege(tableCollegeDO);
        return baseResult.ok();
    }

    @PutMapping
    public BaseResult updateCollege(TableCollegeDO tableCollegeDO) {
        BaseResult baseResult = new BaseResult();
        tableCollegeService.updateCollege(tableCollegeDO);
        return baseResult.ok();
    }

    @GetMapping("{collegeId}")
    public BaseResult getCollegeById(@PathVariable int collegeId) {
        BaseResult baseResult = new BaseResult();
        TableCollegeDO tableCollegeDO = tableCollegeService.getById(collegeId);
        return baseResult.ok(tableCollegeDO);
    }

    @GetMapping("list/{regionId}")
    public BaseResult listByRegionId(@PathVariable Double regionId) {
        BaseResult baseResult = new BaseResult();
        List<TableCollegeDO> tableCollegeDOList = tableCollegeService.listAllByRegionId(regionId);
        return baseResult.ok(tableCollegeDOList);
    }

    @GetMapping("list/closing/{regionId}")
    public BaseResult listByRegionIdClosing(@PathVariable Double regionId) {
        BaseResult baseResult = new BaseResult();
        List<TableCollegeDO> tableCollegeDOList = tableCollegeService.listAllByRegionIdClosing(regionId);
        return baseResult.ok(tableCollegeDOList);
    }

    @GetMapping("list/opening/{regionId}")
    public BaseResult listByRegionIdOpening(@PathVariable Double regionId) {
        BaseResult baseResult = new BaseResult();
        List<TableCollegeDO> tableCollegeDOList = tableCollegeService.listAllByRegionIdOpening(regionId);
        return baseResult.ok(tableCollegeDOList);
    }

    @PostMapping("close")
    public BaseResult closeCollege(int collegeId) {
        BaseResult baseResult = new BaseResult();
        tableCollegeService.closeCollege(collegeId);
        return baseResult.ok();
    }

    @PostMapping("open")
    public BaseResult openCollege(int collegeId) {
        BaseResult baseResult = new BaseResult();
        tableCollegeService.openCollege(collegeId);
        return baseResult.ok();
    }
}
