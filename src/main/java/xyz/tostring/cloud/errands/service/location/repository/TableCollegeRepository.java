package xyz.tostring.cloud.errands.service.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.tostring.cloud.errands.service.location.entity.TableCollegeDO;

import java.util.List;

@Repository
public interface TableCollegeRepository extends JpaRepository<TableCollegeDO, Integer> {
    List<TableCollegeDO> findAllByRegionId(Double regionId);
}
