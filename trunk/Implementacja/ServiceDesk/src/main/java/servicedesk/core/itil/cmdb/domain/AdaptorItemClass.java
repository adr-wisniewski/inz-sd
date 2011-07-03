/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import servicedesk.core.itil.cmdb.domain.helper.EntityClassVisitor;

/**
 *
 * @author Adrian
 */
public abstract class AdaptorItemClass implements ItemClass {
    private Integer id;
    private String name;
    private String description;

    public AdaptorItemClass(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isAbstraction() {
        return false;
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
        return new LinkedList<Attribute>();
    }

    @Override
    public List<Attribute> getInheritedAttributes() {
        return new LinkedList<Attribute>();
    }

    @Override
    public List<Attribute> getAllAttributes() {
        return new LinkedList<Attribute>();
    }

    @Override
    public List<Attribute> getAllAttributesSorted() {
        return getAllAttributes();
    }

    @Override
    public <ReturnType> ReturnType accept(EntityClassVisitor<ReturnType> visitor) {
        return visitor.visit(this);
    }
   
    @Override
    public Attribute createAttribute() {
        return new Attribute(this);
    }
}
