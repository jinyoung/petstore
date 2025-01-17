
package petshop.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="pet", url="http://pet:8080")
public interface PetService {

    @RequestMapping(method= RequestMethod., path="/pets")
    public void store(@RequestBody Pet pet);

}