<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="comment" required="true" rtexprvalue="true" type="servicedesk.change.domain.RfcComment"%>

<div class="rfc comment">
    <span class="content">
        ${comment.content}
    </span>
    <span class="signarure">
        <link:employee object="${comment.creator}"/> <print:datetime datetime="${comment.timestamp}" />
    </span>
</div>