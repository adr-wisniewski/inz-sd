package sd.cmdb.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;

@Service
@Transactional
public interface ClassService {
    public void addItemClass(ItemClass itemClass);
    public void updateItemClass(ItemClass itemClass);
    public void deleteItemClass(ItemClass itemClass);
    public ItemClass getItemClassByName(String name);
    public ItemClass getItemClassById(Integer identifier);
    public List<ItemClass> getAllItemClasses();
    public List<ItemClass> searchItemClass(ItemClassCriteria criteria);
}