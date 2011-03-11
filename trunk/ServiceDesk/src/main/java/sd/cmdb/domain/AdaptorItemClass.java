/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import sd.cmdb.domain.helper.EntityClassVisitor;

/**
 *
 * @author Adrian
 */
public abstract class AdaptorItemClass implements ItemClass {

    protected final Integer id;
    protected final String name;
    protected final String description;
    protected final List<Attribute> attributes;

    public AdaptorItemClass(Integer id, String name, String description, List<Attribute> attributes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attributes = attributes;
    }

    @Override
    public boolean isAbstraction() {
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ItemClass getParent() {
        return null;
    }

    @Override
    public Set<? extends EntityClass> getChildren() {
        return null;
    }

    @Override
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public List<Attribute> getInheritedAttributes() {
        return new LinkedList<Attribute>();
    }

    @Override
    public List<Attribute> getAllAttributes() {
        return getAttributes();
    }

    @Override
    public List<Attribute> getAllAttributesSorted() {
        List<Attribute> allAttributes = getAllAttributes();
        Collections.sort(allAttributes);
        return allAttributes;
    }

    @Override
    public Integer getParentId() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void accept(EntityClassVisitor visitor) {
        visitor.visit(this);
    }
}
