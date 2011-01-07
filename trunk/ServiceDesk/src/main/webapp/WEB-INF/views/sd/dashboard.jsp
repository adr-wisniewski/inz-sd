<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sd" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:element>
    <table class="mainTable">
            <tbody>
                    <tr>
                            <td class="column">
                            <table width="100%">
                                    <tbody>
                                            <tr>
                                                    <td width="100%">
                                                    <table class="box" id="sygnaly" width="100%">
                                                            <thead>
                                                                    <tr>
                                                                            <th colspan="20"><spring:message code="signals.label" /></th>
                                                                    </tr>
                                                            </thead>
                                                            <tbody class=data-table-body>
                                                                    <tr class=data-table-header>
                                                                            <td><spring:message code="creationDate.label" /></td>
                                                                            <td><spring:message code="signal_subject.label" /></td>
                                                                            <td><spring:message code="signal_message.label" /></td>
                                                                            <td><spring:message code="signal_significance.label" /></td>
                                                                            <td></td>
                                                                    </tr>
                                                                    <c:forEach items="${signals}" var="s">
                                                                    <tr class="${s.type.significance.cssClass}">
                                                                            <td>${s.creationDate}</td>
                                                                            <td>${s.subject}</td>
                                                                            <td>${s.message}</td>
                                                                            <td>${s.type.significance.name}</td>
                                                                            <td>
                                                                    <sd:editButton url="${s.detailsURL}"/>
                                                                            </td>
                                                                    </tr>
                                                                    </c:forEach>
                                                            </tbody>
                                                    </table>
                                                    </td>
                                            </tr>
                                            <tr>
                                                    <td class="space-row"></td>
                                            </tr>

                                    </tbody>
                            </table>
                            </td>
                            <td class=column>
                            <table width="100%">
                                    <tbody>
                                            <tr>
                                                    <td width="100%">

                                                    <table class=currents id=aktualnosci_wszystko>
                                                            <thead>
                                                                    <tr>
                                                                            <th>
                                                                            <div style="FLOAT: left"><spring:message code="news.label" /></div>
                                                                            <div class="x-tool x-tool-show-all"
                                                                                    onclick="show_hide('aktualnosci_wszystko','aktualnosci_skrot')"></div>
                                                                            <div class="x-tool x-tool-toggle-over"
                                                                                    onclick="toggle('aktualnosci_wszystko')"></div>
                                                                            </th>
                                                                    </tr>
                                                            </thead>
                                                            <tbody class=currents-body>
                                                                    <tr>
                                                                            <td class=currents-header1>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</td>
                                                                    </tr>
                                                                    <tr>
                                                                            <td class=currents-info>2010-03-10 18:46</td>
                                                                    </tr>
                                                                    <tr>
                                                                            <td class=currents-body>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</td>
                                                                    </tr>
                                                                    <tr>
                                                                            <td>
                                                                            <HR class=horizontal-line>
                                                                            </td>
                                                                    </tr>
                                                                    <tr>
                                                                            <td class=currents-header1>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</td>
                                                                    </tr>
                                                                    <tr>
                                                                            <td class=currents-info>2010-03-10 18:46</td>
                                                                    </tr>
                                                                    <tr>
                                                                            <td class=currents-body>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatu</td>
                                                                    </tr>
                                                            </tbody>
                                                    </table>
                                                    </td>
                                            </tr>
                                            <tr>
                                                    <td class=space-row></td>
                                            </tr>
                                    </tbody>
                            </table>
                            </td>
                    </tr>
            </tbody>
    </table>
</ui:element>

