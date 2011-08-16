/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.security.domain;

/**
 *
 * @author Adrian
 */
public interface UserVisitor<Result, Context> {
    Result visit(ClientUser client, Context context);
    Result visit(CooperantUser cooperant, Context context);
    Result visit(EmployeeUser employee, Context context);
}
