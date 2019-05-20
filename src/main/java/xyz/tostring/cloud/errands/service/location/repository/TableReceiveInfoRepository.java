package xyz.tostring.cloud.errands.service.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.tostring.cloud.errands.service.location.entity.TableReceiveInfoDO;

import java.util.List;

@Repository
public interface TableReceiveInfoRepository extends JpaRepository<TableReceiveInfoDO, Long> {
    List<TableReceiveInfoDO> findAllByUserOpenIdOrderBySortWeightDescUpdateTimeDesc(String userOpenId);
}
