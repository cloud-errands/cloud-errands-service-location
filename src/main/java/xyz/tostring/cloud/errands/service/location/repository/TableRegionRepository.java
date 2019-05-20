package xyz.tostring.cloud.errands.service.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.tostring.cloud.errands.service.location.entity.TableRegionDO;

import java.util.List;

@Repository
public interface TableRegionRepository extends JpaRepository<TableRegionDO, Double> {
    List<TableRegionDO> findAllByParentId(Double parentId);

}
