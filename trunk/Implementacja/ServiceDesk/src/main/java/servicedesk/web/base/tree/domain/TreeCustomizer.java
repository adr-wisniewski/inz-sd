/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.base.tree.domain;

import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;

/**
 *
 * @author Adrian
 */
public interface TreeCustomizer<Type extends HierarchicalDomainObject<?>> {
    public void customize(TreeItem item, Type value);
}
