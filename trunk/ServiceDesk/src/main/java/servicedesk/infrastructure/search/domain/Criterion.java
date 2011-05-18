/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.domain;

/**
 *
 * @author Adrian
 */
public interface Criterion {
    public <C> void accept(QueryVisitor<C> visitor, C context);
}
