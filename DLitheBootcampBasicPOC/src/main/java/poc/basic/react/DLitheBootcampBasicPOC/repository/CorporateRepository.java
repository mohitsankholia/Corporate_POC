package poc.basic.react.DLitheBootcampBasicPOC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poc.basic.react.DLitheBootcampBasicPOC.entity.Corporate;


@Repository
public interface CorporateRepository extends JpaRepository<Corporate, String> 
{

}
