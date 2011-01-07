package sd.cmdb.service;

import java.util.List;
import sd.cmdb.domain.ClassAttribute;
import sd.cmdb.domain.ClassAttributePk;
import sd.cmdb.domain.ElementClass;
import sd.cmdb.domain.ItemClass;
import sd.cmdb.domain.helper.ItemClassCriteria;

public interface ClassServiceFacade {

    public ElementClass loadElementClass(Integer classId);

    public void addItemClass(ItemClass itemClass);
    public void updateItemClass(ItemClass itemClass);
    public void deleteItemClass(ItemClass classId);
    
    public ItemClass loadItemClass(Integer classId);
    public ItemClass getItemClassByName(String name);
    public ItemClass getItemClassById(Integer identifier);
    public List<ItemClass> getAllItemClasses();
    public List<ItemClass> searchItemClass(ItemClassCriteria criteria);

    public void addClassAttribute(ClassAttribute classAttribute);
    public void updateClassAttribute(ClassAttribute classAttribute);
    public void deleteClassAttribute(ClassAttribute classAttribute);
    public ClassAttribute loadClassAttribute(ClassAttributePk classAttributePk);
}