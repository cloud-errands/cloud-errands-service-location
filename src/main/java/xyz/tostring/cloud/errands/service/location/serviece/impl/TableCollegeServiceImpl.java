package xyz.tostring.cloud.errands.service.location.serviece.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tostring.cloud.errands.service.location.entity.TableCollegeDO;
import xyz.tostring.cloud.errands.service.location.repository.TableCollegeRepository;
import xyz.tostring.cloud.errands.service.location.serviece.TableCollegeService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TableCollegeServiceImpl implements TableCollegeService {

    public static final int IS_CLOSING = 0;
    public static final int IS_OPENING = 1;


    @Autowired
    private TableCollegeRepository tableCollegeRepository;

    @Override
    public List<TableCollegeDO> listAllByRegionId(Double regionId) {
        return tableCollegeRepository.findAllByRegionId(regionId);
    }

    @Override
    public void createCollege(TableCollegeDO tableCollegeDO) {
        Date date = new Date();
        tableCollegeDO.setIsOpening(IS_OPENING);
        tableCollegeDO.setCreateTime(date);
        tableCollegeDO.setUpdateTime(date);
        tableCollegeRepository.save(tableCollegeDO);
    }

    @Override
    public void updateCollege(TableCollegeDO tableCollegeDO) {
        tableCollegeDO.setUpdateTime(new Date());
        tableCollegeRepository.save(tableCollegeDO);
    }

    @Override
    public void closeCollege(Integer collegeId) {
        Optional<TableCollegeDO> byId = tableCollegeRepository.findById(collegeId);
        if (byId.isPresent()) {
            TableCollegeDO tableCollegeDO = byId.get();
            tableCollegeDO.setIsOpening(IS_CLOSING);
            tableCollegeDO.setUpdateTime(new Date());
            tableCollegeRepository.save(tableCollegeDO);
        }
    }

    @Override
    public void openCollege(Integer collegeId) {
        Optional<TableCollegeDO> byId = tableCollegeRepository.findById(collegeId);
        if (byId.isPresent()) {
            TableCollegeDO tableCollegeDO = byId.get();
            tableCollegeDO.setIsOpening(IS_OPENING);
            tableCollegeDO.setUpdateTime(new Date());
            tableCollegeRepository.save(tableCollegeDO);
        }
    }

    @Override
    public List<TableCollegeDO> listAllByRegionIdClosing(Double regionId) {
        List<TableCollegeDO> tableCollegeDOList = tableCollegeRepository.findAllByRegionId(regionId);
        return tableCollegeDOList.stream().filter(item -> item.getIsOpening() == IS_CLOSING).collect(Collectors.toList());
    }

    @Override
    public List<TableCollegeDO> listAllByRegionIdOpening(Double regionId) {
        List<TableCollegeDO> tableCollegeDOList = tableCollegeRepository.findAllByRegionId(regionId);
        return tableCollegeDOList.stream().filter(item -> item.getIsOpening() == IS_OPENING).collect(Collectors.toList());
    }

    @Override
    public TableCollegeDO getById(int id) {
        return tableCollegeRepository.findById(id).orElse(null);
    }
}
